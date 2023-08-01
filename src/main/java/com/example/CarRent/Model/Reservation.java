package com.example.CarRent.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table (name = "t_reservation")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "startdate")
    private LocalDate startDate;

    @Column (name = "enddate")
    private LocalDate endDate;

    @Column (name = "dateofreservation")
    private LocalDate dateOfReservation;

    @ManyToOne
    @JoinColumn (name = "customerid")
    private Customer customer;

    @ManyToOne
    @JoinColumn (name = "carid")
    private Car car;

    public void setDateOfReservation(LocalDate dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

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

    public LocalDate getDateOfReservation1 () {
        return dateOfReservation;
    }
}
