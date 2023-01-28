package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComprobarDatos {

	public static boolean comprobar = false;

	public static boolean comprobarNombreGenero(String nombre) {
		comprobar = false;
		Pattern p = Pattern.compile("^[A-Z][a-z]*");
		Matcher mat = p.matcher(nombre);

		if (mat.matches()) {
			comprobar = true;
		}

		return comprobar;
	}

	public static boolean comprobarDescripcionGenero(String descripcion) {
		comprobar = false;
		Pattern p = Pattern.compile("^[A-Z][A-Za-z0-9\\s]{5,}");
		Matcher mat = p.matcher(descripcion);

		if (mat.matches()) {
			comprobar = true;
		}

		return comprobar;
	}
	
	//comprobaciones de peliculas

	public static boolean comprobarNombrePelicula(String nombre) {
		comprobar = false;
		Pattern p = Pattern.compile("^[A-Z][A-Za-z0-9\\s]*");
		Matcher m = p.matcher(nombre);

		if (m.matches()) {
			comprobar = true;
		} else {
			comprobar = false;
		}

		return comprobar;
	}

	public static boolean comprobarValoracionPelicula(Double valoracion) {
		comprobar = false;
		if (valoracion > 5.0) {
			System.out.println("La valoración no puede ser mayor de 5");
			comprobar = false;
		} else if(valoracion >=0 && valoracion <= 5){
			comprobar = true;
		}else {
			System.out.println("La valoracion no puede ser menor que 0");
			comprobar = false;
		}

		return comprobar;
	}

	public static boolean comprobarDirectorPelicula(String nombreDirector) {
		comprobar = false;

		Pattern p = Pattern.compile("^[A-Z][A-Za-z\\s]*");
		Matcher m = p.matcher(nombreDirector);

		if (m.matches()) {
			comprobar = true;
		} else {
			comprobar = false;
		}

		return comprobar;
	}

	public static boolean comprobarSinopsisPelicula(String sinopsis) {
		comprobar = false;

		Pattern p = Pattern.compile("^[A-Z][a-z\\d\\s]{15,}");
		Matcher m = p.matcher(sinopsis);

		if (m.matches()) {
			comprobar = true;
		} else {
			comprobar = false;
		}

		return comprobar;
	}

	public static boolean comprobarDuracionPelicula(int duracion) {
		comprobar = false;
		
		if(duracion < 0) {
			comprobar = false;
		}else if(duracion > 0 && duracion < 10) {
			comprobar = false;
		}else if(duracion > 10) {
			comprobar = true;
		}
		return comprobar;
	}

	public static boolean comprobarFechaPelicula(String fecha) {
		comprobar = false;

		/* Check if date is 'null' */
		if (fecha.trim().equals("")) {
			comprobar = false;
		}
		/* Date is not 'null' */
		else {
			/*
			 * Set preferred date format, For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.
			 */
			SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
			sdfrmt.setLenient(false);
			/*
			 * Create Date object parse the string into date
			 */
			try {
				Date javaDate = sdfrmt.parse(fecha);
				comprobar = true;
			}
			/* Date format is invalid */
			catch (ParseException e) {
				comprobar = false;
			}
			/* Return true if date format is valid */
		}

		return comprobar;
	}

	public static int comprobarMayorEdad(int edad) {
		
		if(edad <= 0) {
			edad = 7;
		}else if(edad > 0 || edad < 18) {
			
		}else if(edad > 18) {
			edad = 18;
		}
		
		return edad;
	}

	public static boolean comprobarNumeroMenu(String opcionMenu) {
		return opcionMenu.matches("[0-9]");
	}

	public static boolean comprobarNumeroDouble(String numero){
		return numero.matches("[0-9].[0-9]") || numero.matches("[0-9]");
	}

	public static boolean comprobarBoolean(String booleano) {
		return booleano.equalsIgnoreCase("true") || booleano.equalsIgnoreCase("false");
	}

}
