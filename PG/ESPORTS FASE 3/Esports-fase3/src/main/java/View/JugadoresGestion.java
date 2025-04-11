package View;

import Controller.VistaController;
import Exceptions.CampoVacioException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JugadoresGestion extends JFrame {
    private JComboBox cbOpciones;
    private JTextField tfDni;
    private JTextField tfNombre;
    private JTextField tfNickname;
    private JTextField tfNacionalidad;
    private JTextField tfApellido;
    private JTextField tfFechaNacimiento;
    private JTextField tfSueldo;
    private JButton bAceptar;
    private JButton bCancelar;
    private JPanel pPrincipal;
    private JComboBox cmRol;
    private JLabel a1;
    private JLabel a2;
    private JLabel a3;
    private JLabel a4;
    private JLabel a5;
    private JLabel a7;
    private JLabel a8;
    private JLabel e1;
    private JLabel e2;
    private JLabel e3;
    private JLabel e4;
    private JLabel e5;
    private JLabel e6;
    private JLabel e7;
    private JLabel e8;
    private JPanel pDatos;
    private JLabel jlDni;
    private JPanel pDni;

    private VistaController vistaController;

    private JLabel[] labels = {a1, a2, a3, a4, a5, a7, a8, e1, e2, e3, e4, e5, e6, e7, e8};
    private boolean camposCompletos = false;

    //TODO Funcionalidad botones, validación de datos. Corregir fallos ortográficos avisos rojos

    public JugadoresGestion(VistaController vistaController) {
        this.vistaController = vistaController;

        for (JLabel label : labels) {
            label.setVisible(false);
        }
        bAceptar.setEnabled(false);
        pDatos.setVisible(false);
        pDni.setVisible(false);

        setContentPane(pPrincipal);
        setSize(600, 600);
        setTitle("Gestión de Jugadores");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        bAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        bCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        pPrincipal.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        cbOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (!vistaController.validarDato(tfDni.getText(), "[0-9]{8}[A-Za-z]")){
                        a1.setVisible(true);
                    }
                } catch (CampoVacioException ex) {
                    e1.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                validarCampos();
                if (!cbOpciones.getSelectedItem().toString().equals("Crear Jugador")) {
                    if (vistaController.validarDni(tfDni.getText())) {
                        if (cbOpciones.getSelectedItem().toString().equals("Modificar Jugador")) {
                            pDatos.setVisible(true);
                        } else {
                            tfDni.setForeground(Color.GREEN);
                        }

                    } else {
                        tfDni.setForeground(Color.red);
                        JOptionPane.showMessageDialog(null, "No existe un jugador con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (!vistaController.validarDato(tfNombre.getText(), "^[a-zA-Z]{1,25}$")){
                        a2.setVisible(true);
                    }
                } catch (CampoVacioException ex) {
                    e2.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                validarCampos();
            }
        });
        tfApellido.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (!vistaController.validarDato(tfApellido.getText(), "^[a-zA-Z]{1,50}$")){
                        a3.setVisible(true);
                    }
                } catch (CampoVacioException ex) {
                    e3.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                validarCampos();
            }
        });
        tfNickname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (!vistaController.validarDato(tfNickname.getText(), "^[a-zA-Z0-9._]{1,50}$")){
                        a4.setVisible(true);
                    }
                } catch (CampoVacioException ex) {
                    e4.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                validarCampos();
            }
        });
        tfNacionalidad.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (!vistaController.validarDato(tfNacionalidad.getText(), "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\\\s]{1,50}$")){
                        a5.setVisible(true);
                    }
                } catch (CampoVacioException ex) {
                    e5.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                validarCampos();
            }
        });
        tfFechaNacimiento.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (!vistaController.validarDato(tfFechaNacimiento.getText(), "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$")){
                        a7.setVisible(true);
                    }
                } catch (CampoVacioException ex) {
                    e7.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                validarCampos();
            }
        });
        tfSueldo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                try {
                    if (!vistaController.validarDato(tfSueldo.getText(), "^\\d{1,6}(\\,\\d{1,2})?$")){
                        a8.setVisible(true);
                    }
                } catch (CampoVacioException ex) {
                    e8.setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                validarCampos();
            }
        });
        tfDni.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                a1.setVisible(false);
                e1.setVisible(false);
            }
        });
        tfNombre.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                a2.setVisible(false);
                e2.setVisible(false);
            }
        });
        tfApellido.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                a3.setVisible(false);
                e3.setVisible(false);
            }
        });
        tfNickname.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                a4.setVisible(false);
                e4.setVisible(false);
            }
        });
        tfNacionalidad.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                a5.setVisible(false);
                e5.setVisible(false);
            }
        });
        tfFechaNacimiento.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                a7.setVisible(false);
                e7.setVisible(false);
            }
        });
        tfSueldo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                a8.setVisible(false);
                e8.setVisible(false);
            }
        });

        cbOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbOpciones.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Debes seleccionar una opción");
                } else if (cbOpciones.getSelectedItem().equals("Crear Jugador")) {
                    pDatos.setVisible(true);
                    pDni.setVisible(true);
                } else if (cbOpciones.getSelectedItem().equals("Modificar Jugador")) {
                    pDatos.setVisible(false);
                    pDni.setVisible(true);
                } else if (cbOpciones.getSelectedItem().equals("Eliminar Jugador")) {
                    pDatos.setVisible(false);
                    pDni.setVisible(true);
                }
            }
        });
    }
    //TODO Externalizar los JOption es labor del view o del controller???
    private void onOK() {
       if (cbOpciones.getSelectedItem().equals("Crear Jugador")) {
           if (vistaController.validarDni(tfDni.getText())){
               JOptionPane.showMessageDialog(this, "Ya existe un Jugador con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
           } else if(vistaController.validarNickname(tfNickname.getText())){
               JOptionPane.showMessageDialog(this, "El nickname introducido ya está en uso", "Error", JOptionPane.ERROR_MESSAGE);
           } else {
               vistaController.crearJugador(tfDni.getText(), tfNombre.getText(), tfApellido.getText(), tfNickname.getText(), tfNacionalidad.getText(), cmRol.getSelectedItem().toString(), tfFechaNacimiento.getText(), tfSueldo.getText());
               JOptionPane.showMessageDialog(this, "Jugador con nif "+tfDni.getText()+" creado correctamente", "Jugador Creado", JOptionPane.INFORMATION_MESSAGE );
           }
       } else if (cbOpciones.getSelectedItem().equals("Modificar Jugador")) {
            if (vistaController.validarNickname(tfNickname.getText())){
                JOptionPane.showMessageDialog(this, "El nickname introducido ya está en uso", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                vistaController.modificarJugador(tfDni.getText(), tfNombre.getText(), tfApellido.getText(), tfNickname.getText(), tfNacionalidad.getText(), cmRol.getSelectedItem().toString(), tfFechaNacimiento.getText(), tfSueldo.getText());
                JOptionPane.showMessageDialog(this, "Jugador con nif "+tfDni.getText()+" modificado correctamente", "Jugador Creado", JOptionPane.INFORMATION_MESSAGE );
            }
       } else if (cbOpciones.getSelectedItem().equals("Eliminar Jugador")) {
            vistaController.eliminarJugador(tfDni.getText());
            JOptionPane.showMessageDialog(this,"Jugador con nif "+tfDni.getText()+" eliminado correctamente", "Jugador Eliminado", JOptionPane.INFORMATION_MESSAGE );
       }
   }


    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void validarCampos() {
        boolean todosCompletos = !tfDni.getText().trim().isEmpty() &&
                !tfNombre.getText().trim().isEmpty() &&
                !tfApellido.getText().trim().isEmpty() &&
                !tfNickname.getText().trim().isEmpty() &&
                !tfNacionalidad.getText().trim().isEmpty() &&
                !tfFechaNacimiento.getText().trim().isEmpty() &&
                !tfSueldo.getText().trim().isEmpty() &&
                !cmRol.getSelectedItem().toString().isEmpty();

        // Verificar si hay algún JLabel de error visible
        boolean hayErrores = false;
        for (JLabel label : labels) {
            if (label.isVisible()) {
                hayErrores = true;
                break;
            }
        }

        // Habilitar el botón solo si todos los campos están completos y no hay errores
        bAceptar.setEnabled(todosCompletos && !hayErrores);
    }

}


