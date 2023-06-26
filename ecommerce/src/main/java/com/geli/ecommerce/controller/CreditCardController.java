package com.geli.ecommerce.controller;


import com.geli.ecommerce.model.CreditCard;
import com.geli.ecommerce.request.CreditCardRequest;
import com.geli.ecommerce.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/creditcards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping("/add")
    public CreditCard saveCreditCard(@RequestBody CreditCardRequest creditCardRequest){
        Integer customerId = creditCardRequest.getCustomerId();
        String cardNumber = creditCardRequest.getCardNumber();
        String cvv = creditCardRequest.getCvv();
        Date expirationDate = creditCardRequest.getExpirationDate();
        CreditCard creditCard = new CreditCard(cardNumber,cvv,expirationDate);
        return creditCardService.saveCreditCard(creditCard, customerId);
    }
}
