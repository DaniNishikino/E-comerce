package com.danilel.ecomerce.service;

import com.danilel.ecomerce.DTOs.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO deleteById(Long id);
    List<ProductDTO> getProducts();
    Optional<ProductDTO> getById(Long id);

}
