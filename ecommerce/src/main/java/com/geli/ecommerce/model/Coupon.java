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
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "amount")
    private String amount;
//
//    @Column(name = "creation_date")
//    private Date creationDate;
//
//    @Column(name = "expiration_date")
//    private Date expirationDate;
}
