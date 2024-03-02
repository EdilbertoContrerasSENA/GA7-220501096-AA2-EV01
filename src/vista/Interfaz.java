package vista;

import javax.swing.*;
import controlador.ControladorUsuario;

import java.awt.*;

public class Interfaz extends javax.swing.JFrame{

    private JTextField tfNombre;
    private JTextField tfApellido;
    private JTextField tfIdentificacion;
    private JTextField tfUsuario;
    private JTextField tfContrasena;
    private JTable tbUsuarios;
    private JButton btnAgregar;
    private JButton btnActualizar;
    private JButton btnBorrar;
    private JButton btnLimpiar;
    private JPanel usersPanel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public Interfaz(JFrame parent) {
        //super(parent);
        setTitle("Listar Usuarios");
        setContentPane(usersPanel);
        setMinimumSize(new Dimension(500, 550));
        setLocationRelativeTo(parent);
        // setVisible(true);
    }

    public static void main(String[] args) {
        Interfaz vista = new Interfaz(null);
        ControladorUsuario controlador = new ControladorUsuario(vista);
    }


    // Metodos Getters
    public JTextField getTfNombre() {
        return tfNombre;
    }

    public JTextField getTfApellido() {
        return tfApellido;
    }

    public JTextField getTfIdentificacion() {
        return tfIdentificacion;
    }

    public JTextField getTfUsuario() {
        return tfUsuario;
    }

    public JTextField getTfContrasena() {
        return tfContrasena;
    }

    public JTable getTbUsuarios() {
        return tbUsuarios;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

}
