/*Un directorio telefónico posee una lista de Clientes de los que interesa conocer su nombre,
apellido, ciudad y dirección.
El directorio telefónico posee además las siguientes funcionalidades:
● agregarCliente() que permite registrar un nuevo cliente con su respectivo nro de
teléfono. Siendo el nro del teléfono la clave del mismo.
● buscarCliente() que en base al nro de teléfono retorna el Cliente asociado al
mismo.
● buscarTeléfono() que en base a un apellido nos devuelve una lista con los nros de
teléfono asociados a dicho apellido.
● buscarClientes() que en base a una ciudad nos devuelve una lista con los Clientes
asociados a dicha ciudad.
● borrarCliente() que en base a un dni elimina el cliente del directorio.
*/

package trabajopractico.n7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DirectorioTelefonico {
    private HashMap<String,Cliente> directorio = new HashMap<>();

    public HashMap<String, Cliente> getDirectorio() {
        return directorio;
    }

    public void setDirectorio(HashMap<String, Cliente> directorio) {
        this.directorio = directorio;
    }
    
    public void agregarCliente(Cliente cliente, String tel){
        if(directorio.containsKey(tel))
            System.out.println("El numero de telefono ingresado ya pertenece a otra persona.");
        else
            directorio.put(tel, cliente);
    }
    
    public Cliente buscarCliente(String tel){
        if(directorio.containsKey(tel))
            return (directorio.get(tel));
        else
            return null;   
    }
    
    public ArrayList<String> buscarTelefono(String apellido){
        ArrayList lista = new ArrayList();
        Iterator it = directorio.keySet().iterator();
        while(it.hasNext()){
            String aux = it.next().toString();
            if(directorio.get(aux).getApellido().equals(apellido)){
                lista.add(aux);
            }
        }
        return lista;
    }
    
    public ArrayList<Cliente> buscarClientes(String ciudad){
        ArrayList<Cliente> lista = new ArrayList();
        Iterator it = directorio.keySet().iterator();
        while(it.hasNext()){
            String aux = it.next().toString();
            if(directorio.get(aux).getCiudad().equals(ciudad)){
                lista.add(directorio.get(aux));
            }
        }
        return lista;
    }
    
    public void borrarCliente(String dni){
        Iterator it = directorio.keySet().iterator();
        String a_remover=null, valorRetorno;
        while(it.hasNext()){
            String aux = it.next().toString();
            if(directorio.get(aux).getDni().equals(dni)){
                a_remover = aux;
                System.out.println();
            }
        }
        if(a_remover == null)
            System.out.println("No se ha encontrado a nadie con ese documento.");
        else{
            valorRetorno = directorio.remove(a_remover).getNombre();
            System.out.println("Se ha removido a "+valorRetorno+" del directorio.");
        }
    }
    
    public void mostrarDirectorio(){
        Iterator it = directorio.keySet().iterator();
        while(it.hasNext()){
            String aux = it.next().toString();
            System.out.print("Nombre: "+directorio.get(aux).getNombre()+" - ");
            System.out.print("Apellido: "+directorio.get(aux).getApellido()+" - ");
            System.out.print("Ciudad: "+directorio.get(aux).getCiudad()+" - ");
            System.out.print("Direccion: "+directorio.get(aux).getDireccion()+" - ");
            System.out.println("Telefono: "+aux);
        }
    }
}
