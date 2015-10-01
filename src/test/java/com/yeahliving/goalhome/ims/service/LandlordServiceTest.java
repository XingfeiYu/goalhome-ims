package com.yeahliving.goalhome.ims.service; 

import com.yeahliving.goalhome.ims.bean.GoHoLandlord;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/** 
* LandlordService Tester. 
* 
* @author <Authors name> 
* @since <pre>Sep 30, 2015</pre> 
* @version 1.0 
*/ 
public class LandlordServiceTest {
    public static final GoHoLandlord landlord1;
    public static final GoHoLandlord landlord2;
//    public static final GoHoLandlord landlord3;
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

    @Test
    public void testAddLandlord() {
        GoHoLandlord landlord = LandlordService.add(landlord2);
        assertTrue(landlord.getId() > 0);
    }

} 
