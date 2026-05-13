
package Controllers;
import ED.*;
import Models.*;
/**
 *
 * @author emami
 */
public class gestorMedico implements IGestionable<Medico>{
    Lista<Medico> lista;

    public gestorMedico() {
        this.lista = new Lista<>();
    }

    @Override
    public void registrar(Medico elem) {
    }

    @Override
    public Medico buscar(Medico elem) {
    }

    @Override
    public void eliminar(Medico elem) {
    }

    @Override
    public void mostrarListado() {
    }
    
    
}
