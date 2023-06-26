package com.geli.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name ="cart")
@RequiredArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "cart_id")
    private int cartId;

    @Column(name = "total_price")
    private double totalPrice;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderItem> orderItemList = new ArrayList<>();

    public Cart(int cartId) {
        this.cartId = cartId;
    }
}
