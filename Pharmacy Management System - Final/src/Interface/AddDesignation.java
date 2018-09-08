/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import My_Code.DBconnect;
import Validation.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import Validation.Employee;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import net.sf.jasperreports.engine.JRException;
import static rr.Ireport.MyReport;
/**
 *
 * @author MAXMO
 */
public class AddDesignation extends javax.swing.JInternalFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form CalculateOTRate
     */
    public AddDesignation() {
        initComponents();
        con = DBconnect.connect();
        tableload();
    }

    public void clear(){
        id.setText("");
        Designation.setText ("");
        BasicSalary.setText("");
        Rate.setText("");
        }
    
    public void labelload(){
         try{
            String designation = Designation.getText ();
            String basicSalary = BasicSalary.getText();
            String rate = Rate.getText();
        
            String sql1 = "Select Salary_Details_Id from salary_details where Designation='"+ designation +"' and OT_Rate='"+ rate +"' and Basic_Salary='"+ basicSalary +"'";
        
              pst = con.prepareStatement(sql1);
              rs=pst.executeQuery();
              while(rs.next()){
              id.setText(rs.getString(1));
              //String depoID = did.getText();
               
            
              }
         }
         catch(Exception e){
             System.out.println(e);
         }
     }
    
    public void tableload () {
        
        try {
            
            String sql = "SELECT * FROM salary_details";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            designation.setModel ( DbUtils.resultSetToTableModel ( rs ));
          
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

        jPanel1 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        designation = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Designation = new javax.swing.JTextField();
        BasicSalary = new javax.swing.JTextField();
        Rate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        clear = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 640));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Designation");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Basic Salary");

        designation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Employee_Id", "Date", "Arrived_Time", "Left_TIme"
            }
        ));
        designation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                designationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(designation);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Designation");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("OT Rate");

        Designation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Designation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesignationActionPerformed(evt);
            }
        });
        Designation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DesignationKeyTyped(evt);
            }
        });

        BasicSalary.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BasicSalaryActionPerformed(evt);
            }
        });
        BasicSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BasicSalaryKeyTyped(evt);
            }
        });

        Rate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Rate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RateActionPerformed(evt);
            }
        });
        Rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                RateKeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(85, 55, 118));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Designation Id");

        jButton2.setBackground(new java.awt.Color(85, 55, 118));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(85, 55, 118));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Rate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Designation, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel18)
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Designation, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Rate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(clear))))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DesignationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesignationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DesignationActionPerformed

    private void BasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BasicSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BasicSalaryActionPerformed

    private void RateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Employee E = new Employee();
       
           
        
        try {

             String designation = Designation.getText ();
            String basicSalary = BasicSalary.getText();
            String rate = Rate.getText();
            
            String sql = "INSERT INTO salary_details( Designation, OT_Rate, Basic_Salary) VALUES ('"+ designation +"','"+ rate +"','"+ basicSalary +"')";
            pst = con.prepareStatement ( sql );
            pst.execute ();

            JOptionPane.showMessageDialog ( null, "Add Succesful" );

            tableload ();
            labelload();
            clear();
            

        }

        catch ( Exception e ) {

            System.out.print ( e );

            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Employee E = new Employee();
        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to update?" );

        if ( x==0 ) {
            
               
            try {

                 String designation = Designation.getText ();
                String basicSalary = BasicSalary.getText();
                String rate = Rate.getText();
                String id1 = id.getText();
                
                String sql = "UPDATE salary_details SET Designation = '"+ designation +"', OT_Rate = '"+ rate +"', Basic_Salary = '"+ basicSalary +"' WHERE Salary_Details_Id = '"+ id1 +"' ";
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
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to delete?" );

        if ( x==0 ) {

            String id1 = id.getText ();
            
            try {

                String sql = "DELETE FROM salary_details WHERE Salary_Details_Id = '"+ id1 +"'";
                pst = con.prepareStatement ( sql );
                pst.execute ();

                JOptionPane.showMessageDialog ( null, "Delete Succesful" );
            }

            catch ( Exception e ) {

                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot delete." );

                System.out.println ( e );

            }
           
            tableload();
            /*try {
                sql = "INSERT INTO resigned_employee ( Id, Name, Address, Contact_Num, NIC, Designation) VALUES ('"+ id +"','"+ name +"','"+ address +"','"+ contNum +"','"+ nic +"','"+ designation +"')";
                pst = con.prepareStatement ( sql );
                pst.execute ();
                sql = "UPDATE resigned_employee SET Id = '"+ id +"', Name = '"+ name +"', Address = '"+ address +"', Contact_Num = '"+ contNum +"', NIC = '"+ nic +"', Designation = '"+ designation +"' WHERE Id = '"+ id +"' ";
                pst = con.prepareStatement ( sql );
                pst.execute ();*

            }

           catch ( Exception e ) {

            }*/
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void designationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_designationMouseClicked
        // TODO add your handling code here:
        int r = designation.getSelectedRow ();

        String id1 = designation.getValueAt ( r, 0 ).toString ();
        String designation1 = designation.getValueAt ( r, 1 ).toString ();
        String sal = designation.getValueAt ( r, 3 ).toString ();
        String ot = designation.getValueAt ( r, 2 ).toString ();
        
        id.setText ( id1 );
        Designation.setText ( designation1 );
        Rate.setText ( ot );
        BasicSalary.setText ( sal );
        
  
    }//GEN-LAST:event_designationMouseClicked

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        //bank.setText ( " " );
        clear();
        
    }//GEN-LAST:event_clearActionPerformed

    private void BasicSalaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BasicSalaryKeyTyped
        // TODO add your handling code here:
        Employee e3= new Employee();
        Employee e2= new Employee();
                String type1 = Designation.getText();
         if(type1.equals("")){
             getToolkit().beep();
             BasicSalary.setText("");
             //BasicSalary.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Enter Designation", "Error", JOptionPane.INFORMATION_MESSAGE);
             BasicSalary.setText("");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(e2.isDoublebSalary(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             BasicSalary.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Basic Salary should be digits only", "Error", JOptionPane.INFORMATION_MESSAGE);
             evt.consume();
         }
         BasicSalary.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
    }//GEN-LAST:event_BasicSalaryKeyTyped

    private void DesignationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DesignationKeyTyped
        // TODO add your handling code here:
         Employee e2= new Employee();
        
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(e2.NewDesignationvalidation(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             Designation.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Designation should be Letters only ");
             evt.consume();
         }
         Designation.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         
    }//GEN-LAST:event_DesignationKeyTyped

    private void RateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RateKeyTyped
        // TODO add your handling code here:
         Employee e2= new Employee();
             String type1 = BasicSalary.getText();
         if(type1.equals("")){
             getToolkit().beep();
             Rate.setText("");
             //BasicSalary.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Enter Basic Salary", "Error", JOptionPane.INFORMATION_MESSAGE);
             Rate.setText("");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(e2.isDoublebot(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             Rate.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "OT rate should be digits only", "Error", JOptionPane.INFORMATION_MESSAGE);
             evt.consume();
         }
         Rate.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
    }//GEN-LAST:event_RateKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BasicSalary;
    private javax.swing.JTextField Designation;
    private javax.swing.JTextField Rate;
    private javax.swing.JButton clear;
    private javax.swing.JTable designation;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
