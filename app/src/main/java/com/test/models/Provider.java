package com.test.models;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinsol on 4/6/15.
 */
public class Provider implements Serializable {

    @Expose
    private int id;
    @Expose
    private String name;
    @Expose
    private String phone;
    @Expose
    private ArrayList<String> served_pincode_list = new ArrayList<String>();
    @Expose
    private String address;
    @Expose
    private int average_delivery_time;
    @Expose
    private String image;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<String> getServed_pincode_list() {
        return served_pincode_list;
    }

    public void setServed_pincode_list(ArrayList<String> served_pincode_list) {
        this.served_pincode_list = served_pincode_list;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAverage_delivery_time() {
        return average_delivery_time;
    }

    public void setAverage_delivery_time(int average_delivery_time) {
        this.average_delivery_time = average_delivery_time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
