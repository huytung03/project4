package org.project4.backend.service;

import org.project4.backend.dto.TruyenDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TruyenService {
    List<TruyenDTO> getAll(Pageable pageable);
    List<TruyenDTO> findByStoryname(String storyname, Pageable pageable);
    List<TruyenDTO> findByEpisodes(int episodes, Pageable pageable);
    int totalItem();
    TruyenDTO getById(int storyid);
    void create(TruyenDTO story , MultipartFile file) throws IOException;
    void update(TruyenDTO story , MultipartFile file)throws IOException;
    void delete(int storyid)throws IOException;
}
