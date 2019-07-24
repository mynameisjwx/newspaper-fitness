package com.hand6.health.domain.entity;/**
 * Created by Administrator on 2019/7/16.
 */

import lombok.Data;

/**
 * @author xxxx
 * @description
 * @date 2019/7/16
 */
@Data
public class Student {
    private int id;
    private String name;
    private int score;
    private int score1;

    public Student(int id, String name, int score,int score1) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.score1=score1;
    }
}
