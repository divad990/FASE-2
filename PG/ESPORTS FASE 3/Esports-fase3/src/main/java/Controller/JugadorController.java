package Controller;

import Model.DAO.JugadorDAO;
import Utils.BaseDatos;



public class JugadorController {

    private final JugadorDAO jugadorDAO;

    public JugadorController() {
        this.jugadorDAO = new JugadorDAO(BaseDatos.getEm(), BaseDatos.getT());
    }

    public boolean validarDni(String dni) {
        return jugadorDAO.validarDni(dni);
    }
    public boolean validarNickname(String nombre) {
        return jugadorDAO.validarNickname(nombre);
    }
}
