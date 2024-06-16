package org.project4.backend.dto;


public class TruyenDTO {
    private int truyenid;
    private String tentruyen;
    private String sotap;
    private String mota;
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
