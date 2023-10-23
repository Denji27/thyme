package com.example.thyme.service;

import com.example.thyme.entity.Customer;
import com.example.thyme.entity.Description;

public interface CustomerService {
    void activateStamp(String name, String citizenIdentificationNumber, String address, String email);
    void saveCustomer(Customer customer);
    void createDescription(String type);
    Description getDescription(Integer id);
}
