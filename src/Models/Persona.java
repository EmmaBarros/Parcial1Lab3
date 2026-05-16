
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
        this.dato = new DatoContacto();
    }
    
//mets abstractos
  
    public abstract void mostrarDatos();

//carga 
 
    public void CargarDatos(){
        ingresarNombre();
        ingresarApellido();
        ingresarDni();
        this.dato.cargarDatos();
    }

    private void ingresarNombre(){
      String n;
        do {
            Consola.emitirMensaje("Nombre: ");
            n = Consola.leerDato();
            if (!Validar.validarString(n)) {
                Consola.emitirMensajeLN("Carga invalida , ingrese un nombre...");
            }
        } while (!Validar.validarString(n));
        setNom(n);  
    }
    private void ingresarApellido(){
        String a;
        do {
            Consola.emitirMensaje("Apellido: ");
            a = Consola.leerDato();
            if (!Validar.validarString(a)) {
                Consola.emitirMensajeLN("Carga invalida , ingrese un apellido");
            }
        } while (!Validar.validarString(a));
        setApe(a);
    }
    public void ingresarDni(){
        String d;
        do {
            Consola.emitirMensaje("DNI: ");
            d = Consola.leerString();
            if (!Validar.validarDni(d)) {
                Consola.emitirMensajeLN("Carga invlida , ingerese un Dni");
            }
        } while (!Validar.validarDni(d));
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
    return String.format("%-15s | DNI: %-10s | %s", 
                         ape.toUpperCase() + ", " + nom, 
                         dni, 
                         dato.toString());
}
    
 
}
