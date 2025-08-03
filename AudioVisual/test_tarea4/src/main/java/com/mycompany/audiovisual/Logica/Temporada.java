
package com.mycompany.audiovisual.Logica;


public class Temporada {
    private int numeroTemporada;
    private int cantidadEpisodios;
    
    public Temporada(int numeroTemporada, int cantidadEpisodio){
        this.numeroTemporada = numeroTemporada;
        this.cantidadEpisodios = cantidadEpisodio;
    }
    public int getNumeroTemporada(){
        return numeroTemporada;
    }
    public void setNumerotemporada(int numeroTemporada){
        this.numeroTemporada = numeroTemporada;
    }
    public int getCantidadEpisodios(){
        return cantidadEpisodios;
    }
    public void setCantidadEpisodios(int cantidadEpisodios){
        this.cantidadEpisodios = cantidadEpisodios;
    }
    @Override
    public String toString(){
        return "Temporada " + numeroTemporada + "(" + cantidadEpisodios + "episodios)";
    }
}
