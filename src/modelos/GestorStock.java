package modelos;

public interface GestorStock<E extends Elemento> {
    boolean cargarElemento(E e);

    boolean reservarELemento(E e);

    boolean reservarMateriaPrima(E e, int cantidad);

    void agregarStock(E e);

    void agregarMateriaPrima(E e, int cantidad);

    boolean stockNecesario(E e);

    boolean existeELemento(E e);

    void mostrarStockTotal();

    void consultarEstadoStock();
}
