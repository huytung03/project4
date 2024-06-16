package org.project4.backend.repository;

import org.project4.backend.entity.TruyenEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruyenRepository extends JpaRepository<TruyenEntity,Integer > {
    List<TruyenEntity> findByTentruyen(String storyname, Pageable pageable);
    List<TruyenEntity> findBySotap(int episodes, Pageable pageable );
    TruyenEntity findByTruyenid(int storyid);
    void deleteByTruyenid(int storyid);

}
