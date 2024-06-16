package org.project4.backend.service.IMPL;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.project4.backend.dto.TapTruyenDTO;
import org.project4.backend.entity.TruyenEntity;
import org.project4.backend.entity.TapTruyenEntity;
import org.project4.backend.repository.TapTruyenRepository;
import org.project4.backend.repository.TruyenRepository;
import org.project4.backend.service.TapTruyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TapTruyenServiceIMPL implements TapTruyenService {
    @Value("D:/duong/Fontend/File/Storyfile/")
   private String imageSavePath ;
    @Autowired
    private TapTruyenRepository tapTruyenRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private TruyenRepository truyenRepository;
    @Override
    public List<TapTruyenDTO> getAll(Pageable pageable) {
        List<TapTruyenDTO> results = new ArrayList<>();
        List<TapTruyenEntity> epEntities = tapTruyenRepository.findAll(pageable).getContent();
        for (TapTruyenEntity item : epEntities
        ) {
            TapTruyenDTO dto = modelMapper.map(item, TapTruyenDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<TapTruyenDTO> getByStoryid(int storyid, Pageable pageable) {
        List<TapTruyenDTO> results = new ArrayList<>();
        TruyenEntity story = truyenRepository.findByTruyenid(storyid);
        List<TapTruyenEntity> epEntities = tapTruyenRepository.findByTruyenid(story,pageable);
        for (TapTruyenEntity item : epEntities
        ) {
            TapTruyenDTO dto = modelMapper.map(item, TapTruyenDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<TapTruyenDTO> getByEpnumber(int epnumber, Pageable pageable) {
        List<TapTruyenDTO> results = new ArrayList<>();
        List<TapTruyenEntity> epEntities = tapTruyenRepository.findBySotap(epnumber,pageable);
        for (TapTruyenEntity item : epEntities
        ) {
            TapTruyenDTO dto = modelMapper.map(item, TapTruyenDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<TapTruyenDTO> getByEpURL(String epURL, Pageable pageable) {
        List<TapTruyenDTO> results = new ArrayList<>();
        List<TapTruyenEntity> epEntities = tapTruyenRepository.findByTruyenURL(epURL,pageable);
        for (TapTruyenEntity item : epEntities
        ) {
            TapTruyenDTO dto = modelMapper.map(item, TapTruyenDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public TapTruyenDTO getById(int epid) {
        try {
            TapTruyenEntity ep = tapTruyenRepository.findByTapid(epid);
            if (ep == null) return null;
            return modelMapper.map(ep, TapTruyenDTO.class);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public int totalItem() {
        return (int) tapTruyenRepository.count();
    }

    @Override
    public void create(TapTruyenDTO ep, MultipartFile file) throws IOException {
        if( ep != null){
            TapTruyenEntity epEntity = modelMapper.map(ep, TapTruyenEntity.class);
            TruyenEntity story = truyenRepository.findByTruyenid(ep.getTruyenid().getTruyenid());
            epEntity.setTruyenid(story);
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = imageSavePath + filename;
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            epEntity.setTruyenURL(filename);
            tapTruyenRepository.save(epEntity);
        }else{
            throw new RuntimeException("Không lỗi được dữ liệu");
        }
    }

    @Override
    public void update(TapTruyenDTO ep , MultipartFile file) throws IOException {
        if( ep != null){
            TapTruyenEntity epEntity = tapTruyenRepository.findByTapid(ep.getTapid());
            TruyenEntity story = truyenRepository.findByTruyenid(epEntity.getTruyenid().getTruyenid());
            epEntity.setTruyenid(story);
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = imageSavePath + filename;
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            if (file.isEmpty()) {
                filename = epEntity.getTruyenURL();
            }
            epEntity.setTruyenURL(filename);
            tapTruyenRepository.save(epEntity);
        }else{
            throw new RuntimeException("Không lỗi được dữ liệu");
        }
    }

    @Override
    public void delete(int epid) throws IOException {
        try {
            TapTruyenEntity epEntity = tapTruyenRepository.findByTapid(epid);
            if (epEntity != null) {
                tapTruyenRepository.delete(epEntity);
            }
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting data", e);
        }
    }

}
