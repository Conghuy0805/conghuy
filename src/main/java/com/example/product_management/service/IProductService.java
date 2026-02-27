package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService { List<Product> findAll();
    void create(Product product);
    Product findById(int id);
    void update(int id,Product product);
    void delete(int id);
    List<Product> searchByName(String nameSearch);

}
