package com.atguigu.spring6.iocxml.dimap;

public class Lesson {
    private String lname;

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lname='" + lname + '\'' +
                '}';
    }
}
