package com.danilel.ecomerce.DTOs;

public record AddressDTO(
        String cep,
        String country,
        String state,
        String city,
        String district,
        String street,
        Integer number
) {}
