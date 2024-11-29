package com.danilel.ecomerce.service.impl;

import com.danilel.ecomerce.DTOs.ProductDTO;
import com.danilel.ecomerce.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO deleteById(Long id) {
        return null;
    }

    @Override
    public List<ProductDTO> getProducts() {
        return List.of();
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        return Optional.empty();
    }
}
