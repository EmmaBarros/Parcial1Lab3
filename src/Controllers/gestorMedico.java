
package Controllers;
import ED.*;
import Models.*;
import Consola.Consola;
/**
 *
 * @author emami
 */
public class gestorMedico implements IGestionable<Medico>{
    Lista<Medico> lista;

    public gestorMedico() {
        this.lista = new Lista<>();
    }

    
    
    
        
    
    //Override
    @Override
    public void registrar(Medico nuevo) {
        Medico encontrado = buscar(nuevo);
        if(encontrado == null){
            lista.insertarPri(nuevo);
            Consola.emitirMensajeLN("medico registrado");
        }else{
            if(encontrado.getMatricula() == nuevo.getMatricula()){
                Consola.emitirMensajeLN("la matricula ya existe");
            }else{
                Consola.emitirMensajeLN("el dni ya pertenece a otro medico");
            }
        }
    }

    @Override
    public Medico buscar(Medico m) {
        Nodo<Medico> p = lista.inicio();
        while(p != null){
            if(p.getDato().esElMismo(m) ||
                    p.getDato().esElMismo(m)){
                return p.getDato();
            }
            p = p.getPs();
        }
     return null; 
    }

    
    @Override
    public void eliminar() {
      Consola.emitirMensajeLN("ingrese la matricula a eliminar : ");
      int mat = Consola.leerInt();
      
      Medico encontrado = buscarPorMatricula(mat);
      if(encontrado != null){
          lista.eliminar(encontrado);
      }else{
          Consola.emitirMensajeLN("no se encontro ningun medico con la matricula"+mat);
      }
    }

    @Override
    public void mostrarListado() {
        if(lista.listaVacia()){
            Consola.emitirMensajeLN("la lista de medicos esta vacia");
        }else{
            lista.visualizar();        
        }
    }
    
    //busqueda
    public Medico buscarPorMatricula(int mat){
        Nodo<Medico> p = lista.inicio();
        while(p != null){
            if(p.getDato().getMatricula()==mat){
                return p.getDato();
            }
            p = p.getPs();
        }
        return null;
    }
    
    
}
