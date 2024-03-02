package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.Interfaz;

public class ControladorUsuario implements ActionListener {

    // Instancias
    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    Interfaz vista = new Interfaz(null);
    DefaultTableModel modeloTabla = new DefaultTableModel();
    
    // Variable globales
    private int id;
    private String nombre;
    private String apellido;
    private double identificacion;
    private String user;
    private String password;

    public ControladorUsuario(Interfaz vista) {
        this.vista = vista;

        // vista.setExtendedState(JFrame.NORMAL);
        vista.setVisible(true);
        agregarEventos();
        listarTabla();
        // System.out.println("Entro aqui");
    }

    private void agregarEventos() {
        //Acciones cuando el botón sea oprimido
        vista.getBtnAgregar().addActionListener(this);
        vista.getBtnActualizar().addActionListener(this);
        vista.getBtnBorrar().addActionListener(this);
        vista.getBtnLimpiar().addActionListener(this);
        vista.getTbUsuarios().addMouseListener(new MouseAdapter() {
            //Creamos el método
            public void mouseClicked(MouseEvent e) {
                llenarCampos(e);
            }
        });

    }

    private void listarTabla() {
        String[] titulos = new String[]{"Id", "Nombre", "Apellido", "Identificaciòn", "Usuario", "Contraseña"};
        modeloTabla = new DefaultTableModel(titulos, 0);
        List<Usuario> listaUsuarios = usuarioDAO.listar();
        for (Usuario usuario : listaUsuarios) {
            modeloTabla.addRow(new Object[]{
                    usuario.getId(),
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getIdentificacion(),
                    usuario.getUser(),
                    usuario.getPassword()
            });
        }
        vista.getTbUsuarios().setModel(modeloTabla);
        vista.getTbUsuarios().setPreferredSize(new Dimension(350, modeloTabla.getRowCount() * 16));
    }

    private void llenarCampos(MouseEvent e) {
        JTable target = (JTable) e.getSource();
        vista.getTfNombre()
                .setText(vista.getTbUsuarios().getModel()
                        .getValueAt(target.getSelectedRow(), 1)
                        .toString());  // para el nombre
        vista.getTfApellido()
                .setText(vista.getTbUsuarios().getModel()
                        .getValueAt(target.getSelectedRow(), 2)
                        .toString());  // para el apellido
        vista.getTfIdentificacion()
                .setText(vista.getTbUsuarios().getModel()
                        .getValueAt(target.getSelectedRow(), 3)
                        .toString());  // para la identificacion
        vista.getTfUsuario()
                .setText(vista.getTbUsuarios().getModel()
                        .getValueAt(target.getSelectedRow(), 4)
                        .toString());  // para el usuario
        vista.getTfContrasena()
                .setText(vista.getTbUsuarios().getModel()
                        .getValueAt(target.getSelectedRow(), 5)
                        .toString());  // para la contraseña
    }

    //-------------------Validar Formulario------------
    private boolean validarDatos() {        
        if (       "".equals(vista.getTfNombre().getText())
                || "".equals(vista.getTfApellido().getText())
                || "".equals(vista.getTfIdentificacion().getText())
                || "".equals(vista.getTfUsuario().getText())
                || "".equals(vista.getTfContrasena().getText())) {
            JOptionPane.showMessageDialog(null, "Los campos no pueden ser vacios",
                     "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean cargarDatos(){
        try {
            nombre = vista.getTfNombre().getText();
            apellido = vista.getTfApellido().getText();
            identificacion = Double.parseDouble(vista.getTfIdentificacion().getText());
            user = vista.getTfUsuario().getText();
            password = vista.getTfContrasena().getText();
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                    "El campo Identificacion debe ser númerico"
            ,"error", JOptionPane.ERROR);
            System.out.println("Error al cargar los Datos " + e);
            return false;
        }       
    }
    
    private void limpiarCampos(){
        vista.getTfNombre().setText("");
        vista.getTfApellido().setText("");
        vista.getTfIdentificacion().setText("");
        vista.getTfUsuario().setText("");
        vista.getTfContrasena().setText("");
        id = 0;
        nombre = "";
        apellido = "";
        identificacion = 0;
        user = "";
        password = "";
    }
    
    private void agregarProducto(){
        try {
            if(validarDatos()){
                if(cargarDatos()){
                    Usuario usuario = new Usuario(nombre, apellido, identificacion, user, password);
                    usuarioDAO.agregar(usuario);
                    JOptionPane.showMessageDialog(null, "Registro agregado con éxito");
                    limpiarCampos();
                }
            }
            
        } catch (Exception e) {
            System.out.println("Error al Agregar(C)");
        }finally{
            listarTabla();
        }
    }
    //--------------------------------------------------
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getBtnAgregar()){
            agregarProducto();
        }

        if(ae.getSource() == vista.getBtnLimpiar()){
            limpiarCampos();
        }

    }
}
