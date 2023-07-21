package com.example.CarRent.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private int id;
    private String brand;
    private String model;
    private int yearOfManufacture;
    private String color;
    private double mileage;
}
