/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import registrofia.OracleConnection;

/**
 *
 * @author Dell i3
 */
public class Update_Notas extends javax.swing.JFrame {
ArrayList carnetx = new ArrayList();
ArrayList nombres = new ArrayList();
ArrayList apellidos = new ArrayList();
ArrayList Notasx = new ArrayList();
int j;
CallableStatement cstm = null;
ResultSet rset = null; 
    /**
     * Creates new form Insertar_Notas
     */
    public Update_Notas() {
        initComponents();
      InicioSesion jfra=new InicioSesion();
          String duidoc= jfra.DuiDocente;
        llenarcombo1(duidoc);
         setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Asig = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        alumno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nota = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();
        Actualizar = new javax.swing.JButton();
        Buscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        carnetCombo = new javax.swing.JComboBox();
        Evalu = new javax.swing.JComboBox();
        obtener = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Actualizar Notas");

        jLabel1.setText("Asignatura");

        Asig.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Opcion" }));
        Asig.setToolTipText("");
        Asig.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Asig.setKeySelectionManager(null);
        Asig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsigActionPerformed(evt);
            }
        });

        jLabel2.setText("Evaluacion");

        jLabel3.setText("Alumno");

        alumno.setEditable(false);

        jLabel4.setText("Nota");

        nota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                notaKeyTyped(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        jLabel6.setText("Carnet");

        carnetCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carnetComboMouseClicked(evt);
            }
        });
        carnetCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetComboActionPerformed(evt);
            }
        });

        Evalu.setToolTipText("");

        obtener.setText("Obtener");
        obtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerActionPerformed(evt);
            }
        });

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Asig, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nota, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cancelar)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(carnetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(obtener)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Evalu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(Buscar))
                                .addGap(8, 8, 8)))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Asig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Evalu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(carnetCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(obtener))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancelar)
                    .addComponent(Actualizar))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsigActionPerformed
       llenarcombo2();
       j=1;
        // TODO add your handling code here:
    }//GEN-LAST:event_AsigActionPerformed
    private void notaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notaKeyTyped
       int k = (int) evt.getKeyChar();
            if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar Texto", "Error en los datos", JOptionPane.ERROR_MESSAGE);
            }  // TODO add your handling code here:
    }//GEN-LAST:event_notaKeyTyped
    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
if(Asig.getSelectedIndex()!=0){
        Connection cn = null;
        OracleConnection c = new OracleConnection();
             try{
                 cn= c.getConnectionDocente();
                 cstm=null;
                 rset=null;
                 cstm = cn.prepareCall("begin tareabase.sp_nota_ciclo_update(?,?,?,?);end;");
                 cstm.setString(1,(String)carnetCombo.getSelectedItem());
                 cstm.setString(2,(String)Asig.getSelectedItem());
                 cstm.setInt(3,(int)Evalu.getSelectedItem());
                     if(nota.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Campo Nota esta vacio");
                        }
                        else{
                                   double notaalum = Double.parseDouble(nota.getText());
                                   if(notaalum>=0 && notaalum<=10){
                                          notaalum=Math.rint(notaalum*100)/100;
                                          cstm.setDouble(4,notaalum);
                                          cstm.execute();
                                          cstm.close();
                                          cn.close();
                                   }
                                      else{
                                            JOptionPane.showMessageDialog(null, "La Nota debe estar del rago de cero a diez puntos");
                                        }
                    }
                }
                catch (SQLException se){
                do {
                    System.out.println("SQL STATE: " + se.getSQLState());
                    System.out.println("ERROR CODE: " + se.getErrorCode());
                    System.out.println("MESSAGE: " + se.getMessage());
                    System.out.println();
                    se =se.getNextException();
                } while (se != null);
            } catch (Exception ex) {
        Logger.getLogger(Update_Notas.class.getName()).log(Level.SEVERE, null, ex);
    }
                
        }
        else{
             JOptionPane.showMessageDialog(null, "Seleccione una Asignatura");
        }        
// TODO add your handling code here:
    }//GEN-LAST:event_ActualizarActionPerformed

    private void carnetComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carnetComboMouseClicked
         
// TODO add your handling code here:
    }//GEN-LAST:event_carnetComboMouseClicked

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
            llevar_comboCarnet();
                   
