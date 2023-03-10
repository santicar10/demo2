package com.example.demo3.services.serviceImpl;

public class Demo {
    private final ProductServiceImpl psi;

    public Demo() {
        this.psi = new ProductServiceImpl(this);
    }

    public ProductServiceImpl getPsi() {
        return psi;
    }
}
