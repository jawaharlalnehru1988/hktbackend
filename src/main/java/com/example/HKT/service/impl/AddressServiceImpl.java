package com.example.HKT.service.impl;

import com.example.HKT.DTOs.AddressDto;
import com.example.HKT.entity.AddressEntity;
import com.example.HKT.repository.AddressRepository;
import com.example.HKT.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private  AddressRepository addressRepository;

    @Override
    public List<AddressDto> getAllAddresses(){
        List<AddressEntity> address = addressRepository.findAll();
        return address.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @Override
    public AddressDto getAddressById(Integer id){
        AddressEntity address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address with the id" + id + "not found"));
        return convertToDto(address);
    }

    @Override
    public AddressDto createAddress(AddressDto dto){
        AddressEntity address = convertToEntity(dto);
        AddressEntity savedAddress = addressRepository.save(address);
        return convertToDto(savedAddress);
    }

    @Override
    public AddressDto updateAddress(AddressDto dto, Integer id){
        AddressEntity address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find the ID" + id));
        address.setName(dto.getName());
        address.setStreet(dto.getStreet());
        address.setPostcode(dto.getPostcode());
        address.setNumber(dto.getNumber());
        AddressEntity result = addressRepository.save(address);
        return convertToDto(result);
    }

    @Override
    public void deleteAddress(Integer id){
        AddressEntity address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Unable to delete the address with id "+ id));
        addressRepository.delete(address);
    }

    public AddressDto convertToDto(AddressEntity entity){
        AddressDto dto = new AddressDto();
        dto.setId(entity.getId());
        dto.setStreet(entity.getStreet());
        dto.setName(entity.getName());
        dto.setPostcode(entity.getPostcode());
        dto.setNumber(entity.getNumber());
        return dto;
    }

    public AddressEntity convertToEntity(AddressDto dto) {
        AddressEntity  entity = new AddressEntity();
        entity.setId(dto.getId());
        entity.setPostcode(dto.getPostcode());
        entity.setStreet(dto.getStreet());
        entity.setNumber(dto.getNumber());
        entity.setName(dto.getName());
        return entity;
    }
//
//    @Override
//    public AddressEntity getAddressById(Integer id) {
//        return addressRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public AddressEntity createAddress(AddressEntity address) {
//        return addressRepository.save(address);
//    }
//
//    @Override
//    public AddressEntity updateAddress(Integer id, AddressEntity address) {
//        if (addressRepository.existsById(id)) {
//            address.setId(id);
//            return addressRepository.save(address);
//        }
//        return null;
//    }
//
//    @Override
//    public void deleteAddress(Integer id) {
//        addressRepository.deleteById(id);
//    }
//
//    @Override
//    public List<AddressEntity> getAddressByPostcode(String postcode) {
//        return addressRepository.findByPostcode(postcode);
//    }
}
