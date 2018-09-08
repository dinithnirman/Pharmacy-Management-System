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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author AAA
 */
public class Returns_Notification extends javax.swing.JFrame {

    /**
     * Creates new form Returns_Notification
     */
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public static String id;
    public static String sname;
    public static String bname;
    public static String qty;
    public static String tot;
    public static String ndate;
    public static String edate;
    
    public Returns_Notification() {
        initComponents();
        con = DBconnect.connect();
        aa();
        tableload1();
        
    }
    
    public void aa(){
        try{
         /*String sq1l = "SELECT * FROM `returns_notification`";
            pst = con.prepareStatement ( sq1l );
            rs = pst.executeQuery ();
            while(rs.next()){
                String sname = rs.getString(2);
                String bname = rs.getString(3);
                String qty = rs.getString(4);
                String tot = rs.getString(5);
                String ndate = rs.getString(6);
                String edate = rs.getString(7);    */
            
        String sql = "SELECT s.Price,p.brandName,s.Quantity,s.Expiry_Date,s.Status,s.Expiry_Date,s.Item_Code FROM sales_stock s,pharma_items p where p.I_id=s.Item_Code AND s.Expiry_Date <= DATE_ADD(DATE(now()), INTERVAL 7 MONTH) and s.Expiry_Date > CURDATE()";
                pst = con.prepareStatement ( sql );
                rs = pst.executeQuery ();
                while(rs.next()){
                    //String sName = rs.getString(1);
                    String price = rs.getString(1);
                    double price1 = Double.parseDouble(price);
                    String bName = rs.getString(2);
                    String quantity = rs.getString(3);
                    int quantity1 = Integer.parseInt(quantity);
                    double total = quantity1 * price1;
                    String total1 = Double.toString(total);
                    String expdate = rs.getString(4);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date d = new Date();
                    String date = sdf.format(d);
                    String status = rs.getString(5);
                    String stt= rs.getString(6);
                    String ic= rs.getString(7);
                    //(`Supplier_Name`, `Brand_Name`, `Quantity`, `Total`, `Notification_Date`, `Expiry_Date`) VALUES ('"+ sName +"','"+ bName +"','"+ quantity +"','"+ total1 +"','"+ date +"','"+ expdate +"')
                    //if((!sname.equals(sName))&&(!bname.equals(bName))&&(!qty.equals(quantity))&&(!tot.equals(total1))&&(!ndate.equals(date))&&(!edate.equals(expdate))){*/
                    
                    /*String sql1="SELECT `Supplier_Name`, `Brand_Name`, `Quantity`, `Total`, `Notification_Date`, `Expiry_Date`,`Status` from returns_notification where Supplier_Name='"+ sName +"' and Brand_Name='"+ bName +"' and Quantity='"+ quantity +"' and Total='"+ total1 +"' and Notification_Date='"+ date +"' and Expiry_Date='"+ expdate+"'";
                    pst = con.prepareStatement ( sql1 );
                    rs = pst.executeQuery ();
                     while(rs.next()){
                    String sName5 = rs.getString(1);
                    String price5 = rs.getString(2);
                    double price15 = Double.parseDouble(price);
                    String bName5 = rs.getString(3);
                    String quantity5 = rs.getString(4);
                    int quantity15 = Integer.parseInt(quantity);
                    double total5 = quantity1 * price1;
                    String total15 = Double.toString(total);
                    String expdate5 = rs.getString(5);
                    SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM-dd");
                    Date d5 = new Date();
                    String date5 = sdf5.format(d);
                    
                     
                    if(sName5.isEmpty()&&price5.isEmpty()&&bName5.isEmpty()&&quantity5.isEmpty()&&total15.isEmpty()&&expdate5.isEmpty()&&date5.isEmpty()){*/
                    
                    
                    if(status.equals("False")){    
                        String s = "True";
                        
                    String sql2 = "Insert INTO returns_notification(`Brand_Name`, `Quantity`, `Total`, `Notification_Date`, `Expiry_Date`) VALUES ('"+ bName +"','"+ quantity +"','"+ total1 +"','"+ date +"','"+ expdate+"')" ;//WHERE NOT EXISTS (SELECT `Supplier_Name`, `Brand_Name`, `Quantity`, `Total`, `Notification_Date`, `Expiry_Date` from returns_notification where Spplier_Name='"+ sName +"' and Brand_Name='"+ bName +"' and Quantity='"+ quantity +"' and Total='"+ total1 +"' and Notification_Date='"+ date +"' and Expiry_Date='"+ expdate +;
                        pst = con.prepareStatement ( sql2 );
                        pst.executeUpdate();
                        
                        String sql1 = "UPDATE sales_stock SET Status='"+ s +"' WHERE Expiry_Date='"+ stt +"' and Item_Code='"+ ic +"' ";
                        pst = con.prepareStatement ( sql1 );
                        pst.execute ();
                        
                     
                    
                
        
                
               
            }}}
        catch(Exception e){
            System.out.println(e);
        }
    }
        
    
    
    
    

    public void tableload1 () {
        
        try {
            String sq1 = "SELECT * FROM `returns_notification`";
            pst = con.prepareStatement ( sq1 );
            rs = pst.executeQuery ();
            
                
            notification.setModel ( DbUtils.resultSetToTableModel ( rs ));
            
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notification = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        notification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Notification_Id", "Brand_Name", "Quantity", "Total", "Notification_Date", "Expiry_Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notificationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(notification);

        jPanel2.setBackground(new java.awt.Color(85, 55, 118));

        Back.setBackground(new java.awt.Color(85, 55, 118));
        Back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.setAutoscrolls(true);
        Back.setBorder(null);
        Back.setBorderPainted(false);
        Back.setFocusable(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(85, 55, 118));
        Logout.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.setAutoscrolls(true);
        Logout.setBorder(null);
        Logout.setBorderPainted(false);
        Logout.setFocusable(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Supplier Return Notifications");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        this.dispose ();
    }//GEN-LAST:event_BackActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed

        Home_Page1 HP1 = new Home_Page1 ();
        Home_Page2 HP2 = new Home_Page2 ();
        HP1.setVisible ( true );
        this.dispose ();
        HP2.dispose ();
    }//GEN-LAST:event_LogoutActionPerformed

    private void notificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notificationMouseClicked
        // TODO add your handling code here:
        int r = notification.getSelectedRow ();

        id = notification.getValueAt ( r, 0 ).toString ();
        //sname = notification.getValueAt ( r, 1 ).toString ();
        bname = notification.getValueAt ( r, 1 ).toString ();
        qty = notification.getValueAt ( r, 2 ).toString ();
        tot = notification.getValueAt ( r, 3 ).toString ();
        ndate = notification.getValueAt ( r, 4 ).toString ();
        edate = notification.getValueAt ( r, 5 ).toString ();
        
        
    }//GEN-LAST:event_notificationMouseClicked

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
            java.util.logging.Logger.getLogger(Returns_Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Returns_Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Returns_Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Returns_Notification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Returns_Notification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Logout;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable notification;
    // End of variables declaration//GEN-END:variables
}
