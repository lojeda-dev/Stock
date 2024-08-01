package servicio;

import modelos.*;

import java.util.HashSet;
import java.util.Set;

public class Stock<E extends Elemento> implements GestorStock<E> {

    private Set<Elemento> elementos;
    private Mensaje mensaje;

    public Stock() {
        this.elementos = new HashSet<>();
        this.mensaje = new Mensaje();
    }

    @Override
    public boolean cargarElemento(E e) {
        if (!existeELemento(e)) {
            elementos.add(e);
            return true;
        } else
            return false;
    }

    @Override
    public boolean reservarELemento(E e) {
        if (existeELemento(e))
            return stockNecesario(e);
        else {
            mensaje.noExiste(e);
            return false;
        }
    }

    @Override
    public boolean reservarMateriaPrima(E e, int cantidad) {
        if (existeELemento(e))
            return stockMateriaPrima(e, cantidad);
        else {
            mensaje.noExiste(e);
            return false;
        }
    }

    @Override
    public boolean stockNecesario(E e) {
        if (e instanceof ProductoFinal) {
            if (e.getStock() > 0) {
                int valor = e.getStock() - 1;
                e.setStock(valor);
                e.setEstado(true);
                return true;
            } else {
                mensaje.sinStock(e);
                mostrarStockTotal();
                return false;
            }
        } else if (e instanceof Componente || e instanceof ComponenteCompuesto || e instanceof SubComponenteCompuesto) {
            if (e.getStock() >= e.getCantElementosConstruccion()) {
                int valor = e.getStock() - e.getCantElementosConstruccion();
                e.setStock(valor);
                e.setEstado(true);
                return true;
            } else {
                mensaje.sinStock(e);
                mostrarStockTotal();
                return false;
            }
        } else {
            System.out.println("SIN TIPO DE DATO (stockNecesario)");
            return false;
        }
    }

    public boolean stockMateriaPrima(E e, int cantidad) {
        int cantidadNecesaria = e.getCantElementosConstruccion() * cantidad;

        if (e.getStock() >= cantidadNecesaria) {
            int valor = e.getStock() - cantidadNecesaria;
            e.setStock(valor);
            e.setEstado(true);
            return true;
        } else {
            mensaje.sinStock(e);
            mostrarStockTotal();
            return false;
        }
    }

    @Override
    public boolean existeELemento(E e) {
        return elementos.contains(e);
    }

    @Override
    public void agregarStock(E e) {
        if (existeELemento(e)) {
            e.setStock(e.getCantElementosConstruccion());
        } else {
            e.setStock(e.getCantElementosConstruccion());
            elementos.add(e);
        }
        mensaje.fabricacionExitosa(e);
        mostrarStockTotal();
    }

    @Override
    public void agregarMateriaPrima(E e, int cantidad) {
        if (existeELemento(e)) {
            e.setStock(e.getCantElementosConstruccion() * cantidad);
        } else {
            e.setStock(e.getCantElementosConstruccion() * cantidad);
            elementos.add(e);
        }
        mensaje.fabricacionExitosa(e);
        mostrarStockTotal();
    }


    @Override
    public void mostrarStockTotal() {
        System.out.println("STOCK:");
        elementos.forEach(e -> System.out.println(e.getNombre() + " [" + e.getStock() + "]"));
        System.out.println();
    }

    @Override
    public void consultarEstadoStock() {
        System.out.println("ESTADO DE RESERVA:");
        elementos.forEach(e -> System.out.println(e.getNombre() + " [" + e.isEstado() + "]"));
        System.out.println();
    }
}
