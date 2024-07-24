public class Principal {
    public static void main(String[] args) {
        /*Componente componente = new Componente("A",2,1,false);
        MateriaPrima materiaPrima = new MateriaPrima("B",1,5,false);
        ProductoFinal productoFinal = new ProductoFinal("C",2,5,false);
        ComponenteCompuesto componenteCompuesto = new ComponenteCompuesto("D",1,1,false);
        componenteCompuesto.setComponentes(componente);*/

        Fabrica fabrica = new Fabrica();

        Componente c = new Componente.Builder()
                .setNombre("A")
                .setStock(1)
                .setCantElementosConstruccion(1)
                .setEstado(false)
                .build();

        MateriaPrima mp = new MateriaPrima.Builder()
                .setNombre("B")
                .setStock(1)
                .setEstado(false)
                .setCantElementosConstruccion(1)
                .build();

        fabrica.cargarElemento(c);
        fabrica.cargarElemento(c);
        fabrica.cargarElemento(mp);
        fabrica.consultarEstado();
        fabrica.mostrarStock();


        /*Fabrica fabrica = new Fabrica();
         *//*fabrica.cargarElemento(componente);
        fabrica.cargarElemento(materiaPrima);
        fabrica.cargarElemento(productoFinal);
        fabrica.cargarElemento(componente);
        fabrica.cargarElemento(componenteCompuesto);*//*
        fabrica.cargarElemento(componente);
        fabrica.cargarElemento(componente);
        fabrica.consultarEstado();
        fabrica.mostrarStock();*/
    }
}
