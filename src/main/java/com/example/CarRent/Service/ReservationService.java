package com.example.CarRent.Service;

import com.example.CarRent.Dto.ReservationDto;
import com.example.CarRent.Dto.ReservationDtoOverview;
import com.example.CarRent.Mapper.ReservationMapper;
import com.example.CarRent.Model.Car;
import com.example.CarRent.Model.Customer;
import com.example.CarRent.Model.Reservation;
import com.example.CarRent.Repository.ReservationRepository;
import com.example.CarRent.Utils.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
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

    public int getTodayReservations () {
        List<Reservation> reservations = reservationRepository.findAll().stream()
                .filter(reservation -> reservation.getDateOfReservation1().equals(LocalDate.now()))
                .collect(Collectors.toList());
        return reservations.size();
    }

    public List<Integer> getReservationNumber (ChartData chartData) {
        List<Reservation> reservations = reservationRepository.findReservationsInLastTenDays(LocalDate.now().minusDays(10));
        Map<Integer, Long> lastTenDayCount = reservations.stream()
                .collect(Collectors.groupingBy(reservation -> reservation.getDateOfReservation1().getDayOfMonth(), Collectors.counting()));
        chartData.setChartYMaxValue(lastTenDayCount.values().stream()
                .max(Long::compare)
                .orElse(0L));
        List<Integer> listOfElements = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (lastTenDayCount.containsKey(LocalDate.now().minusDays(i).getDayOfMonth())) {
                listOfElements.add(i, lastTenDayCount.get(LocalDate.now().minusDays(i).getDayOfMonth()).intValue());
            }
            else {
                listOfElements.add(i, 0);
            }
        }
        Collections.reverse(listOfElements);
        return listOfElements;
    }
}
