public class Genero {
    private String nombre;
    private String descripcion;
    //private List<Pelicula> peliculas;

    public Genero(String nombre, String descripcion/*, ArrayList<Pelicula> peliculas*/) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        //this.peliculas = peliculas;
    }

    public Genero() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
