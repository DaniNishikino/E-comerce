package com.danilel.ecomerce.service;

import com.danilel.ecomerce.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    Cart save(Cart user);
    Cart clearCartById(Long id);
    List<Cart> getCarts();
    Optional<Cart> getById(Long id);

}
