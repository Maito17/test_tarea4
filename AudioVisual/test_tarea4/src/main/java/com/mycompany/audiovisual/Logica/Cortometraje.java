
package com.mycompany.audiovisual.Logica;


public abstract class Cortometraje extends ContenidoAudivisual{
    private String directorCorto;
    private int duracionMinutos;
    private String festivalGanado;
    
    public Cortometraje(String titulo, int anioLanzamiento, String genero, String directorCorto, int duracionMinutos, String festivalGanado){
        super(titulo, anioLanzamiento, genero);
        this.directorCorto = directorCorto;
        this.duracionMinutos = duracionMinutos;
        this.festivalGanado = festivalGanado;
    }
    public String getDirectorCorto(){
        return directorCorto;
    
    }
    public void setDirectorCorto(String directorCorto){
        this.directorCorto = directorCorto;
    }
    public int getDuracionMinutos(){
        return duracionMinutos;
    }
    public void setDuracionMinutos(int duracionMinutos){
        this.duracionMinutos = duracionMinutos;
    }
    public String getFestivalGanado(){
        return festivalGanado;
    }
    public void setFestivalGanado(String festivalGanado){
        this.festivalGanado = festivalGanado;
    }
    @Override
    public void reproducir(){
        System.out.println("Reproduciendo el cortometraje: " + titulo
                + " (Dirigido por: " + directorCorto + ")");
    }
    @Override
    public String toString(){
        return "Cortometraje: " + super.toString() + ", Director: " + directorCorto + ", Duración: " + duracionMinutos + " min, Festival: " + festivalGanado; 
    }
    public String getTipoCortometraje(){
        return "CORTOMETRAJE";
    }
}

