package com.geli.ecommerce.service;


import com.geli.ecommerce.model.*;
import com.geli.ecommerce.repository.CartRepository;
import com.geli.ecommerce.repository.CustomerRepository;
import com.geli.ecommerce.repository.OrderRepository;
import com.geli.ecommerce.request.OrderRequest;
import com.geli.ecommerce.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest){
        System.out.println(orderRequest);
        System.out.println(orderRequest.getCustomerId());


        Order orderToBePlaced = new Order();
        Customer customer = customerRepository.findById(orderRequest.getCustomerId()).orElse(null);
//        System.out.println(customer);
        Cart cartForOrder= cartRepository.findById(202).orElse(null);


        Address address = customer.getAddresses().get(0);
        CreditCard creditCard=customer.getCreditCards().get(0);
        Date date = new Date(System.currentTimeMillis());
        List<OrderItem> orderItemList=cartForOrder.getOrderItemList();

//        System.out.println(orderItemList);
        Double totalPrice =customer.getCart().getTotalPrice();

        orderToBePlaced.setCart(cartForOrder);
        orderToBePlaced.setCreationDate(date);
        orderToBePlaced.setCreditCardUsed(creditCard);
        orderToBePlaced.setShippingAddress(address);
        orderRepository.save(orderToBePlaced);
        customerRepository.save(customer);
        cartRepository.save(cartForOrder);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(orderToBePlaced.getOrderId());
        orderResponse.setOrderItemList(orderItemList);
        orderResponse.setTotalPrice(totalPrice);
        orderResponse.setShippingAddress(address);
        orderResponse.setDateCreated(date);
        orderResponse.setCreditCardUsed(creditCard);
        return orderResponse;
//        return null;
    }

}
