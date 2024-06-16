package org.project4.backend.ouput;

import org.project4.backend.dto.NguoiDungDTO;

import java.util.ArrayList;
import java.util.List;

public class NguoiDungOutPut {
    private int page;
    private int totalPage;
    private List<NguoiDungDTO> listResult = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<NguoiDungDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<NguoiDungDTO> listResult) {
        this.listResult = listResult;
    }
}
