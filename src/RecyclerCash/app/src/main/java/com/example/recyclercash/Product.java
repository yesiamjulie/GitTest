package com.example.recyclercash;

public class Product {
    String name;
    String manufacturer;
    int countAgent;
    int price;
    int imgRes;


    public Product(String name,
                   String manufacturer,
                   int countAgent,
                   int price, int imgRes) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.countAgent = countAgent;
        this.price = price;
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCountAgent() {
        return countAgent;
    }

    public void setCountAgent(int countAgent) {
        this.countAgent = countAgent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
