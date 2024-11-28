package com.danilel.ecomerce.DTOs;

public record ProductDTO(
        String name,
        String description,
        Double price,
        Integer quantity,
        CartDTO cart
) {}
