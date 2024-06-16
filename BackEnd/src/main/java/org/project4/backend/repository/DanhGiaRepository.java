package org.project4.backend.repository;

import org.project4.backend.entity.DanhGiaEntity;
import org.project4.backend.entity.TruyenEntity;
import org.project4.backend.entity.NguoiDungEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface DanhGiaRepository extends JpaRepository<DanhGiaEntity, Integer> {
    List<DanhGiaEntity> findByNguoidungid(NguoiDungEntity nguoidungid, Pageable pageable);
    List<DanhGiaEntity> findByTruyenid(TruyenEntity story, Pageable pageable);
    List<DanhGiaEntity> findByNoidung(String content, Pageable pageable);
    List<DanhGiaEntity> findByNgaydang(Date reviewdate, Pageable pageable);
    DanhGiaEntity findByDanhgiaid(int reviewid);
    void deleteByDanhgiaid(int reviewid);
}
