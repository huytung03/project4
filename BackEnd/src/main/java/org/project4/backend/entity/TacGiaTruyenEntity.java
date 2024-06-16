package org.project4.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TacGiaTruyen")
public class TacGiaTruyenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tacgiatruyenid;

    @ManyToOne
    @JoinColumn(name = "truyenid")
    private TruyenEntity truyenid;

    @ManyToOne
    @JoinColumn(name = "tacgiaid")
    private TacGiaEntity tacgiaid;

    public int getTacgiatruyenid() {
        return tacgiatruyenid;
    }

    public void setTacgiatruyenid(int tacgiatruyenid) {
        this.tacgiatruyenid = tacgiatruyenid;
    }

    public TruyenEntity getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(TruyenEntity truyenid) {
        this.truyenid = truyenid;
    }

    public TacGiaEntity getTacgiaid() {
        return tacgiaid;
    }

    public void setTacgiaid(TacGiaEntity tacgiaid) {
        this.tacgiaid = tacgiaid;
    }
}
