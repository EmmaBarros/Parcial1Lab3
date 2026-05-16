
package Models;
import ED.Lista;
import Consola.Consola;
/**
 *
 * @author emami
 */
public abstract class Medico extends Persona {
    private  int id;
    static int contId = 0;
    private int matricula;
    private Lista<Turno> agenda;
    private String esp;

    
  //-constr  
    public Medico() {
        super();
        contId ++;
        this.id = contId;
       
    }
  //abstrc
    public abstract void verEsp(); 

   //carga  
    public void cargarDatos(){
        super.CargarDatos();
    }
    
    public boolean esElMismo(Medico otro) {
    return matricula == otro.getMatricula() || getDni() == otro.getDni();
}
    
  

    
    //gtrs y strs
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public static int getContId() {
        return contId;
    }

    private static void setContId(int contId) {
        Medico.contId = contId;
    }

    public int getMatricula() {
        return matricula;
    }

    private void setMatricula(int matricula) {
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
        return "Medico " + "\n-id = " + id + "\n-matricula = " + matricula + "\n-agenda = " + agenda + "\nesp = " + esp;
    }
    
    
    
    
}
