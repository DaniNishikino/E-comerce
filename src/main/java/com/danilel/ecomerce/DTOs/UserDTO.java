package com.danilel.ecomerce.DTOs;

import java.util.List;

public record UserDTO(
        String login,
        String password,
        String name,
        String cpf,
        List<AddressDTO> addresses,
        CartDTO cart
) {}
