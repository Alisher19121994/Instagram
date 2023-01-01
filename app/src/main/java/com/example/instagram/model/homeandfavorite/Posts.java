package com.example.instagram.model.homeandfavorite;

public class Posts {
    String caption;
    String image;

    public Posts(String image) {
        this.image = image;
    }

    public String getCaption() {
        return caption;
    }

    public String getImage() {
        return image;
    }
}
