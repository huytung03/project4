package org.project4.backend.api.admin;

import jakarta.transaction.Transactional;
import org.project4.backend.dto.TapTruyenDTO;
import org.project4.backend.dto.TruyenDTO;
import org.project4.backend.ouput.TapTruyenOutPut;
import org.project4.backend.service.TapTruyenService;
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
@RequestMapping("/admin/storyep")
public class TapTruyenController {
    @Autowired
    private TapTruyenService tapTruyenService;

    @GetMapping("/getall")
    public TapTruyenOutPut getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        TapTruyenOutPut result = new TapTruyenOutPut();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        result.setListResult(tapTruyenService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (tapTruyenService.totalItem()) / limit));
        return result;
    }
    @GetMapping("/getByStoryid/{storyid}")
    public TapTruyenOutPut getByStoryid(@PathVariable int storyid, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        TapTruyenOutPut result = new TapTruyenOutPut();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page - 1, limit);
        result.setListResult(tapTruyenService.getByStoryid(storyid,pageable));
        result.setTotalPage((int) Math.ceil((double) (tapTruyenService.totalItem()) / limit));
        return result;
    }

    @GetMapping("/get-by-storyepid/{storyepid}")
    public ResponseEntity<?> getByUserId(@PathVariable Integer storyepid) {
        try {
            TapTruyenDTO storyEpDTO = tapTruyenService.getById(storyepid);

            return new ResponseEntity<>(storyEpDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/create-story-ep")
    public ResponseEntity<String> createUser(@RequestParam("epnumber") int epnumber, @RequestParam("story") int storyid,
                               @RequestParam("file") MultipartFile file) {
        try {
            TapTruyenDTO storyEpDTO = new TapTruyenDTO();
                    TruyenDTO storyDTO = new TruyenDTO();
            storyDTO.setTruyenid(storyid);
            storyEpDTO.setSotap(epnumber);
            storyEpDTO.setTruyenid(storyDTO);
            tapTruyenService.create(storyEpDTO, file);
            return new ResponseEntity<>("more success ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-storyep/{storyiepd}")
    public ResponseEntity<String> updateStory(@PathVariable int storyepid,
                                              @RequestParam("epnumber") int epnumber,
                                              @RequestParam("story") int storyid,
                                              @RequestParam("file") MultipartFile file) {
        try {

            TapTruyenDTO storyEpDTO = new TapTruyenDTO();
            TruyenDTO storyDTO = new TruyenDTO();
            storyDTO.setTruyenid(storyid);
            storyEpDTO.setTapid(storyepid);
            storyEpDTO.setSotap(epnumber);
            storyEpDTO.setTruyenid(storyDTO);
            tapTruyenService.update(storyEpDTO, file);
            return new ResponseEntity<>(storyDTO + "Cập nhật thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @DeleteMapping("/delete-storyep/{storyid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable int storyid) {
        try {
            tapTruyenService.delete(storyid);
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
