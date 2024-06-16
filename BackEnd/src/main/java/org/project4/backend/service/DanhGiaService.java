package org.project4.backend.service;

import org.project4.backend.dto.DanhGiaDTO;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;

public interface DanhGiaService {
    List<DanhGiaDTO> getAll(Pageable pageable);
    List<DanhGiaDTO> getByReviewDate(Date adddate, Pageable pageable);
    List<DanhGiaDTO> getByContent(String content, Pageable pageable);
    List<DanhGiaDTO> getByUser(int userid, Pageable pageable);
    List<DanhGiaDTO> getByStory(int storyid, Pageable pageable);
    int totalItem();
    DanhGiaDTO getById(int reviewid);

    void create(DanhGiaDTO review);

    void update(DanhGiaDTO review);

    void delete(int reviewid);
}
