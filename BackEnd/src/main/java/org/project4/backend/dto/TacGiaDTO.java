package org.project4.backend.dto;

import jakarta.persistence.*;

public class TacGiaDTO {
    private int tacgiaid;
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
