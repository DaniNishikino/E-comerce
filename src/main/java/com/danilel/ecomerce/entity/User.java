package com.danilel.ecomerce.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cpf;
    @OneToMany
    @Column(nullable = false)
    private List<Address> addresses;
    @OneToOne
    private Cart cart;

    public User(String login, String password, String name, String cpf, List<Address> addresses, Cart cart) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.cpf = cpf;
        this.addresses = addresses;
        this.cart = cart;
    }
}
