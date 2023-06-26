package com.geli.ecommerce.controller;


import com.geli.ecommerce.model.Address;
import com.geli.ecommerce.request.AddressRequest;
import com.geli.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @PostMapping("/add")
    public String addAddress(@RequestBody AddressRequest addressRequest){
        addressService.addAddress(addressRequest);
        return "address added";
    }

//    @PutMapping("/update/{id}")
//    public Address updateProduct(@PathVariable("id") Integer id,@RequestBody Address address){
//        return addressService.updateAddress(id,address);
//    }


}
