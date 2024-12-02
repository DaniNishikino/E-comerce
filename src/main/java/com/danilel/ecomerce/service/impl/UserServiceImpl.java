package com.danilel.ecomerce.service.impl;

import com.danilel.ecomerce.DTOs.AddressDTO;
import com.danilel.ecomerce.DTOs.CartDTO;
import com.danilel.ecomerce.DTOs.ProductDTO;
import com.danilel.ecomerce.DTOs.UserDTO;
import com.danilel.ecomerce.entity.Address;
import com.danilel.ecomerce.entity.Cart;
import com.danilel.ecomerce.entity.Product;
import com.danilel.ecomerce.entity.User;
import com.danilel.ecomerce.repository.AddressRepository;
import com.danilel.ecomerce.repository.CartRepository;
import com.danilel.ecomerce.repository.UserRepository;
import com.danilel.ecomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends DefaultMethods implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CartRepository cartRepository;

    @Override
    public UserDTO save(UserDTO user) {
        User userToSave = userToEntity(user);

        // Save addresses first
        List<Address> savedAddresses = userToSave.getAddresses().stream()
                .map(addressRepository::save)
                .collect(Collectors.toList());
        userToSave.setAddresses(savedAddresses);

        // Save cart if it exists
        if (userToSave.getCart() != null) {
            Cart savedCart = cartRepository.save(userToSave.getCart());
            userToSave.setCart(savedCart);
        }

        if (userRepository.findByLogin(user.login()).isEmpty()) {
            User savedUser = userRepository.save(userToSave);
            return userToDTO(savedUser);
        } else {
            throw new RuntimeException("User already exists");
        }
    }

    @Override
    public void deleteByLogin(String login) {
        if (userRepository.findByLogin(login).isPresent()){
            userRepository.deleteByLogin(login);
        }else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(DefaultMethods::userToDTO).toList();
    }

    @Override
    public Optional<UserDTO> getByLogin(String login) {
        return userRepository.findByLogin(login).map(DefaultMethods::userToDTO);
    }
}
