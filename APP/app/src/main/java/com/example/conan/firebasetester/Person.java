package com.example.conan.firebasetester;

/**
 * Created by Conan on 15/11/2017.
 */

public class Person {
    String name;
    String info;

    public Person(){

    }

    public Person(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
