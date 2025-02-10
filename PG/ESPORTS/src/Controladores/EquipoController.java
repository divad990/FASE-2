package Controladores;

import Modelo.Equipo;
import Modelo.EquipoDAO;
import Utils.Utilidades;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static Modelo.EquipoDAO.equipos;

public class EquipoController {
    //INICIO VARIABLES
    private static final StringBuilder vista = new StringBuilder();
    private static final StringBuilder vista2 = new StringBuilder();
    //INICIO FUNCIONES PRINCIPALES
    public static void crearEquipo() {
        try {
            boolean terminar = true;
            do {
                Equipo e = solicitarDatos();

                boolean comprobante = EquipoDAO.crearEquipo(e);
                if (comprobante) {
                    JOptionPane.showMessageDialog(null, "Ya existe un equipo con ese nombre");
                    crearEquipo();
                }
                System.out.println("Equipo con nombre " + e.getNombre() + " creado correctamente");
                // Fin creación -- preguntar si se quiere crear otro equipo
                String respuesta = JOptionPane.showInputDialog("¿Quieres crear otro equipo? (s/n)");
                if (respuesta.equalsIgnoreCase("n")) {
                    terminar = false;
                }
            } while (terminar);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el equipo");
            System.out.println("Error al crear el equipo: " + e.getClass());
        }
    }
    public static void modificarEquipo() {
        boolean nombreCorrecto = false;
        String nombre = Utilidades.solicitarDato("Nombre", "Teclea el nombre del equipo", "^[A-Za-z0-9_]+$");
        // Comprobamos si el nombre del equipo existe
        for (Equipo equipo  : equipos) {
            if (equipo.getNombre().contentEquals(nombre)) {
                nombreCorrecto = true;
            }
        }
        if (nombreCorrecto) {
            EquipoDAO.eliminarEquipo(nombre);
            Equipo e = solicitarDatosExceptoNombre(nombre);
            boolean comprobante = EquipoDAO.crearEquipo(e);
            if (comprobante) {
                JOptionPane.showMessageDialog(null, "Ya existe un equipo con ese nombre");
                crearEquipo();
            }
            JOptionPane.showMessageDialog(null, "Equipo con nombre " + nombre + " modificado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No existe un equipo con ese nombre");
        }
    }
    public static void eliminarEquipo() {
        boolean nombreCorrecto=false;

        String nombre = Utilidades.solicitarDato("Nombre", "Teclea el nombre del equipo", "^[A-Za-z0-9_]+$");
        //Comrpobar si el nombre del equipo existe
        for (Equipo equipo  : equipos) {
            if (equipo.getNombre().contentEquals(nombre)) {
                nombreCorrecto = true;
            }
        }
        if (nombreCorrecto) {
            EquipoDAO.eliminarEquipo(nombre);
            JOptionPane.showMessageDialog(null, "Equipo eliminado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No existe un equipo con ese nombre");
        }
    }
    public static void listarEquipos() {
        try {
            // Comprobamos si ha sido cambiado el arraylist de equipos para no repetir inserción de datos en SB
            EquipoDAO.mostrarEquipoActual(vista2);
            if (vista2.toString().contentEquals(vista)) {
                System.out.println("No hay cambios");
            } else {
                EquipoDAO.mostrarEquipos(vista);
            }
            // Si no hay equipos se muestra mensaje, si no han cambiado no se introduce nuevo y si han cambiado se introduce el nuevo
            if (vista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay equipos creados");
            } else {
                JOptionPane.showMessageDialog(null, vista.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los equipos");
        }
    }
    // INICIO FUNCIONES COMPLEMENTARIAS
    public static Equipo solicitarDatos(){

        String nombre = Utilidades.solicitarDato("Nombre", "Teclea el nombre del equipo", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        LocalDate fechaFundacion = convertirLocalDate(Utilidades.solicitarDato("Fecha de Fundación", "Teclea la fecha de fundación del equipo (dd/MM/yyyy)", "^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));

        return new Equipo(nombre, null, fechaFundacion);
    }
    public static Equipo solicitarDatosExceptoNombre(String nombre){
        LocalDate fechaFundacion = convertirLocalDate(Utilidades.solicitarDato("Fecha de Fundación", "Teclea la fecha de fundación del equipo (dd/MM/yyyy)", "^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));

        return new Equipo(nombre, null, fechaFundacion);
    }
    public static LocalDate convertirLocalDate(String fecha){
        DateTimeFormatter formato;
        formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formato);
    }

}
