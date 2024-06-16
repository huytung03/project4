package org.project4.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TacGia")
public class TacGiaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tacgiaid;
    @Column(name = "tentacgia", columnDefinition = "nvarchar(255)")
    private String tentacgia;

    public int getTacgiaid() {
        return tacgiaid;
    }

    public void setTacgiaid(int tacgiaid) {
        this.tacgiaid = tacgiaid;
    }

    public String getTentacgia() {
        return tentacgia;
    }

    public void setTentacgia(String tentacgia) {
        this.tentacgia = tentacgia;
    }
}
