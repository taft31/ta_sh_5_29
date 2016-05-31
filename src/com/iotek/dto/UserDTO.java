package com.iotek.dto;

import java.io.Serializable;

/**
 * Created by taft on 2016/5/29.
 */
public class UserDTO implements Serializable{
    private String id;
    private String name;
    private String pass;
    private String img;
    private String udid;
    private String phone;
    private String address;
    private String userID;

    public String getId() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setNAME(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPASS(String pass) {
        this.pass = pass;
    }

    public String getImg() {
        return img;
    }

    public void setIMG(String img) {
        this.img = img;
    }

    public String getUdid() {
        return udid;
    }

    public void setUDID(String udid) {
        this.udid = udid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPHONE(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setADDRESS(String address) {
        this.address = address;
    }

    public String getUserID() {
        return userID;
    }

    public void setUSERID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", img='" + img + '\'' +
                ", udid='" + udid + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
