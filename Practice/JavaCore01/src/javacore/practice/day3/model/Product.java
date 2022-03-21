package javacore.practice.day3.model;

public class Product {
    private int id_product;
    private String name;
    private String price;
    private String picture_name;
    private String picture_url;

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
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

    public String getPicture_name() {
        return picture_name;
    }

    public void setPicture_name(String picture_name) {
        this.picture_name = picture_name;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }

    public Product() {
    }

    public Product(int id_product, String name, String price, String picture_name, String picture_url) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.picture_name = picture_name;
        this.picture_url = picture_url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + id_product +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", picture_name='" + picture_name + '\'' +
                ", picture_url='" + picture_url + '\'' +
                '}';
    }
}
