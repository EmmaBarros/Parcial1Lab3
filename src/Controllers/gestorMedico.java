
package Controllers;
import ED.*;
import Models.*;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class gestorMedico implements IGestionable<Medico>{
    Lista<Medico> lista;

    public gestorMedico() {
        this.lista = new Lista<>();
    }
 public void cargar(int tipo){
        Medico m = null;
        switch(tipo){
            case 1:
                m = new Clinico();
                break;
                
            case 2:
                m = new Pediatra();
                break;
                
            case 3:
                m = new Cardiologo();
                break;
            default:
                Consola.emitirMensajeLN("especialidad invalida");
                return;
        }
        
        m.cargarDatos();
        registrar(m);
    }
 
    public void consultarAgenda(){
        Consola.emitirMensajeLN("---Consultar Agenda de Medico---");
        Consola.emitirMensajeLN("ingrese la matricula del medico : ");
        String mat = Consola.leerString();
       //se bvusca y se muestra la agenda
        Medico encontrado = buscarPorMatricula(mat);
        
        if(encontrado != null){
            encontrado.verAgenda();
        }else{
            Consola.emitirMensajeLN("Error : no se encontro ningun medico con matricula"+mat);
        }
    }
    
        
    
    //Override
    @Override
    public void registrar(Medico nuevo) {
        Medico encontrado = buscar(nuevo);
        if(encontrado == null){
            lista.insertarPri(nuevo);
            Consola.emitirMensajeLN("medico registrado");
        }else{
            if(encontrado.getMatricula().equals(nuevo.getMatricula())){
                Consola.emitirMensajeLN("la matricula ya existe");
            }else{
                Consola.emitirMensajeLN("el dni ya pertenece a otro medico");
            }
        }
    }

    @Override
    public Medico buscar(Medico m) {
        Nodo<Medico> p = lista.inicio();
        while(p != null){
            //a continuacion se crea referencia para verificar la busuqeda de medicos
           
            if(p.getDato().esElMismo(m) ||
                    p.getDato().esElMismo(m)){
                return p.getDato();
            }
            p = p.getPs();
        }
     return null; 
    }

    
    @Override
    public void eliminar() {
      Consola.emitirMensajeLN("ingrese la matricula a eliminar : ");
      String mat = Consola.leerString();
      
      Medico encontrado = buscarPorMatricula(mat);
      if(encontrado != null){
          lista.eliminar(encontrado);
          Consola.emitirMensajeLN("Medico Eliminado de la lista");
      }else{
          Consola.emitirMensajeLN("no se encontro ningun medico con la matricula"+mat);
      }
    }

    @Override
    public void mostrarListado() {
        if(lista.listaVacia()){
            Consola.emitirMensajeLN("la lista de medicos esta vacia");
        }else{
            lista.visualizar();        
        }
    } 
    
    //busqueda
    public Medico buscarPorMatricula(String mat){
        Nodo<Medico> p = lista.inicio();
        while(p != null){
            if(p.getDato().getMatricula().equals(mat)){
                return p.getDato();
            }
            p = p.getPs();
        }
        return null;
    }
    
    
}
