package Controller;

import Model.Usuario;
import Model.UsuarioDAO;
import Utils.BaseDatos;

import javax.swing.*;

public class ModeloController {

    private VistaController vistaController;

    private Usuario usuario;
    private UsuarioController usuarioController;
    private UsuarioDAO usuarioDAO;

    public ModeloController() {
        usuarioController = new UsuarioController();
    }

    public VistaController getVistaController() {
        return vistaController;
    }

    public boolean buscarUsuario(String username) throws Exception {
        boolean encontrado = false;
        usuario = usuarioController.buscarUsuario(username);
        if (usuario == null) {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }else{
            encontrado = true;
        }
        return encontrado;
    }
    public boolean buscarUsuarioContrasenia(String password) throws Exception {
        return password.equals(usuario.getPasswd());
    }
    public void setVistaController(VistaController vistaController) {
        this.vistaController = vistaController;
    }
}
