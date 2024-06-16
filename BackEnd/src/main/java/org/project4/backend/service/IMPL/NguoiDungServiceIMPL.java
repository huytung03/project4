package org.project4.backend.service.IMPL;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.project4.backend.dto.NguoiDungDTO;
import org.project4.backend.entity.QuyenHanEntity;
import org.project4.backend.entity.NguoiDungEntity;
import org.project4.backend.repository.QuyenHanRepository;
import org.project4.backend.repository.NguoiDungRepository;
import org.project4.backend.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NguoiDungServiceIMPL implements NguoiDungService {
    @Autowired
    private NguoiDungRepository nguoiDungRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private QuyenHanRepository roleRepository;

    @Override
    public List<NguoiDungDTO> getAll(Pageable pageable) {
        List<NguoiDungDTO> results = new ArrayList<>();
        List<NguoiDungEntity> epEntities = nguoiDungRepository.findAll(pageable).getContent();
        for (NguoiDungEntity item : epEntities
        ) {
            NguoiDungDTO dto = modelMapper.map(item, NguoiDungDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<NguoiDungDTO> getByUsername(String username, Pageable pageable) {
        List<NguoiDungDTO> results = new ArrayList<>();
        List<NguoiDungEntity> epEntities = nguoiDungRepository.findByTendangnhap(username,pageable);
        for (NguoiDungEntity item : epEntities
        ) {
            NguoiDungDTO dto = modelMapper.map(item, NguoiDungDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) nguoiDungRepository.count();
    }

    @Override
    public List<NguoiDungDTO> getByEmail(String email, Pageable pageable) {
        List<NguoiDungDTO> results = new ArrayList<>();
        List<NguoiDungEntity> epEntities = nguoiDungRepository.findByEmail(email,pageable);
        for (NguoiDungEntity item : epEntities
        ) {
            NguoiDungDTO dto = modelMapper.map(item, NguoiDungDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<NguoiDungDTO> getByPhone(String phone, Pageable pageable) {
        List<NguoiDungDTO> results = new ArrayList<>();
        List<NguoiDungEntity> epEntities = nguoiDungRepository.findBySodienthoai(phone,pageable);
        for (NguoiDungEntity item : epEntities
        ) {
            NguoiDungDTO dto = modelMapper.map(item, NguoiDungDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<NguoiDungDTO> getByRole(Integer role, Pageable pageable) {
        List<NguoiDungDTO> results = new ArrayList<>();
        QuyenHanEntity rolesEntity = roleRepository.findById(role).get();
        List<NguoiDungEntity> epEntities = nguoiDungRepository.findByQuyenhanid(rolesEntity,pageable);
        for (NguoiDungEntity item : epEntities
        ) {
            NguoiDungDTO dto = modelMapper.map(item, NguoiDungDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public NguoiDungDTO getById(int userid) {
        try {
            NguoiDungEntity user = nguoiDungRepository.findByNguoidungid(userid);
            if (user == null)  return null;
            return modelMapper.map(user, NguoiDungDTO.class);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public void create(NguoiDungDTO user) {
        if (user != null) {
             NguoiDungEntity nguoiDungEntity =  modelMapper.map(user, NguoiDungEntity.class);
             QuyenHanEntity rolesEntity = roleRepository.findByQuyenhanid(user.getQuyenhanid().getQuyenhanid());
             nguoiDungEntity.setQuyenhanid(rolesEntity);
            if (nguoiDungEntity != null ) {
                nguoiDungRepository.save(nguoiDungEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu!");
            }
        }
    }

    @Override
    public void update(NguoiDungDTO user) {
        if (user != null) {
            NguoiDungEntity nguoiDungEntity = modelMapper.map(user, NguoiDungEntity.class);
            QuyenHanEntity rolesEntity = roleRepository.findByQuyenhanid(user.getQuyenhanid().getQuyenhanid());
            nguoiDungEntity.setQuyenhanid(rolesEntity);
            if (nguoiDungEntity != null) {
                nguoiDungRepository.save(nguoiDungEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu!");
            }
        }
    }

    @Override
    public void delete(int user) {
     nguoiDungRepository.deleteByNguoidungid(user);
    }


}
