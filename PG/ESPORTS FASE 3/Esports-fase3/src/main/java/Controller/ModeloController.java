package Controller;

import java.math.BigDecimal;

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
    public void crearJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, java.sql.Date fechaNacimiento, BigDecimal sueldo) {
        jugadorController.crearJugador(dni, nombre, apellido, nickname, nacionalidad, rol, fechaNacimiento, sueldo);
    }
}
