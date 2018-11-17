package net.rdd.common;

import java.io.Serializable;

/**
 * Created by rdd on 2018/11/16.
 */
public class Person implements Serializable {

    private static final long serialVersionUID = -7898194272883238670L;

    String name;
    String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
