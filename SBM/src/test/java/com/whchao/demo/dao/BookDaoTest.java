package com.whchao.demo.dao;

import com.whchao.demo.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    public void queryBook() {
        List<Book> list = bookDao.queryBook();

        System.out.println(list);
//        assertEquals(false, list.size());
    }

    @Test
    public void queryBookById() {
        Book book = bookDao.queryBookById(1001);

        System.out.println(book);
        assertEquals(1001, book.getBook_id().intValue());

    }
}
