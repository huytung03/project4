package org.project4.backend.service;

import org.project4.backend.dto.LichDangDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LichDangService {
     List<LichDangDTO> getAll(Pageable pageable);

     List<LichDangDTO> getByShowtimename(String showtimename, Pageable pageable);
     LichDangDTO getById(int showtimeid);
     int totalItem();
     void create(LichDangDTO showtime);

     void update(LichDangDTO showtime);

     void delete(int showtimeid);
}
