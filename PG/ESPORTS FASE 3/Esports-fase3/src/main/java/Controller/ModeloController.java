package Controller;

public class ModeloController {

    private VistaController vistaController;
    private JugadorController jugadorController;
    public ModeloController() {
        this.jugadorController = new JugadorController();
    }

    public VistaController getVistaController() {
        return vistaController;
    }

    public void setVistaController(VistaController vistaController) {
        this.vistaController = vistaController;
    }

    public boolean validarDni(String dni) {
        return jugadorController.validarDni(dni);
    }
    public boolean validarNickname(String nickname) {
        return jugadorController.validarNickname(nickname);
    }
}
