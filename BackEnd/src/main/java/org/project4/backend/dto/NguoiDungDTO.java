package org.project4.backend.dto;

public class NguoiDungDTO {
    private int nguoidungid;
    private String tendangnhap;
    private String matkhau;
    private String email;
    private String sodienthoai;
    private QuyenHanDTO quyenhanid;

    public int getNguoidungid() {
        return nguoidungid;
    }

    public void setNguoidungid(int nguoidungid) {
        this.nguoidungid = nguoidungid;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public QuyenHanDTO getQuyenhanid() {
        return quyenhanid;
    }

    public void setQuyenhanid(QuyenHanDTO quyenhanid) {
        this.quyenhanid = quyenhanid;
    }
}
