package com.film.entity;

import java.io.Serializable;

/**
 * (Film)实体类
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:14
 */
public class Film implements Serializable {
    private static final long serialVersionUID = -92180324883344147L;
    
    private Integer id;
    
    private String fname;
    
    private String type;
    
    private int rate;
    
    private String img;
    
    private String video;


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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}

