package Consola;
import Modelo.Turno;
import Modelo.Tablero;

public class View {

    public void visualizar(Tablero tablero){
        System.out.println("---------------");
        for (int i = 0; i < tablero.getDIMENSIONX(); i++) {
            System.out.print("|");
            for (int j = 0; j < tablero.getDIMENSIONY(); j++) {
                System.out.print(tablero.getCasillas()[i][j]);
                System.out.print("|");

            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public void visualizar(Turno turno) {
        if(turno.actual()==0) {
            System.out.println("Modelo.Turno: RED");
        }else{
            System.out.println("Modelo.Turno: YELLOW");
        }
    }

    public void print(String mensaje){
        System.out.println(mensaje);
    }

}
