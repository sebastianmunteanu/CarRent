package com.example.CarRent.Service;

import com.example.CarRent.Dto.CustomerDto;
import com.example.CarRent.Dto.CustomerDtoOverview;
import com.example.CarRent.Mapper.CustomerMapper;
import com.example.CarRent.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    public List<CustomerDtoOverview> getAllCustomers (){
        return customerMapper.getCustomersDtoList(customerRepository.findAll());
    }

    public void saveCustomer(CustomerDto customer) {
        customerRepository.save(customerMapper.getCustomer(customer));
    }

    public CustomerDto findCustomer(int customerId) {
        return customerMapper.getCustomerDto(customerRepository.findById(customerId).get());
    }

    public void deleteCustomer(int customerId) {
        customerRepository.deleteById(customerId);
    }
}
