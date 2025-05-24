/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storages;

import core.models.Plane;
import java.util.ArrayList;

/**
 *
 * @author ddbarraza
 */
public class PlaneStorage {
    
    private static PlaneStorage instance;
    
    private ArrayList<Plane> planes;

    public PlaneStorage() {
        this.planes = new ArrayList<>();
    }
    
    public static PlaneStorage getInstance() {
        if (instance == null) {
            instance = new PlaneStorage();
        }
        return instance;
    }
    
    public boolean addPlane(Plane plane) {
        for (Plane p : this.planes) {
            if (p.getId().equals(plane.getId())) {
                return false;
            }
        }
        //Comparacion de letras (como substrings) y numeros (como enteros) para que la lista quede ordenada por id
        int index = 0;
        while (index < planes.size()) {
            String currentId = planes.get(index).getId();
            String newId = plane.getId();

            String lettersCurrent = currentId.substring(0, 2);
            String lettersNew = newId.substring(0, 2);
            int letterComparison = lettersCurrent.compareTo(lettersNew);

            if (letterComparison > 0) {
                break;
            } else if (letterComparison == 0) {
                int numberCurrent = Integer.parseInt(currentId.substring(2));
                int numberNew = Integer.parseInt(newId.substring(2));

                if (numberCurrent > numberNew) {
                    break;
                }
            }
            index++;
        }
        
        this.planes.add(plane);
        return true;
    }
    
    public Plane getPlane(String id) {
        for (Plane plane : this.planes) {
            if (plane.getId().equals(id)) {
                return plane;
            }
        }
        return null;
    }
    
    public boolean delPlane(int id) {
        for (Plane plane : this.planes) {
            if (plane.getId().equals(id)) {
                this.planes.remove(plane);
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Plane> getAllPlanes() {
        return this.planes;
    }
    
}
