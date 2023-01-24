import java.time.LocalDate;
import java.util.ArrayList;

public class Pelicula {

    private String nombrePelicula;
    private double valoracion;
    private String director;
    private String sinopsis;
    private int duracion;
    private String fechaEstreno;
    private boolean mayorDeEdad;
    private ArrayList<Genero> generos;

    public Pelicula(String nombrePelicula, double valoracion, String director, String sinopsis, int duracion, String fechaEstreno, boolean mayorDeEdad, ArrayList<Genero> generos) {
        this.nombrePelicula = nombrePelicula;
        this.valoracion = valoracion;
        this.director = director;
        this.sinopsis = sinopsis;
        this.duracion = duracion;
        this.fechaEstreno = fechaEstreno;
        this.mayorDeEdad = mayorDeEdad;
        this.generos = generos;
    }

    public Pelicula() {
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public boolean isMayorDeEdad() {
        return mayorDeEdad;
    }

    public void setMayorDeEdad(boolean mayorDeEdad) {
        this.mayorDeEdad = mayorDeEdad;
    }

    public ArrayList<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(ArrayList<Genero> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Pelicula: " +
                "Nombre de la pelicula='" + nombrePelicula + '\'' +
                ", Valoracion=" + valoracion +
                ", Director='" + director + '\'' +
                ", Sinopsis='" + sinopsis + '\'' +
                ", Duracion=" + duracion +
                ", Fecha de Estreno=" + fechaEstreno +
                ", Mayor de Edad =" + mayorDeEdad +
                ", Generos =" + generos +
                '}';
    }
}
