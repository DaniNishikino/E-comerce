package com.danilel.ecomerce.DTOs;

import java.util.List;

public record CartDTO(
        List<ProductDTO> products,
        Double totalPrice
) {}
