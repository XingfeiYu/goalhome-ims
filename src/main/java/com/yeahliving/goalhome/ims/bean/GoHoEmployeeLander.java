package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xingfeiy on 9/28/15.
 */
@XmlRootElement(name = "emp_login")
public class GoHoEmployeeLander extends GoHoObject{

    private String user_name = StringUtils.EMPTY;

    private String password = StringUtils.EMPTY;

    private String deleted = StringUtils.EMPTY;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
