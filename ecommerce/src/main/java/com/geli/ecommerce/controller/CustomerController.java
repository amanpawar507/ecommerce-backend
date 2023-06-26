package com.geli.ecommerce.controller;


import com.geli.ecommerce.model.Cart;
import com.geli.ecommerce.model.Customer;
import com.geli.ecommerce.request.LoginRequest;
import com.geli.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Customer addCustomer(@RequestBody Customer customer){
        Cart cart = new Cart(customer.getId());
        customer.setCart(cart);
        return customerService.saveCustomer(customer);
    }

    @PostMapping("/login")
    public ResponseEntity<Customer> loginCustomer(@RequestBody LoginRequest loginRequest) throws Exception {
        return customerService.loginCustomer(loginRequest);
    }

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers(){
        return customerService.findAllCustomers();
    }


    @GetMapping("/{customer_id}")
    public Optional<Customer> getCustomerInfo(@PathVariable(name="customer_id") int customerid){
        return customerService.findCustomer(customerid);
    }

    @DeleteMapping ("/deleteCustomer/{customer_id}")
    public String deleteCustomer(@PathVariable(name="customer_id") int customerid){
        return customerService.deleteCustomer(customerid);
    }







//
//    @PostMapping("/update/{id}")
//    public Customer updateCustomer(@PathVariable("id")String id, @RequestBody Customer customer){
//        return customerService.saveCustomer(customer);
//    }




}
