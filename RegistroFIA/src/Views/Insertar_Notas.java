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
public class Insertar_Notas extends javax.swing.JFrame {
ArrayList carnetx = new ArrayList();
ArrayList nombres = new ArrayList();
ArrayList apellidos = new ArrayList();
int j;
CallableStatement cstm = null;
ResultSet rset = null;
    /**
     * Creates new form Insertar_Notas
     */
    public Insertar_Notas() {
        initComponents();
       llenarcombo1();
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
        Eval = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        alumno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nota = new javax.swing.JTextField();
        siguiente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        carnet = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Notas");

        jLabel1.setText("Asignatura");

        Asig.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Opcion" }));
        Asig.setToolTipText("");
        Asig.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Asig.setKeySelectionManager(null);
        Asig.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                AsigComponentAdded(evt);
            }
        });
        Asig.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AsigItemStateChanged(evt);
            }
        });
        Asig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsigActionPerformed(evt);
            }
        });

        jLabel2.setText("Evaluacion");

        Eval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EvalActionPerformed(evt);
            }
        });

        jLabel3.setText("Alumno");

        alumno.setEditable(false);

        jLabel4.setText("Nota");

        nota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                notaKeyTyped(evt);
            }
        });

        siguiente.setText("Siguiente");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");

        jButton4.setText("Volver");

        jLabel6.setText("Carnet");

        carnet.setEditable(false);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Asig, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nota, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Eval, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 57, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(siguiente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(64, 64, 64))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Asig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Eval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(alumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguiente)
                    .addComponent(jButton3))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AsigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsigActionPerformed
       llenarcombo2();
       j=1;
        // TODO add your handling code here:
    }//GEN-LAST:event_AsigActionPerformed

    private void AsigComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_AsigComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_AsigComponentAdded

    private void AsigItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AsigItemStateChanged
        
    }//GEN-LAST:event_AsigItemStateChanged

    private void EvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EvalActionPerformed
       
    }//GEN-LAST:event_EvalActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
               //insercion de notas ciclo
        if(Asig.getSelectedIndex()!=0){
            Connection cn = null;
            OracleConnection c = new OracleConnection();
             try{
                 cn= c.getConnectionDocente();
                 cstm = cn.prepareCall("begin notasfia.sp_nota_ciclo_insert(?,?,?,?);end;");
                 cstm.setString(1,carnet.getText());
                 cstm.setString(2,(String)Asig.getSelectedItem());
                 cstm.setInt(3,(int)Eval.getSelectedItem());
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
                                          int i=(int)carnetx.size();
                                            if(j<i){
                                            carnet.setText(null);
                                            alumno.setText(null);
                                            String car2=(String)carnetx.get(j);
                                            carnet.setText(car2);
                                            String nomb2=(String)apellidos.get(j)+' '+(String)nombres.get(j);
                                            alumno.setText(nomb2);
                                            j++;
                                            }
                                            else{
                                                JOptionPane.showMessageDialog(null, "Este es el ulimo elemento");
                                            }
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
                Logger.getLogger(Insertar_Notas.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        else{
             JOptionPane.showMessageDialog(null, "Seleccione una Asignatura");
        }
               
    }//GEN-LAST:event_siguienteActionPerformed

    private void notaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notaKeyTyped
       int k = (int) evt.getKeyChar();
if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {

evt.consume();
JOptionPane.showMessageDialog(null, "No puede ingresar Letras", "Error en los datos", JOptionPane.ERROR_MESSAGE);
}  // TODO add your handling code here:
    }//GEN-LAST:event_notaKeyTyped

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
            java.util.logging.Logger.getLogger(Insertar_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar_Notas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Insertar_Notas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox Asig;
    private javax.swing.JComboBox Eval;
    private javax.swing.JTextField alumno;
    private javax.swing.JTextField carnet;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nota;
    private javax.swing.JButton siguiente;
    // End of variables declaration//GEN-END:variables
    public void llenarcombo1(){
        Connection cn = null;
        OracleConnection c = new OracleConnection();
        try {
                cn= c.getConnectionDocente();
                cstm = cn.prepareCall("begin notasfia.CURSORES.OBTENER_DATOS(?,?);end;");
                String dui= "12345";
                cstm.setString(1,dui);
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
        Logger.getLogger(Insertar_Notas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void llenarcombo2(){
        Connection cn = null;
        OracleConnection c = new OracleConnection();
        try {
                cn= c.getConnectionDocente();
                String codigo="";
                Eval.removeAllItems();
                cstm = cn.prepareCall("begin notasfia.CURSORES.LLENAR_COMBO(?,?);end;");
                codigo=(String)Asig.getSelectedItem();
                cstm.setString(1,codigo);
                cstm.registerOutParameter(2, OracleTypes.CURSOR);
                cstm.execute();
                rset =((OracleCallableStatement) cstm).getCursor(2);
                while (rset.next()){
                     int dato=rset.getInt(1);
                     //String estado=rset.getString(2);
                        Eval.addItem(dato);
                }
                rset.close();
                cstm.close();
                cstm = null;
                rset = null;
                carnetx.clear();
                nombres.clear();
                apellidos.clear();
                cstm = cn.prepareCall("begin notasfia.CURSORES.LLENAR_TEXTFIELDALUMNO(?,?);end;");
                cstm.setString(1,codigo);
                cstm.registerOutParameter(2, OracleTypes.CURSOR);
                cstm.execute();
                rset =((OracleCallableStatement) cstm).getCursor(2);
                while (rset.next()){
                     String dato=rset.getString(1);
                     String nombre=rset.getString(2);
                     String apellido=rset.getString(3);
                     carnetx.add(dato);
                     nombres.add(nombre);
                     apellidos.add(apellido);
                     //String estado=rset.getString(2);
                        System.out.println(dato);
                }
                rset.close();
                cstm.close();
                cn.close();
                String car=(String)carnetx.get(0);
                carnet.setText(car);
                String nomb=(String)apellidos.get(0)+' '+(String)nombres.get(0);
                alumno.setText(nomb);
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
        Logger.getLogger(Insertar_Notas.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}

