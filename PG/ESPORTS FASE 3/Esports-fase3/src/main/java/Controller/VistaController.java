package Controller;

import Exceptions.CampoVacioException;
import Utils.*;
import View.JugadoresGestion;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class VistaController {

    private ModeloController modeloController;

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
    public void modificarJugador(String dni, String nombre, String apellido, String nickname, String nacionalidad, String rol, String nacimiento, String sueldo) {
        BigDecimal sueldoInt = BigDecimal.valueOf(Integer.parseInt(sueldo));
        Date fechaNacimiento = fechaOracle(nacimiento);
        modeloController.modificarJugador(dni,nombre,apellido,nickname,nacionalidad,rol,fechaNacimiento,sueldoInt);
    }
    public void eliminarJugador(String dni) {
        modeloController.eliminarJugador(dni);
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
