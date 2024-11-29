package com.danilel.ecomerce.controller;

import com.danilel.ecomerce.DTOs.UserDTO;
import com.danilel.ecomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/{login}")
    public ResponseEntity<UserDTO>getByLogin(@PathVariable String login){
       Optional<UserDTO> userDTO =  userService.getByLogin(login);
       return userDTO.map(ResponseEntity::ok)
               .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @PostMapping("/create")
    public ResponseEntity<String > createUser(@RequestBody UserDTO userDTO){
        try {
            userService.save(userDTO);
            return ResponseEntity.ok("User Created");
        }catch (RuntimeException e){
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }
    @DeleteMapping("{login}")
    public ResponseEntity<String>deleteByLogin (@PathVariable String login){
        try {
            userService.deleteByLogin(login);
            return ResponseEntity.ok("User deleted Successfully");
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
