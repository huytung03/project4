package org.project4.backend.service;

import org.project4.backend.dto.NguoiDungDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NguoiDungService {
    List<NguoiDungDTO> getAll(Pageable pageable);
    List<NguoiDungDTO> getByUsername(String username, Pageable pageable);
    int totalItem();
    List<NguoiDungDTO> getByEmail(String email, Pageable pageable);
    List<NguoiDungDTO> getByPhone(String phone, Pageable pageable);
    List<NguoiDungDTO> getByRole(Integer role, Pageable pageable);
    NguoiDungDTO getById(int userid);
    void create(NguoiDungDTO user);
    void update(NguoiDungDTO user);
    void delete(int user);
}
