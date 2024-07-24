import java.util.HashSet;
import java.util.Set;

public class Stock<E extends Elemento> implements GestorStock<E>{

    private Set<Elemento> elementos;

    public Stock() {
        this.elementos = new HashSet<>();
    }

    @Override
    public boolean cargar(Elemento e) {
        if (!existe(e)) {
            elementos.add(e);
            return true;
        } else
            return false;
    }

    @Override
    public boolean reservar(Elemento e) {
        if (!existe(e))
            return stockNecesario(e);
        else
            return false;
    }

    @Override
    public boolean stockNecesario(Elemento e) {
        if (e.getStock() >= e.getCantElementosConstruccion()) {
            int valor = e.getStock() - e.getCantElementosConstruccion();
            e.setStock(valor);
            e.setEstado(true);
            return true;
        } else
            return false;
    }

    @Override
    public boolean existe(Elemento e) {
        return elementos.contains(e);
    }

    @Override
    public void mostrar() {
        System.out.println("STOCK:");
        elementos.forEach(e -> System.out.println(e.getNombre() + ": " + e.getStock()));
    }

    @Override
    public void consultarEstado() {
        System.out.println("ESTADO DE RESERVA:");
        elementos.forEach(e -> System.out.println(e.getNombre() + ": " + e.isEstado()));
    }
}
