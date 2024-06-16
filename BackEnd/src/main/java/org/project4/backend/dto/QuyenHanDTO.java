package org.project4.backend.dto;


import jakarta.persistence.*;

public class QuyenHanDTO {
    private int quyenhanid;
    private String tenquyenhan;

    public int getQuyenhanid() {
        return quyenhanid;
    }

    public void setQuyenhanid(int quyenhanid) {
        this.quyenhanid = quyenhanid;
    }

    public String getTenquyenhan() {
        return tenquyenhan;
    }

    public void setTenquyenhan(String tenquyenhan) {
        this.tenquyenhan = tenquyenhan;
    }
}
