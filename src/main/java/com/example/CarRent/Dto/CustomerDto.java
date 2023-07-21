package com.example.CarRent.Dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
}
