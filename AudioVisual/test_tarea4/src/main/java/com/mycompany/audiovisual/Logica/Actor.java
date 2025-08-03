
package com.mycompany.audiovisual.Logica;


public class Actor {
    private String nombre;
    private String paisOrigen;
    
    public Actor(String nombre, String paisOrigen){
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getPaisOrigen(){
        return paisOrigen;
    }
    public void setPaisOrigen(String paisOrigen){
        this.paisOrigen = paisOrigen;
    }
    @Override
    public String toString(){
        return "Actor: " + nombre + "(Oriegen: " + paisOrigen + ")";
    }
    
}

