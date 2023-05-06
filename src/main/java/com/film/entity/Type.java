package com.film.entity;

import java.io.Serializable;

/**
 * (Type)实体类
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:14
 */
public class Type implements Serializable {
    private static final long serialVersionUID = 356622518055631150L;
    
    private Integer id;
    /**
     * 电影类型名
     */
    private String tname;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

}

