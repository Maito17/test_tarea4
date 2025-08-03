
package com.mycompany.audiovisual.Logica;

import java.util.ArrayList;
import java.util.List;


public abstract class SerieDeTV extends ContenidoAudivisual{
    private int numeroTemporadas;
    private List<Temporada> temporadas;

    public SerieDeTV(String titulo, int anioLanzamiento, String genero, int numeroTemporadas) {
        super(titulo, anioLanzamiento, genero);
        this.numeroTemporadas = numeroTemporadas;
        this.temporadas = new ArrayList<>();
    }

    

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }
    public void agregarTemporada(Temporada temporada){
        this.temporadas.add(temporada);
    }
    public List<Temporada>getTemporadas(){
        return temporadas;
    }
    public int getNumeroTotalTemporadas(){
        return temporadas.size();
    }
    
    @Override
    public void reproducir(){
        System.out.println("Reproduciendo la serie de TV: " + titulo 
                + " (Temporadas: " + numeroTemporadas + getNumeroTotalTemporadas()+")");
    }
    @Override
    public String toString(){
        if(temporadas.isEmpty()){
        }
    
        return "Serie de TV: " + super.toString() + ", Temporadas: " + numeroTemporadas;
    }
}
