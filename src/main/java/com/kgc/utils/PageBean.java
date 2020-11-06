package com.kgc.utils;

import java.util.List;

public class PageBean {
    private int totalRows;
    private int totalPage;
    private int currentPage;
    private int pageSize = 3;
    private List<?> list;

    public PageBean() {
    }

    public PageBean(int currentPage, int totalPage, int pageSize, int totalRows, List<?> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.totalRows = totalRows;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage <= 1){
            this.currentPage = 1;
            return;
        }
        if (currentPage > this.totalPage){
            if (this.totalPage == 0){
                this.currentPage = 1;
            }else{
                this.currentPage = this.totalPage;
            }
            return;
        }
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) { }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        if (this.totalRows % this.pageSize == 0){
            this.totalPage = this.totalRows / this.pageSize;
        }else {
            this.totalPage = this.totalRows / this.pageSize + 1;
        }
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalRows=" + totalRows +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
