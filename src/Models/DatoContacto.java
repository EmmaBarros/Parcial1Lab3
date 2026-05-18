
package Models;
import Validar.Validar;
import Consola.Consola;
/**
 *
 * @author pc
 */
public class DatoContacto {
   private String nroTel;
   private String gmail; 
   private String direc;

    public DatoContacto(String nroTel, String gmail, String direc) {
        this.nroTel = nroTel;
        this.gmail = gmail;
        this.direc = direc;
    }

    public DatoContacto() {
        this.direc = "";
        this.gmail = "";
        this.nroTel = "";    
    }
    
   
   //carga
    public void cargarDatos(){
        ingresoTelf();
        ingresoGmail();
        ingresoDirec();
   }
    
    
   private void ingresoTelf(){
        String nro = Validar.leerString("Ingrese el Numero de Telefono: ", "Carga Invalida m ingrese nuevamente..."); 
        setNroTel(nro);
   } 
   
   private void ingresoGmail(){
        String g = Validar.leerString("Ingrese el Gmail: ", "Carga Invalida , intente Nuevamente...");
        setGmail(g);

    }
   
   private void ingresoDirec(){
         String d = Validar.leerString("ingrese La Direciion (calle-Nro): ", "Carga Invalida , intente nuevamente....");
        setDirec(d);
   }
   
   
   
  //stt y gtt

    public String getNroTel() {
        return nroTel;
    }

    private void setNroTel(String nroTel) {
        this.nroTel = nroTel;
    }

    public String getGmail() {
        return gmail;
    }

    private void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getDirec() {
        return direc;
    }

    private void setDirec(String direc) {
        this.direc = direc;
    }

    @Override
    public String toString() {
        return "Contacto\n" + "-Numero de Telefono = " + nroTel + "\n-gmail = " + gmail + "\n-Direccion = " + direc;
    }
   
   
}
