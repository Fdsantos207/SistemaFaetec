/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;
import java.sql.*;
import conexao.ModuloConexao;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Fdsan
 */
public class TelaLogin extends javax.swing.JFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public void logar(){
        String sql="select * from tbusuarios where loginusuario=? and senhausuario =?";
        try {
            //as linhas abaixo preparam a consulta ao banco em função do que foi digitado nas caixas de texto
            //o ? é substituido pelo conteudo das variaveis
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUsuario.getText());
            String captura = new String(txtSenha.getPassword());
            pst.setString(2, captura);
            //a linha abaixo executa a query
            rs = pst.executeQuery();
            //se existir usuario e senha correspondente
            if(rs.next()){
                //a llinha a baixo obtem o conteudo do campo perfilda tabela tbfaetec
                String perfil = rs.getString(4);
               // System.out.println(perfil);
               //a estrutura abaixo faz o tratamento do perfildo usuario
               if(perfil.equals("admin")){
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.menAdmin.setEnabled(true);
                TelaPrincipal.lblUsuario.setText(rs.getString(5));
                TelaPrincipal.lblAcesso.setText(rs.getString(4));
                TelaPrincipal.lblUsuario.setForeground(Color.red);
                TelaPrincipal.lblAcesso.setForeground(Color.red);
                this.dispose();
               }else{
                TelaPrincipal principal = new TelaPrincipal();
                principal.setVisible(true);
                TelaPrincipal.lblUsuario.setText(rs.getString(5));
                TelaPrincipal.lblAcesso.setText(rs.getString(4));
                this.dispose();
            }
            }else{
                JOptionPane.showMessageDialog(null,"usuàrio e/ou senha Inválido(s)");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        conexao = ModuloConexao.conector();
        //System.out.println(conexao);
        if (conexao != null){
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dbok.png")));
        }else{
            lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dberro.png")));
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

        txtUsuario = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Faetec - Tela Login");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setText("lauren");
        txtUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 180, 30));

        txtSenha.setForeground(new java.awt.Color(0, 0, 0));
        txtSenha.setText("thais");
        txtSenha.setCaretColor(new java.awt.Color(255, 255, 255));
        txtSenha.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtSenha.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtSenha.setSelectionColor(new java.awt.Color(255, 255, 255));
        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 180, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Senha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        btnLogin.setBackground(new java.awt.Color(0, 204, 0));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 80, -1));

        lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dberro.png"))); // NOI18N
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 50, 50));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 80, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/painel-login-P.png"))); // NOI18N
        jLabel2.setText("Login");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 350, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/telaloginG.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        //Chamando o metodo logar
        logar();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
