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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import Validation.Accounts;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;

/**
 *
 * @author MAXMO
 */
public class bank extends javax.swing.JInternalFrame {
    Connection ct=null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * Creates new form bank
     */
    public bank() {
        initComponents();
        ct= DBconnect.connect();
        tabled();
        fillcombo();
        //fillcombo1();
    }

    private bank(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public boolean dateValidation(){
        if(((JTextField)date.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter Date");
            return false;
        } else {
            return true;
        }
    }
    
    public void fillcombo () {
        
        
        try {
            
            String sql = "SELECT * FROM bankacc ";
            ps = ct.prepareStatement ( sql );
            rs = ps.executeQuery ();
            
            while ( rs.next ()) {
                
                String ps = rs.getString ( "bankName" );
                Boolean exists = false;
                for (int index = 0; index < bank.getItemCount() && !exists; index++) {
                    if (ps.equals(bank.getItemAt(index))) {
                        exists = true;
                    }
                }
                    if (!exists) {
                        bank.addItem ( ps );
                    }
            }
            
            
        }
        
        
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
            
        }

    }
    /*public void itemCount ()
    {
        int itemCount = accno.getItemCount();
        System.out.println(itemCount);
        
    for(int i=0;i<itemCount;i++){
        
        accno.removeItemAt(i);
     }
    }*/
    
    public void clear(){
        did.setText("");
        accno.setSelectedItem("Select Account Number" );
        bank.setSelectedItem("Select Bank" );
        depositamt.setText ( " " );
        ((JTextField)date.getDateEditor().getUiComponent()).setText(" ") ;
        }
    
     public void fillcombo1 () {
         String bname1 = bank.getSelectedItem().toString();
        
        try {
            accno.removeAllItems();
            
            //accno.setSelectedItem("Select Account Number");
            
            String sql = "SELECT accNo FROM bankacc where bankName='"+bname1+"'";
            ps = ct.prepareStatement ( sql );
            rs = ps.executeQuery ();
            
            while ( rs.next ()) {
                
               String acc1 = rs.getString ( 1 );
               accno.addItem(acc1);
               
                
            }
            //itemCount();
            
            
        }
        
        
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
            
        }
        
    }
     public void labelload(){
         try{
             String acc = accno.getSelectedItem().toString(); 
            String bank1 = bank.getSelectedItem().toString(); 
            String depoamt= depositamt.getText();
            String sql1 = "Select deposit_Id from bankdeposit where bankName='"+ bank1 +"' and accNo='"+ acc +"' and depositAmt='"+ depoamt +"'";
        
              ps = ct.prepareStatement(sql1);
              rs=ps.executeQuery();
              while(rs.next()){
              did.setText(rs.getString(1));
              //String depoID = did.getText();
               
            
              }
         }
         catch(Exception e){
             System.out.println(e);
         }
     }

    /*public void labelload () {
        
        try {
            
            String accno = accno.getSelectedItem().toString();
            month = Month.getSelectedItem().toString();
                                
            sql = "SELECT a.OT_Hours, sd.OT_Rate FROM attendance a, salary_details sd, employee e WHERE a.Employee_Id = '"+ id +"' AND e.Id = '"+ id +"'  AND e.Designation = sd.Designation AND a.Month= '"+ month +"' ";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                otHours =rs.getString ( 1 );
                otRate = rs.getString(2);
            }   
         
            otHours1 = Integer.parseInt(otHours);
            otRate1 = Double.parseDouble(otRate);
            ot1 = otHours1 * otRate1;
            ot = Double.toString(ot1);
                
            Ot.setText(ot);
      
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }*/

