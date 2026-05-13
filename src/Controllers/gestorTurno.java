
package Controllers;
import ED.*;
import Models.*;
/**
 *
 * @author pc
 */
public class gestorTurno implements IGestionable<Turno>{
    Lista<Turno> list;

    public gestorTurno() {
    this.list = new Lista<>();
    }

    
    
  //Override  
    @Override
    public void registrar(Turno elem) {
    }

    @Override
    public Turno buscar(Turno elem) {
    }

    @Override
    public void eliminar(Turno elem) {
    }

    @Override
    public void mostrarListado() {
    }
    
    
    
    
}
