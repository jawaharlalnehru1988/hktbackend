package com.example.HKT.service;

import com.example.HKT.DTOs.PersonDto;

import java.util.List;


public interface CollectionService {
    public List<Integer> printEven();
    public List<String> filterString();
    public List<PersonDto> validPersons();
}
