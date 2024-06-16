package org.project4.backend.dto;

import jakarta.persistence.*;

public class LichDangDTO {
    private int lichdangid;
    private String tenlich;

    public int getLichdangid() {
        return lichdangid;
    }

    public void setLichdangid(int lichdangid) {
        this.lichdangid = lichdangid;
    }

    public String getTenlich() {
        return tenlich;
    }

    public void setTenlich(String tenlich) {
        this.tenlich = tenlich;
    }
}
