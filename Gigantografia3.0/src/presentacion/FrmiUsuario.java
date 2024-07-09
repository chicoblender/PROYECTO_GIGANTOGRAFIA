package presentacion;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import entidades.Rol;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.UsuarioControl;
import org.apache.commons.validator.routines.EmailValidator;
import java.sql.Date;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class FrmiUsuario extends javax.swing.JInternalFrame {

    //atributos
    private final UsuarioControl CONTROL;
    private String accion;
    private String emailAnt;
    
    private String rutaDestino;
    private final String DIRECTORIO="src/files/usuarios/";
    private String imagen="";
    private String imagenAnt;
    
    //atributos de la camara
    File salidaImage;
    int anchoCamara=225;
    int altoCamara=200;
    Dimension dimension=new Dimension(anchoCamara,altoCamara);
    Dimension dimension1=WebcamResolution.VGA.getSize();
    Webcam webcam=Webcam.getDefault();
    WebcamPanel webcamPanel=new WebcamPanel(webcam,dimension,false);
    BufferedImage rutaWebcam;
    
    
  //  private int totalRegistros;
    //metodos
    public FrmiUsuario() {
        initComponents();
        this.CONTROL=new UsuarioControl();
        this.listado("");
        tabGeneral.setEnabledAt(1,false);
        this.accion="guardar";
        txtId.setEnabled(false);
        this.cargarRoles();
        dcFechaNac.setDate(new Date(1970-1900,00,01));
        
        webcam.setViewSize(dimension1);
        webcamPanel.setFillArea(true);
        pnlCamara.setLayout(new FlowLayout());
        pnlCamara.add(webcamPanel);
        desactiva();
    }
    
    private void activa(){
        btnCapturaFoto.setEnabled(true);
    }
    
    private void desactiva(){
        btnCapturaFoto.setEnabled(false);
    }
    
    private void listado(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden=new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        ocultarColumnas();
        lblTotalRegistros.setText("Mostrando "+this.CONTROL.totalMostrados()+" de un total de "+this.CONTROL.total()+" registros.");
    }
    
    private void listado(String texto,String campo){
        tablaListado.setModel(this.CONTROL.listar(texto,campo));
        TableRowSorter orden=new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        ocultarColumnas();
        lblTotalRegistros.setText("Mostrando "+this.CONTROL.totalMostrados()+" de un total de "+this.CONTROL.total()+" registros.");
    }
    
    private void cargarRoles(){
        DefaultComboBoxModel items = this.CONTROL.seleccionar();
        cboRol.setModel(items);
    }
    
    private void limpiar(){
        txtId.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtCi.setText("");
        txtEmail.setText("");
        txtClave.setText("");
        dcFechaNac.setDate(new Date (1970-1900,00,01));
        
        this.imagen="";
        this.imagenAnt="";
        lblFotoTomada.setIcon(null);
        this.rutaDestino="";
        
        this.accion="guardar";
    }
    
    private void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje,"Sistema",JOptionPane.ERROR_MESSAGE);
    }
    
    private void mensajeInformacion(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje,"Sistema",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void mensajeAlerta(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje,"Sistema",JOptionPane.WARNING_MESSAGE);
    }
    
    private void mensajePregunta(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje,"Sistema",JOptionPane.QUESTION_MESSAGE);
    }
    
    private void ocultarColumnas(){
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        
        
        tablaListado.getColumnModel().getColumn(7).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(7).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
    }
    
    private void subirImagenes(){
        this.imagen=CONTROL.generaNombreImagen(txtNombres.getText(), txtCi.getText()).trim()+".jpg";
        this.rutaDestino=this.DIRECTORIO+this.imagen;
        salidaImage=new File(rutaDestino);
        try {
            ImageIO.write(rutaWebcam,"jpg", salidaImage);
            mensajeInformacion("Imagen guardada en: "+salidaImage.getAbsolutePath());
        } catch (HeadlessException | IOException e) {
            mensajeError(e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoBusqueda = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabGeneral = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        btnDesactivar = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        rbtNombre = new javax.swing.JRadioButton();
        rbtApellido = new javax.swing.JRadioButton();
        rbtCi = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cboRol = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        dcFechaNac = new com.toedter.calendar.JDateChooser();
        pnlCamara = new javax.swing.JPanel();
        lblFotoTomada = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnCapturaFoto = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");
        setPreferredSize(new java.awt.Dimension(950, 610));

        jPanel1.setPreferredSize(new java.awt.Dimension(758, 47));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("USUARIOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel2.setText("Nombre:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/buscar2.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/nuevo.GIF"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/elim.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/deshacer.gif"))); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        lblTotalRegistros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotalRegistros.setText("Registros");

        btnGrupoBusqueda.add(rbtNombre);
        rbtNombre.setText("Buscar por nombre");

        btnGrupoBusqueda.add(rbtApellido);
        rbtApellido.setSelected(true);
        rbtApellido.setText("Buscar por apellido");

        btnGrupoBusqueda.add(rbtCi);
        rbtCi.setText("Buscar por CI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDesactivar)
                .addGap(18, 18, 18)
                .addComponent(btnActivar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros)
                .addGap(157, 157, 157))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtNombre)
                        .addGap(18, 18, 18)
                        .addComponent(rbtApellido)
                        .addGap(18, 18, 18)
                        .addComponent(rbtCi))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtNombre)
                    .addComponent(rbtApellido)
                    .addComponent(rbtCi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesactivar)
                    .addComponent(btnActivar)
                    .addComponent(lblTotalRegistros))
                .addGap(37, 37, 37))
        );

        tabGeneral.addTab("Listado", jPanel2);

        jLabel3.setText("Nombres (*)");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/star.png"))); // NOI18N
        jLabel4.setText("(*)Indica que es un campo obligatorio");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/guardar02.jpg"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Apellidos (*)");

        jLabel6.setText("Ci(*)");

        jLabel8.setText("Email(*)");

        jLabel9.setText("Rol (*)");

        jLabel10.setText("Clave (*)");

        jLabel7.setText("Fecha Nac.");

        pnlCamara.setBackground(new java.awt.Color(51, 51, 51));
        pnlCamara.setPreferredSize(new java.awt.Dimension(225, 200));

        javax.swing.GroupLayout pnlCamaraLayout = new javax.swing.GroupLayout(pnlCamara);
        pnlCamara.setLayout(pnlCamaraLayout);
        pnlCamaraLayout.setHorizontalGroup(
            pnlCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );
        pnlCamaraLayout.setVerticalGroup(
            pnlCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        lblFotoTomada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnIniciar.setText("Iniciar Camara");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnApagar.setText("Apagar Camara");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnCapturaFoto.setText("Captura Foto");
        btnCapturaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtClave, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnGuardar)
                        .addGap(35, 35, 35)
                        .addComponent(btnCancelar)))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFotoTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIniciar)
                    .addComponent(btnApagar)
                    .addComponent(btnCapturaFoto))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(pnlCamara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnApagar)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(dcFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnCancelar))
                        .addGap(112, 112, 112))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblFotoTomada, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnCapturaFoto)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        tabGeneral.addTab("Mantenimiento", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabGeneral)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listado(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String cadena=txtBuscar.getText();
        if (rbtApellido.isSelected()) {
            listado(cadena, "apellidos");
        }else if(rbtNombre.isSelected()){
            listado(cadena, "nombres");
        }else if(rbtCi.isSelected()){
            listado(cadena,"ci");
        }
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabGeneral.setEnabledAt(1,true);
        tabGeneral.setEnabledAt(0,false);
        tabGeneral.setSelectedIndex(1);
        this.accion="guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        tabGeneral.setEnabledAt(1,false);
        tabGeneral.setEnabledAt(0,true);
        tabGeneral.setSelectedIndex(0);
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombres.getText().isEmpty()||txtNombres.getText().length()>40) {
            mensajeAlerta("Debes ingresar un nombre y no debe ser mayor a 40 caracteres, es obligatorio.");
            txtNombres.requestFocus();
            return;
        }
        if (txtApellidos.getText().isEmpty()||txtApellidos.getText().length()>50) {
            mensajeAlerta("Debes ingresar un nombre y no debe ser mayor a 50 caracteres, es obligatorio.");
            txtApellidos.requestFocus();
            return;
        }
        if (txtCi.getText().isEmpty()||txtCi.getText().length()>20) {
            mensajeAlerta("Debes ingresar un numero de CI y no debe ser mayor a 20 caracteres, es obligatorio.");
            txtCi.requestFocus();
            return;
        }
        if (txtEmail.getText().isEmpty()||txtEmail.getText().length()>50) {
            mensajeAlerta("Debes ingresar un email y no debe ser mayor a 50 caracteres, es obligatorio.");
            txtEmail.requestFocus();
            return;
        }
        boolean email=EmailValidator.getInstance().isValid(txtEmail.getText());
        if (!email) {
            mensajeError("Debes ingresar un email valido.");
            txtEmail.requestFocus();
            return;
        }
        if (txtClave.getText().isEmpty()||txtClave.getText().length()>64) {
            mensajeAlerta("Debes ingresar una clave, es obligatorio.");
            txtClave.requestFocus();
            return;
        }
        
        String fecha=((JTextField)dcFechaNac.getDateEditor().getUiComponent()).getText();
        if (fecha.equals("")) {
            mensajeError("Debes ingresar una fecha, es obligatorio");
            dcFechaNac.requestFocus();
            return;
        }
        
        Calendar cal;
        Date fechaSeleccionada;
        int d,m,a;
        try {
            cal=dcFechaNac.getCalendar();
            d= cal.get(Calendar.DAY_OF_MONTH);
            m= cal.get(Calendar.MONTH);
            a= cal.get(Calendar.YEAR)-1900;
            fechaSeleccionada=new Date(a,m,d);
        } catch (Exception e) {
            mensajeError(e.getMessage());
            fechaSeleccionada=new Date(1970-1900,00,01);
        }
        
        
        String resp;
        if (this.accion.equals("editar")) {
            //editar
            String imagenActual="";
            if(this.imagen.equals("")) {
                imagenActual=this.imagenAnt;
            }else{
                imagenActual=this.imagen;
            }
            
            Rol seleccionado=(Rol)cboRol.getSelectedItem();
            resp=this.CONTROL.actualizar(Integer.parseInt(txtId.getText()),seleccionado.getId(), txtNombres.getText().trim(),txtApellidos.getText().trim(),txtCi.getText().trim(),txtEmail.getText().trim(), emailAnt,txtClave.getText(),fechaSeleccionada,imagenActual);
            if (resp.equals("OK")) {
                if (!this.imagen.equals("")) {
                    this.subirImagenes();
                }
                this.mensajeInformacion("Actualizado correctamente.");
                this.limpiar();
                this.listado("");
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
                tabGeneral.setSelectedIndex(0);
            } else {
                this.mensajeError(resp);
            }
        }else{
            //guardar
            Rol seleccionado=(Rol)cboRol.getSelectedItem();
            resp=this.CONTROL.insertar(seleccionado.getId(),txtNombres.getText().trim(),txtApellidos.getText().trim(),txtCi.getText().trim(),txtEmail.getText().trim(),txtClave.getText(),fechaSeleccionada,this.imagen);
            if (resp.equals("OK")) {
                 if (!this.imagen.equals("")) {
                    this.subirImagenes();
                }
                this.mensajeInformacion("Registrado correctamente.");
                this.limpiar();
                this.listado("");
                txtNombres.requestFocus();
            }else{
                this.mensajeError(resp);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tablaListado.getSelectedRowCount()==1) {
            String id=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            int rolId=Integer.parseInt(String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1)));
            String rolNombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            String nombres=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
            String apellidos=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));
            String ci=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5));
            String email = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 6));
            this.emailAnt=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 6));
            String clave=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 7));
            Date fechaNacimiento=Date.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 8).toString());
            this.imagenAnt=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 9));
            
            
            txtId.setText(id);
            Rol seleccionado=new Rol(rolId,rolNombre);
            cboRol.setSelectedItem(seleccionado);
            txtNombres.setText(nombres);
            txtApellidos.setText(apellidos);
            txtCi.setText(ci);         
            txtEmail.setText(email);
            txtClave.setText(clave);
            dcFechaNac.setDate(fechaNacimiento);
            
            ImageIcon im=new ImageIcon(this.DIRECTORIO+this.imagenAnt);
            Icon icono=new ImageIcon(im.getImage().getScaledInstance(lblFotoTomada.getWidth(),lblFotoTomada.getHeight(),Image.SCALE_DEFAULT));
            lblFotoTomada.setIcon(icono);
            lblFotoTomada.repaint();
            
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setSelectedIndex(1);
            
            this.accion="editar";
            btnGuardar.setText("Editar");
        }else{
            this.mensajeError("Seleccione un registro a editar");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        if (tablaListado.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));

            if (JOptionPane.showConfirmDialog(this, "Deseas activar el registro"+nombre+" ?","Sistema",JOptionPane.YES_NO_OPTION)==0){
                 String resp=this.CONTROL.activar(Integer.parseInt(id));
                 if (resp.equals("OK")) {
                    this.mensajeInformacion("Registro activado.");
                    this.listado("");
                }else{
                     this.mensajeError(resp);
                 }
            }
        } else {
            this.mensajeError("Seleccione un registro a activar");
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
         if (tablaListado.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));

            if (JOptionPane.showConfirmDialog(this, "Deseas desactivar el registro"+nombre+" ?","Sistema",JOptionPane.YES_NO_OPTION)==0){
                 String resp=this.CONTROL.desactivar(Integer.parseInt(id));
                 if (resp.equals("OK")) {
                    this.mensajeInformacion("Registro desactivado.");
                    this.listado("");
                }else{
                     this.mensajeError(resp);
                 }
            }
        } else {
            this.mensajeError("Seleccione un registro a desactivar");
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        Thread hilo = new Thread() {
            @Override
            public void run() {
                webcamPanel.start();
            }
        };
        hilo.setDaemon(true);
        hilo.start();
        activa();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        webcamPanel.stop();
        desactiva();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnCapturaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaFotoActionPerformed
        if (txtNombres.getText().isEmpty() || txtNombres.getText().length() > 40) {
            mensajeAlerta("Debes ingresar un nombre y no debe ser mayor a 40 caracteres, es obligatorio.");
            txtNombres.requestFocus();
            return;
        }
        if (txtCi.getText().isEmpty() || txtCi.getText().length() > 20) {
            mensajeAlerta("Debes ingresar un numero de CI y no debe ser mayor a 20 caracteres, es obligatorio.");
            txtCi.requestFocus();
            return;
        }
        ImageIcon foto;
        this.imagen = CONTROL.generaNombreImagen(txtNombres.getText(), txtCi.getText()).trim() + ".jpg";
        foto = new ImageIcon(webcam.getImage());
        Icon iconoFoto = new ImageIcon(foto.getImage().getScaledInstance(lblFotoTomada.getWidth(), lblFotoTomada.getHeight(), Image.SCALE_SMOOTH));
        lblFotoTomada.setIcon(iconoFoto);
        rutaWebcam=webcam.getImage();
    }//GEN-LAST:event_btnCapturaFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCapturaFoto;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup btnGrupoBusqueda;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cboRol;
    private com.toedter.calendar.JDateChooser dcFechaNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFotoTomada;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JPanel pnlCamara;
    private javax.swing.JRadioButton rbtApellido;
    private javax.swing.JRadioButton rbtCi;
    private javax.swing.JRadioButton rbtNombre;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCi;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
