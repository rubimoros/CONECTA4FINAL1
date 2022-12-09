package Consola;

public class ManejadorErrores {
    private final Console consola;
    private final View view;

    public ManejadorErrores(Console consola, View view) {
        this.consola = consola;
        this.view = view;
    }

    public void manejadorErrores(){
        try {
            this.consola.mensajeValido();
        }catch (Exception e){
            this.view.print("ERROR (" + e.getClass().getSimpleName() + ")" + e.getMessage());
            this.manejadorErrores();
        }
    }
}
