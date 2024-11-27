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
    private String cep;
    private String country;
    private String state;
    private String city;
    private String district;
    private String street;
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
