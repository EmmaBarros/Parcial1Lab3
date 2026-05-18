
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
        String nro;
        do{
            Consola.emitirMensajeLN("ingrese el numero de celular ");
            nro = Consola.leerString();
            if(!Validar.validarString(nro)){
                Consola.emitirMensajeLN("numero incorrecto , por favot ingrese nuevamente");
            }else{
                Consola.emitirMensajeLN("numero asignado correctamente");
            }
        }while(!Validar.validarString(nro));
        setNroTel(nro);
   } 
   
   private void ingresoGmail(){
        String g;       
        do{
            Consola.emitirMensajeLN("ingrese el Gmail de la persona");
            g = Consola.leerString();
            if(!Validar.validarString(g)){
                Consola.emitirMensajeLN("Gmail incorrecto , por favot ingrese nuevamente");
            }else{
                Consola.emitirMensajeLN("Gmail asignado correctamente");
            }
        }while(!Validar.validarString(g));
        setGmail(g);

    }
   
   private void ingresoDirec(){
         String d;       
        do{
            Consola.emitirMensajeLN("ingrese el la direccion EJ : Calle - Nro");
            d = Consola.leerString();
            if(!Validar.validarString(d)){
                Consola.emitirMensajeLN("Direccion incorrecta , por favot ingrese nuevamente");
            }else{
                Consola.emitirMensajeLN("Direccion asignada correctamente");
            }
        }while(!Validar.validarString(d));
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
