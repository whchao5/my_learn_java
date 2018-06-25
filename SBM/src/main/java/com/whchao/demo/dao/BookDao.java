package com.whchao.demo.dao;

import com.whchao.demo.entity.Book;

import java.util.List;

public interface BookDao {

    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Book> queryBook();


    Book queryBookById(int id);
}
