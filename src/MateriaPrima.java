public class MateriaPrima extends Elemento {
    public MateriaPrima(String nombre, int cantElementosConstruccion, int stock, boolean estado) {
        super(nombre, cantElementosConstruccion, stock, estado);

    }

    public static class Builder extends BuilderAbstract {
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

        public MateriaPrima build() {
            return new MateriaPrima(nombre, cantElementosConstruccion, stock, estado);
        }
    }
}
