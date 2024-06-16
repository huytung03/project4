package org.project4.backend.service.IMPL;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.project4.backend.dto.DanhGiaDTO;
import org.project4.backend.entity.DanhGiaEntity;
import org.project4.backend.entity.TruyenEntity;
import org.project4.backend.entity.NguoiDungEntity;
import org.project4.backend.repository.DanhGiaRepository;
import org.project4.backend.repository.TruyenRepository;
import org.project4.backend.repository.NguoiDungRepository;
import org.project4.backend.service.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class DanhGiaServiceIMPL implements DanhGiaService {
    @Autowired
    private final DanhGiaRepository danhGiaRepository;
    @Autowired
    private final NguoiDungRepository nguoiDungRepository;
    @Autowired
    private final TruyenRepository truyenRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public DanhGiaServiceIMPL(DanhGiaRepository danhGiaRepository, NguoiDungRepository nguoiDungRepository, TruyenRepository truyenRepository, ModelMapper modelMapper) {
        this.danhGiaRepository = danhGiaRepository;
        this.nguoiDungRepository = nguoiDungRepository;
        this.truyenRepository = truyenRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DanhGiaDTO> getAll(Pageable pageable) {
        List<DanhGiaDTO> results = new ArrayList<>();
        List<DanhGiaEntity> reviewEntities = danhGiaRepository.findAll(pageable).getContent();
        for (DanhGiaEntity item : reviewEntities
        ) {
            DanhGiaDTO dto = modelMapper.map(item, DanhGiaDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<DanhGiaDTO> getByReviewDate(Date adddate, Pageable pageable) {
        List<DanhGiaDTO> results = new ArrayList<>();
        List<DanhGiaEntity> reviewEntities = danhGiaRepository.findByNgaydang(adddate, pageable);
        for (DanhGiaEntity item : reviewEntities
        ) {
            DanhGiaDTO dto = modelMapper.map(item, DanhGiaDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<DanhGiaDTO> getByContent(String content, Pageable pageable) {
        List<DanhGiaDTO> results = new ArrayList<>();
        List<DanhGiaEntity> reviewEntities = danhGiaRepository.findByNoidung(content, pageable);
        for (DanhGiaEntity item : reviewEntities
        ) {
            DanhGiaDTO dto = modelMapper.map(item, DanhGiaDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<DanhGiaDTO> getByUser(int userid, Pageable pageable) {
        List<DanhGiaDTO> results = new ArrayList<>();
        NguoiDungEntity user = nguoiDungRepository.findByNguoidungid(userid);
        List<DanhGiaEntity> reviewEntities = danhGiaRepository.findByNguoidungid(user, pageable);
        for (DanhGiaEntity item : reviewEntities
        ) {
            DanhGiaDTO dto = modelMapper.map(item, DanhGiaDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<DanhGiaDTO> getByStory(int storyid, Pageable pageable) {
        List<DanhGiaDTO> results = new ArrayList<>();
        TruyenEntity story = truyenRepository.findByTruyenid(storyid);
        List<DanhGiaEntity> reviewEntities = danhGiaRepository.findByTruyenid(story, pageable);
        for (DanhGiaEntity item : reviewEntities
        ) {
            DanhGiaDTO dto = modelMapper.map(item, DanhGiaDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) danhGiaRepository.count();
    }

    @Override
    public DanhGiaDTO getById(int reviewid) {
        try {
            DanhGiaEntity review = danhGiaRepository.findByDanhgiaid(reviewid);
            if (review == null) return null;
            return modelMapper.map(review, DanhGiaDTO.class);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public void create(DanhGiaDTO review) {
        if (review != null) {
            DanhGiaEntity reviewEntity = modelMapper.map(review, DanhGiaEntity.class);
            if (reviewEntity != null) {

                danhGiaRepository.save(reviewEntity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu!");
            }
        }
    }

    @Override
    public void update(DanhGiaDTO review) {
        DanhGiaEntity existingReview = danhGiaRepository.findByDanhgiaid(review.getDanhgiaid());
        modelMapper.map(review, existingReview);
        danhGiaRepository.save(existingReview);
    }

    @Override
    public void delete(int reviewid) {
        danhGiaRepository.deleteByDanhgiaid(reviewid);
    }
}
