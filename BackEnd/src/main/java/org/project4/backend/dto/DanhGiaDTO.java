package org.project4.backend.dto;

import java.sql.Date;

public class DanhGiaDTO {
    private int danhgiaid;
    private String noidung;
    private NguoiDungDTO nguoidungid;
    private TruyenDTO truyenid;

    private Date ngaydang;

    public int getDanhgiaid() {
        return danhgiaid;
    }

    public void setDanhgiaid(int danhgiaid) {
        this.danhgiaid = danhgiaid;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public NguoiDungDTO getNguoidungid() {
        return nguoidungid;
    }

    public void setNguoidungid(NguoiDungDTO nguoidungid) {
        this.nguoidungid = nguoidungid;
    }

    public TruyenDTO getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(TruyenDTO truyenid) {
        this.truyenid = truyenid;
    }

    public Date getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(Date ngaydang) {
        this.ngaydang = ngaydang;
    }
}
