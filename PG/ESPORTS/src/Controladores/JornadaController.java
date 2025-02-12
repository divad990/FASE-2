package Controladores;

import Modelo.*;
import Utils.Utilidades;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JornadaController {
    //INICIO VARIABLES
    private static final StringBuilder vista = new StringBuilder();
    private static final StringBuilder vista2 = new StringBuilder();

    public static void crearJornada() {
        try {
            boolean terminar = true;
            do {
                Jornada j = solicitarDatos();

                boolean comprobante = JornadaDAO.crearJornada(j);
                if (comprobante) {
                    JOptionPane.showMessageDialog(null, "Ya existe la jornada con ese nombre");
                    JornadaDAO.crearJornada(j);
                }
                System.out.println("Jornada con nombre " + j.getNumero() + j.getFecha() +" creado correctamente");
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
    public static Jornada solicitarDatos(){
        int numero = Integer.parseInt(Utilidades.solicitarDato("Nombre", "Teclea el nombre del equipo", "^[A-Z][a-z]+([ -][A-Z][a-z]+)*$"));
        LocalDate fecha = convertirLocalDate(Utilidades.solicitarDato("Fecha de Fundación", "Teclea la fecha de fundación del equipo (dd/MM/yyyy)", "^[0-9]{2}/[0-9]{2}/[0-9]{4}$"));

        return new Jornada(numero,fecha);
    }

    public static LocalDate convertirLocalDate(String fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(fecha, formato);
    }
}