    public void tabled(){
        try{
            String Se= "SELECT deposit_Id,bankName,accNo,depositAmt,date FROM bankdeposit";
            ps = ct.prepareStatement(Se);
            rs = ps.executeQuery();
            
            deposits.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    
//    public ArrayList<bank> getData(String bankName){
//        ArrayList<bank> list = new ArrayList<bank>();
//        try{
//            ps = (PreparedStatement) ct.createStatement();
//            rs= ps.executeQuery("");
//            
//            String bname1 = bank.getSelectedItem().toString();
//            
//            String sql = "SELECT accNo FROM bankacc bankdeposit b2 where b2.bankName = b1.bankName  and bankName='"+bname1+"'";
//            ps = ct.prepareStatement ( sql );
//            rs = ps.executeQuery ();
//            bank b;
//            while ( rs.next ()) {
//                b=new bank(rs.getString("accNo"));
//            list.add(b);
//            }
//            }catch (Exception e){
//            System.out.println(e);
//            
//        }
//        return list;
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bank = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        depositamt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        deposits = new javax.swing.JTable();
        add = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        accno = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        did = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 640));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 200, 0));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Account Number");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jButton1.setBackground(new java.awt.Color(85, 55, 118));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Details");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 210, 50));

        bank.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Bank" }));
        bank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bankMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bankMouseEntered(evt);
            }
        });
        bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bankActionPerformed(evt);
            }
        });
        jPanel1.add(bank, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 230, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Date");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        depositamt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        depositamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositamtActionPerformed(evt);
            }
        });
        depositamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                depositamtKeyTyped(evt);
            }
        });
        jPanel1.add(depositamt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 230, 30));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Bank Deposits");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 269, 81));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Bank");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        deposits.setModel(new javax.swing.table.DefaultTableModel(
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
        deposits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depositsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(deposits);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, -1, -1));

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
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 80, 40));

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
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 80, 40));

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
        jPanel1.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, -1, 40));

        accno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        accno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Account Number" }));
        accno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accnoMouseClicked(evt);
            }
        });
        accno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accnoActionPerformed(evt);
            }
        });
        jPanel1.add(accno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 230, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Deposit ID");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        date.setDateFormatString("yyyy-MM-dd");
        date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateMouseClicked(evt);
            }
        });
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 230, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Deposit Amount");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));
        jPanel1.add(did, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 230, 30));

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
        jPanel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 470, 110, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1064, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ViewDeposits vd = new ViewDeposits ();
        vd.setVisible ( true );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void depositamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositamtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_depositamtActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
            Accounts a = new Accounts();
        
            
                
            
        try{
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            
            String acc = accno.getSelectedItem().toString(); 
            String bank1 = bank.getSelectedItem().toString(); 
            String amt = depositamt.getText();
            String da = d.format(date.getDate());
            
            String sql = "insert into bankdeposit (bankName,accNo,depositAmt,date) values ('"+bank1+"','"+acc+"','"+amt+"','"+ da +"')";
            ps = ct.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Add Succesful");
            tabled();
            labelload();
            clear();
        }
        catch (Exception e){
            System.out.println(e);
             JOptionPane.showMessageDialog ( null, "Date is incorrect" );
        }
            
        
        /*try{
          String bank1 = bank.getSelectedItem().toString();
          String acc = accno.getSelectedItem().toString();
          String depoamt= depositamt.getText();
            String sql1 = "Select deposit_Id from bankdeposit where bankName='"+ bank1 +"' and accNo='"+ acc +"' and depositAmt='"+ depoamt +"'";
        
              ps = ct.prepareStatement(sql1);
              ps.executeQuery();
              jLabel1.setText(rs.getString(1));
              String depoID = jLabel1.getText();
        }
              catch (Exception e){
    System.out.println(e);
}*/
    }//GEN-LAST:event_addActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        //bank.setText ( " " );
       clear();
        
    }//GEN-LAST:event_clearActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null,"Do you really want to delete?");
        
        if(x==0) {
         
          String x1 = did.getText();
          
          
          try {
              
              
                            
              String sql = "Delete from bankdeposit where deposit_id = '"+x1+"' ";
              ps = ct.prepareStatement(sql);
              ps.execute();
              
              JOptionPane.showMessageDialog(null, "Delete Succesful");
              
          }
          
          catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Invalid Records. \nCannot delete.");
              
              System.out.println(e);
          }
          tabled();
          clear();
        }
    }//GEN-LAST:event_removeActionPerformed

    private void bankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankMouseClicked
        // TODO add your handling code here:
        String r = bank.getSelectedItem().toString();
        System.out.println(r);
         
        
        try {
            String sql = "SELECT FROM bankdeposit WHERE accNo = '"+ r +"' ";
            ps = ct.prepareStatement ( sql );
            //ps.execute ();
            sql = "SELECT accNo FROM bankdeposit";
            ps = ct.prepareStatement ( sql );
            rs = ps.executeQuery ();
            
            while ( rs.next ()) {
                
                String accId = rs.getString ( "accNo" );
                accno.getSelectedItem().toString();
                //CID.addItem ( cid );
            
            
            
            
            
            
        } 
        }catch (SQLException ex) {
            Logger.getLogger(bank.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bankMouseClicked

    private void bankMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bankMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_bankMouseEntered

    private void accnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accnoActionPerformed
        // TODO add your handling code here:
       /* try{
          String bank1 = bank.getSelectedItem().toString();
          String acc = accno.getSelectedItem().toString();
          String depoamt= depositamt.getText();
            String sql1 = "Select deposit_Id from bankdeposit where bankName='"+ bank1 +"', accNo='"+ acc +"', depositAmt='"+ depoamt +"'";
        
              ps = ct.prepareStatement(sql1);
              ps.executeQuery();
              
              String depoID = jLabel1.getText();
                 
    }//GEN-LAST:event_accnoActionPerformed
catch (Exception e){
    System.out.println(e);
}*/
}
    private void bankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bankActionPerformed
        // TODO add your handling code here:
        fillcombo1();
        
        
        
         /*bank bk = new bank ();
        ArrayList<bank> list = bk.getData((String) bank.getSelectedItem());
        for(int i=0;i<list.size();i++){
        accno.addItem(list.get(i).getName());
    }                                    */
        
    }//GEN-LAST:event_bankActionPerformed

    private void depositsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositsMouseClicked
        // TODO add your handling code here:
        int r = deposits.getSelectedRow ();
        
        String x = deposits.getValueAt(r, 0).toString();
        String bn = deposits.getValueAt ( r, 1 ).toString ();
        String an = deposits.getValueAt ( r, 2).toString ();
        String da = deposits.getValueAt ( r, 3 ).toString ();
        Double da1 = Double.parseDouble(da);
        
        String date1 = deposits.getValueAt ( r, 4).toString ();
        did.setText(x);
        bank.setSelectedItem(bn);
        accno.setSelectedItem(an);
        depositamt.setText(Double.toString(da1));
        ((JTextField)date.getDateEditor().getUiComponent()).setText (date1);
    }//GEN-LAST:event_depositsMouseClicked

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        Accounts a = new Accounts();

        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to update?" );

        if ( x==0 ) {
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            
            String acc = accno.getSelectedItem().toString(); 
            String bank1 = bank.getSelectedItem().toString(); 
            String amt = depositamt.getText();
         //   ps.setString(1,((JTextField)jDateChooser1.getDateEditor().getDateFormatString().getUiComponent()).getText());
            String da = d.format(date.getDate());
            String did1 = did.getText();
            try {

                String sql1 = "UPDATE bankdeposit SET bankName = '"+ bank1 +"',accNo = '"+ acc +"',depositAmt = '"+ amt +"',date = '"+ da +"' WHERE deposit_Id='"+ did1 +"' ";
                ps = ct.prepareStatement ( sql1 );
                ps.execute ();

                JOptionPane.showMessageDialog ( null, "Update Succesful" );

                tabled();
                clear();
            }

            catch ( Exception e ) {

                System.out.println ( e );

                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot update." );

            }
        }
    }//GEN-LAST:event_add1ActionPerformed

    private void accnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accnoMouseClicked
        // TODO add your handling code here:
        Accounts a2= new Accounts();
        
                String id1 = bank.getSelectedItem().toString();
     
         if(!((a2.BankNameValidation(id1)))){
             getToolkit().beep();
             accno.setSelectedItem("Select Account Number");
        
             //qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Select Bank", "Error", JOptionPane.INFORMATION_MESSAGE);
                   //evt.consume();
         }
    }//GEN-LAST:event_accnoMouseClicked

    private void depositamtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_depositamtKeyTyped
        // TODO add your handling code here:
        Accounts a2= new Accounts();
        Accounts a3= new Accounts();
        
               String type1 = accno.getSelectedItem().toString();
         if(!a3.AccnumValidation(type1)){
             getToolkit().beep();
             depositamt.setText(" ");
             //qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Select Account Number", "Error", JOptionPane.INFORMATION_MESSAGE);
             depositamt.setText(" ");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(a2.isDoubleCharge(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             depositamt.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Deposit Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
             evt.consume();
         }
         depositamt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
         
    }//GEN-LAST:event_depositamtKeyTyped

    private void dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dateMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accno;
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JComboBox<String> bank;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextField depositamt;
    private javax.swing.JTable deposits;
    private javax.swing.JLabel did;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton remove;
    // End of variables declaration//GEN-END:variables
}
