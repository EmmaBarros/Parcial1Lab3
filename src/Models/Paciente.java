
package Models;
import Validar.Validar;
import ED.Lista;
import ED.Nodo;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Paciente extends Persona{
    static int contId = 0;
    private int id;
    private int nroCel;
    private Lista<Turno> agenda;
    private String obraSoc;
    private int edad;

    public Paciente() {
        super();
        contId ++;
        this.id = contId;
    }

    
    
    public void mostrarDatos() {
        
    }
    
    //carga de datos
        @Override
   public void CargarDatos(){
      super.CargarDatos();
    }
    private void ingresarNroCel(){
     int nroCel;   
    }
    private void ingresarObraSoc(){
     String obS;
    }
    private void ingresarEdad(){
     int edad;
    }
    
    
    //se validara que el paciente no tenga mas de dos turnos
    public boolean validarTurno(){
     int cv = 0;
     Nodo<Turno> p = agenda.inicio();
     while(p != null){
         cv ++;
         p = p.getPs();
     }
     return cv < 2;
    }
//si cumple la validacion del turno se asignara en la lista de agendas
    public void asignarTurno(Turno t){
        if(validarTurno()){
            agenda.insertarPri(t);
            Consola.emitirMensajeLN("Turo asignado Correctamente ");
        }else{
            Consola.emitirMensajeLN("Asignacion Denegada ,el Pacioente ya tiene error");
        }
    }
    
}
