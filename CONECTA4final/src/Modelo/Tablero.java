package Modelo;

public class Tablero {
    private char [][] casillas;
    private final int DIMENSIONX=6;
    private final int DIMENSIONY=7;
    private char vacio;

    public Tablero(){
        this.vacio=' ';
        this.casillas= new char[DIMENSIONX][DIMENSIONY];
        for(int i=0;i< DIMENSIONX;i++){
            for(int j=0;j< DIMENSIONY;j++){
                casillas[i][j]=vacio;
            }
        }
    }

    public char getVacio() {
        return vacio;
    }

    public int getDIMENSIONX() {
        return DIMENSIONX;
    }

    public int getDIMENSIONY() {
        return DIMENSIONY;
    }

    public char[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(int columna,int fila,char x) {
        this.casillas[columna][fila]=x;
    }

    public boolean lleno() {
        boolean lleno=true;
        for (int i = 0; i < DIMENSIONX; i++) {
            for (int j = 0; j < DIMENSIONY; j++) {
                if(casillas[i][j]==vacio){
                    lleno=false;
                }
            }
        }
        return lleno;
    }

    public int elegirFila(int columna){
        int i=DIMENSIONX-1;
        while(casillas[i][columna]!=vacio){
            i--;
        }
        return i;
    }

}
