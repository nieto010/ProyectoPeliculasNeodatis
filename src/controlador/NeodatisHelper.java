package controlador;

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
}
