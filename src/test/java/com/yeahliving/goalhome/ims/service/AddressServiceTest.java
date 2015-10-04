package com.yeahliving.goalhome.ims.service; 

import com.yeahliving.goalhome.ims.bean.GoHoAddress;
import com.yeahliving.goalhome.ims.bean.GoHoAddressContainer;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import javax.validation.constraints.AssertTrue;

/** 
* AddressService Tester. 
* 
* @author <Authors name> 
* @since <pre>Sep 29, 2015</pre> 
* @version 1.0 
*/ 
public class AddressServiceTest {
    public static final GoHoAddress address;
    public static final GoHoAddress address1;
    public static final GoHoAddress address2;
    public static final GoHoAddress address3;

    static {
        address = new GoHoAddress();
        address.setComplex("天立花园");
        address.setProvince("四川省");
        address.setCity("泸州市");
        address.setDistrict("龙马潭区");
        address.setStreet("南光路");
        address.setDoor("8号");
        address.setSub_door("3栋");

        address1 = new GoHoAddress();
        address1.setComplex("天立花园");
        address1.setProvince("四川省");
        address1.setCity("泸州市");
        address1.setDistrict("龙马潭区");
        address1.setStreet("南光路");
        address1.setDoor("88号");
        address1.setSub_door("3栋");

        address2 = new GoHoAddress();
        address2.setComplex("天立花园");
        address2.setProvince("四川省");
        address2.setCity("泸州");
        address2.setDistrict("龙马区");
        address2.setStreet("南光路");
        address2.setDoor("888号");
        address2.setSub_door("3栋");

        address3 = new GoHoAddress();
        address3.setComplex("天立花园");
        address3.setProvince("四川省");
        address3.setCity("泸州市");
        address3.setDistrict("龙马潭区");
        address3.setStreet("南光路");
        address3.setDoor("8888号");
        address3.setSub_door("3栋");
    }

    @Test
    public void testAddAddress() {
        AddressService.add(address);
//        System.out.println(address.getId());
    }

    @Test
    public void testGetByID() {
        GoHoAddress address = AddressService.getByID(1);
        System.out.println(address.getStreet());
    }

    @Test
    public void testSearchByStreet() {
        GoHoAddressContainer container = AddressService.searchAddressByStreet("南光路");
        if(container != null) {
            System.out.println(container.getAddresses().size());
        }
    }

} 
