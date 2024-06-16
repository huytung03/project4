package org.project4.backend.ouput;

import org.project4.backend.dto.TapTruyenDTO;

import java.util.ArrayList;
import java.util.List;

public class TapTruyenOutPut {
    private int page;
    private int totalPage;
    private List<TapTruyenDTO> listResult = new ArrayList<>();

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

    public List<TapTruyenDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<TapTruyenDTO> listResult) {
        this.listResult = listResult;
    }
}
