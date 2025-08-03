
package com.mycompany.audiovisual.Logica;


public abstract class ContenidoAudivisual {
    protected String titulo;
    protected int anioLanzamiento;
    protected String genero;
    protected String id;
    
    public ContenidoAudivisual(String titulo, int anioLanzamiento, String genero) {
        
        this.titulo = titulo;
        this.anioLanzamiento = anioLanzamiento;
        this.genero = genero;
        this.id = java.util.UUID.randomUUID().toString();
        
    }

    // Getter y Setter para el campo 'titulo'
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter y Setter para el campo 'DuracionEnMinutos'
    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    // Getter y Setter para el campo 'genero'
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getter para el campo 'id' (no se proporciona el Setter ya que 'id' se asigna en el constructor y parece ser inmutable)
    
    
    public abstract void reproducir();
    @Override
    public String toString(){
        return "ID: " + id + ", Título: " + titulo + ", Año: " + anioLanzamiento + ", Género: " + genero;
    }
    public abstract String getTipoContenido();
}
//