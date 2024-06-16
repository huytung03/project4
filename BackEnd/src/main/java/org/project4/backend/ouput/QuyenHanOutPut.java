package org.project4.backend.ouput;

import org.project4.backend.dto.QuyenHanDTO;

import java.util.ArrayList;
import java.util.List;

public class QuyenHanOutPut {
    private int page;
    private int totalPage;
    private List<QuyenHanDTO> listResult = new ArrayList<>();

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

    public List<QuyenHanDTO> getListResult() {
        return listResult;
    }

    public void setListResult(List<QuyenHanDTO> listResult) {
        this.listResult = listResult;
    }
}
