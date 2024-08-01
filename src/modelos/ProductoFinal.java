package modelos;

import java.util.HashSet;
import java.util.Set;

public class ProductoFinal extends Elemento {
    private Set<Componente> componentes;
    private Set<ComponenteCompuesto> componenteCompuestos;

    public ProductoFinal(String nombre, int cantElementosConstruccion, int stock, boolean estado, Set<Componente> componentes, Set<ComponenteCompuesto> componenteCompuestos) {
        super(nombre, cantElementosConstruccion, stock, estado);
        this.componentes = componentes;
        this.componenteCompuestos = componenteCompuestos;
    }

    public Set<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(Set<Componente> componentes) {
        this.componentes = componentes;
    }

    public Set<ComponenteCompuesto> getComponenteCompuestos() {
        return componenteCompuestos;
    }

    public void setComponenteCompuestos(Set<ComponenteCompuesto> componenteCompuestos) {
        this.componenteCompuestos = componenteCompuestos;
    }

    public static class Builder extends BuilderAbstracto {

        private Set<Componente> componentes;
        private Set<ComponenteCompuesto> componenteCompuestos;

        public Builder() {
            this.componentes = new HashSet<>();
            this.componenteCompuestos = new HashSet<>();
        }

        @Override
        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        @Override
        public Builder setCantElementosConstruccion(int cantElementosConstruccion) {
            this.cantElementosConstruccion = cantElementosConstruccion;
            return this;
        }

        @Override
        public Builder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        @Override
        public Builder setEstado(boolean estado) {
            this.estado = estado;
            return this;
        }

        public Builder setComponente(Componente c) {
            this.componentes.add(c);
            return this;
        }

        public Builder setComponenteCompuesto(ComponenteCompuesto cc) {
            this.componenteCompuestos.add(cc);
            return this;
        }

        @Override
        public ProductoFinal build() {
            return new ProductoFinal(nombre, cantElementosConstruccion, stock, estado, componentes, componenteCompuestos);
        }
    }
}