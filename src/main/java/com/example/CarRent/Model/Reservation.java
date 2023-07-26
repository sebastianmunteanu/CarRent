package com.example.CarRent.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table (name = "t_reservation")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private LocalDate dateOfReservation;

    @ManyToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn (name = "car_id")
    private Car car;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getStartDate () {
        return startDate.toString();
    }
    public String getEndDate () {
        return endDate.toString();
    }
    public int getNumberOfReservationDays() {
        return (int)ChronoUnit.DAYS.between(startDate, endDate);
    }

    public String getDateOfReservation () {
        return dateOfReservation.toString();
    }
}
