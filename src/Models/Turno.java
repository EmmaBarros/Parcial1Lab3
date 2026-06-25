
package Models;
import Consola.Consola;

/**
 *
 * @author emami
 */
public class Turno {
    private static int contId = 0;
    private int codT;
    private Paciente paciente;
    private Medico medico;
    private boolean estado;
    private Fecha fecha;

    public Turno() {
        contId ++;
         this.codT = contId;
        this.fecha = new Fecha();
        this.medico = null;
        this.paciente = null;

    }
    //carga
    public void cargarDatos(Paciente p,Medico m){
        this.medico = m;
        this.paciente = p;
        
        Consola.emitirMensajeLN("ingrese la fecha y Hora del Turno");
        this.fecha.cargarFecha();
        
        this.estado = true;
        
    }
    
    public void mostrarInfo(){
        Consola.emitirMensajeLN("Codigo :"+codT);
        medico.mostrarDatos();
        paciente.mostrarDatos();
        Consola.emitirMensajeLN("Fecha :"+fecha.StringFecha()+"\tHora : "+fecha.stringHora());
        Consola.emitirMensajeLN("Estado :"+stringEstado());
    }
    
    public boolean coincideTurno(Fecha otraFecha){
        if(!this.estado){//si el estado esta ocupado no lo cuenta
            return false;
        }
        return this.fecha.esIgualA(otraFecha);
    }
    
    public void cambiarEstado(){
       estado = !estado;
               
    }

    private String stringEstado(){
        if(estado){
            return "Activo";
        }else{
            return "Cancelado";
        }
    }
    
    
    
    //gtt y stt
    public static int getContId() {
        return contId;
    }

    private static void setContId(int contId) {
        Turno.contId = contId;
    }

    public int getCodT() {
        return codT;
    }

    private void setCodT(int codT) {
        this.codT = codT;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    private void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    private void setMedico(Medico medico) {
        this.medico = medico;
    }

    public boolean getEstado() {
        return estado;
    }

    private void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Fecha getFecha() {
        return fecha;
    }

    private void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
    
    @Override
    public String toString() {
        return "=======================================\n" +
               " TURNO Nro: " + this.codT + "\n" + 
               " FECHA/HORA: " + this.fecha + "\n" +  
               "---------------------------------------\n" +
               " PACIENTE:\n" + this.paciente.getNom() + " " + this.paciente.getApe() + " (DNI: " + this.paciente.getDni() + ")\n" +
               " MEDICO:\n" + this.medico.getNom() + " " + this.medico.getApe() + " (Mat.: " + this.medico.getMatricula() + ")\n" +
               "=======================================";
    }
    
    
    
    
    
}
