package org.project4.backend.service.IMPL;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.project4.backend.dto.QuyenHanDTO;
import org.project4.backend.entity.QuyenHanEntity;
import org.project4.backend.repository.QuyenHanRepository;
import org.project4.backend.service.QuyenHanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuyenHanServiceIMPL implements QuyenHanService {
    @Autowired
    private QuyenHanRepository quyenHanRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<QuyenHanDTO> getAll(Pageable pageable) {
        List<QuyenHanDTO> results = new ArrayList<>();
        List<QuyenHanEntity> roleEntities = quyenHanRepository.findAll(pageable).getContent();
        for (QuyenHanEntity item : roleEntities
        ) {
            QuyenHanDTO dto = modelMapper.map(item, QuyenHanDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<QuyenHanDTO> getByRolename(String rolename, Pageable pageable) {
        List<QuyenHanDTO> results = new ArrayList<>();
        List<QuyenHanEntity> roleEntities = quyenHanRepository.findByTenquyenhan(rolename,pageable);
        for (QuyenHanEntity item : roleEntities
        ) {
            QuyenHanDTO dto = modelMapper.map(item, QuyenHanDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public QuyenHanDTO getByRoleid(int roleid) {
        try {
            QuyenHanEntity role = quyenHanRepository.findByQuyenhanid(roleid);
            if (role == null) return null;
            return modelMapper.map(role, QuyenHanDTO.class);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public int totalItem() {
        return (int) quyenHanRepository.count();
    }

    @Override
    public void create(QuyenHanDTO roles) {
        if (roles != null) {
            QuyenHanEntity rolesEntity = modelMapper.map(roles, QuyenHanEntity.class);
            if (rolesEntity != null) {

                quyenHanRepository.save(rolesEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu!");
            }
        }
    }

    @Override
    public void update(QuyenHanDTO roles) {
        QuyenHanEntity existingRole = quyenHanRepository.findByQuyenhanid(roles.getQuyenhanid());
        modelMapper.map(roles, existingRole);
        quyenHanRepository.save(existingRole);
    }

    @Override
    public void delete(int rolesid) {
        quyenHanRepository.deleteByQuyenhanid(rolesid);
    }
}
