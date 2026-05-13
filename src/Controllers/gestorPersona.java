
package Controllers;
import ED.*;
import Models.*;
import Consola.Consola;
/**
 *
 * @author pc
 */
public class gestorPersona implements IGestionable <Persona> {
    Lista<Persona> list;
    

    public gestorPersona() {
        this.list = new Lista<Persona>();
    }

    
    
    private boolean filtrar(String dato,String tipo){
        return tipo.equals(dato);
    }

    
    private boolean existeDni(Persona pers){
        return buscar(pers) != null;
    }
    private Persona instP(int tipo){
        Persona p = null;
        switch(tipo){
            case 1:
               p = new Paciente();
               break;
            case 2:
                p = new Clinico();
                break;
            case 3:
                p = new Pediatra();
                break;
            case 4:
                p = new Cardiologo();
                break;
               
        }
        return p;
    }
    
    public void cargarPers(int tipo){
        Persona p = instP(tipo);
        p.ingresarDni();
        if(!existeDni(p)){
            p.CargarDatos();
        }else{
            Consola.emitirMensajeLN("El DNI "+p.getDni()+" Ya existe");
        }
    }
    
    
    @Override
    public void registrar(Persona elem) {
            list.insertarPri(elem);
        
    }
    @Override
    public Persona buscar(Persona pers) {
        Nodo<Persona> n = list.inicio();
        Persona p;
        
        while(n != null){
            p = n.getDato();          
            if(p.equals(pers)){
                return p;
            }            
            n= n.getPs();
        }
        
        return null;
    }

    @Override
    public void eliminar(Persona elem) {
    }

    @Override
    public void mostrarListado() {
    }
    
    
}
