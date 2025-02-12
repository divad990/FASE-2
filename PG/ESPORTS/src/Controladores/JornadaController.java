package Controladores;

import Modelo.*;
import Utils.Utilidades;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JornadaController {
    //INICIO VARIABLES

    public static void crearJornada() {
        try {
            //Comprobar restricciones
            //1. El numero de equipos tiene que ser par.
            //2. Los equipos estan formados por 6 juagadores.
            //3. El salario mínimo tiene que ser mayor al SMI.
        } catch (Exception e) {

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
