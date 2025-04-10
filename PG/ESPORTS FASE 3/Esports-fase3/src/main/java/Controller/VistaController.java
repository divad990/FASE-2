package Controller;

import Exceptions.CampoVacioException;
import Utils.*;

public class VistaController {

    private ModeloController modeloController;

    public VistaController(ModeloController modeloController) {
        this.modeloController = modeloController;
    }

    public boolean validarDni(String dato, String expresionRegular) throws CampoVacioException {
        return Utilidades.validarDato(dato, expresionRegular);
    }



}
