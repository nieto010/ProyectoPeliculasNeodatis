import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class NeodatisHelper {
    ODB odb;
    public void abrirConexion() {
        odb = ODBFactory.open("peliculas.neo");
    }

    public void cerrarConexion() {
        if (odb != null) {
            odb.close();
        }
    }

    public void insertarPelicula() {

    }

    public void modificarPelicula() {

    }

    public void borrarPelicula() {

    }

    public void buscarPelicula() {

    }

    public void insertarGenero() {

    }

    public void modificarGenero() {

    }

    public void borrarGenero() {

    }

    public void buscarGenero() {

    }


}
