import javax.naming.ldap.Control;

public class Main {

    private static Controller.ModeloController modeloController;
    private static Controller.VistaController vistaController;

    public static void main(String[] args) {
        crearObjetos();
    }

    public static void crearObjetos()
    {
        // Modelo
        modeloController = new Controller.ModeloController();
        vistaController = new Controller.VistaController(modeloController);
        modeloController.setVistaController(vistaController);

    }

}
