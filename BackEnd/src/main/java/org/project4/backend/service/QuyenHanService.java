package org.project4.backend.service;

import org.project4.backend.dto.QuyenHanDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuyenHanService {

    List<QuyenHanDTO> getAll(Pageable pageable);

    List<QuyenHanDTO> getByRolename(String rolename, Pageable pageable);

    QuyenHanDTO getByRoleid(int roleid);
    int totalItem();
    void create(QuyenHanDTO roles);

    void update(QuyenHanDTO roles);

    void delete(int rolesid);
}
