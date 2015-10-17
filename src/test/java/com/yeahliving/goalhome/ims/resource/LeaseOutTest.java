package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.*;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;
import com.yeahliving.goalhome.ims.service.response.GoHoSearchResponse;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xingfeiy on 10/12/15.
 */
public class LeaseOutTest extends ResourceTest {
    @Test
    public void testWholeLeaseOut() throws Exception {
        //first step, pick up the lease unit you are going to lease it out.
        //http://localhost:9998/goalhome-ims/lease_units/list?status=1&page=1&per_page=10
        WebTarget unitTarget = target()
                .path("lease_units");
        Response response = unitTarget.path("list")
                .queryParam("status", GoHoEntityStatusCode.LEASABLE.getCode())
                .queryParam("page", 1)
                .queryParam("per_page", 10)
                .request(MediaType.APPLICATION_JSON_TYPE).get();
        assertEquals(200, response.getStatus());
        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        GoHoObjContainer container = searchResponse.getContainer();
        if(container.isEmpty()) {
            System.out.println("No unit is available for lease out.");
            return;
        }
        int unitID = ((GoHoLeaseUnit)container.getObj().get(0)).getId();

        //start adding a new lease out event, the first step is add or select a tenant.
        //http://localhost:9998/goalhome-ims/lease_out/tenant
        WebTarget tenantTarget = target()
                .path("lease_out/tenant");
        response = tenantTarget
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(TestObjects.tenant, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
        GoHoObjResponse objResponse = response.readEntity(GoHoObjResponse.class);

        int tenantID = ((GoHoTenant)objResponse.getGoHoObj()).getId();
        assertTrue(tenantID > 0);

        //next, add the current utility records.
//        http://localhost:9998/goalhome-ims/lease_out/start_utility
        WebTarget uRecordTarget = target()
                .path("lease_out/start_utility");
        response = uRecordTarget
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(TestObjects.utilityRecord1, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
        objResponse = response.readEntity(GoHoObjResponse.class);
        int uRecordID = ((GoHoUtilityRecord)objResponse.getGoHoObj()).getId();
        assertTrue(uRecordID > 0);

        //finish it.
        //http://localhost:9998/goalhome-ims/lease_out
        GoHoLeaseOut leaseOut1 = new GoHoLeaseOut();
        leaseOut1.setAgent_id(100);
        leaseOut1.setBill_period(3);
        leaseOut1.setDeposit(1500);
        leaseOut1.setFee_per_month(1500);
        Calendar start = new GregorianCalendar(2015,10,28);
        Calendar end = new GregorianCalendar(2016,10,28);
        leaseOut1.setFirst_bill_date(start.getTime());
        leaseOut1.setLease_start_date(start.getTime());
        leaseOut1.setLease_end_date(end.getTime());
        leaseOut1.setPrepayment(1000);
        leaseOut1.setLease_unit_id(unitID);
        leaseOut1.setTenant_id(tenantID);
        leaseOut1.setStart_utility_record(uRecordID);
        WebTarget leaseOutTarget = target()
                .path("lease_out");
        response = leaseOutTarget
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(leaseOut1, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
        objResponse = response.readEntity(GoHoObjResponse.class);
        int leaseOutId = ((GoHoLeaseOut)objResponse.getGoHoObj()).getId();
        assertTrue(leaseOutId > 0);

    }
}
