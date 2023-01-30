package vista;


import com.sun.org.apache.xpath.internal.operations.Mod;
import controlador.*;

import java.io.IOException;
import java.util.InputMismatchException;

import static controlador.Borrar.br;

public class Principal {

	public static void main(String[] args) throws IOException {
		menu();
	}


	private static void menu() throws NumberFormatException, IOException { //Menu principal
		String opcion;
		int opcionValida = 100;
		do {
			System.out.println("-MENU PRINCIPAL-");
			System.out.println("1. Menu Usuario");
			System.out.println("2. Menu Administrador");
			System.out.println("0. Salir");
			try {
				System.out.println("Seleccione una opcion: ");
				opcion = br.readLine();
				if (ComprobarDatos.comprobarNumeroMenu(opcion)) { //Comprueba si el dato que ha introducido es un numero
					opcionValida = Integer.parseInt(opcion); //Si es un numero se convierte a integer
				} else {
					System.out.println("Introduzca un numero, por favor");
				}
			} catch (InputMismatchException ime) {
				opcionValida = 100;
			}
			switch (opcionValida) {
				case 1:
					//Menu de usuario para buscar peliculas
					menuUsuario();
					break;
				case 2:
					//Menu administrador con todos los metodos del CRUD.
					menuAdministrador();
					break;
				case 0:
					System.out.println("Fin del programa");
					System.out.println(" ");
					break;
				default:
					System.out.println("Introduzca un numero del 0 al 2");
					break;
			}
		} while (opcionValida != 0);

	}

	private static void menuAdministrador() throws NumberFormatException, IOException {
		String opcion;
		int opcionValida = 5;
		do {
			System.out.println("-MENU ADMINISTRADOR-");
			System.out.println("1. Menu del CRUD de peliculas");
			System.out.println("2. Menu del CRUD de genero");
			System.out.println("0. Salir");
			try {
				System.out.println("Seleccione una opcion: ");
				opcion = br.readLine();
				if (ComprobarDatos.comprobarNumeroMenu(opcion)) { //Comprueba si el dato que ha introducido es un numero
					opcionValida = Integer.parseInt(opcion); //Si es un numero se convierte a integer
				} else {
					System.out.println("Introduzca un numero, por favor");
				}
			} catch (InputMismatchException ime) {
				opcionValida = 100;
			}
			switch (opcionValida) {
				case 1:
					//Menu CRUD de las peliculas
					menuCRUDPelicula();
					break;
				case 2:
					//Menu CRUD de los generos
					menuCRUDGenero();
				case 0:
					System.out.println(" ");
					break;
				default:
					System.out.println("Introduzca un numero del 0 al 2");
					break;
			}
		} while (opcionValida != 0) ;
	}

	private static void menuCRUDPelicula() throws NumberFormatException, IOException {
		String opcion;
		int opcionValida = 100;
		do {
			System.out.println("-MENU PELICULAS (CRUD)-");
			System.out.println("1. Consultar peliculas");
			System.out.println("2. Agregar pelicula");
			System.out.println("3. Borrar pelicula");
			System.out.println("4. Modificar pelicula");
			System.out.println("0. Salir");
			try {
				System.out.println("Seleccione una opcion: ");
				opcion = br.readLine();
				if (ComprobarDatos.comprobarNumeroMenu(opcion)) { //Comprueba si el dato que ha introducido es un numero
					opcionValida = Integer.parseInt(opcion); //Si es un numero se convierte a integer
				} else {
					System.out.println("Introduzca un numero por favor");
				}
			} catch (InputMismatchException ime) {
				opcionValida = 100;
			}
			switch (opcionValida) {
				case 1:
					//Muestra las peliculas que se encuentran en la base de datos
					Listar.listarNombrePelicula();
					break;
				case 2:
					//Inserta una pelicula nueva
					Insertar.insertarPeliculas();
					break;
				case 3:
					//Borra una pelicula
					Borrar.borrarPelicula();
					break;
				case 4:
					//Modifica cualquier campo de la pelicula
					modificarPelicula();
					break;
				case 0:
					System.out.println(" ");
					break;
				default:
					System.out.println("Introduzca un numero del 0 al 4");
					break;
			}
		} while (opcionValida != 0);

	}

