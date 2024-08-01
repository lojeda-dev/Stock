package modelos;

public class Mensaje<E extends Elemento> {
    public void cargaExistosa(E e) {
        System.out.println("Se cargo [" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] correctamente.");
        System.out.println();
    }

    public void cargaFallida(E e) {
        System.out.println("[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] ya existe dentro del stock.");
        System.out.println();
    }

    public void noExiste(E e) {
        System.out.println("[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] no existe dentro del stock.");
        System.out.println();
    }

    public void sinStock(E e) {
        System.out.println("[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] stock insuficiente.");
        System.out.println();
    }

    public void infoReserva(E e) {
        System.out.println("Evaluaremos el stock de los elementos necesarios para la construccion de " + "[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")].");
        System.out.println();
    }

    public void reservaExistosa(E e) {
        System.out.println("[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] se reservo exitosamente.");
        System.out.println();
    }

    public void reservaFallida(E e) {
        System.out.println("[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] no se pudo reservar.");
        System.out.println();
    }

    public void infoFabricacion(E e) {
        System.out.println("Se fabricaron todos los elementos necesarios para " + "[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")].");
        System.out.println();
    }

    public void fabricacionExitosa(E e) {
        System.out.println("[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] se fabrico exitosamente.");
        System.out.println();
    }

    public void fabricacionFallida(E e) {
        System.out.println("[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] no se puede fabricar.");
        System.out.println();
    }

    public void elementoNulo() {
        System.out.println("ERROR! ELEMENTO NULO!");
        System.out.println();
    }

    public void listaVacia(String l) {
        System.out.println("Lista de " + l + " vacia.");
        System.out.println();
    }

    public void compraMateriaPrima(E e){
        System.out.println("[" + e.getClass().getSimpleName() + " (" + e.getNombre() + ")] se compro exitosamente.");
        System.out.println();
    }
}