/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Views;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;
import registrofia.OracleConnection;
import registrofia.combos_procedimientos;
/**
 *
 * @author daniel
 */
public class alumno_insertar extends javax.swing.JFrame {

    /**
     * Creates new form alumno_insertar
     */
    public alumno_insertar() {
        initComponents();
        
        Connection conn = null;
        OracleConnection c = new OracleConnection();
        
        try{
            
            conn = c.getConnection();
            
            //LLamado del procedimiento al estilo pl/sql
            String sql="begin sp_usuarios_disponibles(?); end;";
            
            CallableStatement sp;
            sp = conn.prepareCall(sql);
 
            //Parametros de entrada EL 1 INDICA PRIMER PARAMETRO
            sp.registerOutParameter(1, OracleTypes.CURSOR);

            sp.execute();
            //Se obtiene el cursor en forma de ResultSet
            ResultSet rs = (ResultSet)sp.getObject(1);
           
            while (rs.next()){
                id_usuario.addItem( new combos_procedimientos( 1 ,rs.getString("id_usuario") ));
            }
            
            rs.close();
            sp.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        id_usuario = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        carnet = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombres = new javax.swing.JTextField();
        apellidos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fecha_nac = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        direccion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tipo_sangre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        madre = new javax.swing.JTextField();
        num_emergencia = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        padre = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresar un nuevo alumno"));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Usuarios no asignados :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("Carnet :");

        carnet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                carnetKeyTyped(evt);
            }
        });

        jLabel3.setText("Nombres :");

        jLabel4.setText("Apellidos :");

        nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombresKeyTyped(evt);
            }
        });

        apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                apellidosKeyTyped(evt);
            }
        });

        jLabel5.setText("Fecha de nacimiento :");

        fecha_nac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd-MM-yyyy"))));
        fecha_nac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fecha_nacKeyTyped(evt);
            }
        });

        jLabel6.setText("Direccion :");

        direccion.setColumns(20);
        direccion.setRows(5);
        direccion.setMinimumSize(new java.awt.Dimension(3, 22));
        jScrollPane1.setViewportView(direccion);

        jLabel7.setText("Email :");

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });

        jLabel8.setText("Tipo de sangre :");

        tipo_sangre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tipo_sangreKeyTyped(evt);
            }
        });

        jLabel9.setText("Numero emergencia :");

        madre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                madreKeyTyped(evt);
            }
        });

        try {
            num_emergencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        num_emergencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_emergenciaActionPerformed(evt);
            }
        });
        num_emergencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                num_emergenciaKeyTyped(evt);
            }
        });

        jLabel10.setText("Nombre madre :");

        jLabel11.setText("Nombre padre :");

        padre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                padreKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)))
                            .addComponent(madre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(padre, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(num_emergencia)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha_nac, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tipo_sangre, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fecha_nac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tipo_sangre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(num_emergencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(madre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(padre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        guardar.setText("Guardar alumno");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void num_emergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num_emergenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num_emergenciaActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        OracleConnection c = new OracleConnection();
        
        combos_procedimientos objeto = (combos_procedimientos) id_usuario.getSelectedItem();
           
        try{
            conn = c.getConnection();
            
            if( carnet.getText().trim().length()==0 || nombres.getText().trim().length()==0 || apellidos.getText().trim().length()==0 || fecha_nac.getText().trim().length()==0 || direccion.getText().trim().length()==0 || email.getText().trim().length()==0 )
            {
                JOptionPane.showMessageDialog(null, "Los campos carnet, nombres, apellidos, fecha nacimiento, direccion y email deben estar llenos ", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if( tipo_sangre.getText().trim().length()==0 )
                {
                    tipo_sangre.setText(null);
                }
                
                if( num_emergencia.getText().trim().length()==0 )
                {
                    num_emergencia.setText(null);
                }
                
                if( madre.getText().trim().length()==0 )
                {
                    madre.setText(null);
                }
                
                if( padre.getText().trim().length()==0 )
                {
                    padre.setText(null);
                }
                
                CallableStatement sp ;
                sp = conn.prepareCall("call sp_alumno(?,?,?,?,?,?,?,?,?,?,?)");
                sp.setString("carnet1", carnet.getText().toString() );
                sp.setString("id_usuario1", objeto.getdato() );
                sp.setString("nombres1", nombres.getText().toString() );
                sp.setString("apellidos1", apellidos.getText().toString() );
                sp.setString("fecha_nac1", fecha_nac.getText().toString() );
                sp.setString("direccion1", direccion.getText().toString() );
                sp.setString("email1", email.getText().toString() );
                sp.setString("tipo_sangre1", tipo_sangre.getText().toString() );
                sp.setString("num_emergencia1", num_emergencia.getText().toString() );
                sp.setString("nombre_madre1", madre.getText().toString() );
                sp.setString("nombre_padre1", padre.getText().toString() );
                
                if(sp.execute() )//Ejecución del procedimiento
                {
                    JOptionPane.showMessageDialog(null, "Usuario almacenado correctamente", " ", JOptionPane.INFORMATION_MESSAGE);
                }

                sp.close();
                conn.close();
                
                this.dispose();
                new alumno_insertar().setVisible(true);
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombresKeyTyped
        // TODO add your handling code here:
        if(nombres.getText().length()>=49) evt.consume();
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE) && (car!=(char)KeyEvent.VK_BACK_SPACE) )
        {
           evt.consume();
        }
    }//GEN-LAST:event_nombresKeyTyped

    private void apellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellidosKeyTyped
        // TODO add your handling code here:
        if(apellidos.getText().length()>=49) evt.consume();
        
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE) && (car!=(char)KeyEvent.VK_BACK_SPACE) )
        {
           evt.consume();
        }
    }//GEN-LAST:event_apellidosKeyTyped

    private void carnetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carnetKeyTyped
        // TODO add your handling code here:
        if(carnet.getText().length()>=7) evt.consume();
    }//GEN-LAST:event_carnetKeyTyped

    private void fecha_nacKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fecha_nacKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if(fecha_nac.getText().length()>=10) evt.consume();
        if((car<'0' || car>'9') && car != '-' && car != '/') evt.consume();
    }//GEN-LAST:event_fecha_nacKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        // TODO add your handling code here:
        if(email.getText().length()>=40) evt.consume();
    }//GEN-LAST:event_emailKeyTyped

    private void tipo_sangreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipo_sangreKeyTyped
        // TODO add your handling code here:
        if(tipo_sangre.getText().length()>=4) evt.consume();
    }//GEN-LAST:event_tipo_sangreKeyTyped

    private void num_emergenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num_emergenciaKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_num_emergenciaKeyTyped

    private void madreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_madreKeyTyped
        // TODO add your handling code here:
        if(madre.getText().length()>=49) evt.consume();
        
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE) && (car!=(char)KeyEvent.VK_BACK_SPACE) )
        {
           evt.consume();
        }
    }//GEN-LAST:event_madreKeyTyped

    private void padreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_padreKeyTyped
        // TODO add your handling code here:
        if(padre.getText().length()>=49) evt.consume();
        
        char car = evt.getKeyChar();    
        if((car<'a' || car>'z') && (car<'A' || car>'Z') && (car!=(char)KeyEvent.VK_SPACE) && (car!=(char)KeyEvent.VK_BACK_SPACE) )
        {
           evt.consume();
        }
    }//GEN-LAST:event_padreKeyTyped

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
            java.util.logging.Logger.getLogger(alumno_insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(alumno_insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(alumno_insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(alumno_insertar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new alumno_insertar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidos;
    private javax.swing.JTextField carnet;
    private javax.swing.JTextArea direccion;
    private javax.swing.JTextField email;
    private javax.swing.JFormattedTextField fecha_nac;
    private javax.swing.JButton guardar;
    private javax.swing.JComboBox id_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField madre;
    private javax.swing.JTextField nombres;
    private javax.swing.JFormattedTextField num_emergencia;
    private javax.swing.JTextField padre;
    private javax.swing.JTextField tipo_sangre;
    // End of variables declaration//GEN-END:variables
}
