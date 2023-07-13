package com.example.CarRent.Controller;

import com.example.CarRent.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    List<Customer> customerList = new ArrayList<>() {

    };

    @GetMapping(value = "/customers")
    public String customersList (Model model) {

    /*
        Customer c1 = new Customer(1, "C1FirstName", "C1LastName", "1111111111", "c1@local.com");
        Customer c2 = new Customer(2, "C2FirstName", "C2LastName", "2222222222", "c2@local.com");
        Customer c3 = new Customer(3, "C3FirstName", "C3LastName", "3333333333", "c3@local.com");

        customerList.add(c1);
        customerList.add(c2);
        customerList.add(c3);

     */

        model.addAttribute("customerList", customerList);

        return "customers";
    }

    @GetMapping(value = "/customerForm")
    public String getCustomerForm (Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @PostMapping(value = "/submitCustomer")
    public String submitCustomer (@ModelAttribute("customer") Customer customer) {
        customerList.add(customer);
        return "redirect:customers";
    }


    @GetMapping(value = "/registerCustomer")
    public String getRegisterCustomer (Model model) {
        model.addAttribute("customer", new Customer());
        return "registerCustomer";
    }
}
