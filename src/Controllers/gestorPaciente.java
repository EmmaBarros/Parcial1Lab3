
package Controllers;
import ED.*;
import Models.*;

/**
 *
 * @author emami
 */
public class gestorPaciente implements IGestionable<Paciente> {
 Lista<Paciente> lista;    

    public gestorPaciente() {
        this.lista = new Lista<>();
    }

 
 
 
 
 //Override
    @Override
    public void registrar(Paciente elem) {
    }

    @Override
    public Paciente buscar(Paciente elem) {
    }

    @Override
    public void eliminar(Paciente elem) {
    }

    @Override
    public void mostrarListado() {
    }
 
    
    
 
}
