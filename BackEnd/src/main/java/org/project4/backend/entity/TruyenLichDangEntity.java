package org.project4.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TruyenLichDang")
public class TruyenLichDangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int truyenlichdangid;
    @ManyToOne
    @JoinColumn(name = "lichdangid")
    private LichDangEntity lichdangid;
    @ManyToOne
    @JoinColumn(name = "truyenid")
    private TruyenEntity truyenid;

    public int getTruyenlichdangid() {
        return truyenlichdangid;
    }

    public void setTruyenlichdangid(int truyenlichdangid) {
        this.truyenlichdangid = truyenlichdangid;
    }

    public LichDangEntity getLichdangid() {
        return lichdangid;
    }

    public void setLichdangid(LichDangEntity lichdangid) {
        this.lichdangid = lichdangid;
    }

    public TruyenEntity getTruyenid() {
        return truyenid;
    }

    public void setTruyenid(TruyenEntity truyenid) {
        this.truyenid = truyenid;
    }
}
