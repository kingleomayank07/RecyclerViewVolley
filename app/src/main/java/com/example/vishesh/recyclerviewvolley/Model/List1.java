package com.example.vishesh.recyclerviewvolley.Model;

public class List1 {
    private String name;
    private String img;
    private String id;


    public List1(String name, String img, String id) {
        this.name = name;
        this.img = img;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List1(){

    }
}
