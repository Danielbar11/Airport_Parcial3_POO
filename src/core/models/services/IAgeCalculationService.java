/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

import java.time.LocalDate;

/**
 *
 * @author adolf
 */
public interface IAgeCalculationService {
    int calculateAge(LocalDate birthDate);
}
