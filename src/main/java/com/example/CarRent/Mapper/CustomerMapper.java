package com.example.CarRent.Mapper;

import com.example.CarRent.Dto.CustomerDto;
import com.example.CarRent.Dto.CustomerDtoOverview;
import com.example.CarRent.Model.Customer;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    public List<CustomerDtoOverview> getCustomersDtoList (List<Customer> customerList) {
        return customerList.stream()
                .map(customer -> mapToCustomerDTOOverView(customer))
                .collect(Collectors.toList());
    }

    public Customer getCustomer(CustomerDto customerDto) {
        return mapToCustomer(customerDto);
    }

    public CustomerDto getCustomerDto(Customer customer) {
        return mapToCustomerDto(customer);
    }

    private CustomerDtoOverview mapToCustomerDTOOverView (Customer customer) {
        return CustomerDtoOverview.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .numberOfReservation(customer.getReservationNumer())
                .fullName(customer.getFullName())
                .build();
    }

    private Customer mapToCustomer (CustomerDto customerDto) {
        return Customer.builder()
                .id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .phoneNumber(customerDto.getPhoneNumber())
                .email(customerDto.getEmail())
                .build();
    }

    private CustomerDto mapToCustomerDto (Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phoneNumber(customer.getPhoneNumber())
                .email(customer.getEmail())
                .build();
    }
}
