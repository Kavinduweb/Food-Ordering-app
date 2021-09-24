package com.example.myapplication;

public class RequestModelClass {
    Integer id;
    String name;
    String email;
    String category;
    String type;

    public RequestModelClass(String name, String email, String category, String type) {
        this.name = name;
        this.email = email;
        this.category = category;
        this.type = type;
    }

    public RequestModelClass(Integer id, String name, String email, String category, String type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.category = category;
        this.type = type;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
