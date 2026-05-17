
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

 public void cargar(){
     Paciente p = new Paciente();
     p.CargarDatos();
     registrar(p);
     
 }
 //busqueda para eliminacion por Dni
 public Paciente buscarPorDni(String dniB){
     Nodo<Paciente> n = lista.inicio();
    
    while (n != null) {
        Paciente p = n.getDato();
        
        // Al ser int, comparamos directo con == usando el getter
        if (p.getDni() == dniB) {
            return p; // Encontrado en la lista
        }
        n = n.getPs();
    }
    return null; // Si termina el ciclo y no lo encuentra
     
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

                if(p.equals(elem)){
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
 
    
    
 
}
