package com.example.HKT.controller;

import com.example.HKT.DTOs.AddressDto;
import com.example.HKT.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> addressList = addressService.getAllAddresses();
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Integer id){
        AddressDto addressObj = addressService.getAddressById(id);
        return new ResponseEntity<>(addressObj, HttpStatus.OK);
    }

    @PostMapping("createAddress")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto payload){
        AddressDto postedObj = addressService.createAddress(payload);
        return new ResponseEntity<>(postedObj, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto payload, @PathVariable Integer id){
        AddressDto updateObj = addressService.updateAddress(payload, id);
        return new ResponseEntity<>(updateObj, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>("Address with the id " + id + " deleted Successfully.", HttpStatus.OK);
    }

}
