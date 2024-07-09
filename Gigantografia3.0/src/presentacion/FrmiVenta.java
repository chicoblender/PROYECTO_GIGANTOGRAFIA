package presentacion;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import negocio.VentaControl;

public class FrmiVenta extends javax.swing.JInternalFrame {

    //atributos
    private final VentaControl CONTROL;
    private String accion;
    public DefaultTableModel modeloDetalles;
    public JFrame contenedor;

    //metodos
    public FrmiVenta(JFrame frmP) {
        initComponents();
        this.contenedor=frmP;
        this.CONTROL = new VentaControl();
        this.listado("");
        tabGeneral.setEnabledAt(1, false);
        //this.accion = "guardar";
        
        //this.cargarProductos();
        this.crearDetalles();
        txtIdCliente.setEnabled(false);
        obtenerNumero();
    }

    private void listado(String texto) {
        tablaListado.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden = new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        ocultarColumnas();
        lblTotalRegistros.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total() + " registros.");
    }
    
  /*  private void cargarProductos() {
        DefaultComboBoxModel items = this.CONTROL.seleccionar();
        cboProducto.setModel(items);
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
    }*/
    private void ocultarColumnas(){
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        
        tablaListado.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(3).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(3).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(3).setMinWidth(0);
        
        tablaListado.getColumnModel().getColumn(5).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(5).setMinWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
    }

    private void crearDetalles() {
        modeloDetalles = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                if (columna == 2) {
                    return columna == 2;
                }
                return columna == 2;
            }

            @Override
            public void setValueAt(Object aValor, int fil, int col) {
                String val = String.valueOf(aValor);
                val = val.replace(",", ".");
                super.setValueAt(val, fil, col);
                calcularTotales();
                fireTableDataChanged();
            }
        };
        modeloDetalles.setColumnIdentifiers(new Object[]{"SERVICIO" , "CANTIDAD", "PRECIO"});
        tablaDetalles.setModel(modeloDetalles);
    }

    public void agregarDetalle(String servicio,String cantidad, String precio) {
        String servicioT;
        boolean existe = false;
        for (int i = 0; i < this.modeloDetalles.getRowCount(); i++) {
            servicioT = String.valueOf(this.modeloDetalles.getValueAt(i, 0));
            if (servicioT.equals(servicio)) {
                existe = true;
            }
        }
        if (existe) {
            this.mensajeError("El servicio ya ha sido agregado.");
        } else {
            this.modeloDetalles.addRow(new Object[]{servicio,cantidad, precio});
            this.calcularTotales();
        }
    }

    private void calcularTotales() {

        double total = 0;

        int items = modeloDetalles.getRowCount();

        if (items == 0) {
            total = 0;
        } else {
            for (int i = 0; i < items; i++) {
                total = total + Double.parseDouble(String.valueOf(modeloDetalles.getValueAt(i, 2)));
            }
        }
        txtTotal.setText(String.format("%.2f", total).replace(",", "."));
    }

    private void limpiar() {
        txtIdCliente.setText("");
        txtNombreCliente.setText("");
        txtNumComprobante.setText(null);
        txtTotal.setText("0");
        this.crearDetalles();
        btnGuardar.setVisible(true);
    }

    private void limpiarDetalle() {
        txtCantidad.setText("");
        txtServicio.setText("");
        txtPrecio.setText("0");
        txtServicio.requestFocus();
    }

    private void deshabilitar() {
        txtIdCliente.setEditable(false);
        txtNombreCliente.setEditable(false);
        txtNumComprobante.setEditable(false);
        cboSituacion.setEnabled(false);
        pnlIngresoDet.setVisible(false);
        tablaDetalles.setEnabled(false);
        txtTotal.setEditable(false);
        btnSeleccionarCliente.setVisible(false);
        btnGuardar.setVisible(false);
        btnSeleccionarProducto.setVisible(false);
        txtIdProducto.setEditable(false);
        txtNombreProducto.setEditable(false);
        txtPrecio.setEditable(false);
    }

    private void habilitar() {
        txtIdCliente.setEditable(false);
        txtNombreCliente.setEditable(false);
        txtNumComprobante.setEditable(true);
        cboSituacion.setEnabled(true);
        pnlIngresoDet.setVisible(true);
        tablaDetalles.setEnabled(true);
        txtTotal.setEditable(false);
        btnSeleccionarCliente.setVisible(true);
        btnGuardar.setVisible(true);
        btnSeleccionarProducto.setVisible(true);
        txtIdProducto.setEditable(false);
        txtNombreProducto.setEditable(false);
        txtPrecio.setEditable(false);
    }

    private void obtenerNumero() {
        String numComprobante = this.CONTROL.ultimoNumero();
        if (numComprobante.equals("")) {
            numComprobante = "0001";
            txtNumComprobante.setText(numComprobante);
        } else {
            int num;
            num = Integer.parseInt(numComprobante) + 1;
            txtNumComprobante.setText("000" + (Integer.toString(num)));
        }
    }

    private void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
    }

    private void mensajeInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mensajeAlerta(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.WARNING_MESSAGE);
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
        btnVerIngreso = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        btnAnular = new javax.swing.JButton();
        lblTotalRegistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cboSituacion = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        btnSeleccionarCliente = new javax.swing.JButton();
        pnlIngresoDet = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        btnSeleccionarProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaDetalles = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Venta");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(960, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(754, 47));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("VENTA");

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

        btnVerIngreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/edit.png"))); // NOI18N
        btnVerIngreso.setText("Ver Ingreso");
        btnVerIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerIngresoActionPerformed(evt);
            }
        });

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/elim.png"))); // NOI18N
        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });

        lblTotalRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotalRegistros.setText("Registros");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros)
                .addGap(187, 187, 187))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerIngreso)
                .addContainerGap(257, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnVerIngreso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnular)
                    .addComponent(lblTotalRegistros))
                .addGap(24, 24, 24))
        );

        tabGeneral.addTab("Listado", jPanel2);

        jLabel3.setText("Cliente (*)");

        txtNombreCliente.setEditable(false);

        txtIdCliente.setEditable(false);
        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/star.png"))); // NOI18N
        jLabel4.setText("(*) Indica que es un campo obligatorio");

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

        jLabel5.setText("Situacion (*)");

        cboSituacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ingreso de pedidos de servicio(s)", "En espera de entrega", "Entregado", "El cliente no recogio las entregas " }));

        jLabel6.setText("Num. Comprobante(*)");

        btnSeleccionarCliente.setText("...");
        btnSeleccionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarClienteActionPerformed(evt);
            }
        });

        pnlIngresoDet.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de ingreso de una orden de servicio"));

        jLabel8.setText("Cantidad (*)");

        jLabel9.setText("Servicio:");

        jLabel10.setText("Precio:");

        txtPrecio.setEditable(false);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/seleccionar1.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("DETALLE DE LA VENTA A INGRESAR");

        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/elim.png"))); // NOI18N
        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        jLabel7.setText("Producto (*)");

        txtNombreProducto.setEditable(false);

        txtIdProducto.setEditable(false);
        txtIdProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProductoActionPerformed(evt);
            }
        });

        btnSeleccionarProducto.setText("...");
        btnSeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlIngresoDetLayout = new javax.swing.GroupLayout(pnlIngresoDet);
        pnlIngresoDet.setLayout(pnlIngresoDetLayout);
        pnlIngresoDetLayout.setHorizontalGroup(
            pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoDetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlIngresoDetLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(242, 242, 242)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                        .addComponent(btnQuitar))
                    .addGroup(pnlIngresoDetLayout.createSequentialGroup()
                        .addGroup(pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlIngresoDetLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlIngresoDetLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnSeleccionarProducto)
                        .addGap(25, 25, 25)
                        .addGroup(pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlIngresoDetLayout.setVerticalGroup(
            pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresoDetLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlIngresoDetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(jLabel11)
                    .addComponent(btnQuitar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        tablaDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaDetalles);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Total");

        txtTotal.setEditable(false);
        txtTotal.setText("0");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlIngresoDet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSeleccionarCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboSituacion, 0, 210, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(29, 29, 29)
                                .addComponent(btnCancelar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionarCliente)
                    .addComponent(jLabel6)
                    .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlIngresoDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Mantenimiento", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
            .addComponent(tabGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabGeneral))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listado(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String cadena = txtBuscar.getText();
        listado(cadena);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        //this.accion = "guardar";
        btnGuardar.setText("Guardar");
        obtenerNumero();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setSelectedIndex(0);
        limpiar();
        limpiarDetalle();
        habilitar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtIdCliente.getText().length() == 0) {
            this.mensajeAlerta("Debes seleccionar un Cliente");
            btnSeleccionarCliente.requestFocus();
            return;
        }
        if (txtNumComprobante.getText().length() > 15 || txtNumComprobante.getText().length() == 0) {
            this.mensajeAlerta("Debes ingresar un número de comprobante y no debe ser mayor a 15 caracteres.");
            txtNumComprobante.requestFocus();
            return;
        }
        if (modeloDetalles.getRowCount() == 0) {
            this.mensajeAlerta("Debes agregar detalles al servicio.");
            return;
        }

        String resp;
        //guardar
        
        resp = this.CONTROL.insertar(Integer.parseInt(txtIdCliente.getText()),Integer.parseInt(txtIdProducto.getText()), txtNumComprobante.getText(), (String) cboSituacion.getSelectedItem(), Double.parseDouble(txtTotal.getText()), modeloDetalles);
        if (resp.equals("OK")) {
            this.mensajeInformacion("Registrado correctamente.");
            this.limpiar();
            this.limpiarDetalle();
            this.listado("");
            txtNombreCliente.requestFocus();
           // txtNombreProducto.requestFocus();
            //txtPrecio.requestFocus();
            tabGeneral.setEnabledAt(1, false);
            tabGeneral.setEnabledAt(0, true);
            tabGeneral.setSelectedIndex(0);
        } else {
            this.mensajeError(resp);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVerIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerIngresoActionPerformed
        if(tablaListado.getSelectedRowCount()==1){
            String id=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String idCliente=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
            String nombreCliente=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));
            String numero=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 7));
            String situacion=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 9));
            
            txtIdCliente.setText(idCliente);
            txtNombreCliente.setText(nombreCliente);
            txtNumComprobante.setText(numero);
            cboSituacion.setSelectedItem(situacion);
            this.modeloDetalles=CONTROL.listarDetalle(Integer.parseInt(id));
            tablaDetalles.setModel(modeloDetalles);
            this.calcularTotales();
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setSelectedIndex(1);
            deshabilitar();
        }else{
            this.mensajeAlerta("Seleccione la orden a mostrar");
        }
    }//GEN-LAST:event_btnVerIngresoActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (tablaListado.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String numero = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5));

            if (JOptionPane.showConfirmDialog(this, "Deseas anular la orden de servicio con el numero " + numero + " ?", "Sistema", JOptionPane.YES_NO_OPTION) == 0) {
                String resp = this.CONTROL.anular(Integer.parseInt(id));
                if (resp.equals("OK")) {
                    this.mensajeInformacion("Registro anulado.");
                    this.listado("");
                } else {
                    this.mensajeError(resp);
                }
            }
        } else {
            this.mensajeError("Seleccione un registro a anular");
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtServicio.getText().length() == 0) {
            this.mensajeAlerta("Debes ingresar la descripcion al servicio");
            txtServicio.requestFocus();
            return;
        }
        if (txtCantidad.getText().length() == 0) {
            this.mensajeAlerta("Debes ingresar la cantidad");
            txtCantidad.requestFocus();
            return;
        }
    /*    if (txtPrecio.getText().length() == 0) {
            this.mensajeAlerta("Este campo debe tener un precio, el valor debe ser numerico.");
            txtPrecio.setText("0");
        }
*/
        
        String servicio = txtServicio.getText();
        double cantidadpr = Double.parseDouble(txtCantidad.getText());
        double precio2 = Double.parseDouble(txtPrecio.getText());
        double calcular = precio2*cantidadpr;
        String precio = String.valueOf(calcular);
        String cantidad= txtCantidad.getText();
        this.agregarDetalle(servicio,cantidad, precio);
        limpiarDetalle();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if (tablaDetalles.getSelectedRowCount() == 1) {
            this.modeloDetalles.removeRow(tablaDetalles.getSelectedRow());
            this.calcularTotales();
        } else {
            this.mensajeError("Seleccione el servicio a remover");
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnSeleccionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarClienteActionPerformed
        FrmjSeleccionarClienteVenta frm=new FrmjSeleccionarClienteVenta(contenedor,this,true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarClienteActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtIdProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProductoActionPerformed

    private void btnSeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoActionPerformed
        FrmjSeleccionarProductoVenta frm = new FrmjSeleccionarProductoVenta(contenedor, this, true);
        frm.toFront();
    }//GEN-LAST:event_btnSeleccionarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup btnGrupoBusqueda;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSeleccionarCliente;
    private javax.swing.JButton btnSeleccionarProducto;
    private javax.swing.JButton btnVerIngreso;
    private javax.swing.JComboBox<String> cboSituacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JPanel pnlIngresoDet;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaDetalles;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtIdCliente;
    public javax.swing.JTextField txtIdProducto;
    public javax.swing.JTextField txtNombreCliente;
    public javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNumComprobante;
    public javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
