package org.project4.backend.service;

import org.project4.backend.dto.TapTruyenDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TapTruyenService {
    List<TapTruyenDTO> getAll(Pageable pageable);
    List<TapTruyenDTO> getByStoryid(int storyid, Pageable pageable);
    List<TapTruyenDTO> getByEpnumber(int epnumber, Pageable pageable);
    List<TapTruyenDTO> getByEpURL(String epURL, Pageable pageable);
    TapTruyenDTO getById(int epid);
    int totalItem();
    void create(TapTruyenDTO ep , MultipartFile file)throws IOException;
    void update(TapTruyenDTO ep , MultipartFile file)throws IOException;
    void delete(int epid)throws IOException;
}
