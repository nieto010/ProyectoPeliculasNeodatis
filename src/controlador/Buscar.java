package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import modelo.Genero;
import modelo.Pelicula;

public class Buscar {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String nombre;
	private static ODB odb = null;
	private static String continuar;

	public static void buscarPelicula() {
		boolean seguir = true;
		String edad;


		while(seguir) {
			try {
				Listar.listarNombrePelicula();
				odb = ODBFactory.open("peliculas.neo");
				System.out.println("Introduce el nombre de la película: ");
				nombre = br.readLine();
				if(ComprobarDatos.comprobarNombrePelicula(nombre)== true) {

					IQuery query = new CriteriaQuery(Pelicula.class, Where.equal("nombrePelicula", nombre));
					Objects<Pelicula> g = odb.getObjects(query);

					if (g.size() == 0) {
						System.out.println("El nombre de la pelicula no existe");
					} else {
						while(g.hasNext()) {
							Pelicula pelicula= g.next();

							if(pelicula.isMayorDeEdad()== true) {
								edad = "Sí";
							}else {
								edad = "No";
							}
							System.out.println("\r\nNombre: " +pelicula.getNombrePelicula()+ "\r\nvaloracion: " +pelicula.getValoracion() +"\r\ndirector: " +pelicula.getDirector() + "\r\nsinopsis: " +pelicula.getSinopsis() +  "\r\nduracion: " + pelicula.getDuracion() + "\r\nfecha de estreno: "+ pelicula.getFechaEstreno()+  "\r\nmayor de edad: " +edad+ mostrarGeneros(pelicula.getGeneros()) );
						}
					}
				}else {
					System.out.println("El nombre de la pelicula no existe");
					seguir = true;
				}

				System.out.println("¿Quieres seguir buscando peliculas?(Y/N): ");
				continuar = br.readLine();

				if(continuar.equalsIgnoreCase("Y")) {
					seguir = true;
				}else {
					seguir = false;
				}

			} catch (IndexOutOfBoundsException iobe) {
				System.out.println("Objeto no localizado");
				seguir = true;
			}catch(IOException ioe) {
				seguir = true;
			}finally {
				odb.close();
			}
		}

	}

	private static String mostrarGeneros(ArrayList<Genero> generos) {

		String mostrar = "";

		for(int i=0; i<generos.size(); i++) {
			mostrar += "\r\nNombre del genero: " +generos.get(i).getNombre() + "\r\ndescripción: " +generos.get(i).getDescripcion();
		}

		return mostrar;
	}

	public static void buscarGenero() {

		boolean seguir = true;

		while(seguir) {
			try {
				Listar.listarNombreGenero();
				odb = ODBFactory.open("peliculas.neo");
				System.out.println("Introduce el nombre del género: ");
				nombre = br.readLine();

				if(ComprobarDatos.comprobarNombreGenero(nombre)== true) {
					IQuery query = new CriteriaQuery(Genero.class, Where.equal("nombre", nombre));
					Genero g = (Genero)odb.getObjects(query).getFirst();
					System.out.println("Nombre: " +g.getNombre()+ "\r\ndescripción:" +g.getDescripcion());

/*while(g.hasNext()) {
Genero genero= g.next();


}*/

				}else {
					System.out.println("El genero no existe");
				}
				System.out.println("¿Quieres seguir buscando generos?(Y/N): ");
				continuar = br.readLine();

				if(continuar.equalsIgnoreCase("Y")) {
					seguir = true;
				}else {
					seguir = false;
				}
			} catch (IndexOutOfBoundsException iobe) {
				System.out.println("Objeto no localizado");
				seguir = true;
			}catch(IOException ioe) {
				seguir = true;
			}finally {
				odb.close();
			}
		}

	}

}