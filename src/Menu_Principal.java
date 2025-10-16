import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Menu_Principal {
    private JComboBox comboBoxFormacion; // Para Licenciatura, Maestría, Doctorado
    private JTextField textFieldInstitucion; // Para Institución
    private JTextField textFieldTitulacion;  // Para Titulación (Año)
    private JTextField textFieldCedula;
    private JPanel Panel_Admi;
    private JPanel Panel_Superior;
    private JButton btnMenu1;
    private JButton btnMenu2;
    private JButton btnMenu13;
    private JPanel Panel_Central;
    private JPanel Panel_Izquierdo;
    private JTabbedPane tbPanel;
    private JPanel panelDatos;
    private JComboBox cboPeriodo;
    private JTextField txtNomCurso;
    private JComboBox cboHoraI;
    private JComboBox cboHoraF;
    private JCheckBox chbViernes;
    private JTextField txtArchivoP;
    private JButton btnBuscarArch;
    private JPanel panelRegistro;
    private JPanel panelExperiencia;
    private JTextField txtClaveCurso;
    private JComboBox comboBox1;
    private JTextField txtActividad;
    private JTextField txtPorcentaje;
    private JButton btnActualizarAct;
    private JButton btnRegistro;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnAceptar;
    private JButton btnRegistrarD;
    private JButton btnRegresar;
    private JButton btnSiguiente;
    private JScrollPane scpActividad;
    private JTable tbActividad;
    private JPanel Bienvenida;
    private JTable tbRegistros;
    private JScrollPane scpRegistros;
    private JComboBox comboBox2;
    private JTextField textField1;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton eliminarButton;
    private JButton regresarButton;
    private JButton editarButton;
    private JButton siguienteButton;
    private JButton cancelarButton;
    private JButton actualizarButton;
    private JButton agregarButton;
    private JCheckBox lunesCheckBox;
    private JCheckBox martesCheckBox;
    private JCheckBox miercolesCheckBox;
    private JCheckBox juevesCheckBox;
    private JPanel panelCheck;
    private JTabbedPane tabbedPane1;
    private JPanel panelExperiencia1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton agregarALaTablaButton;
    private JButton actualizarButton1;
    private JTable tbExperiencia;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTable tbMateria;
    private JScrollPane scpMateria;
    private JPanel panelExperiencia2;
    private JComboBox comboBox5;
    private JButton imgButton;
    private JButton imgButton1;
    private JScrollPane scpExperiencia;

    // Modelos de tablas
    private DefaultTableModel tablaActividad;
    private DefaultTableModel tablaRegistros;
    private DefaultTableModel tablaExperiencia;
    private DefaultTableModel tablaMateria;

    class BackgroundPanelMenu extends JPanel {
        private Image image;
        private String welcomeText;

        public BackgroundPanelMenu(String imagePath, String text) {
            this.welcomeText = text;
            setLayout(new GridBagLayout());
            try {
                image = new ImageIcon(getClass().getResource(imagePath)).getImage();
            } catch (Exception e) {
                System.err.println("No se pudo cargar la imagen de fondo: " + imagePath);
                setBackground(new Color(224, 224, 224));
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image != null) {
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }

            if (welcomeText != null) {
                g.setColor(new Color(30, 30, 30));
                g.setFont(new Font("Segoe UI", Font.BOLD, 48));
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(welcomeText)) / 2;
                int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
                g.drawString(welcomeText, x, y);
            }
        }
    }


    public Menu_Principal() {
        initComponents();
        setupWelcomePanel();


        if (btnMenu1 != null) btnMenu1.setText("Instructores");
        if (btnMenu2 != null) btnMenu2.setText("Cursos");
        if (btnMenu13 != null) btnMenu13.setText("Asistencias");


        if (btnMenu1 != null) btnMenu1.addActionListener(e -> tbPanel.setSelectedIndex(1));

        if (btnMenu2 != null) btnMenu2.addActionListener(e -> tbPanel.setSelectedIndex(2));

        if (btnMenu13 != null) btnMenu13.addActionListener(e -> tbPanel.setSelectedIndex(3));


        if (btnBuscarArch != null) {
            btnBuscarArch.addActionListener(e -> JOptionPane.showMessageDialog(null, "Buscando Archivo\n"+"¡Por favor Espere!"));
        }

        if (btnRegistro != null) {
            btnRegistro.addActionListener(e -> {
                if (txtActividad.getText().isEmpty() || txtPorcentaje.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe rellenar Actividad y Porcentaje para registrar", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    tablaActividad.addRow(new Object[]{txtActividad.getText(), txtPorcentaje.getText()});
                    txtActividad.setText("");
                    txtPorcentaje.setText("");
                    JOptionPane.showMessageDialog(null, "Actividad Registrada");
                }
            });
        }


        if (btnRegresar != null) {
            btnRegresar.addActionListener(e -> tbPanel.setSelectedIndex(tbPanel.getSelectedIndex() - 1));
        }

        if (btnSiguiente != null) {
            btnSiguiente.addActionListener(e -> tbPanel.setSelectedIndex(tbPanel.getSelectedIndex() + 1));
        }

        if (regresarButton != null) {
            regresarButton.addActionListener(e -> tbPanel.setSelectedIndex(tbPanel.getSelectedIndex() - 1));
        }

        if (siguienteButton != null) {
            siguienteButton.addActionListener(e -> tbPanel.setSelectedIndex(tbPanel.getSelectedIndex() + 1));
        }

        // Lógica de Agregar Instructor (En Pestaña Instructores)
        if (agregarButton != null) {
            agregarButton.addActionListener(e -> {
                // Validación de campos mínimos (Nombre, CURP, RFC)
                if (textField5.getText().isEmpty() || textField6.getText().isEmpty() || textField7.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Rellene Nombre, CURP y RFC para agregar al Instructor", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Captura los valores (Asumiendo los bindings de la tabla anterior)
                    String nombre = textField5.getText();
                    String curp = textField6.getText();
                    String rfc = textField7.getText();
                    String nivelAcademico = textField8.getText(); // O del JComboBox si lo mapeaste diferente
                    String especialidad = textField9.getText();

                    // CAPTURA DE DATOS ACADÉMICOS
                    // Nota: Usa el binding real de tu JComboBox (ej: comboBox2 o comboBox3)
                    String formacionAcademica = (String) comboBoxFormacion.getSelectedItem();
                    String institucion = textFieldInstitucion.getText();
                    String titulacion = textFieldTitulacion.getText();
                    String cedula = textFieldCedula.getText();

                    // AÑADIMOS 9 CAMPOS A LA TABLA
                    tablaRegistros.addRow(new Object[]{
                            nombre, curp, rfc, nivelAcademico, especialidad,
                            formacionAcademica, institucion, titulacion, cedula
                    });

                    JOptionPane.showMessageDialog(null, "Instructor Agregado con Datos Académicos");

                    // Limpiar campos después de agregar (Asegúrate de limpiar todos los campos relevantes)
                    textField5.setText(""); textField6.setText(""); textField7.setText("");
                    textField8.setText(""); textField9.setText("");

                    // Limpiar campos académicos
                    // comboBoxFormacion.setSelectedIndex(0); // Si quieres resetear el combo
                    textFieldInstitucion.setText("");
                    textFieldTitulacion.setText("");
                    textFieldCedula.setText("");
                }
            });
        }

        if (agregarALaTablaButton != null) {
            agregarALaTablaButton.addActionListener(e -> {
                if(textField2.getText().isEmpty() || textField3.getText().isEmpty() || textField4.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Rellene todos los campos de Experiencia", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    tablaExperiencia.addRow(new Object[]{textField2.getText(), textField3.getText(), textField4.getText(), "Ver actividades"});
                    JOptionPane.showMessageDialog(null, "Experiencia Agregada");
                    textField2.setText(""); textField3.setText(""); textField4.setText("");
                }
            });
        }

        if (actualizarButton1 != null) actualizarButton1.addActionListener(e -> JOptionPane.showMessageDialog(null, "Dato Actualizado"));
        if (actualizarButton != null) actualizarButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Instructor Actualizado"));
        if (eliminarButton != null) eliminarButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Instructor Eliminado"));
        if (editarButton != null) editarButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Datos Editados"));
        if (cancelarButton != null) cancelarButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Acción Cancelada"));
    }

    private void setupWelcomePanel() {
        if (Bienvenida != null) {
            Bienvenida.setLayout(new BorderLayout());
            Bienvenida.add(new BackgroundPanelMenu("/resourses/ImagenMenuPrincipal.png", "¡Bienvenido!"), BorderLayout.CENTER);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Menu_Principal().abrirVentana();
        });
    }

    // Método para abrir la ventana (TAMAÑO GRANDE)
    public void abrirVentana() {
        JFrame frame = new JFrame("Menú Principal - Cursos Intersemestrales");
        frame.setContentPane(this.Panel_Admi);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setPreferredSize(new Dimension(1200, 750));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initComponents(){
        configuracionTablaActividad();
        configuracionTablaRegistrosBD();
        configuracionTablaExperiencia();
        configuracionTablaMateria();
    }

    private void configuracionTablaActividad() {
        this.tablaActividad = new DefaultTableModel(0,2){
            @Override
            public boolean isCellEditable(int row, int column){ return false; }
        };
        String[] cabeceros = {"Nombre", "CURP", "RFC", "Nivel Academico", "Especialidad", "Correo Electrónico", "Contraseña"};
        this.tablaActividad.setColumnIdentifiers(cabeceros);
        if (this.tbActividad != null) {
            this.tbActividad.setModel(tablaActividad);

            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                                                               boolean isSelected, boolean hasFocus,
                                                               int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(new Color(69, 90, 100));
                    c.setForeground(Color.WHITE);
                    c.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    setHorizontalAlignment(JLabel.CENTER);
                    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
                    return c;
                }
            };
            this.tbActividad.getTableHeader().setDefaultRenderer(headerRenderer);
        }
    }

    private void configuracionTablaRegistrosBD() {
        this.tablaRegistros = new DefaultTableModel(0, 9) {
            @Override
            public boolean isCellEditable(int row, int column){ return false; }
        };

        String[] cabeceros = {"Nombre", "CURP", "RFC", "Nivel Academico", "Especialidad", "Formación Académica", "Institución", "Titulación (Año)", "Cédula"};        this.tablaRegistros.setColumnIdentifiers(cabeceros);

        if (this.tbRegistros != null) {
            this.tbRegistros.setModel(tablaRegistros);
            this.tbRegistros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                                                               boolean isSelected, boolean hasFocus,
                                                               int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(new Color(69, 90, 100)); // #455A64
                    c.setForeground(Color.WHITE);
                    c.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    setHorizontalAlignment(JLabel.CENTER);
                    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
                    return c;
                }
            };
            this.tbRegistros.getTableHeader().setDefaultRenderer(headerRenderer);
        }
    }

    private void configuracionTablaExperiencia() {
        this.tablaExperiencia = new DefaultTableModel(0,4){
            @Override
            public boolean isCellEditable(int row, int column){ return false; }
        };
        String[] cabeceros = {"Nombre del Proyecto", "Fecha Inicio", "Fecha Fin", "Actividades"};
        this.tablaExperiencia.setColumnIdentifiers(cabeceros);
        if (this.tbExperiencia != null) {
            this.tbExperiencia.setModel(tablaExperiencia);

            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                                                               boolean isSelected, boolean hasFocus,
                                                               int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(new Color(69, 90, 100)); // #455A64
                    c.setForeground(Color.WHITE);
                    c.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    setHorizontalAlignment(JLabel.CENTER);
                    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
                    return c;
                }
            };
            this.tbExperiencia.getTableHeader().setDefaultRenderer(headerRenderer);
        }
    }

    private void configuracionTablaMateria() {
        this.tablaMateria = new DefaultTableModel(0,4){
            @Override
            public boolean isCellEditable(int row, int column){ return false; }
        };
        String[] cabeceros = {"Materia", "Periodo", "Instructor", "Experiencia"};
        this.tablaMateria.setColumnIdentifiers(cabeceros);
        if (this.tbMateria != null) {
            this.tbMateria.setModel(tablaMateria);

            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                                                               boolean isSelected, boolean hasFocus,
                                                               int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(new Color(69, 90, 100));
                    c.setForeground(Color.WHITE);
                    c.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    setHorizontalAlignment(JLabel.CENTER);
                    setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));
                    return c;
                }
            };
            this.tbMateria.getTableHeader().setDefaultRenderer(headerRenderer);
        }
    }
}