package com.example.CarRent.Service;

import com.example.CarRent.Dto.ReservationDto;
import com.example.CarRent.Dto.ReservationDtoOverview;
import com.example.CarRent.Mapper.ReservationMapper;
import com.example.CarRent.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    public void saveReservation (ReservationDto reservationDto) {
        reservationRepository.save(reservationMapper.getReservation(reservationDto));
    }
}
