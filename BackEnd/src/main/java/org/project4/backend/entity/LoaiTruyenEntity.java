package org.project4.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LoaiTruyen")
public class LoaiTruyenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loạitruyenid;
    @Column(name = "tenloai",columnDefinition = "nvarchar(255)")
    private String tenloai;
    @Column(name = "mota", columnDefinition = "nvarchar(255)")
    private String mota;

    public int getLoạitruyenid() {
        return loạitruyenid;
    }

    public void setLoạitruyenid(int loạitruyenid) {
        this.loạitruyenid = loạitruyenid;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
