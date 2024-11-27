package com.danilel.ecomerce.service;

import com.danilel.ecomerce.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product user);
    Product deleteById(Long id);
    List<Product>getUsers();
    Optional<Product> getById(Long id);
}
