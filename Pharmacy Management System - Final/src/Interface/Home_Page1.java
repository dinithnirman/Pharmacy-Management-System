package Interface;

import static Interface.Login.idP;
import My_Code.DBconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class Home_Page1 extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    
    public Home_Page1 () {
        
        initComponents ();
        con = DBconnect.connect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        email = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        changeu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1450, 725));

        jPanel3.setBackground(new java.awt.Color(54, 33, 84));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 470, 280));

        jSeparator3.setBackground(new java.awt.Color(54, 33, 84));
        jSeparator3.setForeground(new java.awt.Color(54, 33, 84));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 530, 80));
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 320, 280));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1020, 730));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 270, 190, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 80, 200, 40));

        jSeparator2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSeparator2MouseClicked(evt);
            }
        });
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 370, 230, 60));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 200, 230, 90));

        email.setBackground(new java.awt.Color(54, 33, 84));
        email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        email.setForeground(new java.awt.Color(255, 255, 255));
        email.setBorder(null);
        email.setCaretColor(new java.awt.Color(255, 255, 255));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 150, 260, 50));

        password.setBackground(new java.awt.Color(54, 33, 84));
        password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setBorder(null);
        password.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel3.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 320, 230, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 500, 110, 40));

        changeu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        changeu.setForeground(new java.awt.Color(255, 255, 255));
        changeu.setText("Change Password");
        changeu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        changeu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeuMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changeuMouseReleased(evt);
            }
        });
        jPanel3.add(changeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

            idP = email.getText();
            pst = con.prepareStatement("SELECT l.Username, l.Password,l1.Username, l1.Password FROM login l,login1 l1 WHERE l.Username = ? AND l.Password = ? or l1.Username = ? AND l1.Password = ?");
            pst.setString(1, email.getText());
            pst.setString(2, String.valueOf(password.getPassword()));
            pst.setString(3, email.getText());
            pst.setString(4, String.valueOf(password.getPassword()));
            rs = pst.executeQuery();
            
            
           
            if(rs.next()) {

                Home_Page2 HP2 = new Home_Page2 ();
                HP2.setVisible ( true );
                this.dispose ();

            }

            else {

                JOptionPane.showMessageDialog(null, "Invalid User");

            }
        }

        catch(Exception e) {

            System.out.println(e.getMessage());

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void changeuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeuMouseClicked
        changeu.setBorder(BorderFactory.createLineBorder(Color.RED));
        Password P1 = new Password ();
        P1.setVisible(true);
        this.dispose();

        // changeu.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }//GEN-LAST:event_changeuMouseClicked

    private void changeuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeuMouseReleased

    }//GEN-LAST:event_changeuMouseReleased

    private void jSeparator2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSeparator2MouseClicked
        // TODO add your handling code here:
        Password p = new Password();
        p.setVisible(true);
    }//GEN-LAST:event_jSeparator2MouseClicked

    public static void main ( String args[] ) {

        java.awt.EventQueue.invokeLater (new Runnable () {
            
            public void run () {
                
                new Home_Page1 ().setVisible ( true );
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel changeu;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JPasswordField password;
    // End of variables declaration//GEN-END:variables
}
