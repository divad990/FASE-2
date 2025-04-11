package View;

import Controller.VistaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaLogIn extends JDialog {

    private VistaController vistaController;
    private JPanel panelPricipal;
    private JButton imagenLogIn;
    private JButton logInButton;
    private JPanel panelUsuarioContrasenia;
    private JPanel panerArriba;
    private JPanel panelAbajo;
    private JTextField usuarioField;
    private JTextField contaseniaField;

    public VentanaLogIn(VistaController vistaController) {

        this.vistaController = vistaController;
        setContentPane(panelPricipal);
        setModal(true);
        setSize(400,400);
        setLocationRelativeTo(null);


        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todoCorrecto();
            }
        });
    }

    private void todoCorrecto(){
        try{
            String username = usuarioField.getText();
            boolean encontrado = vistaController.buscarUsuario(username);
            if(!encontrado){
                throw new Exception("Usuario no encontrado");
            }
            String password = contaseniaField.getText();
            boolean encontradoContrasenia = vistaController.buscarUsuarioContrasenia(password);
            System.out.println(encontradoContrasenia);
            if(!encontradoContrasenia){
                throw new Exception("Contraseña no encontradada,");
            }
        }catch(Exception e){

            JOptionPane.showMessageDialog(null, "error, contraseña o usuario incorrecto");
            usuarioField.requestFocus();
            usuarioField.setText("");
            contaseniaField.setText("");
        }

    }
}
