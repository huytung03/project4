package org.project4.backend.service.IMPL;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.project4.backend.dto.TruyenDTO;
import org.project4.backend.entity.TruyenEntity;
import org.project4.backend.repository.TruyenRepository;
import org.project4.backend.service.TruyenService;
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
public class TruyenServiceIMPL implements TruyenService {
    @Value("D:/duong/Fontend/File/Images/")
    private String imageSavePath;
    @Autowired
    private TruyenRepository truyenRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<TruyenDTO> getAll(Pageable pageable) {
        List<TruyenDTO> results = new ArrayList<>();
        List<TruyenEntity> epEntities = truyenRepository.findAll(pageable).getContent();
        for (TruyenEntity item : epEntities
        ) {
            TruyenDTO dto = modelMapper.map(item, TruyenDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<TruyenDTO> findByStoryname(String storyname, Pageable pageable) {
        List<TruyenDTO> results = new ArrayList<>();
        List<TruyenEntity> epEntities = truyenRepository.findByTentruyen(storyname,pageable);
        for (TruyenEntity item : epEntities
        ) {
            TruyenDTO dto = modelMapper.map(item, TruyenDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<TruyenDTO> findByEpisodes(int episodes, Pageable pageable) {
        List<TruyenDTO> results = new ArrayList<>();
        List<TruyenEntity> epEntities = truyenRepository.findBySotap(episodes,pageable);
        for (TruyenEntity item : epEntities
        ) {
            TruyenDTO dto = modelMapper.map(item, TruyenDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) truyenRepository.count();
    }

    @Override
    public TruyenDTO getById(int storyid) {
        try {
            TruyenEntity ep = truyenRepository.findByTruyenid(storyid);
            if (ep == null) return null;
            return modelMapper.map(ep, TruyenDTO.class);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public void create(TruyenDTO story , MultipartFile file) throws IOException {
        if( story != null){
            TruyenEntity truyenEntity = modelMapper.map(story, TruyenEntity.class);
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = imageSavePath + filename;
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            truyenEntity.setAnhURL(filename);
            truyenRepository.save(truyenEntity);
        }else{
            throw new RuntimeException("Không lỗi được dữ liệu");
        }
    }

    @Override
    public void update(TruyenDTO story , MultipartFile file) throws IOException {
        if( story != null){
            TruyenEntity truyenEntity = truyenRepository.findByTruyenid(story.getTruyenid());
            modelMapper.map(story, truyenEntity);
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = imageSavePath + filename;
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            if (file.isEmpty()) {
                filename = truyenEntity.getAnhURL();
            }
            truyenEntity.setAnhURL(filename);
            truyenRepository.save(truyenEntity);
        }else{
            throw new RuntimeException("Không lỗi được dữ liệu");
        }
    }

    @Override
    public void delete(int storyid) throws IOException {
    truyenRepository.deleteByTruyenid(storyid);
    }


}
