package com.example.CarRent.Service;

import com.example.CarRent.Dto.CarDto;
import com.example.CarRent.Dto.CarDtoOverview;
import com.example.CarRent.Mapper.CarMapper;
import com.example.CarRent.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarMapper carMapper;

    public List<CarDtoOverview> getAllCars() {
        return carMapper.getAllCars(carRepository.findAll());
    }

    public void saveCar (CarDto carDto) {
        carRepository.save(carMapper.getCar(carDto));
    }

    public CarDto findCar (int carId) {
        return carMapper.getCarDto(carRepository.findById(carId).get());
    }

    public void deleteCar (int carId) {
        carRepository.deleteById(carId);
    }


}
