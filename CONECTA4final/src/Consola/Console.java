package Consola;

import java.util.Scanner;
import Servicio.Servicio;

public class Console {
    private final Servicio servicio;
    private final View view;
    private final Scanner sc;
    public static final String DELIMITER_ANY_WHITE_SPACE = "\\s";
    public final static String MENU = "Conecta4_MENU(Jugar,Salir)";
    public final static String JUGAR = "JUGAR";
    public final static String SALIR = "SALIR";


    public Console(Servicio servicio, View view) {
        this.servicio = servicio;
        this.view = view;
        this.sc = new Scanner(System.in);
    }



    /*public void start() {
        view.print("CONECTA 4");

        while(!servicio.getJugadorActual().isGanador()&&!servicio.getPartida().getTablero().lleno()){
            if(!servicio.getJugadorActual().isGanador()) {
                this.view.visualizar(servicio.getPartida().getTablero());
                this.view.visualizar(servicio.getPartida().getTurno());
                poner();
                servicio.getPartida().getTurno().cambiar();
                this.view.visualizar(servicio.getPartida().getTurno());
                view.print("Nohayganador");
            }

        }



    }*/
    public void start() {
        this.view.visualizar(servicio.getPartida().getTablero());
        do {
            this.view.visualizar(servicio.getPartida().getTurno());
            poner();
            if(servicio.getJugadorActual().isGanador()){view.print("Color: "+servicio.getJugadorActual().getColor()+" ha sido el GANADOR");}
            servicio.getPartida().getTurno().cambiar();
            this.view.visualizar(servicio.getPartida().getTablero());
        } while (!servicio.getPartida().getTablero().lleno()&&!ganar());
        if(servicio.getPartida().getTablero().lleno()){view.print("TABLERO COMPLETO");}

    }
    private void stop() {
        this.view.print("Ha salido");
    }

    public int leer() {
        Scanner scn = new Scanner(System.in);
        return scn.nextInt();
    }

    public String leer(Scanner sc) {
        this.view.print(Console.MENU);
        String comm = sc.next();
        switch (comm.toUpperCase()) {
            case Console.JUGAR:
                this.start();
                break;
            case Console.SALIR:
                this.stop();
                break;
            default:
                throw new UnsupportedOperationException("Este comando no existe " + comm);
        }
        return comm;
    }

    public void mensajeValido() {
        Scanner mensaje = new Scanner(System.in).useDelimiter(Console.DELIMITER_ANY_WHITE_SPACE);
        String comando;
        do {
            comando = leer(mensaje);
        } while (mensaje != null && !Console.SALIR.equalsIgnoreCase(comando.toUpperCase()));
    }

    public void poner() {
        int aux;
        do{
            view.print("Elige columna para poner ficha: ");
            aux = leer();
            if(!servicio.validarColumna(aux)) {
                if (aux > 0 && aux < 8) {
                    view.print("Columna completa!!!");
                }else if(aux<=0||aux>7){view.print("Columna no valida!!! Valores[1-7]");}
            }

        }while(!servicio.validarColumna(aux));






        aux--;
        int x=servicio.getPartida().getTablero().elegirFila(aux);
        int y=aux;

        servicio.getPartida().getTablero().setCasillas(x,y,servicio.getJugadorActual().getColor());
        if(servicio.comprobarGanador(x,y,servicio.getJugadorActual().getColor())){
            servicio.getJugadorActual().setGanador(true);
        }
    }

    public boolean ganar(){
        if(servicio.getPartida().getJugadores()[0].isGanador()||servicio.getPartida().getJugadores()[1].isGanador()){
            return true;
        }else{
            return false;
        }
    }

}