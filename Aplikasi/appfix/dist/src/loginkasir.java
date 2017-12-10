
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class loginkasir extends javax.swing.JFrame {

    public loginkasir() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        BATAl = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel1.setText("LOGIN KASIR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 270, 31));
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 300, 40));

        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, -1, -1));

        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 70, 29));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/1493408028_Login Manager.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 140));
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 300, 40));

        BATAl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai batal login.png"))); // NOI18N
        BATAl.setText("BATAL");
        BATAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BATAlActionPerformed(evt);
            }
        });
        jPanel1.add(BATAl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 203, 230, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon kecil/pakai masuk.png"))); // NOI18N
        jButton1.setText("MASUK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 230, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 590, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Statement statement = (Statement)koneksi.koneksi.getConnection().createStatement();
            ResultSet result = statement.executeQuery("select * from loginkasir where usernamekasir= '"+username.getText()+"'");
            if (result.next()){
                if(password.getText().equals(result.getString("passwordkasir"))){
                    new menukasir().setVisible(true);
                    this.dispose();
                 }else{
                    JOptionPane.showMessageDialog(rootPane, "password salah");
                    password.setText("");
                    username.requestFocus();
                }
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "username tidak ditemukan");
                password.setText("");
                username.setText("");
                username.requestFocus();
            } 
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "gagal");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.setLocationRelativeTo(null);    
    }//GEN-LAST:event_formWindowOpened

    private void BATAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BATAlActionPerformed
        new utama().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BATAlActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginkasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BATAl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
