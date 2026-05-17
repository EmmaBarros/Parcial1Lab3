
package Controllers;
import ED.*;
import Models.*;
import Consola.Consola;
/**
 *
 * @author pc
 */
public class gestorTurno implements IGestionable<Turno>{
    Lista<Turno> list;

    public gestorTurno() {
    this.list = new Lista<>();
    }

    
    
  //Override  
    @Override
    public void registrar(Turno elem) {
     //se extrae el medico , paciente y fecha del turno del parametro
     Medico m = elem.getMedico();
     Paciente p = elem.getPaciente();
     Fecha f = elem.getFecha();
     //se verifica si hay turno ocupado
     if(m.tieneTurno(f)){
         Consola.emitirMensajeLN("Error : el medico ya tiene turno asignado");
         return;
     }
   
     //se intenta asignar el turno , si no se puede se frena
     if(!p.asignarTurno(elem)){
         return;
     }
     
     //se lo guarda en la lista del gesstor
     list.insertarPri(elem);
     //se lo agrega a la agenda del 
     m.getAgenda().insertarPri(elem);
      
     
     Consola.emitirMensajeLN("Turno asignado con exito!");
     Consola.emitirMensajeLN("Codigo de turno "+elem.getCodT());
     
        
    }

    @Override
    public Turno buscar(Turno elem) {
        Nodo<Turno> p = list.inicio();
        while(p!=null){
            if(p.getDato().getCodT() == elem.getCodT()){
                return p.getDato();
            }
            p = p.getPs();
        }
        return null;
    }

    @Override
    public void eliminar() {
        Consola.emitirMensajeLN("-Cancelacion del turno-");
        Consola.emitirMensajeLN("ingrese el codigo del turno que desea eliminar");
        int cod = Consola.leerInt();
        
        //se busca el turno
        Turno encontrado = buscarPorCodT(cod);
       
        if(encontrado != null){
       //si lo encuentra lo valida si ya estaba cancelado
       if(!encontrado.getEstado()){
           Consola.emitirMensajeLN("el turno "+cod+"ya se encuetra cancelado");
           return;   
       }
       //se lo borra logicamente camiando el estado
       encontrado.cambiarEstado();
       Consola.emitirMensajeLN("el turno "+cod+"ha sido cancelado");
        }else{
            Consola.emitirMensajeLN("no se encontro ningun turno asinado");
        }
        
    }

    @Override
    public void mostrarListado() {
        if(list.listaVacia()){
            Consola.emitirMensajeLN("no hay turnos cargados actualmente");
            return;
        }
        Consola.emitirMensajeLN("---Historial de Turnos---");
        Nodo<Turno> p = list.inicio();
        int contAct = 0;//contador para ver si exite al menos un turno activo
        while(p!=null){
            Turno t = p.getDato();
            //se filtra
           if(t.getEstado()){
               Consola.emitirMensajeLN(t.toString());
               Consola.emitirMensajeLN("---------------");
               contAct ++;
           }
         p = p.getPs();
        }
        if(contAct == 0){
            Consola.emitirMensajeLN("no hay turnos actvos acutalmente para mostrar");
        }
    }
    
    
 //busqueda para la eliminacion
    
    private Turno buscarPorCodT(int codB){
        Nodo<Turno> p = list.inicio();
        while(p != null){
            if(p.getDato().getCodT() == codB){
                return p.getDato();
            }
            p = p.getPs();
        }
        return null;
    }
    
}
