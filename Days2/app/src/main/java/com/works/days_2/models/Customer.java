package com.works.days_2.models;

import androidx.annotation.NonNull;

public class Customer {

    private int cid;
    private String name;
    private String surname;
    private String address;

    public Customer() {}

    public Customer(int cid, String name, String surname, String address) {
        this.cid = cid;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
