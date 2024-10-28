package com.example.HKT.service;

import com.example.HKT.DTOs.AddressDto;
import com.example.HKT.entity.AddressEntity;

import java.util.List;

public interface AddressService {
    List<AddressDto> getAllAddresses();
    public AddressDto getAddressById(Integer id);
    public AddressDto createAddress(AddressDto dto);

    public AddressDto updateAddress(AddressDto dto, Integer id);
    public void deleteAddress(Integer id);

}
