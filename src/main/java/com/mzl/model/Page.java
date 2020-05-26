package com.mzl.model;

import java.util.List;

public class Page {

    private int currentPage;    //当前页
    private int pageSize;  //每页的记录数
    private int totalPage;   //总页数
    private List<?> dataList; //每页的数据内容
    private int star;  //开始的数据

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setDataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public List<?> getDataList() {
        return dataList;
    }

    public int getStar() {
        return star;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", dataList=" + dataList +
                ", star=" + star +
                '}';
    }
}
