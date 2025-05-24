/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.interfaces;

import java.time.LocalDate;

/**
 *
 * @author adolf
 */
public interface IPersonalInfo {
    String getFirstname();
    String getLastname();
    String getFullname();
    LocalDate getBirthDate();
    int calculateAge();
    String getCountry();
}