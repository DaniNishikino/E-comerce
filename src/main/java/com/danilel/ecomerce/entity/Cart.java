package com.danilel.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_cart")
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "cart")
    List<Product> products;
    private Double totalPrice;

    public Cart(List<Product> products, Double totalPrice) {
        this.products = products;
        this.totalPrice = totalPrice;
    }
}