// TODO add your handling code here:
    }//GEN-LAST:event_BuscarActionPerformed

    private void carnetComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carnetComboActionPerformed
         
        // TODO add your handling code here:
    }//GEN-LAST:event_carnetComboActionPerformed

    private void obtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerActionPerformed
       llenar_text();
        // TODO add your handling code here:
    }//GEN-LAST:event_obtenerActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
       System.exit( 0 ); 
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menudocente jFrame= new menudocente();
        jFrame.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
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
            java.util.logging.Logger.getLogger(Update_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Update_Notas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JComboBox Asig;
    private javax.swing.JButton Buscar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JComboBox Evalu;
    private javax.swing.JTextField alumno;
    private javax.swing.JComboBox carnetCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nota;
    private javax.swing.JButton obtener;
    // End of variables declaration//GEN-END:variables
    public void llenarcombo1(String duidoc){
        Connection cn = null;
        OracleConnection c = new OracleConnection();
        try {
                cn= c.getConnectionDocente();
                cstm = cn.prepareCall("begin tareabase.CURSORES.OBTENER_DATOS(?,?);end;");
                cstm.setString(1,duidoc);
                cstm.registerOutParameter(2, OracleTypes.CURSOR);
                cstm.execute();
                rset =((OracleCallableStatement) cstm).getCursor(2);
                while (rset.next()){
                     String dato=rset.getString(1);
                     String estado=rset.getString(2);
                    if("activo".equals(estado))
                        Asig.addItem(dato);
                }
                rset.close();
                cstm.close();
                cn.close();
            }
            catch (SQLException se){
                do {
                    System.out.println("SQL STATE: " + se.getSQLState());
                    System.out.println("ERROR CODE: " + se.getErrorCode());
                    System.out.println("MESSAGE: " + se.getMessage());
                    System.out.println();
                    se = se.getNextException();
                } while (se != null);
            } catch (Exception ex) {
        Logger.getLogger(Update_Notas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void llenarcombo2(){
        Connection cn = null;
        OracleConnection c = new OracleConnection();
        try {
                cn= c.getConnectionDocente();
                String codigo="";
                Evalu.removeAllItems();
                cstm = cn.prepareCall("begin tareabase.CURSORES.LLENAR_COMBO(?,?);end;");
                codigo=(String)Asig.getSelectedItem();
                cstm.setString(1,codigo);
                cstm.registerOutParameter(2, OracleTypes.CURSOR);
                cstm.execute();
                rset =((OracleCallableStatement) cstm).getCursor(2);
                while (rset.next()){
                     int dato=rset.getInt(1);
                     //String estado=rset.getString(2);
                        Evalu.addItem(dato);
                }
                rset.close();
                cstm.close();
                cn.close();
            }
            catch (SQLException se){
                do {
                    System.out.println("SQL STATE: " + se.getSQLState());
                    System.out.println("ERROR CODE: " + se.getErrorCode());
                    System.out.println("MESSAGE: " + se.getMessage());
                    System.out.println();
                    se =se.getNextException();
                } while (se != null);
            } catch (Exception ex) {
        Logger.getLogger(Update_Notas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    public void llevar_comboCarnet(){
        Connection cn = null;
        OracleConnection c = new OracleConnection();
         try{
                cn= c.getConnectionDocente();
                cstm = null;
                rset = null;
                carnetx.clear();
                carnetCombo.removeAllItems();
                String codigo="";
                codigo=(String)Asig.getSelectedItem();
               int evaluacio=(int)Evalu.getSelectedItem();
                cstm = cn.prepareCall("begin tareabase.CURSORES.LLENAR_TEXTFIELDALUMNO2(?,?,?);end;");
                cstm.setString(1,codigo);
                cstm.registerOutParameter(2, OracleTypes.CURSOR);
                cstm.setInt(3,evaluacio);
                cstm.execute();
                rset =((OracleCallableStatement) cstm).getCursor(2);
                while (rset.next()){
                     String dato=rset.getString(1);
                     carnetCombo.addItem(dato);
                }
                rset.close();
                cstm.close();
                cn.close();
               
                }
                catch (SQLException se){
                do {
                    System.out.println("SQL STATE: " + se.getSQLState());
                    System.out.println("ERROR CODE: " + se.getErrorCode());
                    System.out.println("MESSAGE: " + se.getMessage());
                    System.out.println();
                    se =se.getNextException();
                } while (se != null);
            } catch (Exception ex) {
        Logger.getLogger(Update_Notas.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }
    public void llenar_text(){
        Connection cn = null;
        OracleConnection c = new OracleConnection();
                
        try{
                cn= c.getConnectionDocente();
                alumno.setText(null);
                nota.setText(null);
                cstm = null;
                rset = null;
                nombres.clear();
                apellidos.clear();
                Notasx.clear();
                String codigo="";
                codigo=(String)Asig.getSelectedItem();
                String cart=(String)carnetCombo.getSelectedItem();
                cstm = cn.prepareCall("begin tareabase.CURSORES.LLENAR_TEXTFIELDALUMNO3(?,?,?);end;");
                cstm.setString(1,codigo);
                cstm.setString(2, cart);
                cstm.registerOutParameter(3, OracleTypes.CURSOR);
                cstm.execute();
                rset =((OracleCallableStatement) cstm).getCursor(3);
                while (rset.next()){
                     String nombre=rset.getString(1);
                     String apellido=rset.getString(2);
                     double notax=rset.getDouble(3);
                     nombres.add(nombre);
                     apellidos.add(apellido);
                     Notasx.add(notax);
                }
                rset.close();
                cstm.close();
                cn.close();
                String nomb=(String)apellidos.get(0)+' '+(String)nombres.get(0);
                String not=String.valueOf(Notasx.get(0));
                alumno.setText(nomb);
                nota.setText(not);
            }
            catch (SQLException se){
                do {
                    System.out.println("SQL STATE: " + se.getSQLState());
                    System.out.println("ERROR CODE: " + se.getErrorCode());
                    System.out.println("MESSAGE: " + se.getMessage());
                    System.out.println();
                    se =se.getNextException();
                } while (se != null);
            } catch (Exception ex) {
        Logger.getLogger(Update_Notas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}


