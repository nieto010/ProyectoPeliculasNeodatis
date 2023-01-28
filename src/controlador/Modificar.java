package controlador;

import modelo.Genero;
import modelo.Pelicula;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static controlador.Insertar.comprobarNombre;
import static controlador.Insertar.guardarGenero;

public class Modificar {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean seguir = true;
    public static ComprobarDatos cd = new ComprobarDatos();
    public static NeodatisHelper nd = new NeodatisHelper();
    public static ODB odb = null;


    public static void modificarNombreGenero(String nombreGeneroModificar) { //Metodo para modificar el nombre del genero
        String nombreGenero = null;
        try {
            System.out.println("Introduzca el nombre que desee poner al genero");
            nombreGenero = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Error");
        }
        if (ComprobarDatos.comprobarNombreGenero(nombreGenero)) {
            odb = ODBFactory.open("peliculas.neo");
            IQuery query = new CriteriaQuery(Genero.class,Where.equal("nombre", nombreGeneroModificar));
            Objects<Genero> generos = odb.getObjects(query);
            if(generos.size()>0){
                Genero genero = generos.getFirst();
                genero.setNombre(nombreGenero);
                odb.store(genero);
            }
            odb.close();
        } else {
            System.out.println("Nombre no valido para el genero");
        }

    }

    public static void modificarDescripcion(String nombreGeneroModificar) { //Metodo para modificar la descripcion del genero
        String descripcionGenero = null;
        try {
            System.out.println("Introduzca la descripcion que desee poner al genero");
            descripcionGenero = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Error");
        }
        if (ComprobarDatos.comprobarDescripcionGenero(descripcionGenero)) {
            odb = ODBFactory.open("peliculas.neo");
            IQuery query = new CriteriaQuery(Genero.class,Where.equal("nombre", nombreGeneroModificar));
            Objects<Genero> generos = odb.getObjects(query);
            if(generos.size()>0){
                Genero genero = generos.getFirst();
                genero.setDescripcion(descripcionGenero);
                odb.store(genero);
            }
            odb.close();
        } else {
            System.out.println("Descripcion no valida para el genero");
        }
    }

    //Peliculas
    public static void modificarNombrePelicula(String nombrePeliculaModificar) { //Metodo para modificar el nombre de la pelicula
        String nombrePelicula = null;
        try {
            System.out.println("Introduzca el nombre que desee poner a la pelicula");
            nombrePelicula = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Error");
        }
        if (ComprobarDatos.comprobarNombrePelicula(nombrePelicula)) {
            odb = ODBFactory.open("peliculas.neo");
            IQuery query = new CriteriaQuery(Pelicula.class,Where.equal("nombrePelicula", nombrePeliculaModificar));
            Objects<Pelicula> peliculas = odb.getObjects(query);
            if(peliculas.size()>0){
                Pelicula pelicula = peliculas.getFirst();
                pelicula.setNombrePelicula(nombrePelicula);
                odb.store(pelicula);
            }
            odb.close();
        } else {
            System.out.println("Introduzca un nombre de pelicula correcto");
        }
    }

    public static void modificarDirectorPelicula(String nombrePeliculaModificar) { //Metodo para modificar el director de la pelicula
        String nombreDirector = null;
        try {
            System.out.println("Introduzca el nombre del director que realizo la pelicula");
            nombreDirector = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Error");
        }
        if (ComprobarDatos.comprobarDirectorPelicula(nombreDirector)) {
            odb = ODBFactory.open("peliculas.neo");
            IQuery query = new CriteriaQuery(Pelicula.class,Where.equal("nombrePelicula", nombrePeliculaModificar));
            Objects<Pelicula> peliculas = odb.getObjects(query);
            if(peliculas.size()>0){
                Pelicula pelicula = peliculas.getFirst();
                pelicula.setDirector(nombreDirector);
                odb.store(pelicula);
            }
            odb.close();
        } else {
            System.out.println("Nombre de director no valido");
        }
    }

    public static void modificarSipnosisPelicula(String nombrePeliculaModificar) { //Metodo para modificar la sinopsis de la pelicula
        String sipnosis = null;
        try {
            System.out.println("Introduzca la sipnosis de la pelicula");
            sipnosis = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Error");
        }
        odb = ODBFactory.open("peliculas.neo");
        IQuery query = new CriteriaQuery(Pelicula.class, Where.equal("nombrePelicula", nombrePeliculaModificar));
        Objects<Pelicula> peliculas = odb.getObjects(query);
        if (peliculas.size() > 0) {
            Pelicula pelicula = peliculas.getFirst();
            pelicula.setSinopsis(sipnosis);
            odb.store(pelicula);
        }
        odb.close();
    }

