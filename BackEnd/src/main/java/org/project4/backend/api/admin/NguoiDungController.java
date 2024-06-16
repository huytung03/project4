package org.project4.backend.api.admin;

import jakarta.transaction.Transactional;
import org.project4.backend.dto.NguoiDungDTO;
import org.project4.backend.ouput.NguoiDungOutPut;
import org.project4.backend.service.NguoiDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/users")
public class NguoiDungController {
    @Autowired
    private NguoiDungService nguoiDungService;

    @GetMapping("/getall")
    public NguoiDungOutPut getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        NguoiDungOutPut result = new NguoiDungOutPut();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(nguoiDungService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (nguoiDungService.totalItem()) / limit));
        return result;
    }

    @GetMapping("/get-by-email/{email}")
    public NguoiDungOutPut getByEmail(@PathVariable String email, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        NguoiDungOutPut result = new NguoiDungOutPut();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(nguoiDungService.getByEmail(email,pageable));
        result.setTotalPage((int) Math.ceil((double) (nguoiDungService.totalItem()) / limit));
        return result;
    }

    @GetMapping("/get-by-username/{username}")
    public NguoiDungOutPut getByUsername(@PathVariable String username, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        NguoiDungOutPut result = new NguoiDungOutPut();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(nguoiDungService.getByUsername(username,pageable));
        result.setTotalPage((int) Math.ceil((double) (nguoiDungService.totalItem()) / limit));
        return result;
    }

    @GetMapping("/get-by-roleid/{roleid}")
    public NguoiDungOutPut getByUsername(@PathVariable int roleid, @RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        NguoiDungOutPut result = new NguoiDungOutPut();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(nguoiDungService.getByRole(roleid,pageable));
        result.setTotalPage((int) Math.ceil((double) (nguoiDungService.totalItem()) / limit));
            return result;
    }
    @GetMapping("/user-by-id/{userid}")
    public ResponseEntity<?> getByUserId(@PathVariable Integer userid) {
        try {
            NguoiDungDTO userDTO = nguoiDungService.getById(userid);

            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<NguoiDungDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody NguoiDungDTO userDTO) {
        try {
            nguoiDungService.create(userDTO);
            return new ResponseEntity<>("more success " , HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-user/{userid}")
    public ResponseEntity<String> updateUserAccount(@PathVariable int userid, @RequestBody NguoiDungDTO userDTO) {
        try {
            userDTO.setNguoidungid(userid);
            nguoiDungService.update(userDTO);
            return new ResponseEntity<>(userDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xóa dữ liệu
    @Transactional
    @DeleteMapping("/delete-user/{userid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable int userid) {
        try {
            nguoiDungService.delete(userid);
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
