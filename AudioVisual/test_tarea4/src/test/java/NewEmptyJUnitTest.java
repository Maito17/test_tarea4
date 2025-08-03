

import com.mycompany.audiovisual.Logica.Actor;
import com.mycompany.audiovisual.Logica.Cortometraje;
import com.mycompany.audiovisual.Logica.Documental;
import com.mycompany.audiovisual.Logica.Investigador;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;


public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }
    @BeforeAll
    public static void setUpClass(){
        System.out.println("ejecutando setUpClass..");
        
    }
    @AfterAll
    public static void tearDownClass(){
        System.out.print("Ejecutando tearDownClass..");
    }
    @BeforeEach
    public void setUo(){
        System.out.println("ejecutando setUp..");
    }
    @AfterEach
    public void tearDown(){
        System.out.println("ejecutando tearDown..");
    }
    @Test
    public void testConstructorAndGetters(){
        System.out.println("Probando el constructor y los getters de Actor.");
        String nombreEsperado = "Tom Hanks";
        String paisEsperado = "Estados Unidos";
        Actor actor = new Actor(nombreEsperado, paisEsperado);
        assertEquals(nombreEsperado, actor.getNombre(),"EL nombre del actor no coincide con el valor esperado.");
        assertEquals(paisEsperado, actor.getPaisOrigen(),"El país de origen del actor no coincide con el valor esperado.");
    }
    @Test
    public void testSetters() {
        System.out.println("Probando los setters de Actor.");
        Actor actor = new Actor("Leonardo DiCaprio", "Estados Unidos");
        String nuevoNombre = "Robert De Niro";
        String nuevoPais = "Italia";
        actor.setNombre(nuevoNombre);
        actor.setPaisOrigen(nuevoPais);
        assertEquals(nuevoNombre, actor.getNombre(),"El nombre no se actualizó correctamente con el setter.");
        assertEquals(nuevoPais, actor.getPaisOrigen(),"El país de origen no se actualizó correctamente con el setter.");
    }

    @Test
    public void testToString() {
        System.out.println("Probando el método toString de Actor.");
        Actor actor = new Actor("Meryl Streep", "Estados Unidos");
        String cadenaEsperada = "Actor: Meryl Streep(Oriegen: Estados Unidos)";
        assertEquals(cadenaEsperada, actor.toString(),"El método toString() no devuelve el formato de cadena esperado.");
    }
    @Test
    public void testConstructorAndGettersDocumental() {
        System.out.println("Probando el constructor y getters de Documental.");
        String titulo = "Planeta Tierra II";
        int anio = 2016;
        String genero = "Naturaleza";
        String tema = "Ecosistemas";
        Documental documental = new Documental(titulo, anio, genero, tema);

        assertEquals(titulo, documental.getTitulo());
        assertEquals(anio, documental.getAnioLanzamiento());
        assertEquals(genero, documental.getGenero());
        assertEquals(tema, documental.getTemaPrincipal());
        
        assertTrue(documental.getInvestigadores().isEmpty());
    }

    @Test
    public void testAgregarInvestigador() {
        System.out.println("Probando el método agregarInvestigador.");
        Documental documental = new Documental("Cosmos", 2014, "Ciencia", "El universo");
        
        Investigador investigador1 = new Investigador("Carl Sagan", "Astrofísica");
        Investigador investigador2 = new Investigador("Neil deGrasse Tyson", "Astrofísica");
        
        documental.agregarInvestigador(investigador1);
        documental.agregarInvestigador(investigador2);
        
        assertEquals(2, documental.getInvestigadores().size());
        
        assertTrue(documental.getInvestigadores().contains(investigador1));
        assertTrue(documental.getInvestigadores().contains(investigador2));
    }
    
    @Test
    public void testReproducirDocumental() {
        System.out.println("Probando el método reproducir de Documental.");
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        Documental documental = new Documental("La historia del mundo", 2012, "Historia", "Civilizaciones");
        documental.reproducir();
        
        String expectedOutput = "Reproduciendo el documental: La historia del mundo (Tema: Civilizaciones)\n";
        assertEquals(expectedOutput, outContent.toString());

        System.setOut(originalOut);
    }
    
    @Test
    public void testToStringConInvestigadores() {
        System.out.println("Probando el método toString con investigadores.");
        Documental documental = new Documental("Un documental", 2020, "Ciencia", "Robótica");
        
        Investigador inv = new Investigador("Marie Curie", "Física");
        documental.agregarInvestigador(inv);

        String expectedString = "Documental: Título: Un documental (2020), Género: Ciencia, Tema Principal: Robótica,Investigadores: [Investigador: Marie Curie (Especialidad: Física)]";
        
        assertEquals(expectedString, documental.toString());
    }

    @Test
    public void testToStringSinInvestigadores() {
        System.out.println("Probando el método toString sin investigadores.");
        Documental documental = new Documental("Un documental", 2020, "Ciencia", "Robótica");

        String expectedString = "Documental: Título: Un documental (2020), Género: Ciencia, Tema Principal: Robótica";
        assertEquals(expectedString, documental.toString());
    }
     @Test
    public void testCortometrajeIntegrado() {
        System.out.println("Probando la funcionalidad completa de Cortometraje.");

        
        String titulo = "La Luna";
        int anio = 2011;
        String genero = "Animación";
        String director = "Enrico Casarosa";
        int duracion = 7;
        String festival = "Festival de Annecy";

        Cortometraje corto = new Cortometraje(titulo, anio, genero, director, duracion, festival) {
            @Override
            public String getTipoContenido() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };

        assertEquals(titulo, corto.getTitulo(), "El título no es el esperado.");
        assertEquals(director, corto.getDirectorCorto(), "El director no es el esperado.");
        assertEquals(duracion, corto.getDuracionMinutos(), "La duración no es la esperada.");
        assertEquals(festival, corto.getFestivalGanado(), "El festival no es el esperado.");

        // 2. Probar los setters
        String nuevoDirector = "Pixar Director";
        int nuevaDuracion = 10;
        String nuevoFestival = "Oscar";

        corto.setDirectorCorto(nuevoDirector);
        corto.setDuracionMinutos(nuevaDuracion);
        corto.setFestivalGanado(nuevoFestival);
        
        assertEquals(nuevoDirector, corto.getDirectorCorto(), "El setter del director falló.");
        assertEquals(nuevaDuracion, corto.getDuracionMinutos(), "El setter de la duración falló.");
        assertEquals(nuevoFestival, corto.getFestivalGanado(), "El setter del festival falló.");
        
        
        String expectedString = "Cortometraje: Título: La Luna (2011), Género: Animación, Director: Pixar Director, Duración: 10 min, Festival: Oscar";
        assertEquals(expectedString, corto.toString(), "El toString no devuelve la cadena esperada.");

        
        assertEquals("CORTOMETRAJE", corto.getTipoCortometraje(), "El tipo de cortometraje no es correcto.");
    }
    

   
  }


