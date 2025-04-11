package Controller;

import Model.Usuario;
import Model.UsuarioDAO;
import Utils.BaseDatos;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO(BaseDatos.getEm(),BaseDatos.getT());
    }

    public Usuario buscarUsuario(String username) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario = usuarioDAO.buscar(usuario);
        return usuario;
    }
}
