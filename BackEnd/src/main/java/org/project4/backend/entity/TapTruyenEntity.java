package org.project4.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TapTruyen")
public class TapTruyenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tapid;

    private int sotap;

    @Column(name = "truyenURL",columnDefinition = "varchar(255)")
    private String truyenURL;

    @ManyToOne
    @JoinColumn(name = "truyenid")
    private TruyenEntity truyenid;

    public int getTapid() {
        return tapid;
    }

    public void setTapid(int tapid) {
        this.tapid = tapid;
    }

    public int getSotap() {
        return sotap;
    }

    public void setSotap(int sotap) {
        this.sotap = sotap;
    }

    public String getTruyenURL() {
        return truyenURL;
    }

    public void setTruyenURL(String truyenURL) {
        this.truyenURL = truyenURL;
    }

    public TruyenEntity getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(TruyenEntity truyenid) {
        this.truyenid = truyenid;
    }
}
