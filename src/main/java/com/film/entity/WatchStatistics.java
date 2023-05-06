package com.film.entity;

/**
 * @author:Chen1myn
 * @time: 2023/5/5
 */
public class WatchStatistics {
    private int num;
    private int age;

    public WatchStatistics(int num, int age) {
        this.num = num;
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
