package Controladores;

import Modelo.Jugador;
import Modelo.JugadorDAO;
import utils.Utilidades;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JugadorController {

    public static void crearJugador(){
        try {
            boolean terminar = true;
            do {
                Jugador j = solicitarDatos();
                JugadorDAO.crearJugador(j);
                System.out.println("Jugador con nickname " + j.getNickname() + " creado correctamente");
                //fin creación -- preguntar si se quiere crear otro jugador
                String respuesta = JOptionPane.showInputDialog("¿Quieres crear otro jugador? (s/n)");
                if (respuesta.equalsIgnoreCase("n")) {
                    terminar = false;
                }
            } while (terminar);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el jugador");
        }
    }

    //INICIO FUNCIONES COMPLEMENTARIAS
    public static Jugador solicitarDatos(){
        String nombre = Utilidades.solicitarDato("Nombre", "Teclea el nombre del cliente", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        String apellidos = Utilidades.solicitarDato("Apellido", "Teclea el apellido del cliente", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        String nacionalidad = Utilidades.solicitarDato("Nacionalidad", "Teclea la nacionalidad del cliente", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        LocalDate fechaNacimiento = convertirLocalDate((Utilidades.solicitarDato("Fecha de Nacimiento", "Teclea la fecha de nacimiento del cliente (yyyy-MM-dd)","^[0-9]{2}/[0-9]{2}/[0-9]{4}$")));
        String nickname = Utilidades.solicitarDato("Nickname", "Teclea el nickname del cliente", "^[A-Za-z0-9_]+$");
        String rol = Utilidades.solicitarDato("Rol", "Teclea el rol del cliente", "^[A-Za-z]+$");
        int sueldo = Integer.parseInt(Utilidades.solicitarDato("Sueldo", "Teclea el sueldo del cliente", "^[0-9]+$"));

        return new Jugador(nombre, apellidos, nacionalidad, fechaNacimiento, nickname, rol, sueldo, null);
    }
    public static LocalDate convertirLocalDate(String fecha)
    {
        DateTimeFormatter formato;
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formato);
    }

}
