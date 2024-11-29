package com.danilel.ecomerce.service.impl;

import com.danilel.ecomerce.entity.Cart;
import com.danilel.ecomerce.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public Cart save(Cart user) {
        return null;
    }

    @Override
    public Cart clearCartById(Long id) {
        return null;
    }


    @Override
    public List<Cart> getCarts() {
        return List.of();
    }

    @Override
    public Optional<Cart> getById(Long id) {
        return Optional.empty();
    }
}
