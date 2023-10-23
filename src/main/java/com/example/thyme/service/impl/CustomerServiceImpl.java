package com.example.thyme.service.impl;

import com.example.thyme.entity.Customer;
import com.example.thyme.entity.Description;
import com.example.thyme.entity.DescriptionType;
import com.example.thyme.repository.CustomerRepo;
import com.example.thyme.repository.DescriptionRepo;
import com.example.thyme.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private DescriptionRepo descriptionRepo;

    @Override
    public void activateStamp(String name, String citizenIdentificationNumber, String address, String email) {
        Customer customer = Customer.builder()
                .name(name)
                .citizenIdentificationNumber(citizenIdentificationNumber)
                .address(address)
                .email(email)
                .build();
        customerRepo.save(customer);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void createDescription(String type) {
        Description description;
        if (type.equals("1")) {
            description = Description.builder()
                    .content("This is description of a default type 1 customer")
                    .descriptionType(DescriptionType.TYPE1)
                    .build();
        } else {
            description = Description.builder()
                    .content("This is description of a default type 2 customer")
                    .descriptionType(DescriptionType.TYPE2)
                    .build();
        }
        descriptionRepo.save(description);
    }

    @Override
    public Description getDescription(Integer id){
        return descriptionRepo.findById(id).get();
    }


}
