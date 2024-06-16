package org.project4.backend.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "QuyenHan")
public class QuyenHanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quyenhanid;
    @Column(name = "tenquyenhan", columnDefinition = "nvarchar(255)")
    private String tenquyenhan;

    public int getQuyenhanid() {
        return quyenhanid;
    }

    public void setQuyenhanid(int quyenhanid) {
        this.quyenhanid = quyenhanid;
    }

    public String getTenquyenhan() {
        return tenquyenhan;
    }

    public void setTenquyenhan(String tenquyenhan) {
        this.tenquyenhan = tenquyenhan;
    }
}
