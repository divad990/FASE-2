package Controladores;

import Modelo.Jugador;

import javax.swing.*;

public class JugadorController {

    public static void crearJugador(){
        try {
            boolean terminar = true;
            do {
                Jugador j = solicitarDatos();
                JugadorDAO.crearJugador(j);
                System.out.println("Jugador con nombre " + j.getNombre() + " creado correctamente");
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
        String nombre = Utilidades.solicitarDato("Nombre", "Teclea el nombre del cliente","^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        String apellidos = Utilidades.solicitarDato("Apellido","Teclea la el apellido del cliente","^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        String dni = Utilidades.solicitarDato("DNI","Teclea el DNI del cliente","^[0-9]{8}[A-Z]$");
        String direccion = Utilidades.solicitarDato("Direccion","Teclea la direccion del cliente","^[A-Z][a-z]+([ -][A-Z][a-z]+)*$");
        int telefono = Integer.parseInt(Utilidades.solicitarDato("Telefono","Teclea el telefono del cliente","^[0-9]{9}$"));
        String email = Utilidades.solicitarDato("Email","Teclea el email del cliente","^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");

        return new Jugador(nombre,apellidos,dni,direccion,telefono,email,null);
    }

}
