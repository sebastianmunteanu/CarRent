package com.example.CarRent.Dto;


import com.example.CarRent.Model.Reservation;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDtoOverview {
    private int id;
    private String brand;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double mileage;
    private int reservationsNumber;
    private String carName;
}
