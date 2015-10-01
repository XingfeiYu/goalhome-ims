package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class GoHoLeaseOut extends GoHoObject {

    private int id = Integer.MIN_VALUE;

    private Date lease_start_date;

    private Date lease_end_date;

    private int house_id = Integer.MIN_VALUE;

    private int room_id = 0;

    private int tenant_id = Integer.MIN_VALUE;

    private int agent_id = Integer.MIN_VALUE;

    private float fee_per_month = 0;

    private float deposit = 0;

    @XmlElement(name = "pic_url")
    private String picPaths = StringUtils.EMPTY;

    @XmlElement(name = "doc_url")
    private String doc_url = StringUtils.EMPTY;

    private String comments = StringUtils.EMPTY;
}
