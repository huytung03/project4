package org.project4.backend.repository;

import org.project4.backend.entity.TacGiaEntity;
import org.project4.backend.entity.TacGiaTruyenEntity;
import org.project4.backend.entity.TruyenEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacGiaTruyenRepository extends JpaRepository<TacGiaTruyenEntity, Integer> {
    List<TacGiaTruyenEntity> findByTruyenid(TruyenEntity story, Pageable pageable);
    List<TacGiaTruyenEntity> findByTacgiaid(TacGiaEntity author, Pageable pageable);
    TacGiaTruyenEntity findByTacgiatruyenid(int storyauthorid);
    void deleteByTacgiatruyenid(int storyauthorid);
}
