package Controller;

import Model.DAO.JugadorDAO;
import Utils.BaseDatos;

import java.math.BigDecimal;


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
    public void crearJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, java.sql.Date fechaNacimiento, BigDecimal sueldo) {
        jugadorDAO.crearJugador(dni, nombre, apellido, nickname, nacionalidad, rol, fechaNacimiento, sueldo);
    }
    public void modificarJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, java.sql.Date fechaNacimiento, BigDecimal sueldo) {
        jugadorDAO.modificarJugador(dni, nombre, apellido, nickname, nacionalidad, rol, fechaNacimiento, sueldo);
    }
    public void eliminarJugador(String dni) {
        jugadorDAO.eliminarJugador(dni);
    }
}
