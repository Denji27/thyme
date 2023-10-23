package com.example.thyme.controller;

import com.example.thyme.entity.Customer;
import com.example.thyme.entity.Description;
import com.example.thyme.entity.DescriptionType;
import com.example.thyme.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/form/{id}")
    public String showCustomerForm(@PathVariable Integer id ,Model model){
//        String ten = "\"default name\"";
        model.addAttribute("customer", new Customer("del"));
        Description description = service.getDescription(id);
        model.addAttribute("description", description);
        if (description.getDescriptionType().equals(DescriptionType.TYPE1)){
            return "description";
        }else {
            return "form";
        }
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute("customer") Customer customer, Model model){
        Description description = (Description) model.getAttribute("description");
        System.out.println(description.getDescriptionType().toString());
        service.saveCustomer(customer);
        return "confirmation";
    }

    @ResponseBody
    @PostMapping("/create-description")
    public void createDes(@RequestParam String type){
        service.createDescription(type);
    }
}
