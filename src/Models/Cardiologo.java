    
package Models;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Cardiologo extends Medico{

    public Cardiologo() {
        super("Cardiologo");
    }


    @Override
    public void verEsp() {
        Consola.emitirMensajeLN(super.getEsp());
    }

   
    
}
