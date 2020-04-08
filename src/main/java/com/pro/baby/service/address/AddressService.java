package com.pro.baby.service.address;


import com.pro.baby.entity.Address;
import com.pro.baby.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {


    @Autowired
    private AddressRepository addressRepository;


//    add
    public int addAddress(Address address){
        addressRepository.save(address);
        return address.getAddressID();
    }



}
