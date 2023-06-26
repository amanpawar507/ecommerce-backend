package com.geli.ecommerce.service;

import com.geli.ecommerce.model.Cart;
import com.geli.ecommerce.model.OrderItem;
import com.geli.ecommerce.repository.CartRepository;
import com.geli.ecommerce.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;


    public Cart getCartByID(Integer cartid){
        Cart cart = cartRepository.findById(cartid).orElse(null);

        List<OrderItem> orderItemList=cart.getOrderItemList();
        Double totalPrice=0.0;
        for(OrderItem orderItem : orderItemList){
            Double price = orderItem.getPrice();
            Integer quantity= orderItem.getQuantity();
            totalPrice=totalPrice+price*quantity;
        }

        cart.setTotalPrice(totalPrice);
        cartRepository.save(cart);

        return cart;

    }



}
