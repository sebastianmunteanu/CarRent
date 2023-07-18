package com.example.CarRent.Model;

import jakarta.persistence.*;

@Entity
@Table(name="t_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "brand")
    private String brand;
    @Column
    private String model;
    @Column (name = "yearofmanufacture")
    private int yearOfManufacture;
    @Column
    private String color;
    @Column
    private double mileage;

    public Car(int id, String brand, String model, int year, String color, double mileage) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = year;
        this.color = color;
        this.mileage = mileage;
    }

    public Car () { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return yearOfManufacture;
    }

    public void setYear(int year) {
        this.yearOfManufacture = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
}
