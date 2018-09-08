package Interface;
import My_Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import Validation.Returns;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import net.sf.jasperreports.engine.JRException;

import static rr.Ireport.MyReport;


public class Licence_Renew_Home extends javax.swing.JInternalFrame {
    Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String da;
    public Licence_Renew_Home () {
         
        initComponents ();
        
    con = DBconnect.connect();
        tableload();
    }
    
    public boolean dateValidation(){
        if(((JTextField)date.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            
            return false;
        } else {
            return true;
        }
    }
    
    public void clear () {
        
        Charge.setText("");
        date.setDate(null);
        renewid.setText("");
        
    }
    
    public void tableload () {
        
        
        try {
            
            String sql = "SELECT RenewID,RenewDate,Charge FROM license_renewal";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            renew.setModel ( DbUtils.resultSetToTableModel ( rs ));
          
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Licence = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        IHome = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        view = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        Charge = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        renew = new javax.swing.JTable();
        date = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        renewid = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1030, 670));
        setPreferredSize(new java.awt.Dimension(1080, 725));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(85, 55, 118));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Licence.setBackground(new java.awt.Color(85, 55, 118));
        Licence.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Licence.setForeground(new java.awt.Color(255, 255, 255));
        Licence.setText("Manage Licence Renew");
        Licence.setAutoscrolls(true);
        Licence.setBorder(null);
        Licence.setBorderPainted(false);
        Licence.setFocusable(false);
        Licence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LicenceActionPerformed(evt);
            }
        });
        jPanel3.add(Licence, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 40));

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
        jPanel3.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 111, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLabel1.setText("Retail License Renewal");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Renew Date");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Charge");

        add.setBackground(new java.awt.Color(85, 55, 118));
        add.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.setAutoscrolls(true);
        add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.setBorderPainted(false);
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        view.setBackground(new java.awt.Color(85, 55, 118));
        view.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        view.setForeground(new java.awt.Color(255, 255, 255));
        view.setText("Remove");
        view.setAutoscrolls(true);
        view.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        view.setBorderPainted(false);
        view.setFocusable(false);
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(85, 55, 118));
        clear.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("Clear");
        clear.setAutoscrolls(true);
        clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.setBorderPainted(false);
        clear.setFocusable(false);
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        Charge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Charge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChargeActionPerformed(evt);
            }
        });
        Charge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ChargeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ChargeKeyTyped(evt);
            }
        });

        renew.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "RenewDate", "Charge"
            }
        ));
        renew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                renewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(renew);

        date.setDateFormatString("yyyy-MM-dd");
        date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dateMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dateMousePressed(evt);
            }
        });
        date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateKeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Renew id");

        renewid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton11.setBackground(new java.awt.Color(85, 55, 118));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Update");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(85, 55, 118));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("View Report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Charge, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(renewid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(Charge, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(renewid, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add)
                            .addComponent(clear)
                            .addComponent(view)
                            .addComponent(jButton11))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        IHome.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout IHomeLayout = new javax.swing.GroupLayout(IHome);
        IHome.setLayout(IHomeLayout);
        IHomeLayout.setHorizontalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        IHomeLayout.setVerticalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(IHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1080, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LicenceActionPerformed

        IHome.removeAll ();
        licencerenew LR = new licencerenew ();
        IHome.add ( LR ).setVisible ( true );
        
    }//GEN-LAST:event_LicenceActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed

        Home_Page1 HP1 = new Home_Page1 ();
        HP1.setVisible ( true );
        this.dispose ();
        
    }//GEN-LAST:event_LogoutActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        Returns r = new Returns();

        try {
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            da = d.format(date.getDate());
            String charge = Charge.getText ();

            String sql = "Insert into license_renewal(RenewDate,Charge)values('"+ da +"','"+ charge +"')";
            pst =  con.prepareStatement(sql);
            pst.execute();

            tableload();
            

            String sql1 = "Select RenewID from license_renewal where RenewDate='"+ da +"' and Charge='"+ charge +"'";

            pst = con.prepareStatement(sql1);
            rs=pst.executeQuery();
            while(rs.next()){
                renewid.setText(rs.getString(1));
            }

            JOptionPane.showMessageDialog ( null, "Add Successful" );
            clear();
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog ( null, "Date format incorrect" );
        }

    }//GEN-LAST:event_addActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to delete?" );

        if ( x==0 ) {

            String id = renewid.getText();

            try {

                String sql = "DELETE FROM license_renewal WHERE RenewID = '"+ id +"' ";
                pst = con.prepareStatement ( sql );
                pst.execute ();

                JOptionPane.showMessageDialog ( null, "Delete Succesful" );
                clear();
            }

            catch ( Exception e ) {

                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot delete." );

                System.out.println ( e );

            }

            tableload ();

        }

    }//GEN-LAST:event_viewActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clearActionPerformed

    private void ChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChargeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_ChargeActionPerformed

    private void ChargeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChargeKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_ChargeKeyPressed

    private void ChargeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChargeKeyTyped
        // TODO add your handling code here:
        Returns r2= new Returns();

        if(!dateValidation()){
            getToolkit().beep();
            Charge.setText("");
            JOptionPane.showMessageDialog(null, "Enter Date");

            evt.consume();
        }

        else{

            char c = evt.getKeyChar();
            String x = Character.toString(c);
            if(!(r2.isDoubleCharge(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
                getToolkit().beep();
                Charge.setBorder(BorderFactory.createLineBorder(Color.red));
                JOptionPane.showMessageDialog(null, "Charge invalid it's should be Digits only ");
                evt.consume();
            }
            Charge.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }

    }//GEN-LAST:event_ChargeKeyTyped

    private void renewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_renewMouseClicked
        // TODO add your handling code here:
        int r = renew.getSelectedRow ();

        String id = renew.getValueAt ( r, 0 ).toString ();
        String date1 = renew.getValueAt ( r, 1 ).toString ();
        String charge = renew.getValueAt ( r, 2 ).toString ();

        ((JTextField)date.getDateEditor().getUiComponent()).setText (date1);
        Charge.setText ( charge );
        renewid.setText ( id );

    }//GEN-LAST:event_renewMouseClicked

    private void dateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_dateMouseEntered

    private void dateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateMousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_dateMousePressed

    private void dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_dateKeyReleased

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        Returns R = new Returns();
        int r = renew.getSelectedRow ();

        String id = renew.getValueAt ( r, 0 ).toString ();
        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to update?" );

        if ( x==0 ) {

            SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            if(dateValidation()){
                String date1 = dformat.format(date.getDate());
                renewid.setText ( id );
                if(R.isDoubleCharge(Charge.getText())){
                    String charge = Charge.getText();
                    String id1 = renewid.getText();
                    try {

                        String sql = "UPDATE license_renewal SET RenewDate = '"+ date1 +"', Charge = '"+ charge +"' WHERE RenewID = '"+ id1 +"' ";
                        pst = con.prepareStatement ( sql );
                        pst.execute ();

                        JOptionPane.showMessageDialog ( null, "Update Succesful" );

                        tableload ();
                        clear();

                    }

                    catch ( Exception e ) {

                        System.out.println ( e );

                        JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot update." );

                    }
                }}
            }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String report1="C:\\ireportsNew\\lisenceRenewal.jasper" ;

        try {
            MyReport(report1,null);
        }
        catch (SQLException | JRException ex) {
        }
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Charge;
    private javax.swing.JDesktopPane IHome;
    private javax.swing.JButton Licence;
    private javax.swing.JButton Logout;
    private javax.swing.JButton add;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable renew;
    private javax.swing.JLabel renewid;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
