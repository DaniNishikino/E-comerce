package com.danilel.ecomerce.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_address")
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String district;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private Integer number;

    public Address(String cep, String country, String state, String city, String district, String street, Integer number) {
        this.cep = cep;
        this.country = country;
        this.state = state;
        this.city = city;
        this.district = district;
        this.street = street;
        this.number = number;
    }
}
