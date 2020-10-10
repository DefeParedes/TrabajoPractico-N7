package trabajopractico.n7;

public class TrabajoPracticoN7 {

    public static void main(String[] args) {
        Cliente cl1 = new Cliente("Fede","Paredes","San Luis","500 Viviendas Sur","39024206");
        Cliente cl2 = new Cliente("Erika","Guzman","San Luis","500 Viviendas Sur","39990742");
        Cliente cl3 = new Cliente("Nicole","Paredes","San Luis","500 Viviendas Sur","57601960");
        Cliente cl4 = new Cliente("Mauri","Diaz","Chaco","En medio del desierto","00000001");
        DirectorioTelefonico dt1 = new DirectorioTelefonico();
        dt1.agregarCliente(cl1, "2664570080");
        dt1.agregarCliente(cl2, "2664508317");
        dt1.agregarCliente(cl3, "2664834565");
        if(dt1.buscarCliente("2664570080")!=null)
            System.out.println("El usuario es: "+dt1.buscarCliente("2664570080").getNombre());
        else
            System.out.println("El numero no pertenece a ningun usuario ingresado.");
        System.out.println(dt1.buscarTelefono("Paredes"));
        System.out.println(dt1.buscarClientes("San Luis"));
        dt1.borrarCliente("39024206");
        dt1.borrarCliente("35781298");
        System.out.println(dt1.buscarTelefono("Paredes"));
    }
    
}
