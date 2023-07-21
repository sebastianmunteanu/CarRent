package com.example.CarRent.Controller;

import com.example.CarRent.Dto.CarDto;
import com.example.CarRent.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/cars")
    public String getAllCars (Model model) {
        model.addAttribute("carList", carService.getAllCars());
        return "cars";
    }

    @PostMapping(value = "/submitCar")
    public String submitCar (@ModelAttribute("car") CarDto car) {
        carService.saveCar(car);
        return "redirect:/cars";
    }

    @GetMapping(value = "/registerCar")
    public String getRegisterCar (Model model) {
        model.addAttribute("car", new CarDto());
        return "carForm";
    }

    @GetMapping(value = "/editCar")
    public String showEditForm (@RequestParam("id") int carId, Model model) {
        model.addAttribute("car", carService.findCar(carId));
        return "carForm";
    }

    @PostMapping(value = "/deleteCar")
    public String deleteCustomer (@RequestParam ("id") int carId) {
        carService.deleteCar(carId);
        return "redirect:/cars";
    }

}
