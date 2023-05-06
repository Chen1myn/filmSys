package com.film.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Comment)实体类
 *
 * @author Chen1myn
 * @since 2023-05-03 21:35:12
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = -89721382533056775L;
    
    private Integer id;
    /**
     * 评论人
     */
    private String uname;
    /**
     * 评论
     */
    private String content;
    /**
     * 时间
     */
    private Date time;

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    private Integer fid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}

