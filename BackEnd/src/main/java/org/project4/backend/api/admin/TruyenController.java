package org.project4.backend.api.admin;

import jakarta.transaction.Transactional;
import org.project4.backend.dto.TruyenDTO;
import org.project4.backend.ouput.TruyenOutPut;
import org.project4.backend.service.TruyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin/story")
public class TruyenController {
    @Autowired
    private TruyenService truyenService;

    @GetMapping("/getall")
    public TruyenOutPut getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        TruyenOutPut result = new TruyenOutPut();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        result.setListResult(truyenService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (truyenService.totalItem()) / limit));
        return result;
    }

    @GetMapping("/get-by-storyname/{storyname}")
    public TruyenOutPut getByStoryname(@PathVariable String storyname, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        TruyenOutPut result = new TruyenOutPut();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        result.setListResult(truyenService.findByStoryname(storyname, pageable));
        result.setTotalPage((int) Math.ceil((double) (truyenService.totalItem()) / limit));
        return result;
    }

    @GetMapping("/get-by-id/{storyid}")
    public ResponseEntity<?> getById(@PathVariable Integer storyid) {
        try {
            TruyenDTO dto = truyenService.getById(storyid);

            return new ResponseEntity<>(dto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-story")
    public ResponseEntity<String> createUser(@RequestParam("storyname") String storyname, @RequestParam("episodes") String episodes,
                                             @RequestParam("description") String description, @RequestParam("file") MultipartFile file) {
        try {
            TruyenDTO storyDTO = new TruyenDTO();
            storyDTO.setTentruyen(storyname);
            storyDTO.setSotap(episodes);
            storyDTO.setMota(description);
            truyenService.create(storyDTO, file);
            return new ResponseEntity<>("more success ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-story/{storyid}")
    public ResponseEntity<String> updateStory(@PathVariable int storyid, @RequestParam("storyname") String storyname
            , @RequestParam("episodes") String episodes
            , @RequestParam("description") String description
            , @RequestParam("file") MultipartFile file) {
        try {
            TruyenDTO storyDTO = new TruyenDTO();
            storyDTO.setTentruyen(storyname);
            storyDTO.setSotap(episodes);
            storyDTO.setMota(description);
            storyDTO.setTruyenid(storyid);
            truyenService.update(storyDTO, file);
            truyenService.update(storyDTO, file);
            return new ResponseEntity<>(storyDTO + "Cập nhật thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @DeleteMapping("/delete-story/{storyid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable int storyid) {
        try {
            truyenService.delete(storyid);
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
