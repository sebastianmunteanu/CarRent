package com.example.CarRent.Controller;

import com.example.CarRent.Service.ReservationService;
import com.example.CarRent.Utils.MonthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping(value = "/index")
    public String getSite (Model model) {
        model.addAttribute("reservationList", reservationService.getAllResrvations());
        model.addAttribute("customer", reservationService.getBestClient());
        model.addAttribute("car", reservationService.getBestCar());
        model.addAttribute("todayreservations", reservationService.getTodayReservations());
        model.addAttribute("chartData", reservationService.getReservationNumber());
        model.addAttribute("lastTenDays", MonthUtils.getLastTenDays());
        return "index";
    }
}
