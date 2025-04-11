package Controller;

import Model.Jugador;
import View.*;
import Exceptions.CampoVacioException;
import Utils.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class VistaController {

    private ModeloController modeloController;
    private VentanaInicio vInicio;
    private VentanaLogIn vLogin;

    public VistaController() {
        this.modeloController = new ModeloController();
    }

    public boolean validarDato(String dato, String expresionRegular) throws CampoVacioException {
        return Utilidades.validarDato(dato, expresionRegular);
    }
    public void iniciarGestionJugadores() {
        JugadoresGestion gestionJugadores = new JugadoresGestion(this);
        gestionJugadores.setVisible(true); //Hace visible la ventana
        gestionJugadores.setLocationRelativeTo(null); //Centra la ventana
    }
    public void iniciarMenuOpciones() {
        MenuOpciones menuOpciones = new MenuOpciones(this);
        menuOpciones.setVisible(true); //Hace visible la ventana
        menuOpciones.setLocationRelativeTo(null); //Centra la ventana
    }
    public boolean validarDni(String dni) {
        return modeloController.validarDni(dni);
    }
    public boolean validarNickname(String nickname) {
        return modeloController.validarNickname(nickname);
    }
    public void crearJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, String nacimiento, String sueldo) {
        BigDecimal sueldoInt = BigDecimal.valueOf(Integer.parseInt(sueldo));
        Date fechaNacimiento = fechaOracle(nacimiento);
        modeloController.crearJugador(dni,nombre,apellido,nickname,nacionalidad,rol,fechaNacimiento,sueldoInt);
    }
    public void modificarJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, String nacimiento, String sueldo, String equipo) {
        BigDecimal sueldoInt = null;
        Date fechaNacimiento = null;
        if (!Objects.equals(sueldo, "")) {
            sueldoInt = BigDecimal.valueOf(Integer.parseInt(sueldo));
        }
        if (!Objects.equals(nacimiento, "")) {
            fechaNacimiento = fechaOracle(nacimiento);
        }
        modeloController.modificarJugador(dni,nombre,apellido,nickname,nacionalidad,rol,fechaNacimiento,sueldoInt, equipo);
    }
    public void eliminarJugador(String dni) {
        modeloController.eliminarJugador(dni);
    }
    public List<String> obtenerEquipos(){
        return modeloController.obtenerEquipos();
    }
    public boolean buscarUsuario(String username) throws Exception {
        return modeloController.buscarUsuario(username);
    }
    public boolean buscarUsuarioContrasenia(String password) throws Exception {
        return modeloController.buscarUsuarioContrasenia(password);
    }
    public void mostrarAccesoLogIn() {
        vLogin = new VentanaLogIn(this);
        vLogin.setVisible(true);
        vInicio.dispose();
    }
    public void iniciarPrincipal() {
        vInicio = new VentanaInicio(this);
        vInicio.setVisible(true);
    }
    public Jugador obtenerJugador(String nif){
        return modeloController.obtenerJugador(nif);
    }
    public void iniciarJugador(String nif){
        MostrarJugador jugador = new MostrarJugador(this, nif);
        jugador.setVisible(true);
    }

    // Funciones complementarias
    public Date fechaOracle(String fecha) {
        String[] fechaSplit = fecha.split("/");
        int dia = Integer.parseInt(fechaSplit[0]);
        int mes = Integer.parseInt(fechaSplit[1]);
        int anio = Integer.parseInt(fechaSplit[2]);

        LocalDate fechaLocalDate = LocalDate.of(anio, mes, dia);
        return Date.valueOf(fechaLocalDate);
    }


}
