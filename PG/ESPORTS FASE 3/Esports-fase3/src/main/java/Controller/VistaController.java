package Controller;

import View.VentanaInicio;
import View.VentanaLogIn;

public class VistaController {

    private ModeloController modeloController;
    private VentanaInicio vInicio;
    private VentanaLogIn vLogin;

    public VistaController(ModeloController modeloController) {

        this.modeloController = modeloController;

        vInicio = new VentanaInicio(this);
        vInicio.setVisible(true);
    }
    public boolean buscarUsuario(String username) throws Exception {
        return modeloController.buscarUsuario(username);
    }
    public boolean buscarUsuarioContrasenia(String password) throws Exception {
        return modeloController.buscarUsuarioContrasenia(password);
    }
    public void mostrarAccesoLogIn()
    {
        vLogin = new VentanaLogIn(this);
        vLogin.setVisible(true);
        vInicio.dispose();
    }

}
