package org.project4.backend.service.IMPL;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.project4.backend.dto.LichDangDTO;
import org.project4.backend.entity.LichDangEntity;
import org.project4.backend.repository.LichDangRepository;
import org.project4.backend.service.LichDangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LichDangServiceIMPL implements LichDangService {
    @Autowired
    private LichDangRepository lichDangRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LichDangDTO> getAll(Pageable pageable) {
        List<LichDangDTO> results = new ArrayList<>();
        List<LichDangEntity> showtimeEntities = lichDangRepository.findAll(pageable).getContent();
        for (LichDangEntity item : showtimeEntities
        ) {
            LichDangDTO dto = modelMapper.map(item, LichDangDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<LichDangDTO> getByShowtimename(String showtimename, Pageable pageable) {
        List<LichDangDTO> results = new ArrayList<>();
        List<LichDangEntity> showtimeEntities = lichDangRepository.findByTenlich(showtimename, pageable);
        for (LichDangEntity item : showtimeEntities
        ) {
            LichDangDTO dto = modelMapper.map(item, LichDangDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public LichDangDTO getById(int showtimeid) {
        try {
            LichDangEntity showtime = lichDangRepository.findByLichdangid(showtimeid);
            if (showtime == null) return null;
            return modelMapper.map(showtime, LichDangDTO.class);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public int totalItem() {
        return (int) lichDangRepository.count();
    }

    @Override
    public void create(LichDangDTO showtime) {
        if (showtime != null) {
            LichDangEntity lichDangEntity = modelMapper.map(showtime, LichDangEntity.class);
            if (lichDangEntity != null) {

                lichDangRepository.save(lichDangEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu!");
            }
        }
    }

    @Override
    public void update(LichDangDTO showtime) {
        LichDangEntity existingShowtime = lichDangRepository.findByLichdangid(showtime.getLichdangid());
        modelMapper.map(showtime, existingShowtime);
        lichDangRepository.save(existingShowtime);
    }

    @Override
    public void delete(int showtimeid) {
        lichDangRepository.deleteByLichdangid(showtimeid);
    }

}
