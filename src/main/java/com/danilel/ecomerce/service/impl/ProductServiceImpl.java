package com.danilel.ecomerce.service.impl;

import com.danilel.ecomerce.DTOs.ProductDTO;
import com.danilel.ecomerce.entity.Product;
import com.danilel.ecomerce.repository.ProductRepository;
import com.danilel.ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl extends DefaultMethods implements ProductService  {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product productToSave = productToEntity(productDTO);
        productRepository.save(productToSave);
        return productDTO;
    }

    @Override
    public Void deleteById(Long id) {
        if (productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
            return null;
        }else {
            throw new RuntimeException("This product don't exist");
        }
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(DefaultMethods::productToDTO).toList();
    }

    @Override
    public Optional<ProductDTO> getById(Long id) {
        if (productRepository.findById(id).isPresent()){
            return productRepository.findById(id).map(DefaultMethods::productToDTO);
        }else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public ProductDTO changePrice(Long id, Double newPrice) {
        if (productRepository.findById(id).isPresent()){
            Product productToChange = productRepository.findById(id).get();
            productToChange.setPrice(newPrice);
            productRepository.save(productToChange);
            return productToDTO(productToChange);
        }else {
            throw new RuntimeException("This product don't exist");
        }
    }

    @Override
    public ProductDTO updateQuantity(Long id, Integer quantity) {
        if (productRepository.findById(id).isPresent()){
            Product product = productRepository.findById(id).get();
            product.setQuantity(quantity);
            productRepository.save(product);
            return productToDTO(product);
        }else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public Double totalValueInStock(Long id) {
        if (productRepository.findById(id).isPresent()){
            Product product = productRepository.findById(id).get();
            return product.getPrice() * product.getQuantity();
        }else {
            throw  new RuntimeException("Product not found");
        }
    }
}
