package presentacion;

import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.ProductoControl;

public class FrmjSeleccionarProductoVenta extends javax.swing.JDialog {

     //atributos
    private FrmiVenta vista;
    private final ProductoControl CONTROL;
    private String accion;
    private String nombreAnt;
    //metodos
    public FrmjSeleccionarProductoVenta(java.awt.Frame parent, FrmiVenta frm,boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.vista = frm;
        this.setTitle("Seleccione un Producto para la Venta");

        this.CONTROL = new ProductoControl();
        this.listado("");
        tabGeneral.setEnabledAt(1, false);
        this.accion = "guardar";
        txtId.setEnabled(false);
        this.setVisible(true);
    }
    private void listado(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden=new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        lblTotalRegistros.setText("Mostrando "+this.CONTROL.totalMostrados()+" de un total de "+this.CONTROL.total()+" registros.");
    }
    
    private void limpiar(){
        txtId.setText("");
        txtNombre.setText("");
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        btnSeleccionarProducto = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecciona Clientes");

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

        lblTotalRegistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTotalRegistros.setText("Registros");

        btnSeleccionarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/seleccionar1.png"))); // NOI18N
        btnSeleccionarProducto.setText("Seleccionar Producto");
        btnSeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDesactivar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnActivar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalRegistros)
                .addGap(172, 172, 172))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSeleccionarProducto)
                    .addComponent(btnEditar))
                .addContainerGap(162, Short.MAX_VALUE))
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
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(btnSeleccionarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesactivar)
                    .addComponent(btnActivar)
                    .addComponent(lblTotalRegistros))
                .addGap(33, 33, 33))
        );

        tabGeneral.addTab("Listado", jPanel2);

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

        jLabel3.setText("Nombre(*)");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/star.png"))); // NOI18N
        jLabel5.setText("(*)Indica que es un campo obligatorio");

        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/guardar02.jpg"))); // NOI18N
        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/cancel.png"))); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Precio(*)");

        jLabel9.setText("Stock(*)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnGuardar1)
                        .addGap(30, 30, 30)
                        .addComponent(Cancelar))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(492, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(jLabel5)
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar1)
                    .addComponent(Cancelar))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(29, 29, 29)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4)))
                .addContainerGap(587, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(139, 139, 139))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabGeneral.addTab("Mantenimiento", jPanel3);

        jPanel1.setPreferredSize(new java.awt.Dimension(754, 47));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("SELECCIONAR PRODUCTOS");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
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

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        String cadena = txtBuscar.getText();
        this.listado(cadena);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listado(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabGeneral.setEnabledAt(1,true);
        tabGeneral.setEnabledAt(0,false);
        tabGeneral.setSelectedIndex(1);
        this.accion="guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       if (tablaListado.getSelectedRowCount() == 1) {
        String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
        String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
        String precio = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
        String stock = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
        
        this.nombreAnt = nombre;
        
        txtId.setText(id);
        txtNombre.setText(nombre);
        txtPrecio.setText(precio);
        txtStock.setText(stock);
        
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        
        this.accion = "editar";
        btnGuardar.setText("Editar");
    } else {
        this.mensajeError("Seleccione un registro a editar");
    }
    }//GEN-LAST:event_btnEditarActionPerformed

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

    private void btnSeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoActionPerformed
         if(tablaListado.getSelectedRowCount()==1){
            String id=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            String precio=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            this.vista.txtIdProducto.setText(id);
            this.vista.txtNombreProducto.setText(nombre);
            this.vista.txtPrecio.setText(precio);
            this.setVisible(false);
        }else{
            this.mensajeError("Debe seleccionar un Producto");
         }
    }//GEN-LAST:event_btnSeleccionarProductoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    tabGeneral.setEnabledAt(1,false);
        tabGeneral.setEnabledAt(0,true);
        tabGeneral.setSelectedIndex(0);
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       if (txtNombre.getText().isEmpty() || txtNombre.getText().length() > 20) {
        mensajeAlerta("Debes ingresar un nombre y no debe ser mayor a 20 caracteres, es obligatorio.");
        txtNombre.requestFocus();
        return;
    }

    if (txtPrecio.getText().isEmpty()) {
        mensajeAlerta("Debes ingresar un precio, es obligatorio.");
        txtPrecio.requestFocus();
        return;
    }

    if (txtStock.getText().isEmpty()) {
        mensajeAlerta("Debes ingresar el stock, es obligatorio.");
        txtStock.requestFocus();
        return;
    }

    // Convertir y validar el precio
    double precio;
    try {
        precio = Double.parseDouble(txtPrecio.getText());
        if (precio < 0) {
            mensajeAlerta("El precio no puede ser negativo.");
            txtPrecio.requestFocus();
            return;
        }
    } catch (NumberFormatException e) {
        mensajeAlerta("Debes ingresar un precio válido.");
        txtPrecio.requestFocus();
        return;
    }

    // Convertir y validar el stock
    int stock;
    try {
        stock = Integer.parseInt(txtStock.getText());
        if (stock < 0) {
            mensajeAlerta("El stock no puede ser negativo.");
            txtStock.requestFocus();
            return;
        }
    } catch (NumberFormatException e) {
        mensajeAlerta("Debes ingresar un stock válido.");
        txtStock.requestFocus();
        return;
    }

    String resp;
    if (this.accion.equals("editar")) {
        // Editar
        int id = Integer.parseInt(txtId.getText());
        resp = this.CONTROL.actualizar(id, txtNombre.getText(), precio, stock);
        if (resp.equals("OK")) {
            this.mensajeInformacion("Actualizado correctamente.");
            this.limpiar();
            this.listado("");
            tabGeneral.setEnabledAt(1, false);
            tabGeneral.setEnabledAt(0, true);
            tabGeneral.setSelectedIndex(0);
        } else {
            this.mensajeError(resp);
        }
    } else {
        // Guardar
        resp = this.CONTROL.insertar(txtNombre.getText(), precio, stock);
        if (resp.equals("OK")) {
            this.mensajeInformacion("Registrado correctamente.");
            this.limpiar();
            this.listado("");
            txtNombre.requestFocus();
        } else {
            this.mensajeError(resp);
        }
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        if (txtNombre.getText().isEmpty() || txtNombre.getText().length() > 20) {
            mensajeAlerta("Debes ingresar un nombre y no debe ser mayor a 20 caracteres, es obligatorio.");
            txtNombre.requestFocus();
            return;
        }

        if (txtPrecio.getText().isEmpty()) {
            mensajeAlerta("Debes ingresar un precio, es obligatorio.");
            txtPrecio.requestFocus();
            return;
        }

        if (txtStock.getText().isEmpty()) {
            mensajeAlerta("Debes ingresar el stock, es obligatorio.");
            txtStock.requestFocus();
            return;
        }

        // Convertir y validar el precio
        double precio;
        try {
            precio = Double.parseDouble(txtPrecio.getText());
            if (precio < 0) {
                mensajeAlerta("El precio no puede ser negativo.");
                txtPrecio.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            mensajeAlerta("Debes ingresar un precio válido.");
            txtPrecio.requestFocus();
            return;
        }

        // Convertir y validar el stock
        int stock;
        try {
            stock = Integer.parseInt(txtStock.getText());
            if (stock < 0) {
                mensajeAlerta("El stock no puede ser negativo.");
                txtStock.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            mensajeAlerta("Debes ingresar un stock válido.");
            txtStock.requestFocus();
            return;
        }

        String resp;
        if (this.accion.equals("editar")) {
            // Editar
            int id = Integer.parseInt(txtId.getText());
            resp = this.CONTROL.actualizar(id, txtNombre.getText(), precio, stock);
            if (resp.equals("OK")) {
                this.mensajeInformacion("Actualizado correctamente.");
                this.limpiar();
                this.listado("");
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
                tabGeneral.setSelectedIndex(0);
            } else {
                this.mensajeError(resp);
            }
        } else {
            // Guardar
            resp = this.CONTROL.insertar(txtNombre.getText(), precio, stock);
            if (resp.equals("OK")) {
                this.mensajeInformacion("Registrado correctamente.");
                this.limpiar();
                this.listado("");
                txtNombre.requestFocus();
            } else {
                this.mensajeError(resp);
            }
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        tabGeneral.setEnabledAt(1,false);
        tabGeneral.setEnabledAt(0,true);
        tabGeneral.setSelectedIndex(0);
        limpiar();
    }//GEN-LAST:event_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSeleccionarProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
