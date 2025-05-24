/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

/**
 *
 * @author adolf
 */
public class ContactServiceImpl implements IContactService {
    
    @Override
    public String formatPhoneNumber(int countryCode, long phone) {
        return "+" + countryCode + " " + phone;
    }
}
