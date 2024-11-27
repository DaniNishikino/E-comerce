package com.danilel.ecomerce.service;

import com.danilel.ecomerce.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    User deleteById(Long id);
    List<User>getUsers();
    Optional<User> getById(Long id);
}
