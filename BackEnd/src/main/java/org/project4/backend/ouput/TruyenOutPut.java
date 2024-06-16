package org.project4.backend.ouput;

import org.project4.backend.dto.TruyenDTO;

import java.util.ArrayList;
import java.util.List;

public class TruyenOutPut {

    private int page;
    private int totalPage;
    private List<TruyenDTO> listResult = new ArrayList<>();

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

    public List<TruyenDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<TruyenDTO> listResult) {
        this.listResult = listResult;
    }
}