	private static void menuCRUDGenero() throws NumberFormatException, IOException {
		String opcion;
		int opcionValida = 100;
		do {
			System.out.println("-MENU GENEROS (CRUD)-");
			System.out.println("1. Consultar generos");
			System.out.println("2. Crear genero");
			System.out.println("3. Borrar genero");
			System.out.println("4. Modificar genero");
			System.out.println("0. Salir");
			try {
				System.out.println("Seleccione una opcion: ");
				opcion = br.readLine();
				if (ComprobarDatos.comprobarNumeroMenu(opcion)) { //Comprueba si el dato que ha introducido es un numero
					opcionValida = Integer.parseInt(opcion); //Si es un numero se convierte a integer
				} else {
					System.out.println("Introduzca un numero por favor");
				}
			} catch (InputMismatchException ime) {
				opcionValida = 100;
			}
			switch (opcionValida) {
				case 1:
					// Muestra todos los generos
					Listar.listarNombreGenero();
					break;
				case 2:
					//Inserta un nuevo genero
					Insertar.insertarGeneros();
					break;
				case 3:
					//Borra un genero
					Borrar.borrarGenero();
					break;
				case 4:
					//Modificar un genero
					modificarGenero();
					break;
				case 0:
					System.out.println(" ");
					break;
				default:
					System.out.println("Introduzca un numero del 0 al 4");
					break;
			}
		} while (opcionValida != 0);

	}

	private static void menuUsuario() throws NumberFormatException, IOException {
		int opcionValida = 0;
		String opcion;
		do {
			System.out.println("-MENU USUARIO-");
			System.out.println("1. Buscar pelicula por nombre");
			System.out.println("2. Buscar genero");
			System.out.println("0. Salir");
			try {
				System.out.println("Seleccione una opcion: ");
				opcion = br.readLine();
				if (ComprobarDatos.comprobarNumeroMenu(opcion)){//Comprueba si el dato que ha introducido es un numero
					opcionValida = Integer.parseInt(opcion); //Si es un numero se convierte a integer
				} else {
					System.out.println("Introduzca un numero por favor");
				}
			} catch (InputMismatchException ime) {
				opcionValida = 100;
			}
			switch (opcionValida) {
				case 1:
					//Busca una pelicula por nombre
					Buscar.buscarPelicula();
					break;
				case 2:
					//Busca un genero
					Buscar.buscarGenero();
					break;
				case 0:
					System.out.println(" ");
					break;
				default:
					System.out.println("Introduce un numero del 0 al 2");
					break;
			}
		} while (opcionValida != 0);
	}
	public static void modificarPelicula() {
		String nombrePeliculaModificar;
		Listar.listarNombrePelicula();
		try {
			System.out.println("Introduzca el nombre de la pelÃ­cula que desee modificar");
			System.out.println("Si desee salir introduzca SALIR");
			nombrePeliculaModificar = br.readLine();
			if (nombrePeliculaModificar.equalsIgnoreCase("salir")) { //Comprueba si el usuario introduce salir para salir del metodo
				System.out.println("SALIENDO...");
				System.out.println();
			} else {
				if (!Insertar.comprobarPeliculaExiste(nombrePeliculaModificar)) { //Comprueba si la pelicula existe
					System.err.println("El nombre de la pelicula no existe");
					modificarPelicula();
				} else {
					menuModificarPelicula(nombrePeliculaModificar);
				}
			}
		} catch (IOException ioe) {
			System.out.println("Error de E/S");
		}

	}

