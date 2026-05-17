
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
        String matric = leerString("ingrese la matricula","Error intente nuevamente");
        setMatricula(matric);
    }
   
    
        
    private String leerString(String msj, String error) {
        String texto;
        
        do{
            Consola.emitirMensaje(msj);
            texto = Consola.leerString();
            
            if(!Validar.validarString(texto)){
                Consola.emitirMensajeLN(error);
            }
            
        }while(!Validar.validarString(texto));
        
        return texto;
    }
    
    private void verAgenda(){
        Nodo<Turno> p = agenda.inicio();
        while(p!=null){
            Turno t = p.getDato();
            
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
    return matricula == otro.getMatricula() || getDni() == otro.getDni();
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
        return "Medico " + "\n-matricula = " + matricula + "\n-agenda = " + agenda + "\nesp = " + esp;
    }
    
    
    
    
}
