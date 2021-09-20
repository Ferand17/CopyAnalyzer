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
public class TokenClase {
    private String nombre;
    private int cantidadDeLineas;

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
     * @return the cantidadDeLineas
     */
    public int getCantidadDeLineas() {
        return cantidadDeLineas;
    }

    /**
     * @param cantidadDeLineas the cantidadDeLineas to set
     */
    public void setCantidadDeLineas(int cantidadDeLineas) {
        this.cantidadDeLineas = cantidadDeLineas;
    }

    public TokenClase(String nombre, int cantidadDeLineas) {
        this.nombre = nombre;
        this.cantidadDeLineas = cantidadDeLineas;
    }
}
