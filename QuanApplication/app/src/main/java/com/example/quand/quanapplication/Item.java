package com.example.quand.quanapplication;

public class Item {
    private int image;
    private String name;

    public  Item(){}

    public Item(int img, String name){
        this.image = img;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
