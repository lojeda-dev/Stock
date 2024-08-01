package cliente;

import modelos.Elemento;
import modelos.ProductoFinal;
import servicio.Fabrica;

public class Empresa {
    public static class PrimerParte<E extends Elemento> {
        private Fabrica fabrica;

        public PrimerParte() {
            this.fabrica = new Fabrica();
        }

        public void reservar(ProductoFinal pf) {
            fabrica.reservar(pf, 1);
        }

        public void cargar(E e) {
            fabrica.cargar(e);
        }

        public void mostrarStock() {
            fabrica.stockTotal();
        }

        public void estadoStock() {
            fabrica.estadoStock();
        }

    }

    public static class SegundaParte {
        Fabrica fabrica;

        public SegundaParte() {
            this.fabrica = new Fabrica();
        }

    }
}