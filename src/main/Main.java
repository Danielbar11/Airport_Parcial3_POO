/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatDarkLaf;
import core.JsonsReaders.JsonFlightReader;
import core.JsonsReaders.JsonLocationReader;
import core.JsonsReaders.JsonPassengerReader;
import core.JsonsReaders.JsonPlaneReader;
import core.views.AirportFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ddbarraza
 */
public class Main {
    
    public static void main(String args[]) {
        
        JsonFlightReader.readJsonFlights();
        JsonLocationReader.readJsonLocations();
        JsonPassengerReader.readJsonPassengers();
        JsonPlaneReader.readJsonPlanes();
        
        System.setProperty("flatlaf.useNativeLibrary", "false");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(() -> {
            new AirportFrame().setVisible(true);
        });
    }
    
}
