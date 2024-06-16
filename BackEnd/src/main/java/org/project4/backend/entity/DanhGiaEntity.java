package org.project4.backend.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "DanhGia")
public class DanhGiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int danhgiaid;
    @Column(name = "noidung", columnDefinition = "nvarchar(max)")
    private String noidung;

    @ManyToOne
    @JoinColumn(name = "nguoidungid")
    private NguoiDungEntity nguoidungid;

    @ManyToOne
    @JoinColumn(name = "truyenid")
    private TruyenEntity truyenid;

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

    public NguoiDungEntity getNguoidungid() {
        return nguoidungid;
    }

    public void setNguoidungid(NguoiDungEntity nguoidungid) {
        this.nguoidungid = nguoidungid;
    }

    public TruyenEntity getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(TruyenEntity truyenid) {
        this.truyenid = truyenid;
    }

    public Date getNgaydang() {
        return ngaydang;
    }

    public void setNgaydang(Date ngaydang) {
        this.ngaydang = ngaydang;
    }
}
