/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import My_Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import Validation.Accounts;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;

/**
 *
 * @author Devin
 */
public class bankacc extends javax.swing.JInternalFrame {
    Connection ct=null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Creates new form bankacc
     */
    public bankacc() {
        initComponents();
        ct= DBconnect.connect();
        tabled();
    }
    
    public void clear(){
        bank.setText ( " " );
        accno.setText ( " " );
        type.setSelectedItem("Select Type" );
        }
    
    public void tabled(){
        try{
            String Se= "SELECT bankName,accNo,accType FROM bankacc";
            ps = ct.prepareStatement(Se);
            rs = ps.executeQuery();
            
            bacc.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
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

        jPanel2 = new javax.swing.JPanel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        bank = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bacc = new javax.swing.JTable();
        accno = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        type = new javax.swing.JComboBox<>();
        add1 = new javax.swing.JButton();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(215, 215, 230));
        jPanel2.setMinimumSize(new java.awt.Dimension(1010, 590));
        jPanel2.setPreferredSize(new java.awt.Dimension(1080, 640));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 200, 0));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Account Number");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        bank.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                bankKeyTyped(evt);
            }
        });
        jPanel2.add(bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 230, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Type");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setText("Bank Accounts");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 269, 81));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Bank");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        bacc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        bacc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                baccMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(bacc);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        accno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                accnoKeyTyped(evt);
            }
        });
        jPanel2.add(accno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 230, 30));

        add.setBackground(new java.awt.Color(85, 55, 118));
        add.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel2.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 90, 40));

        clear.setBackground(new java.awt.Color(85, 55, 118));
        clear.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Clear");
        clear.setFocusable(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel2.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 90, 40));

        remove.setBackground(new java.awt.Color(85, 55, 118));
        remove.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove");
        remove.setFocusable(false);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        jPanel2.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 110, 40));

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type", "Savings Account", "Current Account" }));
        type.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                typePopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                typeMouseClicked(evt);
            }
        });
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel2.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 230, 30));

        add1.setBackground(new java.awt.Color(85, 55, 118));
        add1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        add1.setForeground(new java.awt.Color(255, 255, 255));
        add1.setText("Update");
        add1.setFocusable(false);
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        jPanel2.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        
        clear();
        
    }//GEN-LAST:event_clearActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:int x = JOptionPane.showConfirmDialog ( null, "Do you really want to delete?" );
        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to delete?" );
        if ( x==0 ) {
        
            String a = bank.getText();
            String b = accno.getText();
            try {
            
                String sql = "DELETE FROM bankacc WHERE bankName = '"+ a +"' and accNo = '"+ b +"' ";
                ps = ct.prepareStatement ( sql );
                ps.execute ();
                
//                sql = "DELETE FROM login WHERE Username = '"+ sid +"' ";
//                ps = ct.prepareStatement ( sql );
//                ps.execute ();
                
                JOptionPane.showMessageDialog ( null, "Delete Succesful" );
                clear();
                tabled ();
        
            } 
        
            catch ( Exception e ) {
            
                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot delete." );
                
                System.out.println ( e );
            
            }
        }
    }//GEN-LAST:event_removeActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        Accounts a = new Accounts();

            try {
                String banks = bank.getText();
        String accNo = accno.getText();
        if(a.AccTypeValidation(type.getSelectedItem().toString())){
        String types = type.getSelectedItem().toString();


                String sql = "INSERT INTO bankacc ( bankName,accNo,accType) VALUES ( '" + banks + "', '" + accNo + "', '" + types + "' )";
                ps = ct.prepareStatement(sql);
                ps.execute();

                JOptionPane.showMessageDialog(null, "Add Succesful");
                clear();
                tabled();

            } }catch (Exception e) {

                System.out.println(e);

                JOptionPane.showMessageDialog ( null, "Invalid records" );

                    }
        
    }//GEN-LAST:event_addActionPerformed

    private void baccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_baccMouseClicked
        // TODO add your handling code here:
        accno.setEnabled(false);
        int r = bacc.getSelectedRow ();

        String b_n = bacc.getValueAt ( r, 0 ).toString ();
        String an = bacc.getValueAt ( r, 1).toString ();
        String at = bacc.getValueAt ( r, 2 ).toString ();
        /*int qty2 = Integer.parseInt(qty1);
        try{
        String sql = "Select Sales_Price from sales_stock where Item_Code = '"+ic +"' and Stock_Type = '"+ type+"'";
        ps = ct.prepareStatement(sql);
        ps.executeQuery();
        while(rs.next()){
            String unitprice = rs.getString ( 1 );
            up.setText(unitprice);
        }
        }
        catch(Exception e){
            System.out.println(e);
        }
        String date1 = exchange.getValueAt ( r, 5 ).toString ();
         */             
        System.out.println(an);
        type.setSelectedItem(at);
        accno.setText(an);
        bank.setText(b_n);
        
    }//GEN-LAST:event_baccMouseClicked

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        Accounts a = new Accounts();

        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to update?" );

        if ( x==0 ) {
             
               
            try {
            
             String banks = bank.getText();
//            if(!a.bnameValidation(banks)){
          String accNo = accno.getText();
          if(a.AccTypeValidation(type.getSelectedItem().toString())){
            String types = type.getSelectedItem().toString();
                String sql1 = "UPDATE bankacc SET bankName = '"+ banks +"',accType = '"+ types +"' WHERE accNo='"+ accNo +"' ";
                ps = ct.prepareStatement ( sql1 );
                ps.execute ();
                
            
            
                JOptionPane.showMessageDialog ( null, "Update Succesful" );
                clear();
                tabled();}
                
          }
            
           
            catch ( Exception e ) {

                System.out.println ( e );

                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot update." );

            
            }
            }
       // }
        //}
        
    }//GEN-LAST:event_add1ActionPerformed

    private void accnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accnoKeyTyped
        // TODO add your handling code here:
         Accounts a3= new Accounts();
        Accounts a2= new Accounts();
                String type1 = bank.getText();
         if(type1.equals("")){
             getToolkit().beep();
             accno.setText("");
             //qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Enter Bank Name", "Error", JOptionPane.INFORMATION_MESSAGE);
             accno.setText("");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(a2.AccNumvalidation(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             accno.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Account Number format invalid it's should be Digits only ");
             evt.consume();
         }
         accno.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
    }//GEN-LAST:event_accnoKeyTyped

    private void bankKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankKeyTyped
        // TODO add your handling code here:
        Accounts a2= new Accounts();
        char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(a2.Namevalidation(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             bank.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Bank Name format invalid it's should be Letters only ");
             evt.consume();
         }
         bank.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         
    }//GEN-LAST:event_bankKeyTyped

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_typeActionPerformed

    private void typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typeMouseClicked
        // TODO add your handling code here:
             String type1 = accno.getText();
         if(type1.equals("")){
             System.out.println("gg");
             getToolkit().beep();
             type.setSelectedItem("Select Type");
             //qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Enter Account Number", "Error", JOptionPane.INFORMATION_MESSAGE);
             type.setSelectedItem("Select Type");
            evt.consume();
         }
    }//GEN-LAST:event_typeMouseClicked

    private void typePopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_typePopupMenuCanceled
        // TODO add your handling code here:
            
    }//GEN-LAST:event_typePopupMenuCanceled

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(bankacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(bankacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(bankacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(bankacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new bankacc().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accno;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JTable bacc;
    private javax.swing.JTextField bank;
    private javax.swing.JButton clear;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton remove;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
