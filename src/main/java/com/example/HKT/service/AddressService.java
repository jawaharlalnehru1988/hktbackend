package com.example.HKT.service;

import com.example.HKT.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();
    Address getAddressById(Integer id);
    Address createAddress(Address address);
    Address updateAddress(Integer id, Address address);
    void deleteAddress(Integer id);
}
