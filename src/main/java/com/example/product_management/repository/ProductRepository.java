package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final List<Product> list;

    static {
        list = new ArrayList<>();
        list.add(new Product(1, "Cake", 22000, "Out of product", "Orion"));
        list.add(new Product(2, "Candy", 22000, "Also product", "Classy Foods"));
        list.add(new Product(3, "Jam", 22000, "Also product", "Classy Foods"));
        list.add(new Product(4, "Milk", 22000, "Out of product", "Th-True Milk"));
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public void create(Product product) {
        list.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : list) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        int index;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                list.set(index, product);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }
    }

    @Override
    public List<Product> searchByName(String nameSearch) {
        List<Product> products = new ArrayList<>();
        for (Product product : list) {
            if (product.getName().contains(nameSearch)) {
                products.add(product);
            }
        }
        return products;
    }
}
