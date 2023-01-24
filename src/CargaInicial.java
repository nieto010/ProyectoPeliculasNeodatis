import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

import java.util.ArrayList;
import java.util.List;

public class CargaInicial {
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
        Pelicula p1 = new Pelicula("El Padrino", 4.7, "Francis Ford Coppola", "El padrino es una película estadounidense de 1972 dirigida por Francis Ford Coppola. La película fue producida por Albert S. Ruddy, de la compañía Paramount Pictures", 177, "20/10/1972", true, new ArrayList<Genero>(List.of(drama)));
        Pelicula p2 = new Pelicula("El ciudadano Kane", 4.4, "Orson Welles", "Charles Foster Kane (Orson Welles) lo ha tenido todo en la vida: dinero, fama, prestigio y mujeres… pero en el momento de su muerte existen serias dudas de que este hombre fuera realmente feliz.", 119, "21/02/1966", true, new ArrayList<Genero>(List.of(drama,misterio)));
        Pelicula p3 = new Pelicula("La lista de Schindler", 4.6, "Steven Spielberg", "El empresario alemán Oskar Schindler (Liam Neeson), un dandy oportunista con talento para las relaciones públicas, aprovecha esta situación para prosperar económicamente. Comienza así una interesada relación con los militares nazis más poderosos para poner en marcha una fábrica en Cracovia, cuya mano de obra serán operarios judíos procedentes de los campos de concentración", 195, "04/03/1994", true, new ArrayList<Genero>(List.of(drama)));
        Pelicula p4 = new Pelicula("Boyhood", 4, "Richard Linklater", " 'Boyhood' nos cuenta la historia de Mason (Ellar Coltrane), comenzando la película a los seis años, y que a medida que transcurre la película, y el tiempo, tanto dentro como fuera de pantalla, va creciendo hasta cumplir los dieciocho años, momento en que entra en la universidad, y va entendiendo la relación con sus padres divorciados, la vida, la adolescencia y todo lo que hay a su alrededor.", 165, "12/09/2014", true, new ArrayList<Genero>(List.of(drama)));
        Pelicula p5 = new Pelicula("Lo que el viento se llevo", 4.4, " Victor Fleming", "Escarlata O'Hara es una hermosa jovencita que procede de una familia adinerada del sur de Estados Unidos que está a favor de la esclavitud. Durante una fiesta, Escarlata conoce a un caballero del sur que se quedará prendado de su belleza de manera instantánea y no dejará de pretenderla" , 238, "17/11/1950", true, new ArrayList<Genero>(List.of(drama)));
        Pelicula p6 = new Pelicula("Perdicion", 4, "Billy Wilder", "Estamos en 1938 y Walter Neff es un experimentado viajante comercial de la compañía aseguradora a todo riesgo Pacific. Phyllis no tarda en proponer a Walter matar a su marido para cobrar la indemnización del seguro de accidentes. Cuando el señor Dietrichson aparece muerto en las vías del tren, la policía acepta la hipótesis de un accidente.", 177, "06/03/1947", true, new ArrayList<Genero>(List.of(drama,misterio)));
        Pelicula p7 = new Pelicula("Dejame salir", 4, "Jordan Peele", "Chris es un joven y exitoso fotógrafo afroamericano que, desde hace cinco meses, sale con Rose , una chica blanca. Aunque no está del todo convencido, Chris termina cediendo a la invitación de Rose de conocer a su familia. Pero Chris no tardará en descubrir secretos y mentiras, sobre todo en relación con los dos misteriosos empleados afroamericanos que viven en la casona.", 104, "19/05/2017", true, new ArrayList<Genero>(List.of(misterio,suspense,terror)));
        Pelicula p8 = new Pelicula("Vengadores: Endgame", 4.5, "Joe Russo", " Tras la derrota, las cosas no pintan bien para los Vengadores. Los Vengadores deberán reunirse una vez más para deshacer sus acciones y restaurar el orden en el universo de una vez por todas", 181, "25/03/2019", false, new ArrayList<Genero>(List.of(superheroes,accion,aventuras)));
        Pelicula p9 = new Pelicula("Spider-Man: Un nuevo universo", 4.4, "Bob Persichetti", "En esta ocasión conoceremos a Miles Morales, un joven que adquiere superpoderes tras ser picado por una araña y que, desde entonces, se dedica a llevar una doble vida en la que compagina su rutina de adolescente en el instituto con patrullar la ciudad y perseguir a villanos. Por suerte, para aprender los gajes del oficio, contará con un gran maestro: el mismísimo Peter Parker.", 117, "21/12/2018", false, new ArrayList<Genero>(List.of(superheroes,accion,aventuras)));
        Pelicula p10 = new Pelicula("El caballero oscuro", 4.5, "Christopher Nolan", "Después de derrotar a la Orden de las Sombras y frustrar al jefe de la mafia Carmine Falcone en 'Batman Begins', Bruce Wayne vuelve a enfundarse el traje del hombre murciélago para combatir el crimen en Gotham. Por suerte, la ciudad cuenta ahora con Harvey Dent, un nuevo Fiscal del Distrito caracterizado por su mano dura contra el crimen, lo que da un aire de esperanza a Gotham y permite que Bruce se centre en Rachel Dawes, el amor de su vida y la única que conoce su verdadera identidad. Se trata de El Joker, un psicópata retorcido y sádico, con una morbosa fascinación por todo lo que rodea al murciélago.", 152, "13/08/2008", false, new ArrayList<Genero>(List.of(drama,superheroes,accion)));
        Pelicula p11 = new Pelicula("Indomable", 2.1, "Steven Soderbergh", "Mallory Kane es una guapa agente encubierta que trabaja de incógnito para gobiernos de distintos estados que no quieren que su trabajo salga a la luz por resultar comprometedor. Es buena en su trabajo hasta que un día, durante una misión en Dublín, es traicionada y fracasa en su misión. Está sola, pero tiene la rabia y la inteligencia necesarias para seguir adelante haciendo caso a sus instintos y cargando contra todo lo que se le ponga por delante.", 93, "02/03/2012", true, new ArrayList<Genero>(List.of(drama,accion,suspense)));
        Pelicula p12 = new Pelicula("King Kong", 3.7, "Peter Jackson", "La ambición de Carl hará que decida secuestrar al simio para trasladarlo a Nueva York y exponerlo como si fuera una obra de arte para ganar dinero.\n", 180, "16/12/2005", false, new ArrayList<Genero>(List.of(drama,accion,aventuras)));
        Pelicula p13 = new Pelicula("Naufrago", 4.3, "Robert Zemeckis", "En uno de esos viajes su vida dará un giro inesperado cuando el avión en el que viaja se estrella. Él sobrevive, pero da a parar a una isla desierta en la que tendrá que luchar por su supervivencia.", 143, "19/01/2001", true, new ArrayList<Genero>(List.of(drama,aventuras)));
        Pelicula p14 = new Pelicula("Scary Movie", 3.6, "Keenen Ivory Wayans", "Una noche, Drew Becker recibe una llamada anónima de un maníaco. Su muerte sume a sus compañeros de instituto en una pesadilla, especialmente porque ahora tendrán que enfrentarse a un asesino en serie que se oculta entre ellos.", 84, "31/10/2000", true, new ArrayList<Genero>(List.of(comedia)));
        Pelicula p15 = new Pelicula("Solo en casa", 4.3, "Chris Columbus", "Sin embargo esta nueva libertad tiene un precio, pues rápidamente ha de aprender algunas lecciones básicas sobre responsabilidad, madurez e independencia.\n", 103, "21/12/1990", false, new ArrayList<Genero>(List.of(comedia)));
        Pelicula p16 = new Pelicula("Mad Max: Furia en la carretera", 4.1, "George Miller", "dos rebeldes que son capaces de restaurar el orden perdido, por un lado está Max, que sigue buscando su propia paz tras la muerte de su mujer y su hijo; y por otro lado está Imperator Furiosa, una misteriosa mujer que trata de sobrevivir en este peligroso viaje hacia su hogar.", 120, "15/05/2015", true, new ArrayList<Genero>(List.of(accion,aventuras,cienciaFiccion)));
        Pelicula p17 = new Pelicula("The Matrix", 4.3, "Lana Wachowski", "Su vida cambiará cuando una noche conozca a Trinity , una misteriosa joven que parece ser una leyenda en el mundo de los 'hackers' informáticos. Será ella quien lleve a Neo ante su líder: Morfeo.", 135, "25/06/1999", true, new ArrayList<Genero>(List.of(accion,cienciaFiccion)));
        Pelicula p18 = new Pelicula("Origen", 4.4, "Christopher Nolan", "Dom Cobb es el mejor extractor. No puede regresar a los Estados Unidos donde sus hijos le esperan.", 148, "14/08/2020", true, new ArrayList<Genero>(List.of(accion,aventuras,cienciaFiccion)));
        Pelicula p19 = new Pelicula("Mystic River", 4.2, "Clint Eastwood", "Jimmy Markum , Dave Boyle y Sean Devine han crecido juntos en las calles de Boston. Todo hacía indicar que nada alteraría el curso de su amistad bajo ningún concepto, sobre todo teniendo en cuenta el compromiso y la dedicación que el grupo pone continuamente para que las cosas sigan yendo tan bien como al principio.", 137, "24/10/2003", true, new ArrayList<Genero>(List.of(drama,misterio)));
        Pelicula p20 = new Pelicula("Halloween", 3.9, "John Carpenter", "Han pasado quince años y Michael sigue interno, considerado un peligroso psicópata. Escrita y dirigida por el cineasta John Carpenter , la cinta está protagonizada por los actores Jamie Lee Curtis , Donald Pleasence y Nancy Kyes", 177, "14/03/1979", true, new ArrayList<Genero>(List.of(terror,suspense)));
        Pelicula p21 = new Pelicula("REC", 3.8, "Paco Plaza", " Hasta la llamada telefónica de una anciana que pide ayuda. Al llegar, los bomberos observan que los vecinos están muy impacientes. Se oyen horribles gritos en el apartamento de la vieja mujer", 80, "23/11/2007", true, new ArrayList<Genero>(List.of(terror,misterio,suspense)));
        Pelicula p22 = new Pelicula("El exorcista", 4.4, "William Friedkin", "En Iraq, el Padre Merrin queda profundamente turbado por el descubrimiento de una figurilla del demonio Pazuzu y las macabras visiones que ésta provoca. Mientras tanto, en Washington, en la casa de la actriz Chris MacNeil se están produciendo extraños fenómenos: la despiertan extraños sonidos que vienen del granero", 121, "01/09/1975", false, new ArrayList<Genero>(List.of(terror)));

        ODB odb = ODBFactory.open("peliculas.neo");

        odb.store(p1);
        odb.store(p2);
        odb.store(p3);
        odb.store(p4);
        odb.store(p5);
        odb.store(p6);
        odb.store(p7);
        odb.store(p8);
        odb.store(p9);
        odb.store(p10);
        odb.store(p11);
        odb.store(p12);
        odb.store(p13);
        odb.store(p14);
        odb.store(p15);
        odb.store(p16);
        odb.store(p17);
        odb.store(p18);
        odb.store(p19);
        odb.store(p20);
        odb.store(p21);
        odb.store(p22);

    }
}