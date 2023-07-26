package com.example.CarRent.Controller;


import com.example.CarRent.Dto.ReservationDto;
import com.example.CarRent.Service.CarService;
import com.example.CarRent.Service.CustomerService;
import com.example.CarRent.Service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ReservationController {

    @Autowired
    private CarService carService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = "/reservationForm")
    public String getReservationForm (Model model) {
        model.addAttribute("customerList", customerService.getAllCustomers());
        model.addAttribute("carList", carService.getAllCars());
        model.addAttribute("reservation", new ReservationDto());
        return "reservationForm";
    }

    @PostMapping(value = "/submitReservation")
    public String submitReservation(@ModelAttribute("reservation") @Valid ReservationDto reservation,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerList", customerService.getAllCustomers());
            model.addAttribute("carList", carService.getAllCars());
            return "reservationForm";
        } else {
            System.out.println("OK");
            reservationService.saveReservation(reservation);
        }
      return "redirect:/index";
    }

}
