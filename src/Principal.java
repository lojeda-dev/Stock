import cliente.Empresa;
import modelos.*;

public class Principal {
    public static void main(String[] args) {

        Componente c = new Componente.Builder()
                .setNombre("VOLANTE")
                .setCantElementosConstruccion(1)
                .setEstado(false)
                .build();

        Componente c1 = new Componente.Builder()
                .setNombre("VIDRIO")
                .setCantElementosConstruccion(4)
                .setEstado(false)
                .build();

        MateriaPrima mp = new MateriaPrima.Builder()
                .setNombre("ALUMINIO")
                .setEstado(false)
                .setCantElementosConstruccion(2)
                .build();

        SubComponenteCompuesto scc = new SubComponenteCompuesto.Builder()
                .setNombre("CHAPA")
                .setCantElementosConstruccion(4)
                .setEstado(false)
                .setMateriaPrima(mp)
                .build();

        ComponenteCompuesto cc = new ComponenteCompuesto.Builder()
                .setNombre("PUERTA")
                .setCantElementosConstruccion(4)
                .setEstado(false)
                .setComponente(c1)
                .setSubComponenteCompuesto(scc)
                .build();

        ProductoFinal pf = new ProductoFinal.Builder()
                .setNombre("CHEVROLET")
                .setCantElementosConstruccion(2)
                .setEstado(false)
                .setComponente(c)
                .setComponenteCompuesto(cc)
                .build();


        Empresa.PrimerParte pp = new Empresa.PrimerParte<>();

        pp.cargar(pf);
        pp.cargar(cc);
        pp.cargar(scc);
        pp.cargar(mp);
        pp.cargar(c);
        
        pp.reservar(pf);

        System.out.println("FINAL");
        pp.mostrarStock();
        pp.estadoStock();
    }
}