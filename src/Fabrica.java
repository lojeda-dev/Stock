public class Fabrica<E extends Elemento> {
    private Stock stock;

    public Fabrica() {
        this.stock = new Stock();
    }

    public void cargarElemento(E e) {
        if (stock.cargar(e)) {
            System.out.println("Se cargo [" + e.getClass().getName() + " (" + e.getNombre() + ")] correctamente");
        } else
            System.out.println("[" + e.getClass().getName() + " (" + e.getNombre() + ")] ya existe dentro del stock");
    }

    public void reservar(ProductoFinal pf) {
        if (stock.reservar(pf)) {

        }
    }


    public void fabricar() {

    }

    public void mostrarStock() {
        stock.mostrar();
    }

    public void consultarEstado() {
        stock.consultarEstado();
    }
}
