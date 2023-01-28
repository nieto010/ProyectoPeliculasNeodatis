package controlador;

import modelo.Pelicula;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Listar {

    static ODB odb = null;

    public static void listarNombrePelicula() {
        odb = ODBFactory.open("peliculas.neo");
        IQuery query = new CriteriaQuery(Pelicula.class);
        Objects<Pelicula> peliculas = odb.getObjects(query);
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getNombrePelicula());
        }
    }
    
    public static void listarNombreGenero() {
        odb = ODBFactory.open("peliculas.neo");
        IQuery query = new CriteriaQuery(Pelicula.class);
        Objects<Pelicula> peliculas = odb.getObjects(query);
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getGeneros().get(0).getNombre());
        }
    }
}
