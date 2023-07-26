package com.example.CarRent.Mapper;

import com.example.CarRent.Dto.ReservationDto;
import com.example.CarRent.Dto.ReservationDtoOverview;
import com.example.CarRent.Model.Reservation;
import com.example.CarRent.Repository.CarRepository;
import com.example.CarRent.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<ReservationDtoOverview> getReservations(List<Reservation> reservations) {
        return reservations.stream()
                .map(reservation -> mapToReservationOverview(reservation))
                .collect(Collectors.toList());
    }

    public Reservation getReservation (ReservationDto reservationDto) {
        return mapToReservation(reservationDto);
    }

    private Reservation mapToReservation (ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.getId())
                .startDate(reservationDto.getStartDate())
                .endDate(reservationDto.getEndDate())
                .dateOfReservation(reservationDto.getDateOfReservation())
                .car(carRepository.findById(reservationDto.getCar()).get())
                .customer(customerRepository.findById(reservationDto.getCustomer()).get())
                .build();
    }

    private ReservationDtoOverview mapToReservationOverview (Reservation reservation) {
        return ReservationDtoOverview.builder()
                .id(reservation.getId())
                .dateOfReservation(reservation.getDateOfReservation())
                .startDate(reservation.getStartDate())
                .endDate(reservation.getEndDate())
                .numberOfResDays(reservation.getNumberOfReservationDays())
                .car(reservation.getCar().getCar())
                .customer(reservation.getCustomer().getFullName())
                .build();
    }

}
