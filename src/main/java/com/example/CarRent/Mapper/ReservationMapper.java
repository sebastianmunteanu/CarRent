package com.example.CarRent.Mapper;

import com.example.CarRent.Dto.ReservationDto;
import com.example.CarRent.Model.Reservation;
import com.example.CarRent.Repository.CarRepository;
import com.example.CarRent.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Reservation getReservation (ReservationDto reservationDto) {
        return mapToReservation(reservationDto);
    }

    private Reservation mapToReservation (ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.getId())
                .car(carRepository.findById(reservationDto.getCar()).get())
                .customer(customerRepository.findById(reservationDto.getCustomer()).get())
                .build();
    }

}
