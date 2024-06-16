package org.project4.backend.ouput;

import org.project4.backend.dto.TacGiaDTO;

import java.util.ArrayList;
import java.util.List;

public class TacGiaOutPut {
    private int page;
    private int totalPage;
    private List<TacGiaDTO> listResult = new ArrayList<>();

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

    public List<TacGiaDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<TacGiaDTO> listResult) {
        this.listResult = listResult;
    }
}
