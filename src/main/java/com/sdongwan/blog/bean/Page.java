package com.sdongwan.blog.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class Page<E> {
    private int pageMax = -1;
    private int dataCount = -1;
    private int pageIndex = -1;
    private int pageCount = -1;
    private List<E> pageData;

    public Page() {
    }

    public Page(int pageMax, int dataCount, int pageIndex, int pageCount, List<E> pageData) {
        this.pageMax = pageMax;
        this.dataCount = dataCount;
        this.pageIndex = pageIndex;
        this.pageCount = pageCount;
        this.pageData = pageData;
    }

    public int getPageMax() {
        return pageMax;
    }

    public void setPageMax(int pageMax) {
        this.pageMax = pageMax;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<E> getPageData() {
        return pageData;
    }

    public void setPageData(List<E> pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageMax=" + pageMax +
                ", dataCount=" + dataCount +
                ", pageIndex=" + pageIndex +
                ", pageCount=" + pageCount +
                ", pageData=" + pageData +
                '}';
    }
}
