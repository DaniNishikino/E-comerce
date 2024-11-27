package com.danilel.ecomerce.service.impl;

import com.danilel.ecomerce.entity.Product;
import com.danilel.ecomerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product save(Product user) {
        return null;
    }

    @Override
    public Product deleteById(Long id) {
        return null;
    }

    @Override
    public List<Product> getUsers() {
        return List.of();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return Optional.empty();
    }
}
