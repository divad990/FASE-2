package Controller;

import Exceptions.CampoVacioException;
import Utils.*;

public class VistaController {

    private ModeloController modeloController;

    public VistaController() {
        this.modeloController = new ModeloController();
    }

    public boolean validarDni(String dato, String expresionRegular) throws CampoVacioException {
        return Utilidades.validarDato(dato, expresionRegular);
    }
    public void iniciarGestionJugadores() {
        GestionJugadores gestionJugadores = new GestionJugadores(this);
        gestionJugadores.setVisible(true); //Hace visible la ventana
        gestionJugadores.setLocationRelativeTo(null); //Centra la ventana
    }



}
