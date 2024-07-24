import java.util.HashSet;
import java.util.Set;

public class SubComponenteCompuesto extends Elemento {
    private Set<MateriaPrima> materiasprimas;

    public SubComponenteCompuesto(String nombre, int cantElementosConstruccion, int stock, boolean estado, Set<MateriaPrima> materiasprimas) {
        super(nombre, cantElementosConstruccion, stock, estado);
        this.materiasprimas = materiasprimas;
    }

    public static class Builder extends BuilderAbstract{
        private Set<MateriaPrima> materiasprimas;

        public Builder(){
            this.materiasprimas = new HashSet<>();
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setCantElementosConstruccion(int cantElementosConstruccion) {
            this.cantElementosConstruccion = cantElementosConstruccion;
            return this;
        }

        public Builder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder setEstado(boolean estado) {
            this.estado = estado;
            return this;
        }

        public Builder setMateriaPrima(MateriaPrima mp){
            this.materiasprimas.add(mp);
            return this;
        }
        @Override
        public SubComponenteCompuesto build() {
            return new SubComponenteCompuesto(nombre,cantElementosConstruccion,stock,estado,materiasprimas);
        }
    }

}
