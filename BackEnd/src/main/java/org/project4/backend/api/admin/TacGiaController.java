package org.project4.backend.api.admin;

import jakarta.transaction.Transactional;
import org.project4.backend.dto.TacGiaDTO;
import org.project4.backend.ouput.TacGiaOutPut;
import org.project4.backend.service.TacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/author")
public class TacGiaController {
    @Autowired
    private TacGiaService tacGiaService;

    @GetMapping("/getall")
    public TacGiaOutPut getALL(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        TacGiaOutPut result = new TacGiaOutPut();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(tacGiaService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (tacGiaService.totalItem()) / limit));
        model.addAttribute("getALL", result);
        return result;
    }
    @GetMapping("/getbyauthorname/{authorname}")
    public TacGiaOutPut getALL(@PathVariable String authorname, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model){
        TacGiaOutPut result = new TacGiaOutPut();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(tacGiaService.getByAuthorname(authorname,pageable));
        result.setTotalPage((int) Math.ceil((double) (tacGiaService.totalItem()) / limit));
        model.addAttribute("getALL", result);
        return result;
    }
    @GetMapping("/hien-thi-theo-id/{authorid}")
    public ResponseEntity<?> getByMenuid(@PathVariable Integer authorid){
        try {
            TacGiaDTO authorDTO = tacGiaService.getByAuthorid(authorid);
            if (authorDTO==null){
                return new ResponseEntity<>( "không có người dùng nào có id là: "+authorid, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(authorDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/them-moi-danh-muc")
    public ResponseEntity<String> createMenu(@RequestBody TacGiaDTO authorDTO ) {
        try {
            tacGiaService.create(authorDTO);
            return new ResponseEntity<>("Thêm thành công" , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/chinh-sua-tac-gia/{authorid}")
    public ResponseEntity<String> updateMenu(@PathVariable Integer authorid, @RequestBody TacGiaDTO authorDTO) {
        try {
            authorDTO.setTacgiaid(authorid);
            tacGiaService.update(authorDTO);
            return new ResponseEntity<>(authorDTO+" Cập nhật thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Transactional
    @DeleteMapping("/xoa-thong-tin/{authorid}")
    public ResponseEntity<String> deleteMenu(@PathVariable Integer authorid) {
        try {
            tacGiaService.delete(authorid);
            return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
