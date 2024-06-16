package org.project4.backend.ouput;

import org.project4.backend.dto.DanhGiaDTO;

import java.util.ArrayList;
import java.util.List;

public class DanhGiaOutPut {
    private int page;
    private int totalPage;
    private List<DanhGiaDTO> listResult = new ArrayList<>();

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

    public List<DanhGiaDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<DanhGiaDTO> listResult) {
        this.listResult = listResult;
    }
}
