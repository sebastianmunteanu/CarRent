package com.example.CarRent.Service;

import com.example.CarRent.Dto.ReservationDto;
import com.example.CarRent.Dto.ReservationDtoOverview;
import com.example.CarRent.Mapper.ReservationMapper;
import com.example.CarRent.Model.Car;
import com.example.CarRent.Model.Customer;
import com.example.CarRent.Model.Reservation;
import com.example.CarRent.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    public List<ReservationDtoOverview> getAllResrvations () {
        return reservationMapper.getReservations(reservationRepository.findAll());
    }

    public void saveReservation (ReservationDto reservationDto) {
        reservationRepository.save(reservationMapper.getReservation(reservationDto));
    }

    public String getBestClient() {
        List <Reservation> reservation = reservationRepository.findAll();
        Map<Customer, Long> countMaxCustomer = reservation.stream()
                        .collect(Collectors.groupingBy(Reservation::getCustomer, Collectors.counting()));
        Customer maxCustomer = countMaxCustomer.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        return maxCustomer == null ? "Nu exista rezervari": maxCustomer.getFullName();
    }

    public String getBestCar() {
        List <Reservation> reservation = reservationRepository.findAll();
        Map<Car, Long> countMaxCar = reservation.stream()
                .collect(Collectors.groupingBy(Reservation::getCar, Collectors.counting()));
        Car maxCar = countMaxCar.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        return maxCar == null ? "Nu exista rezervari": maxCar.getCar();
    }
}
