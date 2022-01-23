package com.easykotlin.learn.study9;

import java.util.Date;

/**
 * 实体类产品
 */
public class Product {

    /**
     * ID
     */
    public Long id;

    /**
     * 名称
     */
    public String name;

    /**
     * 分类
     */
    public String category;

    /**
     * 创建时间
     */
    public Date gmtCreate;

    /**
     * 更新时间
     */
    public Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
