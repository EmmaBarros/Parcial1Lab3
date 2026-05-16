
package Models;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class Clinico extends Medico {

    @Override
    public void mostrarDatos() {
        super.toString();
    }

    @Override
    public void verEsp() {
      Consola.emitirMensajeLN("Clinico");
    }

    
    
}
