/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author ferand20
 */
public class TokenFuncion {
    private String nombre;
    private int cantidadLineas;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cantidadLineas
     */
    public int getCantidadLineas() {
        return cantidadLineas;
    }

    /**
     * @param cantidadLineas the cantidadLineas to set
     */
    public void setCantidadLineas(int cantidadLineas) {
        this.cantidadLineas = cantidadLineas;
    }

    public TokenFuncion(String nombre, int cantidadLineas) {
        this.nombre = nombre;
        this.cantidadLineas = cantidadLineas;
    }
    
    
}