	private static void menuModificarPelicula(String nombrePelicula) throws NumberFormatException, IOException {
		String opcion = null;
		int opcionValida = 100;
		do {
			System.out.println("-MENU MODIFICAR PELICULA-");
			System.out.println("1. Modificar el nombre de la pelicula");
			System.out.println("2. Modificar la sipnosis de la pelicula");
			System.out.println("3. Modificar el director de la pelicula");
			System.out.println("4. Modificar la duracion de la pelicula");
			System.out.println("5. Modificar la valoracion de la pelicula");
			System.out.println("6. Modificar fecha de estreno de la pelicula");
			System.out.println("7. Modificar si la pelicula es para mayor de 18 anios");
			System.out.println("0. Salir");
			try {
				System.out.println("Seleccione una opcion: ");
				opcion = br.readLine();
				if (ComprobarDatos.comprobarNumeroMenu(opcion)) {
					opcionValida = Integer.parseInt(opcion);
				} else {
					System.out.println("Introduzca un numero, por favor");
				}
			} catch (InputMismatchException ime) {
				opcionValida = 100;
			}
			switch (opcionValida) {
				case 1:
					//Modifica el nombre de la pelicula
					Modificar.modificarNombrePelicula(nombrePelicula);
					break;
				case 2:
					//Modifica la sinopsis de la pelicula
					Modificar.modificarSipnosisPelicula(nombrePelicula);
					break;
				case 3:
					//Modifica el director de la pelicula
					Modificar.modificarDirectorPelicula(nombrePelicula);
					break;
				case 4:
					//Modifica la duracion de la pelicula
					Modificar.modificarDuracionPelicula(nombrePelicula);
					break;
				case 5:
					//Modifica la valoracion de la pelicula
					Modificar.modificarValoracionPelicula(nombrePelicula);
					break;
				case 6:
					//Modifica la fecha de estreno de la pelicula
					Modificar.modificarFechaEstrenoPelicula(nombrePelicula);
					break;
				case 7:
					//Modifica si la pelicula es para mayores de edad
					Modificar.modificarPublicoPelicula(nombrePelicula);
					break;
				case 0:
					System.out.println(" ");
					break;
				default:
					System.out.println("Introduzca un numero del 0 al 7");
					break;
			}
		} while (opcionValida != 0) ;
	}

	public static void modificarGenero() {
		String nombreGeneroModificar;
		try {
			System.out.println("Introduzca el nombre del gÃ©nero que desee modificar");
			System.out.println("Si desee salir introduzca SALIR");
			nombreGeneroModificar = br.readLine();
			if (nombreGeneroModificar.equalsIgnoreCase("salir")) { //Comprueba si el usuario introduce salir para salir del metodo
				System.out.println("SALIENDO...");
				System.out.println();
			} else {
				if (!Insertar.comprobarGeneroExiste(nombreGeneroModificar)) { //Comprueba si el genero existe
					System.err.println("El nombre del genero no existe");
					modificarGenero();
				} else {
					menuModificarGenero(nombreGeneroModificar);
				}
			}
		} catch (IOException ioe) {
			System.out.println();
		}
	}

	private static void menuModificarGenero(String nombreGenero) throws NumberFormatException, IOException {
		String opcion = null;
		int opcionValida = 100;
		do {
			System.out.println("-MENU MODIFICAR GENERO-");
			System.out.println("1. Modificar el nombre de el genero");
			System.out.println("2. Modificar la descripcion de el genero");
			System.out.println("0. Salir");
			try {
				System.out.println("Seleccione una opcion: ");
				opcion = br.readLine();
				if (ComprobarDatos.comprobarNumeroMenu(opcion)) {
					opcionValida = Integer.parseInt(opcion);
				} else {
					System.out.println("Introduzca un numero, por favor");
				}
			} catch (IOException e) {
				opcionValida = 100;
			}
			switch (opcionValida) {
				case 1:
					//Modifica el nombre del genero
					Modificar.modificarNombreGenero(nombreGenero);
					break;
				case 2:
					//Modifica la descripcion del genero
					Modificar.modificarDescripcion(nombreGenero);
					break;
				case 0:
					System.out.println();
					break;
				default:
					System.out.println("Introduzca un numero del 0 al 2");
					break;
			}
		} while (opcionValida != 0);

	}
}
