
package com.mycompany.audiovisual.Logica;

import java.util.ArrayList;
import java.util.List;


public class Documental extends ContenidoAudivisual{
    private String temaPrincipal;
    private List<Investigador> investigadores;

    public Documental(String titulo, int anioLanzamiento, String genero, String temaPrincipal) {
        super(titulo, anioLanzamiento, genero);
        this.temaPrincipal = temaPrincipal;
        this.investigadores = new ArrayList<>();
        
    }

    public String getTemaPrincipal() {
        return temaPrincipal;
    }

    public void setTemaPrincipal(String temaPrincipal) {
        this.temaPrincipal = temaPrincipal;
    }
    public void agregarInvestigador(Investigador investigador){
        this.investigadores.add(investigador);
    }
    public List<Investigador> getInvestigadores(){
        return investigadores;
    }
    
    @Override
    public void reproducir(){
        System.out.println("Reproduciendo el documental: " + titulo 
                + " (Tema: " + temaPrincipal + ")");
    }
    @Override
    public String toString(){
        String infoInvestigadores = "";
                if(!investigadores.isEmpty()){
                    infoInvestigadores = ",Investigadores: " + investigadores;
                }
        return "Documental: " + super.toString() + ", Tema Principal: " + temaPrincipal + infoInvestigadores;
    }
    @Override
    public String getTipoContenido(){
        return "DOCUMENTAL";
    }
}
