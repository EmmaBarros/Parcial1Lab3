
package Controllers;
import ED.*;
import Models.*;
import Consola.Consola;

/**
 *
 * @author emami
 */
public class gestorPaciente implements IGestionable<Paciente> {
 Lista<Paciente> lista;    

    public gestorPaciente() {
        this.lista = new Lista<>();
    }

    
    
    //carga y registro
 public void cargar(){
     Paciente p = new Paciente();
     p.CargarDatos();
     registrar(p);
     
     
     
 }
 
 
 //Override
    @Override
    public void registrar(Paciente elem) {
      if(buscar(elem)== null){
          lista.insertarPri(elem);
          Consola.emitirMensajeLN("Paciente cargado Correctamente");
      }else{
          Consola.emitirMensajeLN("el dni ya existe");
      }
    }

    @Override
    public Paciente buscar(Paciente elem) {
          Nodo <Paciente> n = lista.inicio();
            Paciente p;

            while(n != null){
                p = n.getDato();

                if(p.esElMismo(elem)){
                    return p;
                }

                n = n.getPs();
            }

            return null;
    }

    @Override
    public void eliminar() {
        Consola.emitirMensajeLN("ingrese el dni del paciente a eliminar");
        String dni = Consola.leerString();
        Paciente Encontrado = buscarPorDni(dni);
        if(Encontrado != null){
            lista.eliminar(Encontrado);
            Consola.emitirMensajeLN("el paciente con DNI"+dni+"fue eliminado");
        }else{
            Consola.emitirMensajeLN("no se encontro el paciente con el DNI"+dni);
        }
    }

    @Override
    public void mostrarListado() {
        if(lista.listaVacia()){
            Consola.emitirMensajeLN("la lista de pacientes se encuentra vacia");
        }else{
            lista.visualizar();
        }
    }
 
    
    //busqueda para eliminacion por Dni
 public Paciente buscarPorDni(String dniB){
     Nodo<Paciente> n = lista.inicio();
    
    while (n != null) {
        Paciente p = n.getDato();
        
        if (p.getDni().equals(dniB)) {
            return p; 
        }
        n = n.getPs();
    }
    return null; 
     
 }

    public Lista<Paciente> getLista() {
        return lista;
    }

    private void setLista(Lista<Paciente> lista) {
        this.lista = lista;
    }
 
 
 
 
}
