/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.abstracts;

import core.models.interfaces.IPassenger;

/**
 *
 * @author adolf
 */
public abstract class AbstractPassenger implements IPassenger {
    protected final long id;
    
    protected AbstractPassenger(long id) {
        this.id = id;
    }
    
    @Override
    public final long getId() {
        return id;
    }
}
