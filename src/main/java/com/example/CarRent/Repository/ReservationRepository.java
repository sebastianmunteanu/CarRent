package com.example.CarRent.Repository;

import com.example.CarRent.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation,Integer> {
    @Query("SELECT r FROM Reservation r WHERE r.dateOfReservation >= :startDate")
    List<Reservation> findReservationsInLastTenDays(LocalDate startDate);
}
