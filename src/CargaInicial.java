import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CargaInicial {
    static NeodatisHelper neodatisHelper = new NeodatisHelper();

    public static void main(String[] args) {
        Genero drama = new Genero("Drama", "El drama es un genero que trata situaciones generalmente no epicas en un contexto serio");
        Genero misterio = new Genero("Misterio", "El misterio es un genero que trata de investigaciones de crimenes");
        Genero superheroes = new Genero("Superheroes", "Peliculas que se basan en personas que tienen superpoderes y necesitan salvar el mundo");
        Genero accion = new Genero("Accion", "Peliculas donde prima la espectacularidad de las imágenes por medio de efectos especiales de estilo clasico");
        Genero aventuras = new Genero("Aventuras", "Peliculas que refleja un mundo heroico de combates y aventuras, y en el que suele predominar la accion y valores caballerescos");
        Genero comedia = new Genero("Comedia", "Peliculas que refleja un mundo heroico de combates y aventuras, y en el que suele predominar la accion y valores caballerescos");
        Genero cienciaFiccion = new Genero("Ciencia Ficcion", "Peliculas con situaciones de humor que intenta provocar la risa de la audiencia. Es uno de los mas prolificos y populares generos cinematograficos");
        Genero suspense = new Genero("Suspense", "es un género cinematográfico amplio que evoca emoción y suspenso en la audiencia");
        Genero terror = new Genero("Terror", "Peliculas que se caracteriza por su voluntad de provocar en el espectador sensaciones de pavor, terror, miedo, disgusto, repugnancia, horror, incomodidad o preocupacion");
        Pelicula p1 = new Pelicula("El Padrino", 4.7, "Francis Ford Coppola", "El padrino es una pelicula estadounidense de 1972 dirigida por Francis Ford Coppola. La pelicula fue producida por Albert S. Ruddy, de la compania Paramount Pictures", 177, "20/10/1972", true, new ArrayList<>(List.of(drama)));
        Pelicula p2 = new Pelicula("El ciudadano Kane", 4.4, "Orson Welles", "Charles Foster Kane (Orson Welles) lo ha tenido todo en la vida: dinero, fama, prestigio y mujeres… pero en el momento de su muerte existen serias dudas de que este hombre fuera realmente feliz.", 119, "21/02/1966", true, new ArrayList<>(Arrays.asList(drama, misterio)));
        Pelicula p3 = new Pelicula("La lista de Schindler", 4.6, "Steven Spielberg", "El empresario aleman Oskar Schindler (Liam Neeson), un dandy oportunista con talento para las relaciones publicas, aprovecha esta situacion para prosperar económicamente. Comienza asi una interesada relacion con los militares nazis mas poderosos para poner en marcha una fabrica en Cracovia, cuya mano de obra seran operarios judios procedentes de los campos de concentracion", 195, "04/03/1994", true, new ArrayList<>(List.of(drama)));
        Pelicula p4 = new Pelicula("Boyhood", 4, "Richard Linklater", " 'Boyhood' nos cuenta la historia de Mason (Ellar Coltrane), comenzando la pelicula a los seis anios, y que a medida que transcurre la pelicula, y el tiempo, tanto dentro como fuera de pantalla, va creciendo hasta cumplir los dieciocho anios, momento en que entra en la universidad, y va entendiendo la relacion con sus padres divorciados, la vida, la adolescencia y todo lo que hay a su alrededor.", 165, "12/09/2014", true, new ArrayList<>(List.of(drama)));
        Pelicula p5 = new Pelicula("Lo que el viento se llevo", 4.4, "Victor Fleming", "Escarlata O'Hara es una hermosa jovencita que procede de una familia adinerada del sur de Estados Unidos que esta a favor de la esclavitud. Durante una fiesta, Escarlata conoce a un caballero del sur que se quedara prendado de su belleza de manera instantanea y no dejara de pretenderla", 238, "17/11/1950", true, new ArrayList<>(List.of(drama)));
        Pelicula p6 = new Pelicula("Perdicion", 4, "Billy Wilder", "Estamos en 1938 y Walter Neff es un experimentado viajante comercial de la compania aseguradora a todo riesgo Pacific. Phyllis no tarda en proponer a Walter matar a su marido para cobrar la indemnizacion del seguro de accidentes. Cuando el senior Dietrichson aparece muerto en las vias del tren, la policia acepta la hipotesis de un accidente.", 177, "06/03/1947", true, new ArrayList<>(Arrays.asList(drama, misterio)));
        Pelicula p7 = new Pelicula("Dejame salir", 4, "Jordan Peele", "Chris es un joven y exitoso fotografo afroamericano que, desde hace cinco meses, sale con Rose , una chica blanca. Aunque no esta del todo convencido, Chris termina cediendo a la invitacion de Rose de conocer a su familia. Pero Chris no tardara en descubrir secretos y mentiras, sobre todo en relacion con los dos misteriosos empleados afroamericanos que viven en la casona.", 104, "19/05/2017", true, new ArrayList<>(Arrays.asList(misterio, suspense, terror)));
        Pelicula p8 = new Pelicula("Vengadores: Endgame", 4.5, "Joe Russo", "Tras la derrota, las cosas no pintan bien para los Vengadores. Los Vengadores deberan reunirse una vez mas para deshacer sus acciones y restaurar el orden en el universo de una vez por todas", 181, "25/03/2019", false, new ArrayList<>(Arrays.asList(superheroes, accion, aventuras)));
        Pelicula p9 = new Pelicula("Spider-Man: Un nuevo universo", 4.4, "Bob Persichetti", "En esta ocasion conoceremos a Miles Morales, un joven que adquiere superpoderes tras ser picado por una arania y que, desde entonces, se dedica a llevar una doble vida en la que compagina su rutina de adolescente en el instituto con patrullar la ciudad y perseguir a villanos. Por suerte, para aprender los gajes del oficio, contara con un gran maestro: el mismisimo Peter Parker.", 117, "21/12/2018", false, new ArrayList<>(Arrays.asList(superheroes, accion, aventuras)));
        Pelicula p10 = new Pelicula("El caballero oscuro", 4.5, "Christopher Nolan", "Despues de derrotar a la Orden de las Sombras y frustrar al jefe de la mafia Carmine Falcone en 'Batman Begins', Bruce Wayne vuelve a enfundarse el traje del hombre murcielago para combatir el crimen en Gotham. Por suerte, la ciudad cuenta ahora con Harvey Dent, un nuevo Fiscal del Distrito caracterizado por su mano dura contra el crimen, lo que da un aire de esperanza a Gotham y permite que Bruce se centre en Rachel Dawes, el amor de su vida y la unica que conoce su verdadera identidad. Se trata de El Joker, un psicopata retorcido y sadico, con una morbosa fascinacion por todo lo que rodea al murcielago.", 152, "13/08/2008", false, new ArrayList<>(Arrays.asList(drama, superheroes, accion)));
        Pelicula p11 = new Pelicula("Indomable", 2.1, "Steven Soderbergh", "Mallory Kane es una guapa agente encubierta que trabaja de incognito para gobiernos de distintos estados que no quieren que su trabajo salga a la luz por resultar comprometedor. Es buena en su trabajo hasta que un dia, durante una mision en Dublin, es traicionada y fracasa en su mision. Esta sola, pero tiene la rabia y la inteligencia necesarias para seguir adelante haciendo caso a sus instintos y cargando contra todo lo que se le ponga por delante.", 93, "02/03/2012", true, new ArrayList<>(Arrays.asList(drama, accion, suspense)));
        Pelicula p12 = new Pelicula("King Kong", 3.7, "Peter Jackson", "La ambicion de Carl hara que decida secuestrar al simio para trasladarlo a Nueva York y exponerlo como si fuera una obra de arte para ganar dinero.", 180, "16/12/2005", false, new ArrayList<>(Arrays.asList(drama, accion, aventuras)));
        Pelicula p13 = new Pelicula("Naufrago", 4.3, "Robert Zemeckis", "En uno de esos viajes su vida dara un giro inesperado cuando el avion en el que viaja se estrella. El sobrevive, pero da a parar a una isla desierta en la que tendra que luchar por su supervivencia.", 143, "19/01/2001", true, new ArrayList<>(Arrays.asList(drama, aventuras)));
        Pelicula p14 = new Pelicula("Scary Movie", 3.6, "Keenen Ivory Wayans", "Una noche, Drew Becker recibe una llamada anonima de un maniaco. Su muerte sume a sus compañeros de instituto en una pesadilla, especialmente porque ahora tendran que enfrentarse a un asesino en serie que se oculta entre ellos.", 84, "31/10/2000", true, new ArrayList<>(List.of(comedia)));
        Pelicula p15 = new Pelicula("Solo en casa", 4.3, "Chris Columbus", "Sin embargo esta nueva libertad tiene un precio, pues rapidamente ha de aprender algunas lecciones basicas sobre responsabilidad, madurez e independencia.", 103, "21/12/1990", false, new ArrayList<>(List.of(comedia)));
        Pelicula p16 = new Pelicula("Mad Max: Furia en la carretera", 4.1, "George Miller", "Dos rebeldes que son capaces de restaurar el orden perdido, por un lado esta Max, que sigue buscando su propia paz tras la muerte de su mujer y su hijo; y por otro lado está Imperator Furiosa, una misteriosa mujer que trata de sobrevivir en este peligroso viaje hacia su hogar.", 120, "15/05/2015", true, new ArrayList<>(Arrays.asList(accion, aventuras, cienciaFiccion)));
        Pelicula p17 = new Pelicula("The Matrix", 4.3, "Lana Wachowski", "Su vida cambiara cuando una noche conozca a Trinity , una misteriosa joven que parece ser una leyenda en el mundo de los 'hackers' informaticos. Sera ella quien lleve a Neo ante su lider: Morfeo.", 135, "25/06/1999", true, new ArrayList<>(Arrays.asList(accion, cienciaFiccion)));
        Pelicula p18 = new Pelicula("Origen", 4.4, "Christopher Nolan", "Dom Cobb es el mejor extractor. No puede regresar a los Estados Unidos donde sus hijos le esperan.", 148, "14/08/2020", true, new ArrayList<>(Arrays.asList(accion, aventuras, cienciaFiccion)));
        Pelicula p19 = new Pelicula("Mystic River", 4.2, "Clint Eastwood", "Jimmy Markum , Dave Boyle y Sean Devine han crecido juntos en las calles de Boston. Todo hacia indicar que nada alteraria el curso de su amistad bajo ningun concepto, sobre todo teniendo en cuenta el compromiso y la dedicacion que el grupo pone continuamente para que las cosas sigan yendo tan bien como al principio.", 137, "24/10/2003", true, new ArrayList<>(Arrays.asList(drama, misterio)));
        Pelicula p20 = new Pelicula("Halloween", 3.9, "John Carpenter", "Han pasado quince años y Michael sigue interno, considerado un peligroso psicopata. Escrita y dirigida por el cineasta John Carpenter , la cinta esta protagonizada por los actores Jamie Lee Curtis , Donald Pleasence y Nancy Kyes", 177, "14/03/1979", true, new ArrayList<>(Arrays.asList(terror, suspense)));
        Pelicula p21 = new Pelicula("REC", 3.8, "Paco Plaza", "Hasta la llamada telefonica de una anciana que pide ayuda. Al llegar, los bomberos observan que los vecinos estan muy impacientes. Se oyen horribles gritos en el apartamento de la vieja mujer", 80, "23/11/2007", true, new ArrayList<>(Arrays.asList(terror, misterio, suspense)));
        Pelicula p22 = new Pelicula("El exorcista", 4.4, "William Friedkin", "En Iraq, el Padre Merrin queda profundamente turbado por el descubrimiento de una figurilla del demonio Pazuzu y las macabras visiones que esta provoca. Mientras tanto, en Washington, en la casa de la actriz Chris MacNeil se estan produciendo extranos fenomenos: la despiertan extranos sonidos que vienen del granero", 121, "01/09/1975", false, new ArrayList<>(List.of(terror)));

        neodatisHelper.abrirConexion();

        neodatisHelper.odb.store(p1);
        neodatisHelper.odb.store(p2);
        neodatisHelper.odb.store(p3);
        neodatisHelper.odb.store(p4);
        neodatisHelper.odb.store(p5);
        neodatisHelper.odb.store(p6);
        neodatisHelper.odb.store(p7);
        neodatisHelper.odb.store(p8);
        neodatisHelper.odb.store(p9);
        neodatisHelper.odb.store(p10);
        neodatisHelper.odb.store(p11);
        neodatisHelper.odb.store(p12);
        neodatisHelper.odb.store(p13);
        neodatisHelper.odb.store(p14);
        neodatisHelper.odb.store(p15);
        neodatisHelper.odb.store(p16);
        neodatisHelper.odb.store(p17);
        neodatisHelper.odb.store(p18);
        neodatisHelper.odb.store(p19);
        neodatisHelper.odb.store(p20);
        neodatisHelper.odb.store(p21);
        neodatisHelper.odb.store(p22);

        neodatisHelper.cerrarConexion();

    }
}