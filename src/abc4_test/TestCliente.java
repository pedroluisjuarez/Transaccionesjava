
package abc4_test;
import abc1_conexion.Conexion;
import abc2_datos.ClienteDAO;
import abc3_domain.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestCliente extends javax.swing.JFrame {
    
    ClienteDAO clienteDAO = new ClienteDAO();
    Cliente cliente;
    Connection conexion = null;
    Conexion instanciaMysql = Conexion.getInstance();
    

    public TestCliente() {
        initComponents();
        this.setTitle("Creacion de Clientes");
        this.setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnombre = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtprofesion = new javax.swing.JTextField();
        txtsaldo = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDatosConsultados = new javax.swing.JTextArea();
        btnListar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtnombre.setText("Nombre: ");

        txtemail.setText("email:");

        txttelefono.setText("Telefono:");

        txtprofesion.setText("Profesion:");

        txtsaldo.setText("Saldo:");

        txtid.setText("Ingrese Id de Cliente:");

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnRegistrar.setText("Crear");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        areaDatosConsultados.setColumns(20);
        areaDatosConsultados.setRows(5);
        jScrollPane1.setViewportView(areaDatosConsultados);

        btnListar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnListar.setText("Actualizar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtprofesion, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtprofesion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
// pluis TODO add your handling code here:
        try{
            conexion = instanciaMysql.conectardb();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            String nombre = txtnombre.getText().trim();
            String telefono = txttelefono.getText().trim();
            String profesion = txtprofesion.getText().trim();
            String email = txtemail.getText().trim();
            double saldo = Double.parseDouble(txtsaldo.getText());
        
            cliente = new Cliente(nombre, telefono, profesion, email, saldo);
            clienteDAO.insertar(cliente);       
           
            conexion.commit();
            JOptionPane.showMessageDialog(null, "Cliente Registrado!");
            limpiartexto();
            
        }catch(Exception error){
            try {
                System.out.println(error);
                conexion.rollback();
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

        private void limpiartexto(){
        txtnombre.setText("");
        txttelefono.setText("");
        txtprofesion.setText("");
        txtemail.setText("");
        txtsaldo.setText("");
        txtid.setText("");
    }
        
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
//pluis TODO add your handling code here:
        try{
             conexion = instanciaMysql.conectardb();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
                areaDatosConsultados.setText("");

                List<Cliente> clientes = clienteDAO.Listar();
                for(Cliente datoscliente: clientes){
                    areaDatosConsultados.append(datoscliente.toString());
                     areaDatosConsultados.append("");
                        }
                
                conexion.commit();
                
        }catch(Exception error){
            try {
                System.out.println(error);
                conexion.rollback();
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
   

    }//GEN-LAST:event_btnListarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//pluis TODO add your handling code here:

        try{
             conexion = instanciaMysql.conectardb();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
                int idcliente = Integer.parseInt(txtid.getText());    
                cliente = new Cliente(idcliente);
                clienteDAO.eliminar(cliente);

                conexion.commit();
                JOptionPane.showMessageDialog(null, "Cliente Eliminado!");
                limpiartexto();
                
        }catch(Exception error){
            try {
                System.out.println(error);
                conexion.rollback();
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }    

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//pluis TODO add your handling code here:
        
        try{
             conexion = instanciaMysql.conectardb();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
                int id = Integer.parseInt(txtid.getText());
                String nombre = txtnombre.getText().trim();
                String telefono = txttelefono.getText().trim();
                String profesion = txtprofesion.getText().trim();
                String email = txtemail.getText().trim();
                double saldo = Double.parseDouble(txtsaldo.getText());

                cliente = new Cliente(id, nombre, telefono, profesion, email, saldo);
                clienteDAO.modificar(cliente);

                conexion.commit();
                JOptionPane.showMessageDialog(null, "Cliente Modificado!");
                limpiartexto();   
                
        }catch(Exception error){
            try {
                System.out.println(error);
                conexion.rollback();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed


    

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(TestCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDatosConsultados;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprofesion;
    private javax.swing.JTextField txtsaldo;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
