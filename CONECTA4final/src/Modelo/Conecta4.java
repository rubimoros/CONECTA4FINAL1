package Modelo;

public class Conecta4{

    private Tablero tablero;
    private Jugador[] jugadores;
    private Turno turno;


    public Conecta4(){
        this.tablero = new Tablero();
        this.turno = new Turno();
        this.jugadores =new Jugador[2];
        this.jugadores[0]=new Jugador('R',tablero);
        this.jugadores[1]=new Jugador('Y',tablero);
    }

    public Turno getTurno() {
        return turno;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

}
