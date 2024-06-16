package org.project4.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TruyenLoaiTryuen")
public class TruyenLoaiTryuenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int truyenloaitruyenid;
    @ManyToOne
    @JoinColumn(name = "tryuenid")
    private TruyenEntity tryuenid;
    @ManyToOne
    @JoinColumn(name = "loaitruyenid")
    private LoaiTruyenEntity loaitruyenid;

    public int getTruyenloaitruyenid() {
        return truyenloaitruyenid;
    }

    public void setTruyenloaitruyenid(int truyenloaitruyenid) {
        this.truyenloaitruyenid = truyenloaitruyenid;
    }

    public TruyenEntity getTryuenid() {
        return tryuenid;
    }

    public void setTryuenid(TruyenEntity tryuenid) {
        this.tryuenid = tryuenid;
    }

    public LoaiTruyenEntity getLoaitruyenid() {
        return loaitruyenid;
    }

    public void setLoaitruyenid(LoaiTruyenEntity loaitruyenid) {
        this.loaitruyenid = loaitruyenid;
    }
}
