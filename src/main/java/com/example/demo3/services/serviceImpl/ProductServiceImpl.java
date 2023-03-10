package com.example.demo3.services.serviceImpl;

import com.example.demo3.models.Product;
import com.example.demo3.services.ProductService;
import com.example.demo3.utilies.BaseDatos;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private Demo demo;
    private List<Product> productList = new ArrayList<>();
    public ProductServiceImpl(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void addProducto(String name, String price, String amount) {
        Product product = new Product(name,price,amount);
        productList.add(product);
        BaseDatos.agregarProducto(product);

    }

    public List<Product> getProductList() {
        return productList;
    }
}
