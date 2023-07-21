package com.example.CarRent.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDtoOverview {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int numberOfReservation;
    private String fullName;
}
