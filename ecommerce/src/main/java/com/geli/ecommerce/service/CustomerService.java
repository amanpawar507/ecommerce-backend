package com.geli.ecommerce.service;

import com.geli.ecommerce.model.Customer;
import com.geli.ecommerce.repository.CustomerRepository;
import com.geli.ecommerce.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }


    public ResponseEntity<Customer> loginCustomer(LoginRequest loginRequest) throws Exception {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Customer customerToVerify = customerRepository.findByUsername(username);

        if(customerToVerify != null){
            if(username.equals(customerToVerify.getUsername()) && password.equals(customerToVerify.getPassword())) {
                return ResponseEntity.ok(customerToVerify);
            }else{
                throw new Exception("Username or password incorrect");
            }
        }else{
            throw new Exception("User does not exist");
        }

    }


    public Optional<Customer> findCustomer(int customer_id){
        Optional<Customer> customerToVerify= customerRepository.findById(customer_id);
        if(customerToVerify.isPresent()){
            Customer customerToReturn = customerToVerify.get();
            return customerToVerify;
        }else{
            return null;
        }
    }

    public String deleteCustomer(int customerid) {
        customerRepository.deleteById(customerid);
        return "customer with id"+customerid+"deleted";
    }


    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    //TO-DO
//    public Customer updateCustomer(Customer customer){
//        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
//        existingCustomer.setEmail(customer.getEmail());
//        return customerRepository.save(existingCustomer);
//    }
}
