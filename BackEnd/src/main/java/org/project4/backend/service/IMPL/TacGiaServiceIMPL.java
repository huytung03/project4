package org.project4.backend.service.IMPL;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.project4.backend.dto.TacGiaDTO;
import org.project4.backend.entity.TacGiaEntity;
import org.project4.backend.repository.TacgiaRepository;
import org.project4.backend.service.TacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TacGiaServiceIMPL implements TacGiaService {
    @Autowired
    private final TacgiaRepository tacgiaRepository;
    @Autowired
    private final   ModelMapper modelMapper;

    public TacGiaServiceIMPL(TacgiaRepository tacgiaRepository, ModelMapper modelMapper) {
        this.tacgiaRepository = tacgiaRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<TacGiaDTO> getAll(Pageable pageable) {
        List<TacGiaDTO> results = new ArrayList<>();
        List<TacGiaEntity> authorEntities = tacgiaRepository.findAll(pageable).getContent();
        for (TacGiaEntity item: authorEntities
        ) {
            TacGiaDTO dto = modelMapper.map(item,TacGiaDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public List<TacGiaDTO> getByAuthorname(String authorname, Pageable pageable) {
        List<TacGiaDTO> results = new ArrayList<>();
        List<TacGiaEntity> authorEntities = tacgiaRepository.findByTentacgia(authorname,pageable);
        for (TacGiaEntity item: authorEntities
        ) {
            TacGiaDTO dto = modelMapper.map(item,TacGiaDTO.class);
            results.add(dto);
        }
        return results;
    }

    @Override
    public TacGiaDTO getByAuthorid(int authorid) {
        try {
            TacGiaEntity author = tacgiaRepository.findByTacgiaid(authorid);
            if (author == null)  return null;
            return modelMapper.map(author,TacGiaDTO.class);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public int totalItem() {
        return (int) tacgiaRepository.count();
    }


    @Override
    public void create(TacGiaDTO author) {
        if (author != null) {
            TacGiaEntity authorentity =  modelMapper.map(author, TacGiaEntity.class);
            if (authorentity != null ) {

                tacgiaRepository.save(authorentity);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu!");
            }
        }
    }

    @Override
    public void update(TacGiaDTO author) {
        TacGiaEntity existingAuthor  = tacgiaRepository.findByTacgiaid(author.getTacgiaid());
        modelMapper.map(author, existingAuthor);
        tacgiaRepository.save(existingAuthor);
    }

    @Override
    public void delete( int authorid) {
        tacgiaRepository.deleteByTacgiaid(authorid);
    }
}
