package com.whchao.demo.entity;


import java.util.Date;

public class Girls {

    private Integer girl_id;
    private Integer age;
    private String  name;

    public Integer getGirl_id() {
        return girl_id;
    }

    public void setGirl_id(Integer girl_id) {
        this.girl_id = girl_id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girls{" +
                "girl_id=" + girl_id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
