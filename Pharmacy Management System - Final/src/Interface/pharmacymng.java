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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.JTextField;
import Validation.Accounts;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;

/**
 *
 * @author MAXMO
 */
public class pharmacymng extends javax.swing.JInternalFrame {
    
    Connection ct=null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    String ei;
    String sqty;
    public String type1;
    String sqty9;
    String sqty14;
    String sqty149;
    private static int q1;
    int m;
    String n;
    public static int qty2;
    String h;
    /**
     * Creates new form pharmacymng
     */
    public pharmacymng() {
        initComponents();
        ct= DBconnect.connect();
        tabled();
        fillcombo ();
//        labelload1 ();
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
    
     public void clear(){
        iId.setSelectedItem("Select Item Code");
        st.setSelectedItem("Select Expiry Date");
        qty.setText ( " " );
        up.setText("");
        date.setDate(null);
        eId.setText(" ");
          }
    
    public void fillcombo () {
        
        try {
            
            String sql = "SELECT DISTINCT Item_Code FROM sales_stock";
            ps = ct.prepareStatement ( sql );
            rs = ps.executeQuery ();
            
            while ( rs.next ()) {
                
                String ino = rs.getString ( "Item_Code" );
                iId.addItem ( ino );
                
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
            
        }
        
    }
    
    public void fillcombo1 () {
        
        try {
            String d = iId.getSelectedItem().toString();
            String sql = "SELECT Expiry_Date FROM sales_stock where Item_Code='"+d+"'";
            ps = ct.prepareStatement ( sql );
            rs = ps.executeQuery ();
            
            while ( rs.next ()) {
                
                String ino = rs.getString ( 1 );
                st.addItem ( ino );
                
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
            
        }
        
    }
    
    public void labelload (){
    String ic = iId.getSelectedItem().toString();
    String type1 = st.getSelectedItem().toString();
        try{
        String sql = "Select Sales_Price from sales_stock where Item_Code='"+ ic +"' and Expiry_Date = '"+ type1 +"'";
         ps = ct.prepareStatement(sql);
         rs=ps.executeQuery();   
         while(rs.next()) {
             up.setText(rs.getString(1));
         }
         
    }    
        
        

        catch (Exception e) {
            System.out.println("e"); 
        }
        
    }
    
//    public void labelload1 () {
//        
//        try {
//            
//            String id = iId.getSelectedItem().toString();
//            //month = Month.getSelectedItem().toString();
//                                
//            String sql = "SELECT Price FROM sales_stock where Item_Code = '"+ id +"'";
//            ps = ct.prepareStatement ( sql );
//            rs = ps.executeQuery ();
//            
//            while ( rs.next ()) {
//                ud.setText(rs.getString(1));
//             
//            }   
//         
//            
//                
//            
//      
//        }
//        
//        catch ( Exception e ) {
//            
//            System.out.println ( e );
//            
//        }
//    }
    public void labelload2 (){
    String id1 = iId.getSelectedItem().toString();
        try{
        String sql = "Select Exchange_Id from pharmng where I_no = '"+ id1 +"'";
         ps = ct.prepareStatement(sql);
         rs=ps.executeQuery();   
         while(rs.next()) {
             eId.setText(rs.getString(1));
         }}
         catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
         
    }    
    public void tabled(){
        try{
            String Se= "SELECT Exchange_Id,I_no,qty,total,date,s.Expiry_Date FROM pharmng,sales_stock s where s.Item_Code=I_no";
            ps = ct.prepareStatement(Se);
            rs = ps.executeQuery();
            
            exchange.setModel(DbUtils.resultSetToTableModel(rs));
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

        jPanel1 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        iId = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        exchange = new javax.swing.JTable();
        clear = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        st = new javax.swing.JComboBox<>();
        eId = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        add1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        up = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 640));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 200, 0));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Unit Price");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 90, 50));

        add.setBackground(new java.awt.Color(85, 55, 118));
        add.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Issue");
        add.setFocusable(false);
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 100, 40));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Expiry Date");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 50));

        iId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        iId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Code" }));
        iId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iIdActionPerformed(evt);
            }
        });
        jPanel1.add(iId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 180, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Exchanges");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 400, 81));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Item No");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 90, 40));

        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });
        jPanel1.add(qty, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 180, 40));

        jButton2.setBackground(new java.awt.Color(85, 55, 118));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("View Details");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 150, 40));

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
        jPanel1.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, -1, 40));

        exchange.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Exchange_Id", "Item_Code", "Stock_Type", "Unit_Price", "Quantity", "Date"
            }
        ));
        exchange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exchangeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(exchange);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 550, 400));

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
        jPanel1.add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 100, 40));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Quantity");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 130, 50));

        date.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 180, 40));

        st.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        st.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Expiry Date" }));
        st.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stMouseClicked(evt);
            }
        });
        st.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stActionPerformed(evt);
            }
        });
        st.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stKeyTyped(evt);
            }
        });
        jPanel1.add(st, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 180, 40));
        jPanel1.add(eId, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 170, 40));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Exchange Id");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 100, 50));

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
        jPanel1.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 110, 40));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Date");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 80, 50));
        jPanel1.add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 180, 40));

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

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        Accounts a = new Accounts();
        try{
            
            
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            if(dateValidation()){
            String da = d.format(date.getDate());
            String quantity = qty.getText();
            int qty1 = Integer.parseInt(quantity);
            String up1 = up.getText();
            double up2 = Double.parseDouble(up1);
            Double total = qty1 * up2;
            String total1 = Double.toString(total);
            String id1 = iId.getSelectedItem().toString();
            //type1 = st.getSelectedItem().toString();
            String ExDate =  st.getSelectedItem().toString();
            String sql2 = "Select Quantity from sales_stock where Item_Code='"+id1+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
                        ps = ct.prepareStatement ( sql2 );
                        rs = ps.executeQuery ();
                        while(rs.next()){
                            sqty = rs.getString(1);
                            
                        }
                        System.out.println(sqty);
                        int sqty1 = Integer.parseInt(sqty);
                        sqty1 = sqty1 - qty1;
                        if(sqty1<0){
                            JOptionPane.showMessageDialog(null, "Stock is not enough");
                        }
                        else{
                        String sqty2 = Integer.toString(sqty1);
                        String sql1 = "UPDATE sales_stock SET Quantity = '"+ sqty2 +"' WHERE Item_Code='"+ id1 +"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"' ";
                        ps = ct.prepareStatement ( sql1 );
                        ps.execute ();
            
            String sql = "insert into pharmng (I_no,qty,total,date) values ('"+id1+"','"+quantity+"','"+total1+"','"+ da +"')";
            ps = ct.prepareStatement(sql);
            ps.execute();
            System.out.println(type1);
            System.out.println(id1);
            
            
            JOptionPane.showMessageDialog(null, "Add successful");
            
            tabled();
            labelload2();
            clear();
            
        }}}
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog ( null, "Date is incorrect" );
            
            
        }
    }//GEN-LAST:event_addActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ViewExchanges ve = new ViewExchanges();
        ve.setVisible(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null,"Do you really want to delete?");
        
        if(x==0) {
          String Id = iId.getSelectedItem().toString();
          String qty1 = qty.getText();
          
          try {
              String eid1 = eId.getText();
              String ExDate = st.getSelectedItem().toString();
              String up1 = up.getText();
              
              String sql3 = "Select Quantity from sales_stock where Item_Code='"+Id+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
                ps = ct.prepareStatement ( sql3 );
                rs = ps.executeQuery ();
                while(rs.next()){
                    h = rs.getString(1);
                }
                int sqty12 = Integer.parseInt(h);
                int u = sqty12 + Integer.parseInt(qty1);
              
              String sql41 = "Update sales_stock SET Quantity = '"+ u +"' where Item_Code='"+Id+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
              ps = ct.prepareStatement ( sql41 );
              ps.execute ();
              
              String sql = "Delete from pharmng where Exchange_Id = '"+eid1+"'";
              ps = ct.prepareStatement(sql);
              ps.execute();
              
              
              
              JOptionPane.showMessageDialog(null, "Delete Succesful");
              clear();
              tabled();
          }
          
          catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Invalid Records. \nCannot delete.");
         
              System.out.println(e);
          }
          tabled();
          clear();
        }
    }//GEN-LAST:event_removeActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        //if(clear.isEnabled()){
         clear();
        //unit.setText ( " " );
    }//GEN-LAST:event_clearActionPerformed

    private void iIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iIdActionPerformed
        // TODO add your handling code here:
        fillcombo1();
        //String ic = iId.getSelectedItem().toString();
        

         
    }//GEN-LAST:event_iIdActionPerformed

    private void stActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stActionPerformed
        // TODO add your handling code here:
        
         
        labelload ();
         
    }//GEN-LAST:event_stActionPerformed

    private void exchangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exchangeMouseClicked
        // TODO add your handling code here:
        
        int r = exchange.getSelectedRow ();
        

        ei = exchange.getValueAt(r, 0).toString();
        String ic = exchange.getValueAt ( r, 1 ).toString ();
        String type = exchange.getValueAt ( r, 3).toString ();
        String qty1 = exchange.getValueAt ( r, 2 ).toString ();
        String edt = exchange.getValueAt ( r, 5 ).toString ();
        qty2 = Integer.parseInt(qty1);
        //int qty1 = Integer.parseInt(quantity);
            q1 = qty2;
        double y = Double.parseDouble(type);
        try{
        String sql = "Select Sales_Price from sales_stock where Item_Code = '"+ic +"' and Expiry_Date='"+ edt +"'";
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
        String date1 = exchange.getValueAt ( r, 4 ).toString ();
                      
        eId.setText(ei);
        iId.setSelectedItem(ic);
        st.setSelectedItem(type);
        qty.setText(Integer.toString(qty2));
        ((JTextField)date.getDateEditor().getUiComponent()).setText (date1);
        st.setSelectedItem(edt);
        
        
    }//GEN-LAST:event_exchangeMouseClicked

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        // TODO add your handling code here:
        Accounts a = new Accounts();

        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to update?" );

        if ( x==0 ) {
            SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
            String da = d.format(date.getDate());
            String quantity = qty.getText();
            int qty1 = Integer.parseInt(quantity);
            String up1 = up.getText();
            double up2 = Double.parseDouble(up1);
            Double total = qty1 * up2;
            String total1 = Double.toString(total);
            String id1 = iId.getSelectedItem().toString();
            String type1 = st.getSelectedItem().toString();
            String ExDate = st.getSelectedItem().toString();
                    try {
                        String sql3 = "Select Quantity from sales_stock where Item_Code='"+id1+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
                        ps = ct.prepareStatement ( sql3 );
                        rs = ps.executeQuery ();
                        while(rs.next()){
                            sqty = rs.getString(1);
                            
                        }
                        System.out.println(sqty);
                        int sqty12 = Integer.parseInt(sqty);
                       
                        int q3 = sqty12 + q1;
                        String sq15 = Integer.toString(q3);
                        String sql41 = "Update sales_stock SET Quantity = '"+ sq15 +"' where Item_Code='"+id1+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
                        ps = ct.prepareStatement ( sql41 );
                        ps.execute ();
                        
                        
                        String quantity1 = qty.getText();
                        int qty12 = Integer.parseInt(quantity);
                        System.out.println(quantity1);
                        String sql31 = "Select Quantity from sales_stock where Item_Code='"+id1+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
                        ps = ct.prepareStatement ( sql31 );
                        rs = ps.executeQuery ();
                        while(rs.next()){
                            sqty14 = rs.getString(1);
                            
                        }
                        System.out.println(sqty);
                        int sqty121 = Integer.parseInt(sqty14);
                        System.out.println(sqty14);
                        
                        if(sqty121>qty12){
                        int f = sqty121-qty12;
                        String q = Integer.toString(f);
                        
                        String sql = "UPDATE pharmng SET I_no = '"+ id1 +"', qty = '"+ quantity1 +"', total = '"+ total1 +"', date = '"+ da +"' WHERE Exchange_Id = '"+ ei +"' ";
                        ps = ct.prepareStatement ( sql );
                        ps.execute ();
                        
                        String sql4 = "Update sales_stock SET Quantity = '"+ q +"' where Item_Code='"+id1+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
                        ps = ct.prepareStatement ( sql4 );
                        ps.execute ();
                        
                        JOptionPane.showMessageDialog ( null, "Update Succesful" );
                        clear();
                        tabled();
                        }
                        else{
                            String quantity12 = qty.getText();
                        int qty123 = Integer.parseInt(quantity);
                        System.out.println(quantity12);
                        String sql311 = "Select Quantity from sales_stock where Item_Code='"+id1+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
                        ps = ct.prepareStatement ( sql311 );
                        rs = ps.executeQuery ();
                        while(rs.next()){
                            sqty149 = rs.getString(1);
                            
                        }
                        System.out.println(sqty);
                        int sqty1212 = Integer.parseInt(sqty149);
                        
                        int f1 = sqty1212-q1;
                        String q1 = Integer.toString(f1);
                        
                        String sql4 = "Update sales_stock SET Quantity = '"+ q1 +"' where Item_Code='"+id1+"' and Sales_Price='"+ up1 +"' and Expiry_Date='"+ ExDate +"'";
                        ps = ct.prepareStatement ( sql4 );
                        ps.execute ();
                        
                        JOptionPane.showMessageDialog ( null, "Cannot Update. Stock is not enough" );
                        }
                        
                    }

                    catch ( Exception e ) {

                        System.out.println ( e );

                        JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot update." );

                    }
                }

    }//GEN-LAST:event_add1ActionPerformed

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        // TODO add your handling code here:
        Accounts a2= new Accounts();
        Accounts a3= new Accounts();
        
                type1 = st.getSelectedItem().toString();
         if(!a3.StockTypeValidation(type1)){
             getToolkit().beep();
             qty.setText("");
             //qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Select Stock Type", "Error", JOptionPane.INFORMATION_MESSAGE);
             qty.setText("");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(a2.isIntQty(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Quantity invalid it's should be Digits only ");
             evt.consume();
         }
         qty.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
         
    }//GEN-LAST:event_qtyKeyTyped

    private void stKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stKeyTyped
        // TODO add your handling code here:
        
         //qty.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_stKeyTyped

    private void stMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stMouseClicked
        // TODO add your handling code here:
        Accounts a2= new Accounts();
        
                String id1 = iId.getSelectedItem().toString();
     
         if(!((a2.ItemCodeValidation(id1)))){
             getToolkit().beep();
             st.setSelectedItem("Select Stock Type");
        
             //qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Select Item Code", "Error", JOptionPane.INFORMATION_MESSAGE);
                   //evt.consume();
         }
    }//GEN-LAST:event_stMouseClicked
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton add1;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel eId;
    private javax.swing.JTable exchange;
    private javax.swing.JComboBox<String> iId;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField qty;
    private javax.swing.JButton remove;
    private javax.swing.JComboBox<String> st;
    private javax.swing.JLabel up;
    // End of variables declaration//GEN-END:variables
}
