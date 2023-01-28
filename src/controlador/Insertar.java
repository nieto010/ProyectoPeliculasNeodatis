package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

import modelo.Genero;
import modelo.Pelicula;

public class Insertar {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static boolean seguir = true;
	public static ComprobarDatos cd = new ComprobarDatos();
	public static NeodatisHelper nd = new NeodatisHelper();
	public static ODB odb = null;
	
	
	
	public static void insertarGeneros() {
		String nombre;
		String descripcion;
		//boolean seguir = true;

		while (seguir) {
			try {
				seguir = true;
				System.out.println("Introduce el nombre: ");
				nombre = br.readLine();
				comprobarNombre(nombre);
				if(comprobarGeneroExiste(nombre)==true) {
					System.out.println("El género ya existe");
					seguir = true;
				}else if(comprobarGeneroExiste(nombre)== false && seguir == false){
					System.out.println("Introduce la descripcion del género: ");
					descripcion = br.readLine();
					comprobarDescripcion(descripcion, nombre);
				}
				
				System.out.println("¿Quieres seguir insertando géneros?(Y/N): ");
				String respuesta = br.readLine();
				
				if(respuesta.equalsIgnoreCase("Y")) {
					seguir = true;
				}else {
					seguir = false;
				}

			} catch (IOException ioe) {

			}
		}
	}
	
	public static boolean comprobarNombre(String nombre) {
		
		if(ComprobarDatos.comprobarNombreGenero(nombre) == true) {
			seguir = false;
		}else {
			System.out.println("El nombre del genero es erróneo");
			seguir = true;
		}
		
		return seguir;
	}
	
	
	
	public static boolean comprobarDescripcion(String descripcion, String nombre) {
		
		if(ComprobarDatos.comprobarDescripcionGenero(descripcion)==true) {
			guardarGenero(nombre, descripcion);
			seguir = false;
		}else {
			System.out.println("La descripción es errónea");
			seguir = true;
		}
		
		return seguir;
	}
	
	public static void guardarGenero(String nombre, String descripcion) {
		odb = ODBFactory.open("peliculas.neo");
		Genero genero = new Genero(nombre, descripcion);
		odb.store(genero);
		odb.close();
		System.out.println("Genero insertado correctamente");
	}
	
	
	
	public static boolean comprobarGeneroExiste(String nombre) {
		
		boolean comprobar = true;
		
		try {
			//nd.abrirConexion();
			odb = ODBFactory.open("peliculas.neo");
			IQuery query = new CriteriaQuery(Genero.class, Where.equal("nombre", nombre));
			Objects<Genero> g =  odb.getObjects(query);
			
			if(g.size()==0) {
				comprobar = false;
			}else {
				comprobar = true;
			}
			
		}catch(IndexOutOfBoundsException iobe) {
			System.out.println("Objeto no localizado");
			comprobar = false;
		}finally {
			odb.close();
		}
		
		return comprobar;
		
	}
	
	//PELICULA
	
	public static void insertarPeliculas() {
		
		seguir = true;
		
		String nombrePelicula;
		double valoracion;
		String director;
		String sinopsis;
		int duracion;
		String fechaEstreno;
		int mayorEdad;
		boolean edad;
		ArrayList<Genero>generos = new ArrayList<Genero>();
		int contador = 0;
		String continuar;
		boolean seguirInsertando;
		
		while(seguir) {
			
			try {
				System.out.println("Introduce el nombre de la pelicula: ");
				nombrePelicula = br.readLine();
				if (comprobarPeliculaExiste(nombrePelicula) == false
						&& comprobarNombrePelicula(nombrePelicula) == false) {
					System.out.println("Introduce la valoración de la pelicula: ");
					valoracion = Double.parseDouble(br.readLine());
					if (comprobarValoracion(valoracion) == false) {
						System.out.println("Introduce el director: ");
						director = br.readLine();
						if(comprobarDirector(director)==false) {
							System.out.println("Introduce la sinopsis de la pelicula: ");
							sinopsis = br.readLine();
							if(comprobarSinopsis(sinopsis)==false) {
								System.out.println("Introduce la duración: ");
								duracion = Integer.parseInt(br.readLine());
								if(comprobarDuracion(duracion)==false){
									System.out.println("Introduce la fecha de estreno(xx/xx/xxxx): ");
									fechaEstreno = br.readLine();
									if(comprobarFechaEstreno(fechaEstreno)==false) {
										System.out.println("Introduce si es para mayores de edad o no(Y/N):");
										mayorEdad = Integer.parseInt(br.readLine());
										if(comprobarMayorEdad(mayorEdad)==false) {
											edad = comprobarMayorEdad(mayorEdad);
											boolean seguirGeneros = true;
											String nombreGenero = null;
											Genero g = null;
											
											while(seguirGeneros) {
												System.out.println("Introduce los géneros de la película: ");
												nombreGenero = br.readLine();
												
												if(comprobarGeneroExiste(nombreGenero)== true) {
													g = addGeneros(nombreGenero);
													generos.add(g);
													contador += 1;
												}else {
													System.out.println("El nombre del género no existe");
												}
												
												System.out.println("¿Quieres seguir insertando generos en la película?(Y/N): ");
												continuar = br.readLine();
												
												if(continuar.equalsIgnoreCase("Y")) {
													seguirGeneros = true;
												}else {
													seguirGeneros = false;
												}
											}
											
											if(contador==0) {
												System.out.println("Ningún género insertado");
												contador = 0;
											}else if(contador == 1){
												odb = ODBFactory.open("peliculas.neo");
												Pelicula pelicula = new Pelicula(nombrePelicula, valoracion, director, sinopsis, duracion, fechaEstreno,edad,generos);
												odb.store(pelicula);
												odb.close();
												contador = 0;
											}else if(contador >1) {
												odb = ODBFactory.open("peliculas.neo");
												Pelicula pelicula2 = new Pelicula(nombrePelicula, valoracion, director, sinopsis, duracion, fechaEstreno,edad,generos);
												odb.store(pelicula2);
												odb.close();
												contador = 0;
											}
											
										}else {
											System.out.println("Edad mal introducida");
										}
									}else {
										System.out.println("fecha mal introducida");
									}
									
								}else {
									System.out.println("Duracion tiene que tener dos digitos como mínimo");
								}
								
							}else {
								System.out.println("Sinopsis mal introducida");
							}
							
						}else {
							System.out.println("Nombre del director mal introducido");
						}
						
					} else {
						System.out.println("Nombre de la película mal introducido");
					}

				} else if (comprobarNombrePelicula(nombrePelicula) == true) {
					System.out.println("Nombre de la pelicula mal introducido");
				} else {
					System.out.println("El nombre de la película ya existe");
					seguir = true;
				}
				System.out.println("¿Quieres seguir insertando generos en la película?(Y/N): ");
				continuar = br.readLine();
				
				if(continuar.equalsIgnoreCase("Y")) {
					seguir = true;
				}else {
					seguir = false;
				}
			}catch(NumberFormatException ioe) {
				System.out.println("El dato introducido no es un numero");
				seguir = true;
			}catch(IOException ioe) {
				seguir = true;
			}
			
		}
		
	}
	
