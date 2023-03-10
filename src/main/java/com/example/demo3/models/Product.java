package com.example.demo3.models;

public class Product {
    private String name;
    private String price;
    private String amount;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Product(String name, String price, String amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }


    public String getAmount() {
        return amount;
    }

}
