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
public class Dato {
    double datoNumerico;
    String datoAlfabetico;

    public Dato(String datoNumerico, String datoAlfabetico) {
        this.datoNumerico = new Double(datoNumerico);
        this.datoAlfabetico = datoAlfabetico;
    }
    public Dato(double datoNumerico, String datoAlfabetico) {
        this.datoNumerico = new Double(datoNumerico);
        this.datoAlfabetico = datoAlfabetico;
    }

    public double getDatoNumerico() {
        return datoNumerico;
    }

    public void setDatoNumerico(double datoNumerico) {
        this.datoNumerico = datoNumerico;
    }
    public void setDatoNumerico(String datoNumerico) {
        this.datoNumerico = new Double(datoNumerico);
    }

    public String getDatoAlfabetico() {
        return datoAlfabetico;
    }

    public void setDatoAlfabetico(String datoAlfabetico) {
        this.datoAlfabetico = datoAlfabetico;
    }
    
    
}
