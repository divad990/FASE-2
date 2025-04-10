package Controller;

import javax.swing.*;

public class ModeloController {

    private VistaController vistaController;

    public ModeloController() {
        vistaController = new VistaController(this);

    }

    public VistaController getVistaController() {
        return vistaController;
    }

    public void setVistaController(VistaController vistaController) {
        this.vistaController = vistaController;
    }
}
