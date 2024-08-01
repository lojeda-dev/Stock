package servicio;

import modelos.*;

public class Fabrica<E extends Elemento> {
    private Stock stock;
    private Mensaje mensaje;

    public Fabrica() {
        this.stock = new Stock();
        this.mensaje = new Mensaje();
    }

    public void cargar(E e) {
        if (e != null) {
            if (stock.cargarElemento(e)) {
                mensaje.cargaExistosa(e);
                stockTotal();
            } else
                mensaje.cargaFallida(e);
        } else
            mensaje.elementoNulo();
    }

    public void reservar(E pf, int opcion) {
        if (pf != null) {
            if (opcion == 1) {
                if (stock.reservarELemento(pf)) {
                    mensaje.reservaExistosa(pf);
                    stockTotal();
                    estadoStock();
                    pf.setEstado(false);
                } else {
                    fabricar(pf);
                }
            } else if (opcion == 2) {

            }
        } else
            mensaje.elementoNulo();
    }

    private void fabricar(E e) {
        if (e instanceof ProductoFinal) {
            mensaje.infoReserva(e);

            if (!(((ProductoFinal) e).getComponentes().isEmpty())) {
                for (Componente c : ((ProductoFinal) e).getComponentes()) {
                    if (stock.reservarELemento(c)) {
                        mensaje.reservaExistosa(c);
                    } else {
                        fabricar((E) c);
                        stock.reservarELemento(c);
                        mensaje.reservaExistosa(c);
                    }
                    stockTotal();
                    estadoStock();
                }
            } else
                mensaje.listaVacia("[COMPONENTES]");

            if (!((ProductoFinal) e).getComponenteCompuestos().isEmpty()) {
                for (ComponenteCompuesto cc : ((ProductoFinal) e).getComponenteCompuestos()) {
                    if (stock.reservarELemento(cc)) {
                        mensaje.reservaExistosa(cc);
                    } else {
                        fabricar((E) cc);
                    }
                    stockTotal();
                    estadoStock();
                }
            } else
                mensaje.listaVacia("[COMPONENTES COMPUESTOS]");

            validarFabricacion(e);

        } else if (e instanceof Componente) {
            stock.agregarStock(e);

        } else if (e instanceof ComponenteCompuesto) {
            mensaje.infoReserva(e);

            if (!((ComponenteCompuesto) e).getComponentes().isEmpty()) {
                for (Componente c : ((ComponenteCompuesto) e).getComponentes()) {
                    if (stock.reservarELemento(c)) {
                        mensaje.reservaExistosa(c);
                    } else {
                        fabricar((E) c);
                        stock.reservarELemento(c);
                        mensaje.reservaExistosa(c);
                    }
                    stockTotal();
                    estadoStock();
                }
            } else
                mensaje.listaVacia("[COMPONENTES]");

            if (!((ComponenteCompuesto) e).getSubComponenteCompuestos().isEmpty()) {
                for (SubComponenteCompuesto scc : ((ComponenteCompuesto) e).getSubComponenteCompuestos()) {
                    if (stock.reservarELemento(scc)) {
                        mensaje.reservaExistosa(scc);
                    } else {
                        fabricar((E) scc);
                        stock.reservarELemento(scc);
                        mensaje.reservaExistosa(scc);

                    }
                    stockTotal();
                    estadoStock();
                }
            } else
                mensaje.listaVacia("[SUB COMPONENTES COMPUESTOS]");

            validarFabricacion(e);

        } else if (e instanceof SubComponenteCompuesto) {
            mensaje.infoReserva(e);

            int cantidadScc = e.getCantElementosConstruccion();

            if (!((SubComponenteCompuesto) e).getMateriasprimas().isEmpty()) {
                for (MateriaPrima mp : ((SubComponenteCompuesto) e).getMateriasprimas()) {
                    if (stock.reservarMateriaPrima(mp, cantidadScc)) {
                        mensaje.reservaExistosa(mp);
                    } else {
                        comprarMateriaPrima(mp, cantidadScc);
                        stock.reservarMateriaPrima(mp, cantidadScc);
                    }
                    stockTotal();
                    estadoStock();
                }
            } else
                mensaje.listaVacia("[MATERIAS PRIMAS]");

            validarFabricacion(e);
        }
    }

