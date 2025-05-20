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
            if (p.getId() == plane.getId()) {
                return false;
            }
        }
        this.planes.add(plane);
        return true;
    }
    
    public Plane getPlane(int id) {
        for (Plane plane : this.planes) {
            if (Integer.parseInt(plane.getId()) == id) {
                return plane;
            }
        }
        return null;
    }
    
    public boolean delPlane(int id) {
        for (Plane plane : this.planes) {
            if (Integer.parseInt(plane.getId()) == id) {
                this.planes.remove(plane);
                return true;
            }
        }
        return false;
    }
    
}
