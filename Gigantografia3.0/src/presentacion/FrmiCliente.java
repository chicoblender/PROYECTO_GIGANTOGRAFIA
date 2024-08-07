package presentacion;

import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.ClienteControl;

public class FrmiCliente extends javax.swing.JInternalFrame {

    //atributos
    private final ClienteControl CONTROL;
    private String accion;
    private String nombreAnt;
    //metodos
    public FrmiCliente() {
        initComponents();
        this.CONTROL=new ClienteControl();
        this.listado("");
        tabGeneral.setEnabledAt(1,false);
        this.accion="guardar";
        txtId.setEnabled(false);
    }
    private void listado(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto));
        TableRowSorter orden=new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        lblTotalRegistros.setText("Mostrando "+this.CONTROL.totalMostrados()+" de un total de "+this.CONTROL.total()+" registros.");
    }
    
    private void listado(String texto, String campo) {
       tablaListado.setModel(this.CONTROL.listar(texto, campo));
        TableRowSorter orden = new TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        lblTotalRegistros.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total() + " registros.");
    }

    private void limpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        this.accion = "guardar";
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
        rbtTelefono = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
        setPreferredSize(new java.awt.Dimension(770, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(758, 47));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("CLIENTES");

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
        rbtNombre.setSelected(true);
        rbtNombre.setText("Buscar por Cliente");

        btnGrupoBusqueda.add(rbtTelefono);
        rbtTelefono.setText("Buscar por Numero telefono");
        rbtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtTelefonoActionPerformed(evt);
            }
        });

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
                        .addComponent(rbtTelefono))
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
                .addContainerGap(84, Short.MAX_VALUE))
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
                    .addComponent(rbtTelefono))
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

        jLabel3.setText("Nombre(*)");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/star.png"))); // NOI18N
        jLabel4.setText("(*)Indica que es un campo obligatorio");

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/guardar02.jpg"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/cancel.png"))); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Direccion(*)");

        jLabel7.setText("Telefono");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(30, 30, 30)
                                .addComponent(Cancelar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel4)))))
                .addContainerGap(333, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(jLabel4)
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(Cancelar))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Mantenimiento", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if (rbtNombre.isSelected()) {
            listado(cadena, "NombreCliente");
        }else if(rbtTelefono.isSelected()){
            listado(cadena, "Telefono");
        }
        
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabGeneral.setEnabledAt(1,true);
        tabGeneral.setEnabledAt(0,false);
        tabGeneral.setSelectedIndex(1);
        this.accion="guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        tabGeneral.setEnabledAt(1,false);
        tabGeneral.setEnabledAt(0,true);
        tabGeneral.setSelectedIndex(0);
        limpiar();
    }//GEN-LAST:event_CancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().isEmpty()||txtNombre.getText().length()>70) {
            mensajeAlerta("Debes ingresar un nombre y no debe ser mayor a 70 caracteres, es obligatorio.");
            txtNombre.requestFocus();
            return;
        }
        if (txtDireccion.getText().isEmpty()||txtDireccion.getText().length()>20) {
            mensajeAlerta("Debes ingresar un numero de documento y no debe ser mayor a 20 caracteres, es obligatorio.");
            txtDireccion.requestFocus();
            return;
        }
        if (txtTelefono.getText().length()>15) {
            mensajeAlerta("Debes ingresar un telefono y no debe ser mayor a 15 caracteres, es obligatorio.");
            txtTelefono.requestFocus();
            return;
        }
       
       
        String resp;
        if (this.accion.equals("editar")) {
            //editar
            resp=this.CONTROL.actualizar(Integer.parseInt(txtId.getText()),txtNombre.getText(), nombreAnt,txtTelefono.getText(),txtDireccion.getText()); 
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
        }else{
            //guardar
            resp=this.CONTROL.insertar(txtNombre.getText(),txtDireccion.getText(),txtTelefono.getText());
            if (resp.equals("OK")) {
                this.mensajeInformacion("Registrado correctamente.");
                this.limpiar();
                this.listado("");
                txtNombre.requestFocus();
            }else{
                this.mensajeError(resp);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tablaListado.getSelectedRowCount()==1) {
            String id=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            this.nombreAnt=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
           
            String numDocumento=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            String telefono=String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));

            
            txtId.setText(id);
            txtNombre.setText(nombre);
            
            txtDireccion.setText(numDocumento);
            txtTelefono.setText(telefono);
            
            
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

    private void rbtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtTelefonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.ButtonGroup btnGrupoBusqueda;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JRadioButton rbtNombre;
    private javax.swing.JRadioButton rbtTelefono;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
