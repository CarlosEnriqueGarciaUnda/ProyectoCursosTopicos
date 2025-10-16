import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioSesion extends JFrame {

    private JPanel Principal;
    private JPanel panelLoginContent;
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JCheckBox recordarContraseñaCheckBox;
    private JButton siguienteButton;

    class BackgroundPanel extends JPanel {
        private Image image;

        public BackgroundPanel() {
            try {
                image = new ImageIcon(getClass().getResource("/resourses/fondorLogIN.jpg")).getImage();
            } catch (Exception e) {
                System.err.println("No se pudo cargar la imagen de fondo: /resourses/fondorLogIN.jpg");
                setBackground(new Color(255, 192, 203));
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public InicioSesion() {
        setTitle("Inicio de Sesión");

        BackgroundPanel background = new BackgroundPanel();
        background.setLayout(new GridBagLayout());

        Principal.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(150, 150, 150, 200), 5),
                new EmptyBorder(20, 40, 20, 40)
        ));
        Principal.setOpaque(true);
        Principal.setBackground(new Color(255, 255, 255, 220));

        background.add(Principal, new GridBagConstraints());
        setContentPane(background);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 500);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 400));

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarCampos();
            }
        });
    }

    private void createUIComponents() {
        txtContraseña = new JPasswordField();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InicioSesion().setVisible(true);
        });
    }

    private void validarCampos() {
        String usuario = txtUsuario.getText();
        String contraseña = new String(txtContraseña.getPassword());

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un Usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe Ingresar una Contraseña", "Error", JOptionPane.ERROR_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(this, "Acceso Verificado\n" + "¡¡Bienvenido!!", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            Menu_Principal principal = new Menu_Principal();
            principal.abrirVentana();
            dispose();
        }
    }
}