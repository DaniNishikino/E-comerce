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
public class UserServiceImpl implements UserService {

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
        return userList.stream().map(this::userToDTO).toList();
    }

    @Override
    public Optional<UserDTO> getByLogin(String login) {
        return userRepository.findByLogin(login).map(this::userToDTO);
    }

    private User userToEntity(UserDTO userDTO) {
        return new User(
                userDTO.login(),
                userDTO.password(),
                userDTO.name(),
                userDTO.cpf(),
                userDTO.addresses().stream().map(this::addressToEntity).collect(Collectors.toList()),
                userDTO.cart() != null ? cartToEntity(userDTO.cart()) : null
        );
    }

    private UserDTO userToDTO(User user) {
        return new UserDTO(
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getCpf(),
                user.getAddresses().stream().map(this::addressToDTO).collect(Collectors.toList()),
                user.getCart() != null ? cartToDTO(user.getCart()) : null
        );
    }

    private Address addressToEntity(AddressDTO addressDTO) {
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

    private AddressDTO addressToDTO(Address address) {
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

    private Cart cartToEntity(CartDTO cartDTO) {
        return new Cart(
                cartDTO.products().stream().map(this::productToEntity).collect(Collectors.toList()),
                cartDTO.totalPrice()
        );
    }

    private CartDTO cartToDTO(Cart cart) {
        return new CartDTO(
                cart.getProducts().stream().map(this::productToDTO).collect(Collectors.toList()),
                cart.getTotalPrice()
        );
    }

    private Product productToEntity(ProductDTO productDTO) {
        return new Product(
                productDTO.name(),
                productDTO.description(),
                productDTO.price(),
                productDTO.quantity(),
                null
        );
    }

    private ProductDTO productToDTO(Product product) {
        return new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                null
        );
    }
}
