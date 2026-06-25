
package Controllers;
import Menu.Menu;
import Consola.Consola;
import Models.*;
/**
 *
 * @author pc
 */
public class GestorGeneral {
    private gestorMedico gMedico;
    private gestorPaciente gPaciente;
    private gestorTurno gTurno;
    private Menu menu;
    private Menu menuT;
    private Menu menuP;
    private Menu menuM;

    public GestorGeneral() {
        this.gMedico = new gestorMedico();
        this.gPaciente = new gestorPaciente();
        this.gTurno = new gestorTurno();
        //inicializa el menu
        this.menu = new Menu(4);
        this.menuP = new Menu(4);
        this.menuM = new Menu(5);
        this.menuT = new Menu(4);
        // carga de titulos
        
        
        this.menu.cargarDato("SISTEMA DE GESTION CLINICA", 
            new String[]{"Modulo Pacientes", "Modulo Medicos", "Modulo Turnos", "Salir del Sistema"});

        this.menuP.cargarDato("MODULO PACIENTES", 
            new String[]{"Agregar Paciente", "Eliminar Paciente", "Mostrar Lista", "Volver al MenuPrincipal"});
    
        this.menuM.cargarDato("MODULO MEDICOS", 
            new String[]{"Agregar Medico", "Eliminar Medico", "Mostrar Lista","Mostrar Agenda", "Volver al Menu Principal"});
   
        this.menuT.cargarDato("MODULO TURNOS",
                new String[]{"Crear Turno","Cancelar Turno","Mostrar Turno","Volver al menu Principal"});
}
    public void iniciar(){
        int op;
        do{
            op = menu.ejecutar();
            switch(op){
                case 1:
                    menuPacientes();
                    break;
                case 2:
                    menuMedicos();
                    break;
                case 3:
                    menuTurnos();
                    break;
                case 4:
                    Consola.emitirMensajeLN("Saliendo del sistema Clinico");
                    break;
                
            }
        }while(op!=4);
    }
//sub menus con cada implementacion de sus gestores 
    private void menuPacientes(){
       
        int op;
        do{
        op = menuP.ejecutar();
        switch(op){
            case 1:
                gPaciente.cargar();
                break;
            case 2:
                gPaciente.eliminar();
                break;
            case 3:
                gPaciente.mostrarListado();
                break;
            case 4:
                Consola.emitirMensajeLN("volviendo al menu principal");
        }
        }while(op!=4);
    }
    
    
    private void menuMedicos(){
        int op;
        do{
            op = menuM.ejecutar();
            switch(op){
                case 1:
                    Consola.emitirMensajeLN("elija Especialidad a Cargar\n"
                            + "1.Clinico"+"\n2.Pediatra"+"\n3.Cardiologo");
                    int tipo = Consola.leerInt();
                    gMedico.cargar(tipo);
                    break;
                case 2:
                    gMedico.eliminar();
                    break;
                case 3:
                    gMedico.mostrarListado();
                    break;
                case 4:
                    gMedico.consultarAgenda();
                    break;
                case 5:
                    Consola.emitirMensajeLN("volviendo al menu Principal...");
                    break;
            }
        }while(op!=5);
    }
    
    
    private void menuTurnos(){
        int op;
        do{
            op = menuT.ejecutar();
            switch(op){
                case 1:
                   altaTurno();
                    break;
                case 2:
                    gTurno.eliminar();
                    break;
                case 3:
                    gTurno.mostrarListado();
                    break;
                case 4:
                    Consola.emitirMensajeLN("volviendo al menu Principal");
                    break;
                    
            }
        }while(op!=4);
    }
    //se usa el siguiente metodo para la interconexion de turnos con pacientes y medicos
    private void altaTurno(){
        //se busca y se valida que el paciente exista
        Consola.emitirMensajeLN("Alta de Turno");
        Consola.emitirMensajeLN("ingrese el DNI del paciente");
        String dniB = Consola.leerString();
        Paciente encontrado = gPaciente.buscarPorDni(dniB);
        
        if(encontrado==null){
            Consola.emitirMensajeLN("Error : no existe el paciente ");
            return;
        }
        //se busca y se valida que el medico exista
        Consola.emitirMensajeLN("ingrese la matricula del Medico");
        String matricula = Consola.leerString();
        Medico encontradoM = gMedico.buscarPorMatricula(matricula);
        
        if(encontradoM==null){
            Consola.emitirMensajeLN("Error : no existe el meidco");
            return;
        }
        //se crea la instancia del turno y se pasan los objetos 
        Turno nuevTurn = new Turno();
        nuevTurn.cargarDatos(encontrado, encontradoM);
        //se lo registra con sus respectivas validaciones
        gTurno.registrar(nuevTurn);
    }
}
