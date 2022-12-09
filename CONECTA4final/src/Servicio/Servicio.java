package Servicio;
import Modelo.*;
import Consola.View;

public class Servicio {
    private final Conecta4 conecta4;
    private final Tablero tablero;
    private View view;


    public Servicio(Conecta4 conecta4) {
        this.conecta4=conecta4;
        tablero = conecta4.getTablero();
    }

    public boolean comprobarFila(int x, int y, char color){
        boolean res=false;
        int aux=0;
        int i=y;
        int j=y-1;

        while (aux<4&&i< tablero.getDIMENSIONX()&&tablero.getCasillas()[x][i]==color){
            if(tablero.getCasillas()[x][i]==color) aux++;
            i++;
        }

        while (aux<4&&j>=0&&tablero.getCasillas()[x][j]==color){
            if(tablero.getCasillas()[x][j]==color) aux++;
            j--;
        }

        if(aux==4) res=true;

        return res;
    }

    public boolean comprobarColumna(int x, int y, char color){
        boolean res=false;
        int aux=0;
        int i=x;
        int j=x-1;

        while (aux<4&&i< tablero.getDIMENSIONY()-1&&tablero.getCasillas()[i][y]==color){
            if(tablero.getCasillas()[i][y]==color) aux++;
            i++;
        }

        while (aux<4&&j>=0&&tablero.getCasillas()[j][y]==color){
            if(tablero.getCasillas()[j][y]==color) aux++;
            j--;
        }

        if(aux==4) res=true;

        return res;
    }

    public boolean comprobarDiagonal(int x, int y, char color){
        boolean res=false;
        int aux=0;
        int i=y;
        int j=y-1;
        int k=x;
        int l=x-1;

        while (aux<4&&i< tablero.getDIMENSIONX()+1&&k< tablero.getDIMENSIONY()-1&&tablero.getCasillas()[k][i]==color){
            if(tablero.getCasillas()[k][i]==color) aux++;
            i++;
            k++;
        }

        while (aux<4&&l>=0&&j>=0&&tablero.getCasillas()[l][j]==color){
            if(tablero.getCasillas()[l][j]==color) aux++;
            j--;
            l--;
        }

        if(aux==4) res=true;

        return res;
    }

    public boolean comprobarOtraDiagonal(int x, int y, char color){
        boolean res=false;
        int aux=0;
        int i=x;
        int j=x+1;
        int k=y;
        int l=y-1;

        while (aux<4&&k< tablero.getDIMENSIONY()-1&&i>=0&&tablero.getCasillas()[i][k]==color){
            if(tablero.getCasillas()[i][k]==color) aux++;
            i--;
            k++;
        }

        while (aux<4&&j< tablero.getDIMENSIONX()&&l>=0&&tablero.getCasillas()[j][l]==color){
            if(tablero.getCasillas()[j][l]==color) aux++;
            j++;
            l--;
        }

        if(aux==4) res=true;

        return res;
    }

    public boolean comprobarGanador(int x,int y, char color){

        if(comprobarDiagonal(x,y,color)) return true;
        if(comprobarFila(x,y,color)) return true;
        if(comprobarOtraDiagonal(x,y,color)) return true;
        if(comprobarColumna(x,y,color)) return true;
        else return false;
    }

    public Conecta4 getPartida(){
        return conecta4;
    }

    public boolean validarColumna(int columna){
        int aux=columna-1;
        if(columna>0&&columna<8) {
            if (tablero.getCasillas()[0][aux] == tablero.getVacio()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public Jugador getJugadorActual(){
        return conecta4.getJugadores()[conecta4.getTurno().actual()];
    }


}