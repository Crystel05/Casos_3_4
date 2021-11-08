package Model;

public class Product {

    String nombre;
    String descripcion;
    String imagen;
    double precioInicial;
    double precioFinal;

    public Product() {}

    public Product(String nombre, String descripcion, double precioInicial, double precioFinal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
    }
    public Product(String nombre, String descripcion, String image) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = image;
    }
    public Product(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Product(String nombre, String descripcion, String imagen, double precioInicial, double precioFinal) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(double precioInicial) {
        this.precioInicial = precioInicial;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
