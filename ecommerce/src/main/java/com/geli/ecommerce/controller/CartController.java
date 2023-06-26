package com.geli.ecommerce.controller;


import com.geli.ecommerce.model.Cart;
import com.geli.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;


    @GetMapping("/{cart_id}")
    public Cart getCartByCartId(@PathVariable(name="cart_id") Integer cart_id){
        return cartService.getCartByID(cart_id);
    }

}
