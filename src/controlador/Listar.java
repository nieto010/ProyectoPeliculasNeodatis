package controlador;

import modelo.Pelicula;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import java.util.ArrayList;

public class Listar {

    static ODB odb = null;

    public static void listarNombrePelicula() {
        odb = ODBFactory.open("peliculas.neo");
        IQuery query = new CriteriaQuery(Pelicula.class);
        Objects<Pelicula> peliculas = odb.getObjects(query);
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getNombrePelicula());
        }
        odb.close();
    }
    
    public static void listarNombreGenero() {
        odb = ODBFactory.open("peliculas.neo");
        IQuery query = new CriteriaQuery(Pelicula.class);
        Objects<Pelicula> peliculas = odb.getObjects(query);
        ArrayList<String> generos = new ArrayList<String>();
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula pelicula = peliculas.next();
            for (int j = 0; j < pelicula.getGeneros().size(); j++) {
                if (!generos.contains(pelicula.getGeneros().get(j).getNombre())){
                    generos.add(pelicula.getGeneros().get(j).getNombre());
                }
            }
        }
        for (String genero : generos) {
            System.out.println(genero);
        }
        odb.close();
    }
}
