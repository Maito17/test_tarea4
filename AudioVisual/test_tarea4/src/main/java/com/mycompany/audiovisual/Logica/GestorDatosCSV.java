
package com.mycompany.audiovisual.Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorDatosCSV {

    private static final String SEPARADOR = ",";

    public void guardarDatos(List<ContenidoAudivisual> contenidos, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (ContenidoAudivisual contenido : contenidos) {
                bw.write(formatearLineaCSV(contenido));
                bw.newLine();
            }
            System.out.println("Datos guardados en " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public List<ContenidoAudivisual> cargarDatos(String nombreArchivo) {
        List<ContenidoAudivisual> contenidos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                ContenidoAudivisual contenido = parsearLineaCSV(linea);
                if (contenido != null) {
                    contenidos.add(contenido);
                }
            }
            System.out.println("Datos cargados desde " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
        return contenidos;
    }

    
    
    private String formatearLineaCSV(ContenidoAudivisual contenido) {
        StringBuilder sb = new StringBuilder();
        sb.append(contenido.getTipoContenido()).append(SEPARADOR); 

        if (contenido instanceof Pelicula) {
            Pelicula p = (Pelicula) contenido;
            sb.append(p.getTitulo()).append(SEPARADOR);
            sb.append(p.getAnioLanzamiento()).append(SEPARADOR);
            sb.append(p.getGenero()).append(SEPARADOR);
            sb.append(p.getDirector()).append(SEPARADOR);
            sb.append(p.getDuracionMinutos()).append(SEPARADOR);
           
        } else if (contenido instanceof Documental) {
            Documental d = (Documental) contenido;
            sb.append(d.getTitulo()).append(SEPARADOR);
            
        }else if (contenido instanceof Cortometraje){
            Cortometraje c = (Cortometraje) contenido;
            sb.append(c.getTitulo()).append(SEPARADOR);
        }
        return sb.toString();
    }
    private ContenidoAudivisual parsearLineaCSV(String linea) {
        String[] partes = linea.split(SEPARADOR);
        String tipo = partes[0]; // La primera parte de la línea indica el tipo

        switch (tipo) {
            case "PELICULA":
                
                return new Pelicula(partes[1], Integer.parseInt(partes[2]), partes[3], partes[4], Integer.parseInt(partes[5]));
            case "DOCUMENTAL":
                
                return new Documental(partes[1], Integer.parseInt(partes[2]), partes[3], partes[4]);
            case "CORTOMETRAJE":
                
                return new Cortometraje(partes[1], Integer.parseInt(partes[2]), partes[3], partes[4], Integer.parseInt(partes[5]), partes[6]) {
            @Override
            public String getTipoContenido() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
            default:
                System.err.println("Tipo de contenido desconocido: " + tipo);
                return null;
        }
    }
}
