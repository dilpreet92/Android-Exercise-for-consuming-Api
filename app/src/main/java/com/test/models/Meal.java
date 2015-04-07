package com.test.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

/**
 * Created by vinsol on 4/7/15.
 */
public class Meal implements Serializable {
    @Expose
    private int id;
    @Expose
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.getName();
    }
}
