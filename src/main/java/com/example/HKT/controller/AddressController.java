package com.example.HKT.controller;

import com.example.HKT.entity.Address;
import com.example.HKT.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {

        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAllAddresses(@RequestParam(required = false) String postcode) {
        if(postcode !=null && !postcode.isEmpty()){
            return addressService.getAddressByPostcode(postcode);
        }
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Integer id) {
        Address address = addressService.getAddressById(id);
        if (address != null) {
            return ResponseEntity.ok(address);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        System.out.println("Received payload: " + address);
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        if (updatedAddress != null) {
            return ResponseEntity.ok(updatedAddress);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
