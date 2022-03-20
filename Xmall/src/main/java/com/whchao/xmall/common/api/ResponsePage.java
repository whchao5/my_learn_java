package com.whchao.xmall.common.api;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public class ResponsePage<T> {

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long    total;
    private List<T> list;



    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> ResponsePage<T> restPage(List<T> list) {

        ResponsePage result = new ResponsePage();

        PageInfo<T> page = new PageInfo<T>(list);

        result.setPageNum(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setTotalPage(page.getPages());
        result.setTotal(page.getTotal());
        result.setList(page.getList());

        return result;
    }

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> ResponsePage<T> restPage(Page<T> pageInfo) {

        ResponsePage result = new ResponsePage();

        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotalPage(pageInfo.getTotalPages());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());

        return  result;
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
