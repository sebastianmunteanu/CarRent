package com.example.CarRent.Utils;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MonthUtils {
    public static List<Integer> getLastTenDays() {
        LocalDate curentDate = LocalDate.now();
        List<Integer> listOfLastTenDays = new ArrayList<>();
        for (int i = 0; i< 10; i++) {
            listOfLastTenDays.add(curentDate.minusDays(i).getDayOfMonth());
        }
        Collections.reverse(listOfLastTenDays);
        return listOfLastTenDays;
    }
}
