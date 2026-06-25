
package Models;
import ED.*;
import Consola.Consola;
import Validar.Validar;
/**
 *
 * @author emami
 */
public abstract class Medico extends Persona {
    protected String matricula;
    protected Lista<Turno> agenda;
    protected String esp;

    
  //-constr  
    public Medico(String especialidad) {
        super();
        this.matricula = "";
        this.esp = especialidad;
        this.agenda = new Lista<>();
        
        
    }
    
    
  //abstrc
    public abstract void verEsp(); 

   //carga  
    public void cargarDatos(){
        super.CargarDatos();
        leerMatr();
    }
   private void leerMatr(){
          String matric = Validar.leerString("ingrese la matricula","Error intente nuevamente");
        setMatricula(matric);
   }
    
    
    public void verAgenda(){
        Nodo<Turno> p = agenda.inicio();
        if(agenda.listaVacia()){
            Consola.emitirMensajeLN("el medico no tiene agendas acutalmente...");
        }
        while(p!=null){
            Turno t = p.getDato();
            Consola.emitirMensajeLN(t.toString());
            p= p.getPs();
        }
        
    }
 
 

    
    public boolean tieneTurno(Fecha buscada){
        Nodo<Turno> p = this.agenda.inicio();
        while(p != null){
            if(p.getDato().coincideTurno(buscada)){
                return true;//encuentra el turno superpuesto
            }
            p = p.getPs();
        }
        return false;
    }
    
    
    public boolean esElMismo(Medico otro) {
    return matricula.equals(otro.getMatricula())|| dni.equals(otro.getDni());
}
    

  
 
    
    //gtrs y strs
   

    public String getMatricula() {
        return matricula;
    }

    private void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Lista<Turno> getAgenda() {
        return agenda;
    }

    private void setAgenda(Lista<Turno> agenda) {
        this.agenda = agenda;
    }

    public String getEsp() {
        return esp;
    }

    private void setEsp(String esp) {
        this.esp = esp;
    }
    
//Override
    
    @Override
    public void mostrarDatos(){
        Consola.emitirMensajeLN(super.toString());
        Consola.emitirMensajeLN(toString());
    }
    
    @Override
    public String toString() {
        String textoAgenda = "";
        if(agenda.listaVacia()){
            textoAgenda  = "Sin Turnos";
        }else{
            textoAgenda = "Con turnos asignados";
        }
        return "\nMedico " + super.toString() + "\n-matricula = " + matricula + "\n-agenda = " + textoAgenda + "\nespecialidad = " + esp;
    }
    
    
    
    
}
