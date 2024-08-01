package modelos;

public interface IBuilder<T> {
    T setNombre(String nombre);

    T setCantElementosConstruccion(int cantElementosConstruccion);

    T setStock(int stock);

    T setEstado(boolean estado);

    T build();
}