package org.project4.backend.repository;

import org.project4.backend.entity.NguoiDungEntity;
import org.project4.backend.entity.QuyenHanEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDungEntity, Integer> {
    @Query("select  u from NguoiDungEntity u where u.tendangnhap like %:username%")
    List<NguoiDungEntity> findByTendangnhap(@Param("username") String username, Pageable pageable);

    List<NguoiDungEntity> findByEmail(String email, Pageable pageable);

    List<NguoiDungEntity> findBySodienthoai(String phone, Pageable pageable);

    List<NguoiDungEntity> findByQuyenhanid(QuyenHanEntity role, Pageable pageable);

    NguoiDungEntity findByNguoidungid(int userid);

    void deleteByNguoidungid(int userid);
}
