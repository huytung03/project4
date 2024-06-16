package org.project4.backend.repository;

import org.project4.backend.entity.TacGiaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TacgiaRepository extends JpaRepository<TacGiaEntity, Integer> {
    // tìm kiếm theo tên tác giả
    List<TacGiaEntity> findByTentacgia(String tentacgia, Pageable pageable);
    // tìm kiếm theo id
    TacGiaEntity findByTacgiaid(int tacgiaid);
    // tìm kiếm theo tên tác giả
    TacGiaEntity findByTentacgia(String tentacgia);
    void deleteByTacgiaid(int tacgiaid);
}
