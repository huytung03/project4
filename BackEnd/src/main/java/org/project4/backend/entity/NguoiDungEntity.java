package org.project4.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "NguoiDung")
public class NguoiDungEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nguoidungid;
    @Column(name = "username", columnDefinition = "varchar(255)")
    private String tendangnhap;
    @Column(name = "password", columnDefinition = "varchar(255)")
    private String matkhau;
    @Column(name = "email", columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "phone", columnDefinition = "varchar(255)")
    private String sodienthoai;
    @ManyToOne
    @JoinColumn(name = "quyenhanid")
    private QuyenHanEntity quyenhanid;

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

    public QuyenHanEntity getQuyenhanid() {
        return quyenhanid;
    }

    public void setQuyenhanid(QuyenHanEntity quyenhanid) {
        this.quyenhanid = quyenhanid;
    }
}
