package org.project4.backend.service;

import org.project4.backend.dto.TacGiaDTO;
import org.project4.backend.entity.TacGiaEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TacGiaService {
    // hiển thị danh sách tác giả
    List<TacGiaDTO> getAll(Pageable pageable);
    // tìm kiếm theo tên tác giả
    List<TacGiaDTO> getByAuthorname(String authorname, Pageable pageable);

    // tìm kiếm theo id
    TacGiaDTO getByAuthorid(int authorid);


int  totalItem();

    // tạo tác giả
    void create(TacGiaDTO author);
    // cập nhật tác giả
    void update(TacGiaDTO author);
    // xóa tác giả
    void delete(int authorid);
}
