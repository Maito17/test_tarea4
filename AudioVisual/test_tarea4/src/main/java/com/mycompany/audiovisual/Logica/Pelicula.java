
package com.mycompany.audiovisual.Logica;

import java.util.ArrayList;
import java.util.List;


public class Pelicula extends ContenidoAudivisual{
    private String director;
    private int duracionMinutos;
    private List<Actor>actores;

    public Pelicula(String titulo, int anioLanzamiento, String genero, String director, int duracionMinutos) {
        super(titulo, anioLanzamiento, genero);
        this.director = director;
        this.duracionMinutos = duracionMinutos;
        this.actores = new ArrayList<>();
    }
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public int getDuracionMinutos(){
        return duracionMinutos;
    
    }
    public void setDuracionMinutos(int duracionMinutos){
        this.duracionMinutos = duracionMinutos;
    }
    public void agregarActor(Actor actor){
        this.actores.add(actor);
    }
    public List<Actor> getActores(){
        return actores;
    }
    @Override
    public void reproducir(){
        System.out.println("Reproduciendo la película: " + titulo 
                + " (Director: " + director + ", Duración: " + duracionMinutos + " min)");
    }
    @Override
    public String toString(){
        String infoActores = "";
                if(!actores.isEmpty()){
                    infoActores = ",Actores: " + actores;
                }
        return "Película: " + super.toString() + ", Director: " + director + ", Duración: " + duracionMinutos + " min" + infoActores;
    }
    @Override
    public String getTipoContenido(){
        return "PElicula";
    }
}
