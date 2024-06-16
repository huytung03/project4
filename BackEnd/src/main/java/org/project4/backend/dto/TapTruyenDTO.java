package org.project4.backend.dto;

public class TapTruyenDTO {
    private int tapid;
    private int sotap;
    private String truyenURL;
    private TruyenDTO truyenid;

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

    public TruyenDTO getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(TruyenDTO truyenid) {
        this.truyenid = truyenid;
    }
}
