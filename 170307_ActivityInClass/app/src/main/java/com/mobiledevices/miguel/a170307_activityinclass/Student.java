package com.mobiledevices.miguel.a170307_activityinclass;

/**
 * Created by miguel on 7/03/17.
 */

public class Student {

    private String name;
    private float grade;

    public Student(String n, float g) {

        this.name = n;
        this.grade = g;
    }

    public String getName() {

        return this.name;
    }

    public float getGrade() {

        return this.grade;
    }
}
