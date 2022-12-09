import Consola.Console;
import Consola.ManejadorErrores;
import Consola.View;
import Modelo.Conecta4;
import Servicio.Servicio;

public class Injector {

    public void inject() {
            Conecta4 conecta4 = new Conecta4();
            View view = new View();
            Servicio servicio = new Servicio(conecta4);
            Console console = new Console(servicio, view);
            ManejadorErrores manejadorError = new ManejadorErrores(console, view);
            manejadorError.manejadorErrores();
        }
    }

