package com.example.CarRent.Mapper;

import com.example.CarRent.Dto.CarDto;
import com.example.CarRent.Dto.CarDtoOverview;
import com.example.CarRent.Model.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarMapper {

    public List<CarDtoOverview> getAllCars (List<Car> carList) {
        return carList.stream()
                .map(car -> mapToCarDTO(car))
                .collect(Collectors.toList());
    }

    public Car getCar (CarDto carDto) {
        return mapToCar(carDto);
    }

    public CarDto getCarDto (Car car) {
        return mapToCarDto(car);
    }

    private CarDtoOverview mapToCarDTO (Car car) {
        return CarDtoOverview.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .yearOfManufacture(car.getYearOfManufacture())
                .mileage(car.getMileage())
                .color(car.getColor())
                .reservationsNumber(car.getNumberOfReserved())
                .carName(car.getCar())
                .build();
    }

    private Car mapToCar (CarDto carDto) {
        return Car.builder()
                .id(carDto.getId())
                .brand(carDto.getBrand())
                .mileage(carDto.getMileage())
                .model(carDto.getModel())
                .color(carDto.getColor())
                .yearOfManufacture(carDto.getYearOfManufacture())
                .build();
    }

    public CarDto mapToCarDto (Car car){
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .color(car.getColor())
                .mileage(car.getMileage())
                .model(car.getModel())
                .yearOfManufacture(car.getYearOfManufacture())
                .build();
    }

}
