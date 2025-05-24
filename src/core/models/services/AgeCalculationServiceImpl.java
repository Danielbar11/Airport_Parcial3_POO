/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author adolf
 */
public class AgeCalculationServiceImpl implements IAgeCalculationService {
    
    @Override
    public int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
