package com.danilel.ecomerce.controller;

import com.danilel.ecomerce.DTOs.UserDTO;
import com.danilel.ecomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO>getById(@PathVariable Long id){
       Optional<UserDTO> userDTO =  userService.getById(id);
       return userDTO.map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
