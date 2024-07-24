public interface GestorStock<E extends Elemento> {
    boolean cargar(E e);
    boolean reservar(E e);
    boolean stockNecesario(E e);
    boolean existe(E e);
    void mostrar();
    void consultarEstado();
}
