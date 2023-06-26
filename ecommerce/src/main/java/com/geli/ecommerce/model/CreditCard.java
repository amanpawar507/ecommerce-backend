package com.geli.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "creditcard")
@RequiredArgsConstructor
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int creditCardId;

    @Column(name= "card_number")
    private String cardNumber;

    @Column(name= "cvv")
    private String cvv;

    @Column(name= "expiration_date")
    private Date expirationDate;

    @ManyToOne
    @JsonIgnore
    private Customer customer;

    public CreditCard(String cardNumber, String cvv, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }
}
