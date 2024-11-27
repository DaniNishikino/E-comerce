package com.danilel.ecomerce.service.impl;

import com.danilel.ecomerce.entity.User;
import com.danilel.ecomerce.repository.UserRepository;
import com.danilel.ecomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User deleteById(Long id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.empty();
    }
}
