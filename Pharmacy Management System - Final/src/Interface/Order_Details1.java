/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Validation.Pay_validations;
import static Interface.Customer_Home.id;
import My_Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static Interface.POrder.j;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import static Interface.Supplier_Home.k;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author AAA
 */
public class Order_Details1 extends javax.swing.JFrame {
    Connection con=null;
    PreparedStatement pas=null;
    ResultSet rs= null;
    
    
    String cdate;
    String h;
    
    /**
     * Creates new form Order_Details
     */
    public Order_Details1() {
        initComponents();
        c.setEditable(false);
        con = DBconnect.connect();
        aa();
        tableload();
        tableload2();
        
        //tableLoad();
        fillCombo();
        //c.setText(k);
        addorder();
    }
    
    
    
    public  void addorder() 
    {
               
        try
        {
            int id = 0;
          
            String getid = "SELECT MAX(orderId) AS mid FROM order_details";
            pas = con.prepareStatement ( getid );
            rs =  pas.executeQuery();
            
            if(rs.next())
            {
                id=rs.getInt("mid");
                id = id + 1;
                c.setText(Integer.toString(id));
                
                int rowcount = jTable1.getRowCount();
        
                for(int row = 0; row<rowcount; row++)
                {System.out.println("ggb");
                    if(jTable1.getValueAt(row, 0)==null)
                    {    
                        break;
                    }
                
                    else
                    {
                        String oId= String.valueOf(jTable1.getValueAt(row, 0));
                        String Iid = String.valueOf(jTable1.getValueAt(row, 1));
                        String h = String.valueOf(jTable1.getValueAt(row, 2));
                        
                        String a = "INSERT INTO `order_details` (`item`, `qty`) VALUES ( '"+Iid+"' , '"+h+"')";
                        pas = con.prepareStatement ( a );
                        pas.execute();
                        
                    }
                }
            }
        }
        
        catch(SQLException e)
        {  
           JOptionPane.showMessageDialog(null,e);
        }        
    }
   
    
//    public void tableLoad()
//    {
//        try{
//        String querry2="SELECT Item_Code, Date, Quantity FROM re_order_notification";
//        pas= con.prepareStatement(querry2);
//        rs = pas.executeQuery();
//      jTable1.setModel(DbUtils.resultSetToTableModel(rs));
//      
//      
//        }
//        catch(Exception e)
//        {
//           System.out.println(e); 
//        }
//    }
    private void fillCombo()
    {
        try{
            String querry3="SELECT * from pharma_Items";
            pas= con.prepareStatement(querry3);
            rs = pas.executeQuery();
            
            while (rs.next())
            {
                String ItemId = rs.getString("I_Id");
                jComboBox1.addItem(ItemId);
            }
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
    
    
    public void tableload () {
        
        try {
            int h=0;
            
            String sql = "SELECT l.Item_Code,s.brandName ,l.Quantity as Remaining_Quantity FROM re_order_notification l , pharma_items s where s.I_id=l.Item_Code and l.type = 'a'";
            pas = con.prepareStatement ( sql );
            rs = pas.executeQuery ();
        
            
            
            RItem.setModel ( DbUtils.resultSetToTableModel ( rs ));
            
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void tableload2 () {
        
        try {
            int h = 0;
            
            String sql = "SELECT l.Item_Code,s.brandName ,l.Quantity as Needed_Quantity FROM re_order_notification l , pharma_items s where s.I_id=l.Item_Code and l.type = 'm' ";
            pas = con.prepareStatement ( sql );
            rs = pas.executeQuery ();
            
            RItem1.setModel ( DbUtils.resultSetToTableModel ( rs ));
        
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void aa(){
        try {
            
            String sqla = "SELECT S.Item_Code,sum(S.Quantity) FROM sales_stock S WHERE rSt='0' group by S.Item_Code";
            pas = con.prepareStatement ( sqla );
            rs = pas.executeQuery ();
            while(rs.next()){
                System.out.println("fgflllllllllllll");
                String ItemCode1=rs.getString(1);
                String Quant1=rs.getString(2);
          
            String sql = "SELECT reOrder_level FROM pharma_items WHERE I_id = '"+ItemCode1+"' ";
            pas = con.prepareStatement ( sql );
            rs = pas.executeQuery ();
            
            while(rs.next()){
                h= rs.getString(1);
            }
            int h1 =  Integer.parseInt(Quant1);
            int j1 = Integer.parseInt(h);
//            sql = "SELECT S.Item_Code,sum(S.Quantity),p.brandName FROM sales_stock S, pharma_items P WHERE S.Item_Code='"+ItemCode1+"' and P.I_id = S.Item_Code AND '"+Quant1+"' <= P.reOrder_level group by S.Item_Code,p.brandName";
//            pst = con.prepareStatement ( sql );
//            rs = pst.executeQuery ();
            System.out.println(ItemCode1);   
          System.out.println(Quant1);   
            if(h1<=j1){
                System.out.println(ItemCode1);   
          System.out.println(Quant1);   
                System.out.println("fgf");   
//                ItemCode=rs.getString(1);
//                Quant=rs.getString(2);
           System.out.println(ItemCode1);
           System.out.println(Quant1);
               Date d = new Date ();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String da = sdf.format(d);
               // String cdate1 = CDate.getText();
               
               SimpleDateFormat DFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
        Date date = new Date ();
        cdate = DFormat.format ( date );
               
                System.out.println(da);
            String k = "a";
            String sql1 = "INSERT INTO re_order_notification ( Item_Code, Date, Quantity,type) VALUES ( '"+ ItemCode1 +"', '"+ cdate +"', '"+ Quant1 +"' ,'"+k+"')";
            pas = con.prepareStatement ( sql1 );
            pas.executeUpdate ();
            System.out.println("fgf");
            int y =1;
            String j = "UPDATE `sales_stock` SET rSt='"+ y +"' WHERE Item_Code='"+ ItemCode1 +"'";   
            pas = con.prepareStatement ( j );
            pas.executeUpdate ();
            System.out.println("fgf");
            }
            System.out.println("fgftyg");
            }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        c = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        RItem = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        quantitytext = new javax.swing.JTextField();
        Cancel1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        RItem1 = new javax.swing.JTable();
        Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Order Id");

        jLabel2.setText("Item Id");

        jLabel3.setText("Qty");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Id", "Items Id", "Qantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("Place Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        RItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item Code", "Quntity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RItem.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(RItem);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Quantity");

        quantitytext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quantitytext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitytextActionPerformed(evt);
            }
        });
        quantitytext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantitytextKeyTyped(evt);
            }
        });

        Cancel1.setBackground(new java.awt.Color(85, 55, 118));
        Cancel1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Cancel1.setForeground(new java.awt.Color(255, 255, 255));
        Cancel1.setText("Order");
        Cancel1.setAutoscrolls(true);
        Cancel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cancel1.setBorderPainted(false);
        Cancel1.setFocusable(false);
        Cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancel1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Manually added list");

        RItem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RItem1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item Code", "Quntity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RItem1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(RItem1);

        Cancel.setBackground(new java.awt.Color(85, 55, 118));
        Cancel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Cancel.setForeground(new java.awt.Color(255, 255, 255));
        Cancel.setText("Order");
        Cancel.setAutoscrolls(true);
        Cancel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cancel.setBorderPainted(false);
        Cancel.setFocusable(false);
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jComboBox1, 0, 73, Short.MAX_VALUE)
                            .addComponent(c))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(quantitytext, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(13, 13, 13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(25, 25, 25)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(quantitytext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addComponent(Cancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.dispose ();
        
//            String Id = jComboBox1.getSelectedItem().toString();
//            String query4 = "DELETE from order WHERE ItemId = '"+Id+"'";
//            try{
//                 pas= con.prepareStatement(query4);
//                 pas.execute();
//                 
//            }
//            catch(Exception e)
//                    {
//                        System.out.println(e);
//                    }
//            
//        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        
                try
                {
                    String id = c.getText();
                    String itemcode = jComboBox1.getSelectedItem().toString();
                    String q = jTextField1.getText();

                    model.addRow(new Object[]{id,itemcode,q});
                    
                    
                    String querry1 = "INSERT INTO order_details(orderId, item, qty) VALUES('"+id+"','"+itemcode+"','"+q+"')";

                pas= con.prepareStatement(querry1);
                pas.execute();
                    
                }

                catch(Exception e)
                {
                    JOptionPane.showMessageDialog ( null,e);
                }
            
    
           

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int r = jTable1.getSelectedRow();
        String Item_code = jTable1.getValueAt(r,0).toString();
        String Quantity = jTable1.getValueAt(r,2).toString();

        jComboBox1.setSelectedItem(Item_code);
        jTextField1.setText(Quantity);
    }//GEN-LAST:event_jTable1MouseClicked

    private void quantitytextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitytextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitytextActionPerformed

    private void quantitytextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantitytextKeyTyped

        /*cheks for invalid characters when typing */

        Pay_validations p2 = new Pay_validations();

        char c = evt.getKeyChar();
        String x = Character.toString(c);

        if(!(p2.digitsOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            quantitytext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Quantity can only have numeric values");
            evt.consume();
        }

        quantitytext.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_quantitytextKeyTyped

    private void Cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancel1ActionPerformed
        // TODO add your handling code here:
        try{
            int rownum = RItem.getSelectedRow();
            System.out.println(id);
            String OOID = c.getText();
            String IId = RItem.getValueAt(rownum, 0).toString();
            String Qty = quantitytext.getText();

            if(Qty.equals("")){
                JOptionPane.showMessageDialog(null,"Enter Quantity");
            }
            else{

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                
                model.addRow(new Object[]{OOID,IId,Qty});
                
                String querry1 = "INSERT INTO order_details(orderId, item, qty) VALUES('"+OOID+"','"+IId+"','"+Qty+"')";

                pas= con.prepareStatement(querry1);
                pas.execute();
                //tableLoad();
                JOptionPane.showMessageDialog(null,"Successfully Order placed");
                System.out.println("qry executed");

                int y= 1;
                String r= "update `sales_stock` SET rSt='"+y+"' where Item_Code='"+IId+"'";
                pas= con.prepareStatement(r);
                pas.execute();

                //String Id = jComboBox1.getSelectedItem().toString();
                String query4 = "DELETE from re_order_notification WHERE Item_Code = '"+IId+"'";

                pas= con.prepareStatement(query4);
                pas.execute();
                tableload();
                quantitytext.setText("");
                //tableload2();
            }}
            catch(Exception e)
            {
                System.out.println(e);
            }

    }//GEN-LAST:event_Cancel1ActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed

        int rownum = RItem1.getSelectedRow();
        System.out.println(id);
        String OOID = c.getText();
        String IId = RItem1.getValueAt(rownum, 0).toString();
        String Qty = RItem1.getValueAt(rownum, 2).toString();

        try{
            
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                
                model.addRow(new Object[]{OOID,IId,Qty});
            
            String querry1 = "INSERT INTO order_details(orderId, item, qty) VALUES('"+OOID+"','"+IId+"','"+Qty+"')";

            pas= con.prepareStatement(querry1);
            pas.execute();
            //tableLoad();
            JOptionPane.showMessageDialog(null,"Successfully Order placed");
            System.out.println("qry executed");

        }
        catch(Exception e)
        {System.out.println(e);}

        //String Id = jComboBox1.getSelectedItem().toString();
        String query4 = "DELETE from re_order_notification WHERE Item_Code = '"+IId+"'";
        try{
            pas= con.prepareStatement(query4);
            pas.execute();
            tableload2();
            // tableload();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_CancelActionPerformed

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
            java.util.logging.Logger.getLogger(Order_Details1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order_Details1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order_Details1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order_Details1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order_Details1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JButton Cancel1;
    private javax.swing.JTable RItem;
    private javax.swing.JTable RItem1;
    private javax.swing.JTextField c;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField quantitytext;
    // End of variables declaration//GEN-END:variables
}
