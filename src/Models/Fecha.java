
package Models;

/**
 *
 * @author emami
 */


import java.util.Scanner;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;
    private int hora;   // Nuevo atributo
    private int minuto; // Nuevo atributo

    public Fecha() {
        this.dia = 1;
        this.mes = 1;
        this.anio = 2000;
        this.hora = 0;
        this.minuto = 0;
    }

    public String obtenerFormatoFecha() {
        return String.format("%02d/%02d/%04d %02d:%02d\n", dia, mes, anio, hora, minuto);
    }

    public void cargarFecha() {
        Scanner leer = new Scanner(System.in);
        int d, m, a, h, min;
        do {
            System.out.println("Ingrese dia:");
            d = leer.nextInt();
            System.out.println("Ingrese mes:");
            m = leer.nextInt();
            System.out.println("Ingrese anio:");
            a = leer.nextInt();
            System.out.println("Ingrese hora (0-23):");
            h = leer.nextInt();
            System.out.println("Ingrese minuto (0-59):");
            min = leer.nextInt();
        } while (!setFecha(d, m, a, h, min));
    }

    private boolean setFecha(int dia, int mes, int anio, int hora, int minuto) {
        if (esFechaValida(dia, mes, anio) && esHoraValida(hora, minuto)) {
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
            this.hora = hora;
            this.minuto = minuto;
            return true;
        } else {
            System.out.println("Datos invalidos. Intente de nuevo.");
            return false;
        }
    }

    // Getters para los nuevos atributos
    public int getHora() { return hora; }
    public int getMinuto() { return minuto; }
    public int getDia() { return dia; }
    public int getMes() { return mes; }
    public int getAnio() { return anio; }

    // Validación de la hora
    private boolean esHoraValida(int hora, int minuto) {
        return (hora >= 0 && hora < 24) && (minuto >= 0 && minuto < 60);
    }

    private boolean esFechaValida(int dia, int mes, int anio) {
        if (mes < 1 || mes > 12 || anio <= 0) {
            return false;
        }
        int maxDias = diasDelMes(mes, anio);
        return dia >= 1 && dia <= maxDias;
    }

    private int diasDelMes(int mes, int anio) {
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esAnioBisiesto(anio) ? 29 : 28;
            default:
                return -1;
        }
    }

    private boolean esAnioBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }
}
