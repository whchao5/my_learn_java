package com.whchao.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Area implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    private String  name;
    // 权重，越大越排前显示
    private Integer priority;
    private Date    createTime;
    private Date    lastEditTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                ", lastEditTime=" + lastEditTime +
                '}';
    }
}
