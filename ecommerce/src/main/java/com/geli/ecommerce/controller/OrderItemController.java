package com.geli.ecommerce.controller;


import com.geli.ecommerce.request.OrderItemRequest;
import com.geli.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/add")
    public String addOrderItem(@RequestBody OrderItemRequest orderItemRequest){
        orderItemService.addOrderItem(orderItemRequest.getCart_id(),orderItemRequest.getStoreItemId(), orderItemRequest.getQuantity());
        return "One order Item added";
    }


}
