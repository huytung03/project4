package org.project4.backend.dto;

import jakarta.persistence.*;

public class TruyenLichDangDTO {
    private int truyenlichdangid;
    private LichDangDTO lichdangid;
    private TruyenDTO truyenid;

    public int getTruyenlichdangid() {
        return truyenlichdangid;
    }

    public void setTruyenlichdangid(int truyenlichdangid) {
        this.truyenlichdangid = truyenlichdangid;
    }

    public LichDangDTO getLichdangid() {
        return lichdangid;
    }

    public void setLichdangid(LichDangDTO lichdangid) {
        this.lichdangid = lichdangid;
    }

    public TruyenDTO getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(TruyenDTO truyenid) {
        this.truyenid = truyenid;
    }
}
