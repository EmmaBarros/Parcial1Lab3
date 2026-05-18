
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
    private DatoContacto contacto;
    private Lista<Turno> agenda;
    private String obraSoc;
    private int edad;

    public Paciente() {
        super();
        this.obraSoc = "";
        this.edad = 0;
        this.agenda = new Lista<Turno>();
    }
  
    //carga de datos
   @Override
   public void CargarDatos(){
      super.CargarDatos();
      leerObraSocial();
      leerEdad();
    }
   
   private void leerObraSocial(){
       String obraSoc;
       do{
           Consola.emitirMensajeLN("ingrese la obra social :");
           obraSoc = Consola.leerString();
           
           if(!Validar.validarString(obraSoc)){
               Consola.emitirMensajeLN("Error ingreso vacio  , intente nuevamente");
           }
       }while(!Validar.validarString(obraSoc));
       setObraSoc(obraSoc);
   }
   
   
   private void leerEdad(){
       int edad;
       do{
           Consola.emitirMensajeLN("ingrese la edad del paciente");
           edad = Consola.leerInt();
           if(!Validar.ValidarIntRang(edad, 0, 100)){
               Consola.emitirMensajeLN("Error : edad invalida , intente nuevamente..");
           }
       }while(!Validar.ValidarIntRang(edad, 0, 100));
       setEdad(edad);
   }
 
    
   
    public boolean esElMismo(Persona otro){
        return otro != null && this.dni.equals(otro.getDni());
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
    public boolean asignarTurno(Turno t){
        if(validarTurno()){
            agenda.insertarPri(t);
            Consola.emitirMensajeLN("Turo asignado Correctamente ");
            return true; // luego le avisa al gestor que salio bien
        }else{
            Consola.emitirMensajeLN("Asignacion Denegada ,el Pacioente ya tiene error");
            return false;//luego avisara al gestro que fallo
        }
    }

    @Override
    public void mostrarDatos() {
        Consola.emitirMensajeLN(super.toString());
        Consola.emitirMensajeLN("Obra Social"+obraSoc);
        Consola.emitirMensajeLN("---Historial Turnos---");
        Nodo<Turno> p = agenda.inicio();
        Turno t;
        while(p!=null){
            t = p.getDato();
            t.mostrarInfo();
            
            p = p.getPs();
        }
        Consola.emitirMensajeLN("");
        
    }

    //getters y setters 
    
    public DatoContacto getContacto() {
        return contacto;
    }

    private void setContacto(DatoContacto contacto) {
        this.contacto = contacto;
    }

    public Lista<Turno> getAgenda() {
        return agenda;
    }

    private void setAgenda(Lista<Turno> agenda) {
        this.agenda = agenda;
    }

    public String getObraSoc() {
        return obraSoc;
    }

    private void setObraSoc(String obraSoc) {
        this.obraSoc = obraSoc;
    }

    public int getEdad() {
        return edad;
    }

    private void setEdad(int edad) {
        this.edad = edad;
    }
    
    

}