	public static Genero addGeneros(String nombre){
		Genero generoInsertar = null;
		try {
			//nd.abrirConexion();
			odb = ODBFactory.open("peliculas.neo");
			IQuery query = new CriteriaQuery(Genero.class, Where.equal("nombre", nombre));
			Objects<Genero> g =  odb.getObjects(query);
			
			while(g.hasNext()) {
				Genero generos = g.next();
				generoInsertar = new Genero(generos.getNombre(), generos.getDescripcion()); 
			}
		}catch(IndexOutOfBoundsException iobe) {
			System.out.println("Objeto no localizado");
		}finally {
			odb.close();
		}
		return generoInsertar;
	}
	
	public static boolean comprobarNombrePelicula(String nombre) {
		if(ComprobarDatos.comprobarNombrePelicula(nombre)==true) {
			seguir = false;
		}else {
			seguir = true;
		}
		
		return seguir;
	}
	
	public static boolean comprobarValoracion(double valoracion) {
		if(ComprobarDatos.comprobarValoracionPelicula(valoracion)==true) {
			seguir = false;
		}else {
			seguir = true;
		}
		
		return seguir;
	}
	
	public static boolean comprobarDirector(String director) {
		if(ComprobarDatos.comprobarDirectorPelicula(director)==true) {
			seguir = false;
		}else {
			seguir = true;
		}
		
		return seguir;
	}
	
	public static boolean comprobarSinopsis(String sinopsis) {
		if(ComprobarDatos.comprobarSinopsisPelicula(sinopsis)==true) {
			seguir = false;
		}else {
			seguir = true;
		}
		
		return seguir;
	}
	
	public static boolean comprobarDuracion(int duracion) {
		if(ComprobarDatos.comprobarDuracionPelicula(duracion)==true) {
			seguir = false;
		}else {
			seguir = true;
		}
		
		return seguir;
	}
	
	public static boolean comprobarFechaEstreno(String fechaEstreno) {
		if(ComprobarDatos.comprobarFechaPelicula(fechaEstreno)==true) {
			seguir = false;
		}else {
			seguir = true;
		}
		
		return seguir;
	}
	
	public static boolean comprobarMayorEdad(int mayorEdad) {
		seguir = true;
		
		try {
			mayorEdad = ComprobarDatos.comprobarMayorEdad(mayorEdad);
			seguir = false;
		}catch(NumberFormatException nfe) {
			seguir = true;
		}
		
		return seguir;
	}
	
	public static boolean comprobarPeliculaExiste(String pelicula) {
		boolean comprobar = true;
		
		try {
			//nd.abrirConexion();
			odb = ODBFactory.open("peliculas.neo");
			IQuery query = new CriteriaQuery(Pelicula.class, Where.equal("nombrePelicula", pelicula));
			Objects<Pelicula> g =  odb.getObjects(query);
			
			if(g.size()==0) {
				comprobar = false;
			}else {
				comprobar = true;
			}
			
		}catch(IndexOutOfBoundsException iobe) {
			System.out.println("Objeto no localizado");
			comprobar = false;
		}finally {
			odb.close();
		}
		
		return comprobar;
	}

}
