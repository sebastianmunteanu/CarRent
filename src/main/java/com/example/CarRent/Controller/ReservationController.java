package com.example.CarRent.Controller;

import com.example.CarRent.Dto.CarDtoOverview;
import com.example.CarRent.Dto.CustomerDtoOverview;
import com.example.CarRent.Dto.ReservationDto;
import com.example.CarRent.Service.CarService;
import com.example.CarRent.Service.CustomerService;
import com.example.CarRent.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = "/reservationForm")
    public String getReservationForm (Model modelCustumer, Model modeCar) {
        List<CustomerDtoOverview> customerList = customerService.getAllCustomers();
        modelCustumer.addAttribute("customerList", customerList);
        List<CarDtoOverview> carList = carService.getAllCars();
        modeCar.addAttribute("carList", carList);
        return "reservationForm";
    }

    @PostMapping(value = "/submitReservation")
    public String submitReservation(@RequestParam("customerId") int customerId, @RequestParam("carId") int carId) {
        ReservationDto reservation = new ReservationDto();
        reservation.setCustomer(customerId);
        reservation.setCar(carId);
        reservationService.saveReservation(reservation);
        return "redirect:/index";
    }

}
