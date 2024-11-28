package com.danilel.ecomerce.service;

import com.danilel.ecomerce.DTOs.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserDTO user);
    void deleteById(Long id);
    List<UserDTO>getUsers();
    Optional<UserDTO> getById(Long id);
}
