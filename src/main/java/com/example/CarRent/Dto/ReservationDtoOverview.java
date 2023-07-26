package com.example.CarRent.Dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDtoOverview {
    private int id;
    private String customer;
    private String car;
    private String dateOfReservation;
    private String startDate;
    private String endDate;
    private int numberOfResDays;
}