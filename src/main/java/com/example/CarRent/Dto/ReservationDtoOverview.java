package com.example.CarRent.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDtoOverview {
    private int id;
    private int customer;
    private int car;
}