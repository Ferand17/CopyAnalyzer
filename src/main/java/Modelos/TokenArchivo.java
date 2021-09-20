/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author ferand20
 */
public class TokenArchivo {
    private String nombre;
    private ArrayList<TokenClase> clases;
    private ArrayList<TokenFuncion> funciones;
    private ArrayList<String> variables;
    private ArrayList<String> comentarios;
    
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
     * @return the Comentarios
     */
    public ArrayList<String> getComentarios() {
        return comentarios;
    }

    /**
     * @param Comentarios the Comentarios to set
     */
    public void setComentarios(ArrayList<String> Comentarios) {
        this.comentarios = Comentarios;
    }

    /**
     * @return the clases
     */
    public ArrayList<TokenClase> getClases() {
        return clases;
    }

    /**
     * @param clases the clases to set
     */
    public void setClases(ArrayList<TokenClase> clases) {
        this.clases = clases;
    }

    /**
     * @return the funciones
     */
    public ArrayList<TokenFuncion> getFunciones() {
        return funciones;
    }

    /**
     * @param funciones the funciones to set
     */
    public void setFunciones(ArrayList<TokenFuncion> funciones) {
        this.funciones = funciones;
    }

    /**
     * @return the variables
     */
    public ArrayList<String> getVariables() {
        return variables;
    }
    /**
     * @param variables the variables to set
     */
    public void setVariables(ArrayList<String> variables) {
        this.variables = variables;
    }

    public TokenArchivo(String nombre,ArrayList<TokenClase> clases, ArrayList<TokenFuncion> funciones, ArrayList<String> variables,ArrayList<String> comentarios) {
        this.nombre = nombre;
        this.comentarios = comentarios;
        this.clases = clases;
        this.funciones = funciones;
        this.variables = variables;
    }

    
    
}
