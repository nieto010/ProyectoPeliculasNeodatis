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

public class Borrar {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String nombre;
    private static ODB odb = null;
    private static String continuar;

    public static void borrarPelicula() {
        boolean seguir = true;

        while (seguir) {
            try {
                odb = ODBFactory.open("peliculas.neo");
                System.out.println("Introduce el nombre de la película: ");
                nombre = br.readLine();
                if (ComprobarDatos.comprobarNombrePelicula(nombre)) {
                    IQuery query = new CriteriaQuery(Pelicula.class, Where.equal("nombrePelicula", nombre));
                    Objects<Pelicula> g = odb.getObjects(query);

                    if (g.size() == 0) {
                        System.out.println("El nombre de la pelicula no existe");
                    } else {
                        while (g.hasNext()) {
                            Pelicula pelicula = g.next();
                            odb.delete(pelicula);
                            System.out.println("Pelicula borrada correctamente");
                        }
                    }
                } else {
                    System.out.println("El nombre de la pelicula no existe");
                    seguir = true;
                }

                System.out.println("¿Quieres seguir buscando peliculas?(Y/N): ");
                continuar = br.readLine();

                if (continuar.equalsIgnoreCase("Y")) {
                    seguir = true;
                } else {
                    seguir = false;
                }

            } catch (IndexOutOfBoundsException iobe) {
                System.out.println("Objeto no localizado");
                seguir = true;
            } catch (IOException ioe) {
                seguir = true;
            } finally {
                odb.close();
            }
        }
    }

    public static void borrarGenero() {

        boolean seguir = true;

        while (seguir) {
            try {
                odb = ODBFactory.open("peliculas.neo");
                System.out.println("Introduce el nombre del género: ");
                nombre = br.readLine();

                if (ComprobarDatos.comprobarNombreGenero(nombre)) {
                    IQuery query = new CriteriaQuery(Genero.class, Where.equal("nombre", nombre));
                    Objects<Genero> g = odb.getObjects(query);

                    if (g.size() == 0) {
                        System.out.println("El nombre de la pelicula no existe");
                    } else {
                        while (g.hasNext()) {
                            Genero genero = g.next();
                            odb.delete(genero);
                            System.out.println("Genero borrado correctamente");
                        }
                    }

                } else {
                    System.out.println("El genero no existe");
                }
                System.out.println("¿Quieres seguir buscando generos?(Y/N): ");
                continuar = br.readLine();

                if (continuar.equalsIgnoreCase("Y")) {
                    seguir = true;
                } else {
                    seguir = false;
                }
            } catch (IndexOutOfBoundsException iobe) {
                System.out.println("Objeto no localizado");
                seguir = true;
            } catch (IOException ioe) {
                seguir = true;
            } finally {
                odb.close();
            }
        }
    }
}