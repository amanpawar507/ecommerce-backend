package com.geli.ecommerce.service;


import com.geli.ecommerce.model.CreditCard;
import com.geli.ecommerce.model.Customer;
import com.geli.ecommerce.repository.CreditCardRepository;
import com.geli.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CustomerRepository customerRepository;


    public CreditCard saveCreditCard(CreditCard creditCard, Integer customerId){
        Customer customer = customerRepository.findById(customerId).orElse(null);
        List<CreditCard> creditCardList= customer.getCreditCards();
        creditCard.setCustomer(customer);
        creditCardList.add(creditCard);
        return creditCardRepository.save(creditCard);

    }
}
