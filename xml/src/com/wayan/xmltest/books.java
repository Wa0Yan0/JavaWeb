package com.wayan.xmltest;

public class books {
    private String cn;
    private String name;
    private String price;
    private String author;

    public books() {
    }

    public books(String cn, String name, String price, String author) {
        this.cn = cn;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "books{" +
                "cn='" + cn + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
