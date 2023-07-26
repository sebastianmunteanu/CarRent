package com.example.CarRent.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDto {
    private int id;
    private int customer;
    private int car;

    @NotNull (message = "Selectati data de start")
    private LocalDate startDate;

    @NotNull (message = "Selectati data de final")
    private LocalDate endDate;

    private LocalDate dateOfReservation = LocalDate.now();


}
