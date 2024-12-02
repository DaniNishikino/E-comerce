package com.danilel.ecomerce.controller;

import com.danilel.ecomerce.DTOs.ProductDTO;
import com.danilel.ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(){
        return ResponseEntity.ok(productService.getProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Long id){
        Optional<ProductDTO> product = productService.getById(id);
        return ResponseEntity.ok(product.get());
    }
    @GetMapping("/stockValue/{id}")
    public ResponseEntity<Double> getStockValue(@PathVariable Long id){
        return ResponseEntity.ok(productService.totalValueInStock(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
    @PutMapping("/{id}/{newPrice}")
    public ResponseEntity<ProductDTO>changePrice(@PathVariable Long id, @PathVariable Double newPrice){
        return ResponseEntity.ok(productService.changePrice(id, newPrice));
    }
    @PutMapping("/uptdatequantity/{id}/{quantity}")
    public ResponseEntity<ProductDTO> updateQuantity (@PathVariable Long id, @PathVariable Integer quantity){
        return ResponseEntity.ok(productService.updateQuantity(id, quantity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteById(id));
    }

}
