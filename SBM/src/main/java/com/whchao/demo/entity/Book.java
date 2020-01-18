package com.whchao.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String name;
    private Integer number;

    public Integer getBook_id() {
        return bookId;
    }

    public void setBook_id(Integer book_id) {
        this.bookId = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + bookId +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
