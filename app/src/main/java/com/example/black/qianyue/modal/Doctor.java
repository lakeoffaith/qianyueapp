package com.example.black.qianyue.modal;

/**
 * Created by black on 2017/5/3.
 */
public class Doctor {
    private  String name;
    private String img;
    private int age;

    public Doctor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", age=" + age +
                '}';
    }
}
