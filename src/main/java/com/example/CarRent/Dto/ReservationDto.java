package com.example.CarRent.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {
    private int id;
    private int customer;
    private int car;
}
