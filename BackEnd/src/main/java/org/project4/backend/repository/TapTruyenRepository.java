package org.project4.backend.repository;

import org.project4.backend.entity.TruyenEntity;
import org.project4.backend.entity.TapTruyenEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TapTruyenRepository extends JpaRepository<TapTruyenEntity, Integer> {
    List<TapTruyenEntity> findByTruyenid(TruyenEntity story, Pageable pageable);
    List<TapTruyenEntity> findBySotap(int epnumber, Pageable pageable);
    List<TapTruyenEntity> findByTruyenURL(String epURL, Pageable pageable);
    TapTruyenEntity findByTapid(int epid);
    void deleteByTapid(int epid);
}
