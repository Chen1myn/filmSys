package com.film.entity;

import java.io.Serializable;

/**
 * (Watch)实体类
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:15
 */
public class Watch implements Serializable {
    private static final long serialVersionUID = -51913930777343253L;
    
    private Integer id;
    
    private String fname;
    
    private Integer age;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}

