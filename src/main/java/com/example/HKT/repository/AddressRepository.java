package com.example.HKT.repository;

import com.example.HKT.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("SELECT a FROM Address a WHERE a.postcode LIKE %:postcode%")
    List<Address> findByPostcode(String postcode);
}
