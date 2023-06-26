package com.geli.ecommerce.service;


import com.geli.ecommerce.model.Cart;
import com.geli.ecommerce.model.OrderItem;
import com.geli.ecommerce.model.StoreItem;
import com.geli.ecommerce.repository.OrderItemRepository;
import com.geli.ecommerce.request.OrderItemRequest;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private StoreItemService storeItemService;

    @Autowired
    private CartService cartService;

    public String addOrderItem(Integer cardId,Integer storeItemId, Integer quantity){
        OrderItem orderItem = new OrderItem();
        StoreItem storeItemToAdd= storeItemService.findStoreItemById(storeItemId);
        orderItem.setStoreItem(storeItemToAdd);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(storeItemToAdd.getItemPrice());
        orderItem.setCart(cartService.getCartByID(cardId));
        orderItemRepository.save(orderItem);
        return "One order item saved";
    }

}
