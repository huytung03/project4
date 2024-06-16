package org.project4.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LichDang")
public class LichDangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lichdangid;
    @Column(name = "tenlich", columnDefinition = "nvarchar(255)")
    private String tenlich;

    public int getLichdangid() {
        return lichdangid;
    }

    public void setLichdangid(int lichdangid) {
        this.lichdangid = lichdangid;
    }

    public String getTenlich() {
        return tenlich;
    }

    public void setTenlich(String tenlich) {
        this.tenlich = tenlich;
    }
}
