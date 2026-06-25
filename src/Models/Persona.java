
package Models;
import Consola.Consola;
import Validar.Validar;
import java.util.Objects;

/**
 *
 * @author emami
 */
public abstract class Persona {
 protected String nom;
 protected String ape;
 protected String  dni;
 protected DatoContacto dato;



    public Persona() {
     this.nom = "";   
     this.ape = "";
     this.dni = "";
     this.dato = new DatoContacto();
    }
    
//mets abstractos
  
    public abstract void mostrarDatos();

//carga 
 
    public void CargarDatos(){
        leerNombre();
        leerApellido();
        leerDni();
        this.dato.cargarDatos();
    }

    private void leerNombre(){
     String nomb = Validar.leerString("Ingrese el Nombre: ","Carga Invalida , intente nuevamente");
     setNom(nomb);
    }
    private void leerApellido(){
        String apell = Validar.leerString("Ingrese el Apellido:  ","Carga Invalida , ingrese nuevamente");
        setApe(apell);
    }
    public void leerDni(){
        String d;
        do {
            Consola.emitirMensaje("DNI: ");
            d = Consola.leerString();
            if (!Validar.validarStringNum(d)|| d.length()< 7 || d.length() > 8) {
                Consola.emitirMensajeLN("Carga invlida , ingerese un Dni");
            }
        } while (!Validar.validarStringNum(d));
        setDni(d);
    }

  //gtts y stts
    public String getNom() {
        return nom;
    }

    private void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    private void setApe(String ape) {
        this.ape = ape;
    }

    public String getDni() {
        return dni;
    }

    private void setDni(String dni) {
        this.dni = dni;
    }
    
 //Override
    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.dni, other.dni);
        
    }
    
    @Override
public String toString() {
    return String.format("%-15s | DNI: %-10s | \n%s", 
                         ape + ", " + nom, 
                         dni, 
                         dato.toString());
}
    
 
}
