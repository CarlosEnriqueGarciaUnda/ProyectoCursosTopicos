import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JFrame {
    private JPanel Principal;
    private JPanel correo;
    private JTextField txtCorreo;
    private JTextField txtContraseña;
    private JCheckBox recordarContraseñaCheckBox;
    private JButton siguienteButton;

    public InicioSesion() {
        setTitle("Inicio de Sesión");
        setContentPane(Principal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //  Bordes (margen interno de todo el panel)
        Principal.setBorder(new EmptyBorder(20, 40, 20, 40));

        //  Tamaño inicial (centrado)
        setSize(800, 500);
        setLocationRelativeTo(null);

        //  Mínimo tamaño al redimensionar
        setMinimumSize(new Dimension(600, 400));
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarCampos();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InicioSesion().setVisible(true);
        });
    }

    private void validarCampos() {
        if(txtCorreo.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Debe ingresar el Correo");
        }else if(txtContraseña.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe Ingresar una Contraseña");
        }else{
            if(txtCorreo.getText().equals("12345678@itoaxaca.edu.mx") && txtContraseña.getText().equals("admin1")){
                JOptionPane.showMessageDialog(null, "Acceso Verificado\n"+ "¡¡Bienvenido!!");
                Menu_Principal principal = new Menu_Principal();
                principal.abrirVentana();
                dispose();
            }else{
                JOptionPane.showMessageDialog(null, "Datos Incorrectos");
                txtCorreo.setText("");
                txtContraseña.setText("");
            }
        }
    }
}
