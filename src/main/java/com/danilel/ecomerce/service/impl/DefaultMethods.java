package com.danilel.ecomerce.service.impl;

import com.danilel.ecomerce.DTOs.AddressDTO;
import com.danilel.ecomerce.DTOs.CartDTO;
import com.danilel.ecomerce.DTOs.ProductDTO;
import com.danilel.ecomerce.DTOs.UserDTO;
import com.danilel.ecomerce.entity.Address;
import com.danilel.ecomerce.entity.Cart;
import com.danilel.ecomerce.entity.Product;
import com.danilel.ecomerce.entity.User;

import java.util.stream.Collectors;

public abstract class DefaultMethods {
    public static User userToEntity(UserDTO userDTO) {
        return new User(
                userDTO.login(),
                userDTO.password(),
                userDTO.name(),
                userDTO.cpf(),
                userDTO.addresses().stream().map(DefaultMethods::addressToEntity).collect(Collectors.toList()),
                userDTO.cart() != null ? cartToEntity(userDTO.cart()) : null
        );
    }

    public static UserDTO userToDTO(User user) {
        return new UserDTO(
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getCpf(),
                user.getAddresses().stream().map(DefaultMethods::addressToDTO).collect(Collectors.toList()),
                user.getCart() != null ? cartToDTO(user.getCart()) : null
        );
    }

    public static Address addressToEntity(AddressDTO addressDTO) {
        return new Address(
                addressDTO.cep(),
                addressDTO.country(),
                addressDTO.state(),
                addressDTO.city(),
                addressDTO.district(),
                addressDTO.street(),
                addressDTO.number()
        );
    }

    public static AddressDTO addressToDTO(Address address) {
        return new AddressDTO(
                address.getCep(),
                address.getCountry(),
                address.getState(),
                address.getCity(),
                address.getDistrict(),
                address.getStreet(),
                address.getNumber()
        );
    }

    public static Cart cartToEntity(CartDTO cartDTO) {
        return new Cart(
                cartDTO.products().stream().map(DefaultMethods::productToEntity).collect(Collectors.toList()),
                cartDTO.totalPrice()
        );
    }

    public static CartDTO cartToDTO(Cart cart) {
        return new CartDTO(
                cart.getProducts().stream().map(DefaultMethods::productToDTO).collect(Collectors.toList()),
                cart.getTotalPrice()
        );
    }

    public static Product productToEntity(ProductDTO productDTO) {
        return new Product(
                productDTO.name(),
                productDTO.description(),
                productDTO.price(),
                productDTO.quantity()
        );
    }

    public static ProductDTO productToDTO(Product product) {
        return new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                null
        );
    }
}
