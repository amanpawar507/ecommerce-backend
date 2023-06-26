package com.geli.ecommerce.service;


import com.geli.ecommerce.model.Address;
import com.geli.ecommerce.model.Customer;
import com.geli.ecommerce.repository.AddressRepository;
import com.geli.ecommerce.repository.CustomerRepository;
import com.geli.ecommerce.request.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public String addAddress(AddressRequest addressRequest){
        Address addressToAdd = new Address();
        addressToAdd.setAddressLineOne(addressRequest.getAddressLineOne());
        addressToAdd.setCity(addressRequest.getCity());
        addressToAdd.setState(addressRequest.getState());
        addressToAdd.setApartmentInformation(addressRequest.getApartmentInformation());
        addressToAdd.setPostalCode(addressRequest.getPostalCode());
        Customer customerToAddAddress = customerRepository.findById(addressRequest.getCustomerId()).orElse(null);
        addressToAdd.setCustomer(customerToAddAddress);
        addressRepository.save(addressToAdd);
        return "address added";
    }


//    public Address updateAddress(int id, Address address) {
////        Address addressToBeUpdated = addressRepository.findById(Integer.valueOf(id)).orElse(null);
//        System.out.println(address);
//        System.out.println(id);


//        Address addressToBeUpdated = addressRepository.findById(id).orElse(null);
//        System.out.println(addressToBeUpdated);

//
//        addressToBeUpdated.setState(address.getState());
//        addressToBeUpdated.setAddressLineOne(address.getAddressLineOne());
//        addressToBeUpdated.setPostalCode(address.getPostalCode());
//        return null;
//    }
}
