package Modelo;

public class Turno {
    private int turno;

    public Turno(){
        this.turno=0;
    }

    public int actual(){
        return turno;
    }

    public void cambiar(){
       if(turno==0) turno=1;
       else turno=0;
    }

}
