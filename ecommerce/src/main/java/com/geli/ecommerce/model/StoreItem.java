package com.geli.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;


@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "store_item")
public class StoreItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_price")
    private double itemPrice;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "item_quantity")
    private int itemQuantity;

    @Column(name = "item_category")
    private String itemCategory;

    @Column(name = "item_image_url")
    private String itemImageURL;

    @ManyToOne
    @JsonIgnore
    private Store store;

    @Override
    public String toString() {
        return "StoreItem{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", itemCategory='" + itemCategory + '\'' +
                ", itemImageURL='" + itemImageURL + '\'' +
                ", store=" + store +
                '}';
    }
}
