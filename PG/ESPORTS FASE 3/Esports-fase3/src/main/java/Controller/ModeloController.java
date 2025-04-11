package Controller;

import Model.Equipo;
import Model.Jugador;
import Model.Usuario;
import Model.UsuarioDAO;
import Utils.BaseDatos;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.List;

public class ModeloController {




    private Usuario usuario;
    private final UsuarioController usuarioController;
    private VistaController vistaController;
    private final JugadorController jugadorController;
    private final EquipoController equipoController;

    public ModeloController() {
        this.usuarioController = new UsuarioController();
        this.equipoController = new EquipoController();
        this.jugadorController = new JugadorController();
    }

    public VistaController getVistaController() {
        return vistaController;
    }

    public boolean buscarUsuario(String username) throws Exception {
        boolean encontrado = false;
        usuario = usuarioController.buscarUsuario(username);
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }else{
            encontrado = true;
        }
        return encontrado;
    }
    public boolean buscarUsuarioContrasenia(String password) throws Exception {
        return password.equals(usuario.getPasswd());
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
    public void modificarJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, java.sql.Date fechaNacimiento, BigDecimal sueldo, String equipo) {
        Equipo equipoE = new Equipo();
        if (!equipo.isEmpty()) {
            equipoE = equipoController.obtenerEquipo(equipo);
        }
        jugadorController.modificarJugador(dni, nombre, apellido, nickname, nacionalidad, rol, fechaNacimiento, sueldo, equipoE);
    }
    public void eliminarJugador(String dni) {
        jugadorController.eliminarJugador(dni);
    }
    public List<String> obtenerEquipos() {
        return equipoController.obtenerEquipos();
    }
    public Jugador obtenerJugador(String nif) {
        return jugadorController.obtenerJugador(nif);
    }
}
