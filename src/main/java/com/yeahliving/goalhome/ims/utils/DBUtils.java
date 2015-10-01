package com.yeahliving.goalhome.ims.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;

/**
 * Created by xingfeiy on 9/28/15.
 */
public class DBUtils {
    public static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "src/main/resources/config/db-configuration.xml";
        File f = new File(resource);

        try {
//            BufferedReader input = new BufferedReader(new FileReader(f));
            InputStream inputStream = Resources.getResourceAsStream("config/db-configuration.xml");
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sessionFactory;
    }
}
