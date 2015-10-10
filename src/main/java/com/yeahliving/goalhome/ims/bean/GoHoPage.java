package com.yeahliving.goalhome.ims.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xingfeiy on 10/6/15.
 */
public class GoHoPage {

    private int pageNo = 1;

    private int pageSize = 10;

    private int totalRecord;

    private int totalPage;

//    private List<T> results;

//    private Map<String, Object> params = new HashMap<String, Object>();

    private int offset=0;

    public GoHoPage() {
    }

    public GoHoPage(int pageSize, int totalRecord) {
        this.pageSize = pageSize > 0 ? pageSize : this.pageSize;
        this.totalRecord = totalRecord;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        if(pageNo > 0) {
            this.pageNo = pageNo;
            this.setOffset(this.offset);
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

//    public List<T> getResults() {
//        return results;
//    }

//    public void setResults(List<T> results) {
//        this.results = results;
//    }
//
//    public Map<String, Object> getParams() {
//        return params;
//    }
//
//    public void setParams(Map<String, Object> params) {
//        this.params = params;
//    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = (this.pageNo - 1) * this.pageSize;
    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Page [pageNo=").append(pageNo).append(", pageSize=")
//                .append(pageSize).append(", results=").append(results).append(
//                ", totalPage=").append(totalPage).append(
//                ", totalRecord=").append(totalRecord).append("]");
//        return builder.toString();
//    }
}
