import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Iniciar la aplicación mostrando la ventana de InicioSesion.form.form.form.form.form.form.form.form
        SwingUtilities.invokeLater(() -> {
            new InicioSesion().setVisible(true);
        });
    }
}