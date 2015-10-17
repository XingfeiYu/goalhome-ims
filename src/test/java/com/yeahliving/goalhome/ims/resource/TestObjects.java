package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.*;
import com.yeahliving.goalhome.ims.service.AddressServiceTest;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by xingfeiy on 10/9/15.
 */
public class TestObjects {
    public static final GoHoAddress address;
    public static final GoHoAddress address1;
    public static final GoHoAddress address2;
    public static final GoHoAddress address3;

    static {
        address = new GoHoAddress();
        address.setComplex("天立花园");
        address.setProvince("四川省");
        address.setCity("成都市");
        address.setDistrict("金牛区");
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
        address2.setComplex("天立");
        address2.setProvince("四川");
        address2.setCity("泸州");
        address2.setDistrict("龙区");
        address2.setStreet("南路");
        address2.setDoor("18111号");
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

    public static final GoHoHouse house_1;
    public static final GoHoHouse house_2;
    public static final GoHoHouse house_3;
    public static final GoHoHouse house_4;

    static {
        house_1 = new GoHoHouse();
        house_1.setAddress(address);
        house_1.setAlias("川大精品公寓");
        house_1.setHouse_type("两室一厅");
        house_1.setArea(100);
        house_1.setFor_sell(false);
        house_1.setComments("空姐邻居");

        house_2 = new GoHoHouse();
        house_2.setAddress(address1);
        house_2.setAlias("九眼桥豪庭");
        house_2.setHouse_type("两室一厅");
        house_2.setArea(160);
        house_2.setFor_sell(true);
        house_2.setComments("隔壁公安局");

        house_3 = new GoHoHouse();
        house_3.setAddress(address2);
        house_3.setAlias("天府广场");
        house_3.setHouse_type("两室两厅");
        house_3.setArea(90);
        house_3.setFor_sell(false);
        house_3.setComments("每晚有广场舞");

        house_4 = new GoHoHouse();
        house_4.setAddress(address3);
        house_4.setAlias("8888");
        house_4.setHouse_type("两室一厅");
        house_4.setArea(1000);
        house_4.setFor_sell(true);
        house_4.setComments("隔壁公安局");
    }

    public static final GoHoLandlord landlord1;
    public static final GoHoLandlord landlord2;
    static {
        landlord1 = new GoHoLandlord();
        landlord1.setLandlord_name("Bitch");
        landlord1.setAge(18);
        landlord1.setMarried(false);
        landlord1.setIdentify("510504198808081111");
        landlord1.setGender(1);
        landlord1.setPhone("028-10086");
        landlord1.setMobile("13661609313");
        landlord1.setSec_mobile("13813888138");
        landlord1.setEmail("110@china.com");
        landlord1.setQq("8888888888");
        landlord1.setWechat("iLove888");
        landlord1.setHobby("basketball, football");
        landlord1.setAddress(AddressServiceTest.address3);
        landlord1.setBank_account("1111 2222 3333 4444");
        landlord1.setBank_info("Bitch");
        landlord1.setPic_url("/Users/xingfeiy/Document/1.jpg;/Users/xingfeiy/Document/4.jpg;/Users/xingfeiy/Document/1.jpg;/Users/xingfeiy/Document/3.jpg;/Users/xingfeiy/Document/2.jpg");
        landlord1.setDoc_url("/Users/xingfeiy/Document/1.doc");
        landlord1.setComments("Bitch");


        landlord2 = new GoHoLandlord();
        landlord2.setLandlord_name("习近平");
        landlord2.setAge(58);
        landlord2.setMarried(true);
        landlord2.setIdentify("16888888888888888888");
        landlord2.setGender(0);
        landlord2.setPhone("001-*******");
        landlord2.setMobile("13661609313");
        landlord2.setSec_mobile("13813888138");
        landlord2.setEmail("xi@china.com");
        landlord2.setQq("168888888888");
        landlord2.setWechat("iLove16888");
        landlord2.setHobby("出国访问");
        landlord2.setJob("执政");
        landlord2.setAddress(AddressServiceTest.address2);
        landlord2.setBank_account("1111 2222 3333 4444");
        landlord2.setBank_info("中央银行");
        landlord2.setPic_url("/Users/xingfeiy/Document/1.jpg;/Users/xingfeiy/Document/4.jpg;/Users/xingfeiy/Document/1.jpg;/Users/xingfeiy/Document/3.jpg;/Users/xingfeiy/Document/2.jpg");
        landlord2.setDoc_url("/Users/xingfeiy/Document/1.doc");
        landlord2.setComments("中华人民共和国主席");
    }

    public static final GoHoRoom room1;
    public static final GoHoRoom room2;
    public static final GoHoRoom room3;
    static {
        room1 = new GoHoRoom();
        room1.setHouse_id(100000);
        room1.setArea(28);
        room1.setRoom_type("主卧");
        room1.setSelf_br(true);
        room1.setFacilities("床、彩电、沙发、空调");

        room2 = new GoHoRoom();
        room2.setHouse_id(100000);
        room2.setArea(18);
        room2.setRoom_type("次卧");
        room2.setSelf_br(true);
        room2.setFacilities("床、彩电、空调");

        room3 = new GoHoRoom();
        room3.setHouse_id(100000);
        room3.setArea(18);
        room3.setRoom_type("客厅");
        room3.setSelf_br(true);
        room3.setFacilities("餐桌、彩电、空调");

    }

    public static final GoHoLeaseIn leaseIn1;
    static {
        Calendar start = new GregorianCalendar(2015,10,28);
        Calendar end = new GregorianCalendar(2016,9,28);
        leaseIn1 = new GoHoLeaseIn();
        leaseIn1.setHouse_id(1000017);
        leaseIn1.setLease_start_date(start.getTime());
        leaseIn1.setLease_end_date(end.getTime());
        leaseIn1.setAgent_id(300);
        leaseIn1.setFee_per_month(2350.5f);
        leaseIn1.setDeposit(1000.43f);
    }

    public static final GoHoContact contact1;
    static {
        contact1 = new GoHoContact();
        contact1.setName("张三丰");
        contact1.setMobile("1388813666133");
        contact1.setAddress("湖北十堰武当山");
        contact1.setCompany("武当房产公司");
    }

    public static final GoHoHouseVendor vendor;
    static {
        vendor = new GoHoHouseVendor();
//        vendor.setContact(contact1);
    }

    public static final GoHoTenant tenant;
    static {
        tenant = new GoHoTenant();
        tenant.setTenant_name("方世玉");
        tenant.setAge(28);
        tenant.setGender(1);
        tenant.setEmail("fangshiyu@gmail.com");
        tenant.setHobby("kongfu");
        tenant.setIdentify("510404198809091212");
        tenant.setMobile("13881388111");
    }

    public static final GoHoUtilityRecord utilityRecord1;
    public static final GoHoUtilityRecord utilityRecord2;
    static {
        utilityRecord1 = new GoHoUtilityRecord();
        utilityRecord1.setWater(100.5f);
        utilityRecord1.setGas(2006.7f);
        utilityRecord1.setElectric(1763.3f);

        utilityRecord2 = new GoHoUtilityRecord();
        utilityRecord2.setWater(1000.5f);
        utilityRecord2.setGas(3006.7f);
        utilityRecord2.setElectric(2763.3f);
    }

    public static final GoHoLeaseOut leaseOut1;
    static {
        leaseOut1 = new GoHoLeaseOut();
        leaseOut1.setAgent_id(100);
        leaseOut1.setBill_period(3);
        leaseOut1.setDeposit(1500);
        leaseOut1.setFee_per_month(1500);
        Calendar start = new GregorianCalendar(2015,10,28);
        leaseOut1.setFirst_bill_date(start.getTime());
        leaseOut1.setPrepayment(1000);
    }
}
