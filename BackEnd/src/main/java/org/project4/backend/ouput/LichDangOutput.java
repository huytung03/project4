package org.project4.backend.ouput;

import org.project4.backend.dto.LichDangDTO;

import java.util.ArrayList;
import java.util.List;

public class LichDangOutput {
    private int page;
    private int totalPage;
    private List<LichDangDTO> listResult = new ArrayList<>();

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

    public List<LichDangDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<LichDangDTO> listResult) {
        this.listResult = listResult;
    }
}
