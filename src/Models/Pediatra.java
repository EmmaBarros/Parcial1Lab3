
package Models;
import Consola.Consola; 
/**
 *
 * @author emami
 */
public class Pediatra extends Medico {

    public Pediatra() {
        super("pediatra");
    }


    @Override
    public void verEsp() {
        Consola.emitirMensajeLN(super.getEsp());
    }

    

    
    
 
}
