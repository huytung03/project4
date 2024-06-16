package org.project4.backend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "Truyen")
public class TruyenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int truyenid;
    @Column(name = "tentruyen",columnDefinition = "NVARCHAR(255)")
    private String tentruyen;
    private String sotap;
    @Column(name = "mota", columnDefinition = "NVARCHAR(255)")
    private String mota;
    @Column(name = "imageURL", columnDefinition = "VARCHAR(255)")
    private String anhURL;

    public int getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(int truyenid) {
        this.truyenid = truyenid;
    }

    public String getTentruyen() {
        return tentruyen;
    }

    public void setTentruyen(String tentruyen) {
        this.tentruyen = tentruyen;
    }

    public String getSotap() {
        return sotap;
    }

    public void setSotap(String sotap) {
        this.sotap = sotap;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getAnhURL() {
        return anhURL;
    }

    public void setAnhURL(String anhURL) {
        this.anhURL = anhURL;
    }
}
