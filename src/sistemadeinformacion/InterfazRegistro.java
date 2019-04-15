
package sistemadeinformacion;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Adan
 */
public class InterfazRegistro extends javax.swing.JFrame {

    Connection miConexion;
    public InterfazRegistro() {
        initComponents();
         this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eti_registro = new javax.swing.JLabel();
        eti_usuario = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoContra = new javax.swing.JPasswordField();
        campoUsuario = new javax.swing.JTextField();
        campoCorreo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        SeleccionCombo = new javax.swing.JComboBox();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eti_registro.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        eti_registro.setForeground(new java.awt.Color(240, 240, 240));
        eti_registro.setText("REGISTRO");
        getContentPane().add(eti_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 30));

        eti_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        eti_usuario.setForeground(new java.awt.Color(240, 240, 240));
        eti_usuario.setText("Usuario:");
        getContentPane().add(eti_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Contraseña:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Correo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        campoContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoContraActionPerformed(evt);
            }
        });
        campoContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoContraKeyTyped(evt);
            }
        });
        getContentPane().add(campoContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 160, 30));

        campoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(campoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 160, 30));

        campoCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoCorreoFocusLost(evt);
            }
        });
        campoCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(campoCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 160, 30));

        jButton1.setBackground(new java.awt.Color(0, 51, 255));
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("Crear cuenta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 110, -1));

        SeleccionCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selec...", "Docente", "Estudiante" }));
        getContentPane().add(SeleccionCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 466, 479));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUsuarioActionPerformed

    private void campoCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCorreoActionPerformed

    private void botonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        
         int i=SeleccionCombo.getSelectedIndex();
        if(i==0)
        {
            JOptionPane.showMessageDialog(this,"seleccione el tipo de usuario");
        }else
        {
            if(i==1)
            {
                insertarDocentesBBDD();
            }else
            {
                if(i==2)
                {
                    insertarEstudiantesBBDD();
                }
            }
        }
        
        
    }                                                


    private void campoContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoContraKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar(); 
        char letra = evt.getKeyChar();
             
              if((num < '0'|| num > '9') && (letra < 'a'|| letra > 'z')){
                  evt.consume();
               
              JOptionPane.showMessageDialog(null, "ingrese solo nuneros o letras minusculas", "Advertencia",JOptionPane.ERROR_MESSAGE );
              campoContra.setText("");
              campoContra.requestFocus();
          }
              //else JOptionPane.showMessageDialog(rootPane, "Bienvenido al sistema");
    }//GEN-LAST:event_campoContraKeyTyped

    //metodo para validar correo electronico
    public boolean isEmail(String correo){
    
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\\\\\+]+(\\.[\\w\\\\]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z](2,4)$)");
        mat =pat.matcher(correo);
        if (mat.find()){
            return true;
        }else{
            return false;
        }
    }
    private void campoCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoCorreoFocusLost
        // TODO add your handling code here:
        if(isEmail(campoCorreo.getText())){
          
        }else{
            JOptionPane.showMessageDialog(null,"Email no valido","Validar Email",JOptionPane.INFORMATION_MESSAGE);
            campoCorreo.requestFocus();
        }
        
    }//GEN-LAST:event_campoCorreoFocusLost

    private void campoContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoContraActionPerformed


    public static void main(String args[]) {
      
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazRegistro().setVisible(true);
            }
        });*/
    }
    
    public void insertarEstudiantesBBDD()
    {
        
        try{
         //1 Crear Conexion 
          miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_sis2","root","");   
         // 2 preparar la consulta
         PreparedStatement miSentencia=miConexion.prepareStatement("INSERT INTO estudiantes (usuario,password,correo) VALUES (?,?,?)");
         //3 establecer parametros de la consulta
          miSentencia.setString(1,campoUsuario.getText());
          miSentencia.setString(2,campoCorreo.getText());
          miSentencia.setString(3,campoCorreo.getText());
          miSentencia.executeUpdate();
          JOptionPane.showMessageDialog(this,"GUARDADO");
        }catch(Exception error)
        {
            System.out.println("no se puede conectar a base de datos");
        }
        
    }
    
    public void insertarDocentesBBDD()
    {
        
         try{
         //1 Crear Conexion 
          miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_sis2","root","");   
         // 2 preparar la consulta
         PreparedStatement miSentencia=miConexion.prepareStatement("INSERT INTO docentes (usuario,password,correo) VALUES (?,?,?)");
         //3 establecer parametros de la consulta
          miSentencia.setString(1,campoUsuario.getText());
          miSentencia.setString(2,campoContra.getText());
          miSentencia.setString(3,campoCorreo.getText());
          miSentencia.executeUpdate();
          JOptionPane.showMessageDialog(this,"GUARDADO");
        }catch(Exception error)
        {
            System.out.println("no se puede conectar a base de datos");
        }
    }
    
    public void ejecutar()
    {
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JComboBox SeleccionCombo;
    private javax.swing.JPasswordField campoContra;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel eti_registro;
    private javax.swing.JLabel eti_usuario;
    private javax.swing.JButton botonCrearCuenta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
