package org.project4.backend.dto;

import jakarta.persistence.*;

public class TruyenLoaiTryuenDTO {
    private int truyenloaitruyenid;
    private TruyenDTO tryuenid;
    private LoaiTruyenDTO loaitruyenid;

    public int getTruyenloaitruyenid() {
        return truyenloaitruyenid;
    }

    public void setTruyenloaitruyenid(int truyenloaitruyenid) {
        this.truyenloaitruyenid = truyenloaitruyenid;
    }

    public TruyenDTO getTryuenid() {
        return tryuenid;
    }

    public void setTryuenid(TruyenDTO tryuenid) {
        this.tryuenid = tryuenid;
    }

    public LoaiTruyenDTO getLoaitruyenid() {
        return loaitruyenid;
    }

    public void setLoaitruyenid(LoaiTruyenDTO loaitruyenid) {
        this.loaitruyenid = loaitruyenid;
    }
}
