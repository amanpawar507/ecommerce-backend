package com.geli.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="address")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private int addressId;

    @Column(name = "address_line_one")
    private String addressLineOne;

    @Column(name = "apartment_info")
    private String apartmentInformation;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

}
