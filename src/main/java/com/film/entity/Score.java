package com.film.entity;

import java.io.Serializable;

/**
 * (Score)实体类
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:14
 */
public class Score implements Serializable {
    private static final long serialVersionUID = 834818689536675091L;
    
    private Integer id;
    /**
     * 电影名
     */
    private String fname;
    /**
     * 打分人
     */
    private String uname;
    /**
     * 几星
     */
    private String star;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

}

