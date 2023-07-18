package com.example.CarRent.Controller;

import com.example.CarRent.Model.Car;
import com.example.CarRent.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;
    private List<Car> carList;

    @GetMapping(value = "/cars")
    public String carsList (Model model) {
        carList = carRepository.findAll();
        model.addAttribute("carList", carList);
        return "cars";
    }

    @PostMapping(value = "/submitCar")
    public String submitCar (@ModelAttribute("car") Car car) {
        carRepository.save(car);
        return "redirect:/cars";
    }

    @GetMapping(value = "/registerCar")
    public String getRegisterCar (Model model) {
        model.addAttribute("car", new Car());
        return "carForm";
    }

    @GetMapping(value = "/editCar")
    public String showEditForm (@RequestParam("id") int carId, Model model) {
        model.addAttribute("car", carRepository.findById(carId));
        return "carForm";
    }
    @PostMapping(value = "/deleteCar")
    public String deleteCustomer (@RequestParam ("id") int carId) {
        carRepository.deleteById(carId);
        return "redirect:/cars";
    }
}
