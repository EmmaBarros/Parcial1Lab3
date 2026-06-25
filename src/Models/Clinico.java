
package Models;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Clinico extends Medico {

    public Clinico() {
        super("Clinico");
    }

    @Override
    public void verEsp() {
      Consola.emitirMensajeLN(super.getEsp());
    }

    
    
}
