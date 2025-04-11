package Controller;

import Exceptions.CampoVacioException;
import Utils.*;
import View.JugadoresGestion;

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
}
