package com.example.demo3.controllers;

import com.example.demo3.models.Product;
import com.example.demo3.services.ModelFactoryService;
import com.example.demo3.services.serviceImpl.Demo;

import java.util.List;

public class ModelFactoryController implements ModelFactoryService {
    private Demo demo;

    @Override
    public void addProduct(String name, String price, String amount) {
        demo.getPsi().addProducto(name,price,amount);
    }

    private static class SingletonHolder{
        private final static ModelFactoryController i= new ModelFactoryController();
    }

    public Demo getDemo() {
        return demo;
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.i;
    }

    public ModelFactoryController() {
        demo = new Demo();
    }
}
