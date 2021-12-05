package com.oyelabs.marvel.universe.models;

public class marvelData {
    String imgurl;
    String name;
    String id;

    public marvelData(String imgurl, String name, String id) {
        this.imgurl = imgurl;
        this.name = name;
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
