package Controladores;

import Modelo.Jugador;
import Modelo.JugadorDAO;
import Utils.Utilidades;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Modelo.JugadorDAO.jugadores;

public class JugadorController {
    //INICIO VARIABLES
    private static final StringBuilder vista = new StringBuilder();
    private static final StringBuilder vista2 = new StringBuilder();
    //INICIO FUNCIONES PRINCIPALES
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
    public static void modificarJugador(){
        String nickname = Utilidades.solicitarDato("Nickname", "Teclea el nickname del jugador", "^[A-Za-z0-9_]+$");
        if (jugadores.containsKey(nickname)) {
            JugadorDAO.eliminarJugador(nickname);
            Jugador j = solicitarDatosExceptoNickname(nickname);
            JugadorDAO.crearJugador(j);
            JOptionPane.showMessageDialog(null, "Jugador con nickname "+nickname+" modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No existe un jugador con ese nickname");
        }
    }
    public static void eliminarJugador(){
        String nickname = Utilidades.solicitarDato("Nickname", "Teclea el nickname del jugador", "^[A-Za-z0-9_]+$");
        if (jugadores.containsKey(nickname)) {
            JugadorDAO.eliminarJugador(nickname);
            JOptionPane.showMessageDialog(null, "Jugador eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No existe un jugador con ese nickname");
        }
    }
    public static void listarJugadores() {
        try {
            //Comprobamos si ha sido cambiado el mapa de jugadores para no repetir insercion de datos en SB
            JugadorDAO.mostrarJugadorActual(vista2);
            if (vista2.toString().contentEquals(vista)) {
                System.out.println("No hay cambios");
            } else {
                JugadorDAO.mostrarJugadores(vista);
            }
            //Si no hay jugadores se muestra mensaje, si no han cambiado no se introduce nuevo y si han cambiado se introduce el nuevo
            if (vista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay jugadores creados");
            } else {
                JOptionPane.showMessageDialog(null, vista.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los jugadores");
        }
    }

    //INICIO FUNCIONES COMPLEMENTARIAS
    public static Jugador solicitarDatos(){
        String nombre = Utilidades.solicitarDato("Nombre", "Teclea el nombre del jugador", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        String apellidos = Utilidades.solicitarDato("Apellido", "Teclea el apellido del juagdor", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        String nacionalidad = Utilidades.solicitarDato("Nacionalidad", "Teclea la nacionalidad del jugador", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        LocalDate fechaNacimiento = convertirLocalDate((Utilidades.solicitarDato("Fecha de Nacimiento", "Teclea la fecha de nacimiento del jugador (dd/mm/yyyy)","^[0-9]{2}/[0-9]{2}/[0-9]{4}$")));
        String nickname = Utilidades.solicitarDato("Nickname", "Teclea el nickname del jugador", "^[A-Za-z0-9_]+$");
        String rol = Utilidades.solicitarDato("Rol", "Teclea el rol del jugador", "^[A-Za-z]+$");
        int sueldo = Integer.parseInt(Utilidades.solicitarDato("Sueldo", "Teclea el sueldo del jugador", "^[0-9]+$"));

        return new Jugador(nombre, apellidos, nacionalidad, fechaNacimiento, nickname, rol, sueldo, null);
    }
    public static LocalDate convertirLocalDate(String fecha){
        DateTimeFormatter formato;
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formato);
    }
    public static Jugador solicitarDatosExceptoNickname(String nickname){
        String nombre = Utilidades.solicitarDato("Nombre", "Teclea el nombre del jugador", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        String apellidos = Utilidades.solicitarDato("Apellido", "Teclea el apellido del juagdor", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        String nacionalidad = Utilidades.solicitarDato("Nacionalidad", "Teclea la nacionalidad del jugador", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        LocalDate fechaNacimiento = convertirLocalDate((Utilidades.solicitarDato("Fecha de Nacimiento", "Teclea la fecha de nacimiento del jugador (yyyy-MM-dd)","^[0-9]{2}/[0-9]{2}/[0-9]{4}$")));
        String rol = Utilidades.solicitarDato("Rol", "Teclea el rol del jugador", "^[A-Za-z]+$");
        int sueldo = Integer.parseInt(Utilidades.solicitarDato("Sueldo", "Teclea el sueldo del jugador", "^[0-9]+$"));

        return new Jugador(nombre, apellidos, nacionalidad, fechaNacimiento, nickname, rol, sueldo, null);
    }

}
