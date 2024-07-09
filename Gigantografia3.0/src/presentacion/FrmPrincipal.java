package presentacion;


import clases.ImagenFondo;
import clases.Variables;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
        escritorio.setBorder(new ImagenFondo());
        setExtendedState(MAXIMIZED_BOTH);
        cargarOpcionesMenu();
    }
    
    private void cargarOpcionesMenu(){
        if (clases.Variables.rolNombre==null) {
            JOptionPane.showMessageDialog(this,"Debe ingresar de forma correcta al sistema, mediante");
        }
        if (clases.Variables.rolNombre.equalsIgnoreCase("Administrador")) {
            mnuOrdServicio.setEnabled(true);
            mnuAcceso.setEnabled(true);
            mnuConsultas.setEnabled(true);
            mnuProducto.setEnabled(true);
        }else if (clases.Variables.rolNombre.equalsIgnoreCase("Empleado")) {
            mnuOrdServicio.setEnabled(true);
            mnuAcceso.setEnabled(false);
            mnuConsultas.setEnabled(false);
            mnuProducto.setEnabled(false);
        }else if (clases.Variables.rolNombre.equalsIgnoreCase("Encargado")) {
            mnuOrdServicio.setEnabled(true);
            mnuAcceso.setEnabled(false);
            mnuConsultas.setEnabled(true);
            mnuProducto.setEnabled(true);
        }else {
            mnuOrdServicio.setEnabled(false);
            mnuAcceso.setEnabled(false);
            mnuConsultas.setEnabled(false);
        }
        lblNombres.setText(Variables.usuarioNombre);
        lblApellidos.setText(Variables.usuarioApellido);
        lblRol.setText(Variables.rolNombre);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuInicio = new javax.swing.JMenu();
        mnuiSalir = new javax.swing.JMenuItem();
        mnuOrdServicio = new javax.swing.JMenu();
        mnuiClientes = new javax.swing.JMenuItem();
        mnuiVenta = new javax.swing.JMenuItem();
        mnuiTransaccion = new javax.swing.JMenuItem();
        mnuiPago = new javax.swing.JMenuItem();
        mnuAcceso = new javax.swing.JMenu();
        mnuiRoles = new javax.swing.JMenuItem();
        mnuiUsuarios = new javax.swing.JMenuItem();
        mnuProducto = new javax.swing.JMenu();
        mnuiProducto = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        mnuiDetalleVenta = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gigantografia");

        jToolBar1.setRollover(true);

        jLabel1.setText("   Nombres:");
        jToolBar1.add(jLabel1);

        jLabel2.setText("   ");
        jToolBar1.add(jLabel2);

        lblNombres.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNombres.setText("   Nombres");
        jToolBar1.add(lblNombres);

        jLabel4.setText("    ");
        jToolBar1.add(jLabel4);

        jLabel5.setText("   Apellidos:");
        jToolBar1.add(jLabel5);

        jLabel6.setText("   ");
        jToolBar1.add(jLabel6);

        lblApellidos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblApellidos.setText("    Apellidos");
        jToolBar1.add(lblApellidos);

        jLabel8.setText("    ");
        jToolBar1.add(jLabel8);

        jLabel9.setText("   Rol:");
        jToolBar1.add(jLabel9);

        jLabel10.setText("   ");
        jToolBar1.add(jLabel10);

        lblRol.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblRol.setText("    Rol");
        jToolBar1.add(lblRol);

        jLabel12.setText("    ");
        jToolBar1.add(jLabel12);

        mnuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/inicio2.0.png"))); // NOI18N
        mnuInicio.setMnemonic('f');
        mnuInicio.setText("Inicio");

        mnuiSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuiSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/salir.png"))); // NOI18N
        mnuiSalir.setMnemonic('x');
        mnuiSalir.setText("Salir");
        mnuiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiSalirActionPerformed(evt);
            }
        });
        mnuInicio.add(mnuiSalir);

        menuBar.add(mnuInicio);

        mnuOrdServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/servicio2.0.png"))); // NOI18N
        mnuOrdServicio.setMnemonic('e');
        mnuOrdServicio.setText("Ordenes y Servicio");

        mnuiClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuiClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/trabajadores.png"))); // NOI18N
        mnuiClientes.setMnemonic('t');
        mnuiClientes.setText("Clientes");
        mnuiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiClientesActionPerformed(evt);
            }
        });
        mnuOrdServicio.add(mnuiClientes);

        mnuiVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuiVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/venta2.2.png"))); // NOI18N
        mnuiVenta.setMnemonic('y');
        mnuiVenta.setText("Venta");
        mnuiVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiVentaActionPerformed(evt);
            }
        });
        mnuOrdServicio.add(mnuiVenta);

        mnuiTransaccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/transaccion2.1.png"))); // NOI18N
        mnuiTransaccion.setText("Transaccion");
        mnuOrdServicio.add(mnuiTransaccion);

        mnuiPago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/pago2.0.png"))); // NOI18N
        mnuiPago.setText("Pago");
        mnuOrdServicio.add(mnuiPago);

        menuBar.add(mnuOrdServicio);

        mnuAcceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/acceso2.0.png"))); // NOI18N
        mnuAcceso.setMnemonic('h');
        mnuAcceso.setText("Acceso");

        mnuiRoles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuiRoles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/rol2.0.png"))); // NOI18N
        mnuiRoles.setMnemonic('c');
        mnuiRoles.setText("Roles");
        mnuiRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiRolesActionPerformed(evt);
            }
        });
        mnuAcceso.add(mnuiRoles);

        mnuiUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_DOWN_MASK));
        mnuiUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/usuario2.0.png"))); // NOI18N
        mnuiUsuarios.setMnemonic('a');
        mnuiUsuarios.setText("Usuarios");
        mnuiUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiUsuariosActionPerformed(evt);
            }
        });
        mnuAcceso.add(mnuiUsuarios);

        menuBar.add(mnuAcceso);

        mnuProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/productos2.0.png"))); // NOI18N
        mnuProducto.setText("Productos");

        mnuiProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/productos2.1.png"))); // NOI18N
        mnuiProducto.setText("Productos");
        mnuiProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuiProductoActionPerformed(evt);
            }
        });
        mnuProducto.add(mnuiProducto);

        menuBar.add(mnuProducto);

        mnuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/consultas2.0.png"))); // NOI18N
        mnuConsultas.setText("Consultas");

        mnuiDetalleVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/detalle2.0.png"))); // NOI18N
        mnuiDetalleVenta.setText("Detalle Venta");
        mnuConsultas.add(mnuiDetalleVenta);

        menuBar.add(mnuConsultas);

        mnuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/images/salir.png"))); // NOI18N
        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        menuBar.add(mnuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuiSalirActionPerformed

    private void mnuiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiClientesActionPerformed
        FrmiCliente frm=new FrmiCliente();
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_mnuiClientesActionPerformed

    private void mnuiRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiRolesActionPerformed
        FrmiRol frm=new FrmiRol();
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_mnuiRolesActionPerformed

    private void mnuiUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiUsuariosActionPerformed
        FrmiUsuario frm=new FrmiUsuario();
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_mnuiUsuariosActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
      System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuiProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiProductoActionPerformed
       FrmiProducto frm=new FrmiProducto();
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_mnuiProductoActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mnuSalirMouseClicked

    private void mnuiVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuiVentaActionPerformed
      FrmiVenta frm= new FrmiVenta(this);
        escritorio.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_mnuiVentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Properties props = new Properties();
                    props.put("logoString", "SisOrdenes2024");
                    HiFiLookAndFeel.setCurrentTheme(props);
                    UIManager.setLookAndFeel(new HiFiLookAndFeel());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblRol;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuAcceso;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenu mnuInicio;
    private javax.swing.JMenu mnuOrdServicio;
    private javax.swing.JMenu mnuProducto;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JMenuItem mnuiClientes;
    private javax.swing.JMenuItem mnuiDetalleVenta;
    private javax.swing.JMenuItem mnuiPago;
    private javax.swing.JMenuItem mnuiProducto;
    private javax.swing.JMenuItem mnuiRoles;
    private javax.swing.JMenuItem mnuiSalir;
    private javax.swing.JMenuItem mnuiTransaccion;
    private javax.swing.JMenuItem mnuiUsuarios;
    private javax.swing.JMenuItem mnuiVenta;
    // End of variables declaration//GEN-END:variables

}
