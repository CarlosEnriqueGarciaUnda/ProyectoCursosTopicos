import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu_Principal {
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
    private JPanel panelExperiencia2;
    private JTextField textField2;
    private JTextField textField3;
    private JButton imgButton;
    private JButton imgButton1;
    private JTextField textField4;
    private JComboBox comboBox5;
    private JButton agregarALaTablaButton;
    private JButton actualizarButton1;
    private JScrollPane scpExperiencia;
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
    private DefaultTableModel tablaActividad;
    private DefaultTableModel tablaRegistros;
    private DefaultTableModel tablaExperiencia;
    private DefaultTableModel tablaMateria;

    public Menu_Principal() {
        initComponents();

        btnMenu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbPanel.setSelectedIndex(1);
            }
        });
        btnMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbPanel.setSelectedIndex(2);
            }
        });
        btnMenu13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbPanel.setSelectedIndex(3);
            }
        });
        btnBuscarArch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Buscando Archivo\n"+"¡Por favor Espere!");
            }
        });
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Actividad Registrada");
            }
        });
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbPanel.setSelectedIndex(0);
            }
        });
        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbPanel.setSelectedIndex(2);
            }
        });
        actualizarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Dato Actualizado");
            }
        });
        agregarALaTablaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Dato Agregada");
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Instructor Actualizado");
            }
        });
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Instructor Agregado");
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Instructor Eliminado");
            }
        });
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Datos Editados");
            }
        });
        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbPanel.setSelectedIndex(0);
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbPanel.setSelectedIndex(2);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu_Principal");
        frame.setContentPane(new Menu_Principal().Panel_Admi);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Metodo para inicializar las configuraciones de las tablas
    private void initComponents(){
        configuracionTablaActividad();
        configuracionTablaRegistrosBD();
        configuracionTablaExperiencia();
        configuracionTablaMateria();
    }

    private void configuracionTablaActividad() {
        // TODO: place custom component creation code here
        //this.tablaModeloClientes = new DefaultTableModel(0, 4);
        // Evitamos la edicion de los valores de las celdas de la tabla
        this.tablaActividad = new DefaultTableModel(10,2){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabeceros = {"Actividad", "Porcentaje"};
        this.tablaActividad.setColumnIdentifiers(cabeceros);
        this.tbActividad.setModel(tablaActividad);
        // Restringimos la seleccion de la tabla a un solo registro
        this.tbActividad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Cargar listado de actividades
        // ▼▼▼ CÓDIGO PARA ESTILIZAR EL CABECERO CON RENDERER ▼▼▼

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                // Llama al método padre para obtener el componente base (un JLabel)
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Aplica tus estilos personalizados
                c.setBackground(new Color(82, 83, 83)); // Fondo
                c.setForeground(Color.WHITE);                   // Letras blancas
                c.setFont(new Font("Segoe UI", Font.BOLD, 16));  // Fuente más moderna

                // Centra el texto del cabecero
                setHorizontalAlignment(JLabel.CENTER);

                // Agrega un borde para que se vea mejor
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));

                return c;
            }
        };
        // 2. Aplica tu renderizador personalizado al cabecero de la tabla
        tbActividad.getTableHeader().setDefaultRenderer(headerRenderer);
    }

    private void configuracionTablaRegistrosBD() {
        // TODO: place custom component creation code here
        //this.tablaModeloClientes = new DefaultTableModel(0, 4);
        // Evitamos la edicion de los valores de las celdas de la tabla
        this.tablaRegistros = new DefaultTableModel(10,5){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabeceros = {"Nombre", "CURP", "RFC", "Nivel Academico", "Especialidad"};
        this.tablaRegistros.setColumnIdentifiers(cabeceros);
        this.tbRegistros.setModel(tablaRegistros);
        // Restringimos la seleccion de la tabla a un solo registro
        this.tbRegistros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Cargar listado de actividades
        // ▼▼▼ CÓDIGO PARA ESTILIZAR EL CABECERO CON RENDERER ▼▼▼

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                // Llama al método padre para obtener el componente base (un JLabel)
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Aplica tus estilos personalizados
                c.setBackground(new Color(82, 83, 83)); // Fondo
                c.setForeground(Color.WHITE);                   // Letras blancas
                c.setFont(new Font("Segoe UI", Font.BOLD, 16));  // Fuente más moderna

                // Centra el texto del cabecero
                setHorizontalAlignment(JLabel.CENTER);

                // Agrega un borde para que se vea mejor
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));

                return c;
            }
        };
        // 2. Aplica tu renderizador personalizado al cabecero de la tabla
        tbRegistros.getTableHeader().setDefaultRenderer(headerRenderer);
    }

    private void configuracionTablaExperiencia() {
        // TODO: place custom component creation code here
        //this.tablaModeloClientes = new DefaultTableModel(0, 4);
        // Evitamos la edicion de los valores de las celdas de la tabla
        this.tablaExperiencia = new DefaultTableModel(10,4){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabeceros = {"Nombre del Proyecto", "Fecha Inicio", "Fecha Fin", "Actividades"};
        this.tablaExperiencia.setColumnIdentifiers(cabeceros);
        this.tbExperiencia.setModel(tablaExperiencia);
        // Restringimos la seleccion de la tabla a un solo registro
        this.tbExperiencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Cargar listado de actividades
        // ▼▼▼ CÓDIGO PARA ESTILIZAR EL CABECERO CON RENDERER ▼▼▼

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                // Llama al método padre para obtener el componente base (un JLabel)
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Aplica tus estilos personalizados
                c.setBackground(new Color(82, 83, 83)); // Fondo
                c.setForeground(Color.WHITE);                   // Letras blancas
                c.setFont(new Font("Segoe UI", Font.BOLD, 16));  // Fuente más moderna

                // Centra el texto del cabecero
                setHorizontalAlignment(JLabel.CENTER);

                // Agrega un borde para que se vea mejor
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));

                return c;
            }
        };
        // 2. Aplica tu renderizador personalizado al cabecero de la tabla
        tbExperiencia.getTableHeader().setDefaultRenderer(headerRenderer);
    }

    private void configuracionTablaMateria() {
        // TODO: place custom component creation code here
        //this.tablaModeloClientes = new DefaultTableModel(0, 4);
        // Evitamos la edicion de los valores de las celdas de la tabla
        this.tablaMateria = new DefaultTableModel(23,4){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabeceros = {"Materia", "Periodo", "Instructor", "Experiencia"};
        this.tablaMateria.setColumnIdentifiers(cabeceros);
        this.tbMateria.setModel(tablaMateria);
        // Restringimos la seleccion de la tabla a un solo registro
        this.tbMateria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Cargar listado de actividades
        // ▼▼▼ CÓDIGO PARA ESTILIZAR EL CABECERO CON RENDERER ▼▼▼

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                // Llama al método padre para obtener el componente base (un JLabel)
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Aplica tus estilos personalizados
                c.setBackground(new Color(82, 83, 83)); // Fondo
                c.setForeground(Color.WHITE);                   // Letras blancas
                c.setFont(new Font("Segoe UI", Font.BOLD, 16));  // Fuente más moderna

                // Centra el texto del cabecero
                setHorizontalAlignment(JLabel.CENTER);

                // Agrega un borde para que se vea mejor
                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.WHITE));

                return c;
            }
        };
        // 2. Aplica tu renderizador personalizado al cabecero de la tabla
        tbMateria.getTableHeader().setDefaultRenderer(headerRenderer);
    }

    public void abrirVentana() {
        JFrame frame = new JFrame("Menú Principal");
        frame.setContentPane(this.Panel_Admi); // Usa el panel de ESTA instancia

        // MUY IMPORTANTE: Usa DISPOSE_ON_CLOSE si esta no es la ventana que cierra toda la app.
        // Si esta es la ventana principal, puedes dejar EXIT_ON_CLOSE.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.pack(); // Ajusta el tamaño de la ventana a los componentes
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        frame.setVisible(true);
    }

    //Metodo para
    public JPanel getMenu_Principal() {
        return Panel_Admi;
    }
}
