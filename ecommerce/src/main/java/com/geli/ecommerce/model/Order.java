package com.geli.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@RequiredArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name="orderdb")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @OneToOne
    private Cart cart;

    @OneToOne
    private Customer customer;

    @OneToOne
    private Address shippingAddress;

    @OneToOne
    private CreditCard creditCardUsed;

    private Date creationDate;

}
