package org.project4.backend.repository;

import org.project4.backend.entity.QuyenHanEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuyenHanRepository extends JpaRepository<QuyenHanEntity, Integer> {
    @Query("select r from QuyenHanEntity r where r.tenquyenhan like :rolename")
    List<QuyenHanEntity> findByTenquyenhan(@Param("rolename") String rolename, Pageable pageable);

    QuyenHanEntity findByQuyenhanid(int roleid);

    void deleteByQuyenhanid(int roleid);
}
