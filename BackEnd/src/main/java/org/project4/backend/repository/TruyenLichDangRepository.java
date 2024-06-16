package org.project4.backend.repository;

import org.project4.backend.entity.LichDangEntity;
import org.project4.backend.entity.TruyenLichDangEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruyenLichDangRepository extends JpaRepository<TruyenLichDangEntity, Integer> {
    List<TruyenLichDangEntity> findByLichdangid(LichDangEntity showtime, Pageable pageable);
    TruyenLichDangEntity findByTruyenlichdangid(int storyshowtimeid);
    void deleteByTruyenlichdangid(int storyshowtimeid);

}
