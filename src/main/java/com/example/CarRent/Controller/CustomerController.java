package com.example.CarRent.Controller;

import com.example.CarRent.Model.Customer;
import com.example.CarRent.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    private List<Customer> customerList = new ArrayList<>() { };

    @GetMapping(value = "/customers")
    public String customersList (Model model) {
        customerList = customerRepository.findAll();
        model.addAttribute("customerList", customerList);
        return "customers";
    }

    @GetMapping(value = "/customerForm")
    public String getCustomerForm (@RequestParam ("id") int customerId, Model model) {
        model.addAttribute("customer", customerRepository.findById(customerId));
        return "customerForm";
    }

    @PostMapping(value = "/submitCustomer")
    public String submitCustomer (@ModelAttribute("customer") Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @PostMapping(value = "/deleteCustomer")
    public String deleteCustomer (@RequestParam ("id") int customerId) {
        customerRepository.deleteById(customerId);
        return "redirect:/customers";
    }

    @GetMapping(value = "/registerCustomer")
    public String getRegisterCustomer (Model model) {
        model.addAttribute("customer", new Customer());
        return "registerCustomer";
    }
}
