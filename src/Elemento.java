public abstract class Elemento {
    private String nombre;
    private int cantElementosConstruccion;
    private int stock;
    private boolean estado;

    public Elemento(String nombre, int cantElementosConstruccion, int stock, boolean estado) {
        this.nombre = nombre;
        this.cantElementosConstruccion = cantElementosConstruccion;
        this.stock = stock;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantElementosConstruccion() {
        return cantElementosConstruccion;
    }

    public void setCantElementosConstruccion(int cantElementosConstruccion) {
        this.cantElementosConstruccion = cantElementosConstruccion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
