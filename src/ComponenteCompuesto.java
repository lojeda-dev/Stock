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
}
