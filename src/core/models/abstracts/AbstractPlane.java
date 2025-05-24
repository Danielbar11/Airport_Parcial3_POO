/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.abstracts;

import core.models.interfaces.IPlane;

/**
 *
 * @author adolf
 */
public abstract class AbstractPlane implements IPlane {
    protected final String id;
    
    protected AbstractPlane(String id) {
        this.id = id;
    }
    
    @Override
    public final String getId() {
        return id;
    }
}
