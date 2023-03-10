package com.example.firebaseauth;

public class Data {
    private String title;
    private String desc;
    private String language;
    private String img;

    public Data(String title, String desc, String language, String img) {
        this.title = title;
        this.desc = desc;
        this.language = language;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Data{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", language='" + language + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
