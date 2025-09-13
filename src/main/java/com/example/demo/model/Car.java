package com.example.demo.model;

import jakarta.validation.constraints.Size;

public class Car {
    @Size(min = 1, message = "no mínimo 1 letra")
    private String name;

    private String id;

    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
