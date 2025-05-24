/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.services;

/**
 *
 * @author adolf
 */
public class NameServiceImpl implements INameService {
    
    @Override
    public String generateFullName(String firstname, String lastname) {
        return firstname + " " + lastname;
    }
}