    private void validarFabricacion(E e) {
        boolean condicion = false;
        int cantidad = 0;

        if (e instanceof SubComponenteCompuesto) {
            if (!((SubComponenteCompuesto) e).getMateriasprimas().isEmpty()) {
                for (MateriaPrima mp : ((SubComponenteCompuesto) e).getMateriasprimas()) {
                    if (verificarEstado((E) mp))
                        cantidad++;
                }

                if (cantidad == e.getCantElementosConstruccion()) {
                    condicion = true;
                }
            }
        } else if (e instanceof ComponenteCompuesto) {
            boolean comp = false;
            if (!((ComponenteCompuesto) e).getComponentes().isEmpty()) {
                comp = true;
                for (Componente c : ((ComponenteCompuesto) e).getComponentes()) {
                    if (verificarEstado((E) c))
                        cantidad++;
                }
            }

            boolean subcc = false;
            if (!((ComponenteCompuesto) e).getSubComponenteCompuestos().isEmpty()) {
                subcc = true;
                for (SubComponenteCompuesto scc : ((ComponenteCompuesto) e).getSubComponenteCompuestos()) {
                    if (verificarEstado((E) scc))
                        cantidad++;
                }
            }

            if (comp == true && subcc == true) {
                if (cantidad == ((ComponenteCompuesto) e).getComponentes().size() + ((ComponenteCompuesto) e).getSubComponenteCompuestos().size())
                    condicion = true;
            } else if (comp == true && subcc == false) {
                if (cantidad == ((ComponenteCompuesto) e).getComponentes().size())
                    condicion = true;
            } else if (comp == false && subcc == true) {
                if (cantidad == ((ComponenteCompuesto) e).getSubComponenteCompuestos().size())
                    condicion = true;
            }
        } else if (e instanceof ProductoFinal) {
            boolean comp = false;
            if (!((ProductoFinal) e).getComponentes().isEmpty()) {
                comp = true;
                for (Componente c : ((ProductoFinal) e).getComponentes()) {
                    if (verificarEstado((E) c))
                        cantidad++;
                }
            }

            boolean compuesto = false;
            if (!((ProductoFinal) e).getComponenteCompuestos().isEmpty()) {
                comp = true;
                for (ComponenteCompuesto cc : ((ProductoFinal) e).getComponenteCompuestos()) {
                    if (verificarEstado((E) cc))
                        cantidad++;
                }
            }

            if (comp == true && compuesto == true) {
                if (cantidad == ((ProductoFinal) e).getComponentes().size() + ((ProductoFinal) e).getComponenteCompuestos().size())
                    condicion = true;
            } else if (comp == true && compuesto == false) {
                if (cantidad == ((ProductoFinal) e).getComponentes().size())
                    condicion = true;
            } else if (comp == false && compuesto == true) {
                if (cantidad == ((ProductoFinal) e).getComponenteCompuestos().size())
                    condicion = true;
            }
        }

        if (condicion = true) {
            e.setStock(e.getCantElementosConstruccion());
            mensaje.fabricacionExitosa(e);
            stockTotal();
        } else
            mensaje.fabricacionFallida(e);
    }

    public void stockTotal() {
        stock.mostrarStockTotal();
    }

    public void estadoStock() {
        stock.consultarEstadoStock();
    }

    private boolean verificarEstado(E e) {
        if (e.isEstado() == true)
            return true;
        else
            return false;
    }

    private void comprarMateriaPrima(MateriaPrima mp, int cantidad) {
        stock.agregarMateriaPrima(mp, cantidad);
    }
}
