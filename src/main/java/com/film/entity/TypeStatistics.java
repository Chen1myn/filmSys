package com.film.entity;

/**
 * @author:Chen1myn
 * @time: 2023/5/5
 */
public class TypeStatistics {

    private int num;
    private String type;

    public TypeStatistics(int num, String type) {
        this.num = num;
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
