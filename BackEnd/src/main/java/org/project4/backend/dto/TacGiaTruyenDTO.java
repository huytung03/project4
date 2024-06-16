package org.project4.backend.dto;

public class TacGiaTruyenDTO {
    private int tacgiatruyenid;
    private TruyenDTO truyenid;
    private TacGiaDTO tacgiaid;

    public int getTacgiatruyenid() {
        return tacgiatruyenid;
    }

    public void setTacgiatruyenid(int tacgiatruyenid) {
        this.tacgiatruyenid = tacgiatruyenid;
    }

    public TruyenDTO getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(TruyenDTO truyenid) {
        this.truyenid = truyenid;
    }

    public TacGiaDTO getTacgiaid() {
        return tacgiaid;
    }

    public void setTacgiaid(TacGiaDTO tacgiaid) {
        this.tacgiaid = tacgiaid;
    }
}