    public static void modificarDuracionPelicula(String nombrePeliculaModificar) { //Metodo para modificar la duracion de la pelicula
        String duracion = null;
        int duracionValida = 0;
        try {
            System.out.println("Introduzca la duracion de la pelicula");
            duracion = br.readLine();
            if (ComprobarDatos.comprobarNumeroMenu(duracion)) {
                duracionValida = Integer.parseInt(duracion);
            }
        } catch (IOException ioe) {
            System.out.println("Error");
        }
        if (ComprobarDatos.comprobarDuracionPelicula(duracionValida)) {
            odb = ODBFactory.open("peliculas.neo");
            IQuery query = new CriteriaQuery(Pelicula.class, Where.equal("nombrePelicula", nombrePeliculaModificar));
            Objects<Pelicula> peliculas = odb.getObjects(query);
            if (peliculas.size() > 0) {
                Pelicula pelicula = peliculas.getFirst();
                pelicula.setDuracion(duracionValida);
                odb.store(pelicula);
            }
            odb.close();
        } else {
            System.out.println("La duracion no es valida");
        }
    }

    public static void modificarValoracionPelicula(String nombrePeliculaModificar) { //Metodo para modificar la valoracion de la pelicula
        double valoracionValida = 0;
        String valoracion;
        try {
            System.out.println("Introduzca la valoracion de la pelicula");
            valoracion = br.readLine();
            if (ComprobarDatos.comprobarNumeroDouble(valoracion)) {
                valoracionValida = Double.parseDouble(valoracion);
            }
        } catch (IOException ioe) {
            System.out.println("Error");
        }
        if (ComprobarDatos.comprobarValoracionPelicula(valoracionValida)) {
            odb = ODBFactory.open("peliculas.neo");
            IQuery query = new CriteriaQuery(Pelicula.class, Where.equal("nombrePelicula", nombrePeliculaModificar));
            Objects<Pelicula> peliculas = odb.getObjects(query);
            if (peliculas.size() > 0) {
                Pelicula pelicula = peliculas.getFirst();
                pelicula.setValoracion(valoracionValida);
                odb.store(pelicula);
            }
            odb.close();
        } else {
            System.out.println("La valoracion no es valida");
        }

    }

    public static void modificarFechaEstrenoPelicula(String nombrePeliculaModificar) { // Metodo para modificar la fecha de estreno de la pelicula
        String fechaPelicula = null;
        try {
            System.out.println("Introduzca la fecha de la pelicula (dd/mm/yyyy)");
            fechaPelicula = br.readLine();
        } catch (IOException ioe) {
            System.out.println("Error");
        }
        if (ComprobarDatos.comprobarFechaPelicula(fechaPelicula)) {
            odb = ODBFactory.open("peliculas.neo");
            IQuery query = new CriteriaQuery(Pelicula.class, Where.equal("nombrePelicula", nombrePeliculaModificar));
            Objects<Pelicula> peliculas = odb.getObjects(query);
            if (peliculas.size() > 0) {
                Pelicula pelicula = peliculas.getFirst();
                pelicula.setFechaEstreno(fechaPelicula);
                odb.store(pelicula);
            }
            odb.close();
        } else {
            System.out.println("Formato de fecha no valido");
        }
    }

    public static void modificarPublicoPelicula(String nombrePeliculaModificar) { //Metodo para modificar si la pelicula es para mayor de edad
        boolean mayorDeEdadValido = false;
        String mayorDeEdad;
        try {
            System.out.println("Introduzca si la pelicula es mayor de 18 anio (True o False)");
            mayorDeEdad = br.readLine();
            if (ComprobarDatos.comprobarBoolean(mayorDeEdad)) {
                mayorDeEdadValido = Boolean.parseBoolean(mayorDeEdad);
                odb = ODBFactory.open("peliculas.neo");
                IQuery query = new CriteriaQuery(Pelicula.class, Where.equal("nombrePelicula", nombrePeliculaModificar));
                Objects<Pelicula> peliculas = odb.getObjects(query);
                if (peliculas.size() > 0) {
                    Pelicula pelicula = peliculas.getFirst();
                    pelicula.setMayorDeEdad(mayorDeEdadValido);
                    odb.store(pelicula);
                }
                odb.close();
            } else {
                System.err.println("Introduce true o false");
            }

        } catch (IOException ioe) {
            System.out.println("Error");
        }

    }


}
