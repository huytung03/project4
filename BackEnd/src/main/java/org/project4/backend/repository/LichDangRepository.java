package org.project4.backend.repository;

import org.project4.backend.entity.LichDangEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichDangRepository extends JpaRepository<LichDangEntity, Integer> {
    LichDangEntity findByLichdangid(int showtimeid);
    List<LichDangEntity> findByTenlich(String showtimename, Pageable pageable);
    void deleteByLichdangid(int showtimeid);
}
