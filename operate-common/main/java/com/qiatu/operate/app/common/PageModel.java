package com.qiatu.operate.app.common;

/**
 * Created by chechi on 15-1-14.
 */
public class PageModel {

    private int pageNo = 1;

    private int pageSize = 1;

    public PageModel() {
    }

    public PageModel(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        if(pageNo == 1){
            return 0;
        }
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordOffset() {
        if (pageNo == 1) {
            return 0;
        }
        return ((getPageNo() - 1) * getPageSize());
    }

}
