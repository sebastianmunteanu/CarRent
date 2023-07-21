package com.example.CarRent.Controller;
import com.example.CarRent.Dto.CustomerDto;
import com.example.CarRent.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public String customersList (Model model) {
        model.addAttribute("customerList", customerService.getAllCustomers());
        return "customers";
    }

    @PostMapping(value = "/submitCustomer")
    public String submitCustomer (@ModelAttribute("customer") CustomerDto customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping(value = "/registerCustomer")
    public String getRegisterCustomer (Model model) {
        model.addAttribute("customer", new CustomerDto());
        return "customerForm";
    }

    @GetMapping(value = "/editCustomer")
    public String showEditForm (@RequestParam ("id") int customerId, Model model) {
        model.addAttribute("customer", customerService.findCustomer(customerId));
        return "customerForm";
    }

    @PostMapping(value = "/deleteCustomer")
    public String deleteCustomer (@RequestParam ("id") int customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customers";
    }
}
