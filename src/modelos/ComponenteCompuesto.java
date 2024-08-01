package modelos;

import java.util.HashSet;
import java.util.Set;

public class ComponenteCompuesto extends Elemento {
    private Set<Componente> componentes;
    private Set<SubComponenteCompuesto> subComponenteCompuestos;

    public ComponenteCompuesto(String nombre, int cantElementosConstruccion, int stock, boolean estado, Set<Componente> componentes, Set<SubComponenteCompuesto> subComponenteCompuestos) {
        super(nombre, cantElementosConstruccion, stock, estado);
        this.componentes = componentes;
        this.subComponenteCompuestos = subComponenteCompuestos;
    }

    public Set<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(Componente c) {
        this.componentes.add(c);
    }

    public Set<SubComponenteCompuesto> getSubComponenteCompuestos() {
        return subComponenteCompuestos;
    }

    public void setSubComponenteCompuestos(Set<SubComponenteCompuesto> subComponenteCompuestos) {
        this.subComponenteCompuestos = subComponenteCompuestos;
    }

    public static class Builder extends BuilderAbstracto {

        private Set<Componente> componentes;
        private Set<SubComponenteCompuesto> subComponenteCompuestos;

        public Builder() {
            this.componentes = new HashSet<>();
            this.subComponenteCompuestos = new HashSet<>();
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

        public Builder setSubComponenteCompuesto(SubComponenteCompuesto scc) {
            this.subComponenteCompuestos.add(scc);
            return this;
        }

        @Override
        public ComponenteCompuesto build() {
            return new ComponenteCompuesto(nombre, cantElementosConstruccion, stock, estado, componentes, subComponenteCompuestos);
        }
    }
}
