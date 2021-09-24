package com.example.myapplication;

public class DeliveryModelClass {

    Integer id;
    String name;
    String address;
    String location;
    String number;

    public DeliveryModelClass(String name, String address, String location, String number) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.number = number;
    }

    public DeliveryModelClass(Integer id, String name, String address, String location, String number) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.location = location;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
