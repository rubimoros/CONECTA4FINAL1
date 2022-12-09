package Modelo;

public class Jugador {
    private char color;
    private Tablero tablero;
    private boolean ganador;

    public Jugador(char color, Tablero tablero){
        this.color=color;
        this.tablero=tablero;
        this.ganador=false;
    }

    public boolean isGanador() {
        return ganador;
    }
    public char getColor() {
        return color;
    }
    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }
}
