package Modelo;

import java.io.Serializable;

public class Multimedia implements Serializable {

    public static ArregloVideos catalogoVideos = new ArregloVideos();
    public static ArregloPeliculas catalogoPeliculas = new ArregloPeliculas();

    public static void crearCatalogo() {


        //INSTANCIAMOS LA PELICULA "Milagros del cielo"/*NUEVO*/
        String[] elenco1 = {"Jennifer Garner", "Kylie Rogers", "Queen Latifah", 
        "Eugenio Derbez", "Martin Henderson", "John Carroll Lynch"};

        Pelicula p1 = new Pelicula( /*TITULO*/"Milagros del cielo",
                /*DIRECTOR*/ "Patricia Riggen",
                /*GENERO*/ "DRAMA",
                /*AÑO DE ESTRENO*/ 2016,
                /*EDAD APTA*/ 13,
                /*SINOPSIS*/ "Christy, una madre devota con una hija muy enferma, sufre una crisis de fe mientras intenta desesperadamente"
                + "\nsalvar a su pequeña y mantener unida su familia.",
                /*CAST*/ elenco1,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 109,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 1, "src\\Imagenes\\Peliculas\\Milagros_del_Cielo.jpg", "src\\Peliculas\\Milagros_del_Cielo.mp4");

        Multimedia.catalogoPeliculas.agregarPelicula(p1);




        //INSTANCIAMOS LA PELICULA "El niño que domo el viento"/*NUEVO*/
        String[] elenco2 = {"Maxwell Simba", "Chiwetel Ejiofor", "Aissa Maiga", 
        "Lily Banda", "Lemogang Tsipa"};

        Pelicula p2 = new Pelicula( /*TITULO*/"El niño que domó el viento",
                /*DIRECTOR*/ "Damien Chazelle",
                /*GENERO*/ "DRAMA",
                /*AÑO DE ESTRENO*/ 2019,
                /*EDAD APTA*/ 13,
                /*SINOPSIS*/ "Un chico se inspira en un libro de ciencia para crear un molino de viento que salve a su aldea malauí del hambre."
                +"\nBasada en la historia real de William Kamkwamba.",
                /*CAST*/ elenco2,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 113,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 2, "src\\Imagenes\\Peliculas\\Domo_el_viento.jpg", "src\\Peliculas\\Domo_el_viento.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p2);




        //INSTANCIAMOS LA PELICULA "La vida ante sí" /*NUEVO*/
        String[] elenco3 = {"Sophia Loren", "Ibrahima Gueye", "Renato Carpentieri", "Diego Iosif Pirvu", "Massimilliano Rossi"};
        Pelicula p3 = new Pelicula( /*TITULO*/"La vida ante sí",
                /*DIRECTOR*/ "Edoardo Ponti",
                /*GENERO*/ "DRAMA",
                /*AÑO DE ESTRENO*/ 2020,
                /*EDAD APTA*/ 13,
                /*SINOPSIS*/ "Una sobreviviente del Holocausto que cuida niños en su casa accede a refugiar a un resentido niño de la calle que le"
                +"\nle robó, y forman un impensable lazo de amistad.",
                /*CAST*/ elenco3,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 95,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 3, "src\\Imagenes\\Peliculas\\La_vida.jpg", "src\\Peliculas\\La_vida.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p3);



        //INSTANCIAMOS LA PELICULA "El duende maldito regresa" /*NUEVO*/
        String[] elenco4 = {"Taylor Spreitler", "Pepi Sonuga", "Linden Bennett", "Emily Reid",
            "Mark Holton", "Ben McGregor", "Oliver Llewellyn", "Heather McDonald"};

        Pelicula p4 = new Pelicula( /*TITULO*/"El duende maldito regresa",
                /*DIRECTOR*/ "Steven Kostanski",
                /*GENERO*/ "TERROR",
                /*AÑO DE ESTRENO*/ 2018,
                /*EDAD APTA*/ 16,
                /*SINOPSIS*/ "Veinticinco años después de haber sido derrotado por una adolecente, el duente malvado vuelve a la vida cuando unas"
                + "\namigas de la fraternidad lo despiertan accidentalmente.",
                /*CAST*/ elenco4,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 93,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 4, "src\\Imagenes\\Peliculas\\El_duende.jpg", "src\\Peliculas\\El_duende.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p4);



        //INSTANCIAMOS LA PELICULA "El dragon de la tetera" */NUEVO*/
        String[] elenco5 = {"Jimmy Wong", "John Cho", "Constance Wu", "Natasha Liu Bordizzo", "Will Yun Lee"};
        Pelicula p5 = new Pelicula( /*TITULO*/"El dragon de la tetera",
                /*DIRECTOR*/ "Chris Appelhans",
                /*GENERO*/ "ANIMACIÓN",
                /*AÑO DE ESTRENO*/ 1988,
                /*EDAD APTA*/ 12,
                /*SINOPSIS*/ "El perseverante adolecente Din anhela recuperar a su mejor amiga de la infancia cuando conoce a un dragón de los deseos"
                +"\nque le muestras la magia de lo posible.",
                /*CAST*/ elenco5,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 89,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 5, "src\\Imagenes\\Peliculas\\El_dragon.jpg", "src\\Peliculas\\El_dragon.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p5);




        //INSTANCIAMOS LA PELICULA "Megamente" /*NUEVO*/
        String[] elenco6 = {"Will Ferrell", "Brad Pitt", "Jonah Hill", "David Cross",
            "Ben Stiller", "Justin Theroux", "Jessica Schulte", "Tom McGrath"};

        Pelicula p6 = new Pelicula( /*TITULO*/"Megamente",
                /*DIRECTOR*/ "Tom McGrath",
                /*GENERO*/ "ANIMACIÓN",
                /*AÑO DE ESTRENO*/ 2010,
                /*EDAD APTA*/ 7,
                /*SINOPSIS*/ "Cuando el brillante supervillano Megamind mata por accidente a su némesis, crea un nuevo enemigo que se propone"
                + "\ndestrir el mundo.",
                /*CAST*/ elenco6,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 97,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 6, "src\\Imagenes\\Peliculas\\Megamente.jpg", "src\\Peliculas\\Megamente.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p6);



        //INSTANCIAMOS LA PELICULA "Slender Man" /*NUEVO*/
        String[] elenco7 = {"Joey King", "Julia Goldani Telles", "Jaz Sinclair", "Annalise Basso",
            "Alex Fitzalan", "Taylor Richardson", "Javier Botet", "Michael Reilly"};
        Pelicula p7 = new Pelicula( /*TITULO*/"Slender Man",
                /*DIRECTOR*/ "Sylvain White",
                /*GENERO*/ "TERROR",
                /*AÑO DE ESTRENO*/ 2018,
                /*EDAD APTA*/ 13,
                /*SINOPSIS*/ "Desesperados por encontrar a su amiga perdida, un grupo de chicas invoca a la entidad que presuntamente se la llevó:"
                +"\nuna malvada leyenda de internet llamada Slender Man.",
                /*CAST*/ elenco7,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/93,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 7, "src\\Imagenes\\Peliculas\\Slenderman.jpg", "src\\Peliculas\\Slenderman.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p7);

        //INSTANCIAMOS LA PELICULA "Los Croods" /*NUEVO*/
        String[] elenco8 = {"Nicolas Cage", "Emma Stone", "Ryan Reynolds", "Catherine Keener",
             "Cloris Leachman", "Clark Duke", "Chris Sanders", "Dandy Thom"};
        
        Pelicula p8 = new Pelicula( /*TITULO*/"Los Croods",
                /*DIRECTOR*/ "Kirk DeMicco, Chris Sanders",
                /*GENERO*/ "ANIMACION",
                /*AÑO DE ESTRENO*/ 2013,
                /*EDAD APTA*/ 16,
                /*SINOPSIS*/ "Cuando un terremoto destruye su cueva, una familia prehistorica se ve obligada a viajar a travez de una zona desnococida"
                + "\nen busca de un nuevo hogar.",
                /*CAST*/ elenco8,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 98,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 8, "src\\Imagenes\\Peliculas\\Los_croods.jpg", "src\\Peliculas\\Los_croods.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p8);

        //INSTANCIAMOS LA PELICULA "Cuidado con lo que deseas" /*NUEVO*/
        String[] elenco9 = {"Fernanda Castillo", "Valery Sais", "Juan Rios", "Ivan Arana",
             "Ramon Medina", "Miguel Mena Camara", "Juan Menchaca", "Hector Holten"};
        Pelicula p9 = new Pelicula( /*TITULO*/"Cuidado con lo que deseas",
                /*DIRECTOR*/ "Agustin Tapia",
                /*GENERO*/ "TERROR",
                /*AÑO DE ESTRENO*/ 2020,
                /*EDAD APTA*/ 16,
                /*SINOPSIS*/ "Una pequeña niña recibe como regalo de cumpleaños un bufón que magicamente le revela el oscuro comportamiento"
                + "secreto de sus padres y su tío.",
                /*CAST*/ elenco9,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 78,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 9, "src\\Imagenes\\Peliculas\\Cuidado_deseas.jpg", "src\\Peliculas\\Cuidado_deseas.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p9);

        //INSTANCIAMOS LA PELICULA "Rango" /*NUEVO*/
        String[] elenco10 = {"Johnny Depp", "Isla Fisher", "Abigail Breslin", "Alfred Molina",
             "Bill Nighy", "Stephen Roota", "Harry Dean Stanton", "Timothy Olyphant"};
        Pelicula p10 = new Pelicula( /*TITULO*/"Rango",
                /*DIRECTOR*/ "Gore Verbinski",
                /*GENERO*/ "ANIMACIÓN",
                /*AÑO DE ESTRENO*/ 2011,
                /*EDAD APTA*/ 7,
                /*SINOPSIS*/ "El camaleón mascota Rango se pierde en el desierto. Para sobrevivir finger ser un tipo rudo, y eso lo lleva a"
                +"\nconvertirse en el comisario de un pueblo fronterizo sin ley.",
                /*CAST*/ elenco10,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 109,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 10, "src\\Imagenes\\Peliculas\\Rango.jpg", "src\\Peliculas\\Rango.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p10);

        //INSTANCIAMOS LA PELICULA "Nadie sale con vida" /¨NUEVO*/
        String[] elenco11 = {"Cristian Rodlo", "Marc Menchara", "David Figlioli", "David Barrera",
             "Moronke Akinola"};

        Pelicula p11 = new Pelicula( /*TITULO*/"Nadie sale con vida",
                /*DIRECTOR*/ "Santiago Menghini",
                /*GENERO*/ "TERROR",
                /*AÑO DE ESTRENO*/ 2021,
                /*EDAD APTA*/ 16,
                /*SINOPSIS*/ "Desesperada y sin documentos, una mujer proveniente de México se muda a una deteriorada pension en Cleveland,"
                + "\ndonde empieza a tener extrañas y perturbadoras visiones.",
                /*CAST*/ elenco11,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 87,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 11, "src\\Imagenes\\Peliculas\\Nadie_sale_con_vida.jpg", "src\\Peliculas\\Nadie_sale_con_vida.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p11);




        //INSTANCIAMOS LA PELICULA "Misión al rescate" /*NUEVO*/
        String[] elenco12 = {"Chris Hemsworth", "Rudhraksh Jaiswal", "Randeep Hooda", "Golshifter Farahani",
             "Pankaj Tripathi", "David Harbour"};
        Pelicula p12 = new Pelicula( /*TITULO*/"Misión al rescate",
                /*DIRECTOR*/ "Sam Hargrave",
                /*GENERO*/ "ACCIÓN",
                /*AÑO DE ESTRENO*/ 2020,
                /*EDAD APTA*/ 12,
                /*SINOPSIS*/ "La misión de un agerrido mercenario se convierte en una introspectiva carrera de supervivencia cuando lo"
                + "\nenvían a Bangladés a rescatar al hijo de un narco.",
                /*CAST*/ elenco12,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 117,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 12, "src\\Imagenes\\Peliculas\\Mision_al_rescate.jpg", "src\\Peliculas\\Mision_al_rescate.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p12);



        //INSTANCIAMOS LA PELICULA "El protector" /*NUEVO*/
        String[] elenco13 = {"Liam Neeson", "Katheryn Winnick", "Juan Pablo Raba", "Teresa Ruiz", "Jacob Perez", "Dylan Kenin"};
        Pelicula p13 = new Pelicula( /*TITULO*/"El protector",
                /*DIRECTOR*/ "Robert Lorenz",
                /*GENERO*/ "ACCIÓN",
                /*AÑO DE ESTRENO*/ 2021,
                /*EDAD APTA*/ 6,
                /*SINOPSIS*/ "Un exmarine y ganadero de Arizona deja un rastro sangriento cuando se convierte en el protector de un niño"
                + "\nque huye de unos narcotraficantes asesinos.",
                /*CAST*/ elenco13,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 107,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 13, "src\\Imagenes\\Peliculas\\El_protector.jpg", "src\\Peliculas\\El_protector.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p13);



        //INSTANCIAMOS LA PELICULA "Triple frontera" /*NUEVO*/
        String[] elenco14 = {"Ben Affleck", "Oscar Isaac", "Charlie Hunnam", "Pedro Pascal",
             "Garrett Hedlund", "Adria Arjona"};
        Pelicula p14 = new Pelicula( /*TITULO*/"Triple frontera",
                /*DIRECTOR*/ "J.C. Chandor",
                /*GENERO*/ "ACCIÓN",
                /*AÑO DE ESTRENO*/ 2019,
                /*EDAD APTA*/ 16,
                /*SINOPSIS*/ "Cinco exsoldados de operaciones especiales ponen la mira en la fortuna oculta de un campo de narcotrafico."
                + "\nNo hay vuelta atras.",
                /*CAST*/ elenco14,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 125,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 14, "src\\Imagenes\\Peliculas\\Triple_frontera.jpg", "src\\Peliculas\\Triple_frontera.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p14);

        //INSTANCIAMOS LA PELICULA "Alerta roja" /*NUEVO*/
        String[] elenco15 = {"Dwayne Johnson", "Ryan Reynolds", "Gal Gadot", "Ritu Arya", "Crris Diamantopoulos"};
        Pelicula p15 = new Pelicula( /*TITULO*/"Alerta roja",
                /*DIRECTOR*/ "Rawson Marshall Thurber",
                /*GENERO*/ "ACCION",
                /*AÑO DE ESTRENO*/ 2021,
                /*EDAD APTA*/ 13,
                /*SINOPSIS*/ "A regañadientes, un perfilador del FBI hace equipo con el ladrón de arte mas buscado del mundo para atrapar a"
                + "\nuna delincuente que siempre consigue ir un paso por delante.",
                /*CAST*/ elenco15,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 117,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 15, "src\\Imagenes\\Peliculas\\Alerta_roja.jpg", "src\\Peliculas\\Alerta_roja.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p15);



        //INSTANCIAMOS LA PELICULA "Paternidad" /*NUEVO*/
        String[] elenco16 = {"Kevin Hart", "Alfre Woodard", "Lil Rel Howery", "DeWanda Wise", 
             "Frankie Faison", "Anthony Carrigan","Paul Reiser"};

        Pelicula p16 = new Pelicula( /*TITULO*/"Paternidad",
                /*DIRECTOR*/ "Makoto Shinkai",
                /*GENERO*/ "DRAMA",
                /*AÑO DE ESTRENO*/ 2021,
                /*EDAD APTA*/ 18,
                /*SINOPSIS*/ "Un papá y viudo les hace frente a las dudas, los miedos, el dolor y los pañakes sucios al criar a su hija por"
                + "\nsu cuenta. Inspirada en una historia real.",
                /*CAST*/ elenco16,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 110,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 16, "src\\Imagenes\\Peliculas\\Paternidad.jpg", "src\\Peliculas\\Paternidad.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p16);



        //INSTANCIAMOS LA PELICULA "Paul" /*NUEVO*/
        String[] elenco17 = {"Simon Pegg", "Nick Frost", "Seth Rogen", "Jason Bateman",
             "Kristen Wiig", "Bill Hader", "Blythe Danner", "Joe Lo Truglio", "Dylan O'Brien"};

        Pelicula p17 = new Pelicula( /*TITULO*/"Paul",
                /*DIRECTOR*/ "Greg Mottola",
                /*GENERO*/ "COMEDIA",
                /*AÑO DE ESTRENO*/ 2011,
                /*EDAD APTA*/ 16,
                /*SINOPSIS*/ "Dos fanaticos de la ciencia ficción, en pos de descubrir que hay en el interior de la infame Área 51 en Nevada,"
                + "se topan con un extraterrestre que está huyendo.",
                /*CAST*/ elenco17,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 103,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 17, "src\\Imagenes\\Peliculas\\Paul.jpg", "src\\Peliculas\\Paul.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p17);



        //INSTANCIAMOS LA PELICULA "No manches Frida" /*NUEVO*/
        String[] elenco18 = {"Omar Chaparro", "Martha Higareda", "Monica Dionne", "Rocio Garcia",
             "Regina Pavon", "Mario Moran", "Fernando Castillo", "Pamela Moreno"};

        Pelicula p18 = new Pelicula( /*TITULO*/"No manches Frida",
                /*DIRECTOR*/ "Nacho G. Venilla",
                /*GENERO*/ "DRAMA",
                /*AÑO DE ESTRENO*/ 2016,
                /*EDAD APTA*/ 13,
                /*SINOPSIS*/ "Apenas sale de prisión, un exconvicto toma un trabajo como maestro sustituto en una escuela. La misma"
                + "/nescuela donde tiene escondido un gran botín",
                /*CAST*/ elenco18,
                /*ESTADO DE VISUALIZACION*/ false,
                /*DURACION*/ 114,
                /*MINUTOS REPRODUCIDOS*/ 0,
                /*CODIGO*/ 18, "src\\Imagenes\\Peliculas\\Frida.jpg", "src\\Peliculas\\Frida.mp4");

        Modelo.Multimedia.catalogoPeliculas.agregarPelicula(p18);


        for (Pelicula p : Multimedia.catalogoPeliculas.getPeliculas()) {
            Video v = p;
            try {
                Multimedia.catalogoVideos.agregarVideo(v);
            } catch (NullPointerException e) {
                break;
            }
        }
    }
}
