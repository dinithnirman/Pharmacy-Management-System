package Interface;

import My_Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import static rr.Ireport.MyReport;

public class Manage_Expiry extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    ResultSet rs = null;
    
    String sql;
    String sql1;
    String ItemCode;
    String StockType;
    String ItemC;
    String Quant;
    String Pric;
    String CDate;
    String ExDate;
    String D1;
    String State;
    String P;
    String ItemCode1;
    String Dat;
    String IC;
    String ST;
    String EState;
    int Quan;
    int x;
    int r;
    float Price;
        
    public Manage_Expiry () {
        
        initComponents ();
        
        con = DBconnect.connect ();
        
        tableload1 ();
        tableload2 ();
        fillcombo1 ();
        fillcombo2 ();
        
    }
    
    public void tableload1 () {
        
        try {
            
            getcurrentdate ();
            
            sql = "SELECT Item_Code FROM `sales_stock` WHERE Expiry_Date <= '"+ Dat +"'";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
                        
            while ( rs.next ()) {
                
                IC = rs.getString ( "Item_Code" );
                //ST = rs.getString ( "Stock_Type" );
               
            }
            
            
            sql = "SELECT Item_Code, Expiry_Date FROM sales_stock";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();

            r = 0;

            while ( rs.next ()) {

                ItemCode = rs.getString ( "Item_Code" );
                
                ExDate = rs.getString ( "Expiry_Date" );             

                if ( ItemCode.equals ( IC ) & StockType.equals ( ST )) {

                        State = "Expired";

                    } 

                else {

                    State = "Not Expired";

                }

                Status.setValueAt ( ItemCode, r, 0 );
                Status.setValueAt ( StockType, r, 1 );
                Status.setValueAt ( ExDate, r, 2 );
                Status.setValueAt ( State, r, 3 );

                r++;
       
            }
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void tableload2 () {
        
        try {
            
            sql = "SELECT Item_Code, Expiry_Date, Quantity, Price FROM expired_stock";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            Stock.setModel ( DbUtils.resultSetToTableModel ( rs ));
        
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void fillcombo1 () {
        
        try {
            
            sql = "SELECT DISTINCT Item_Code FROM sales_stock";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                ItemC = rs.getString ( "Item_Code" );
                ICode.addItem ( ItemC );
                
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }

    public void fillcombo2 () {
        
        try {
            
            sql = "SELECT DISTINCT Item_Code FROM expired_stock";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                ItemC = rs.getString ( "Item_Code" );
                Code.addItem ( ItemC );
                
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void getvalues1 () {
        
        try {
            
            ItemCode = ICode.getSelectedItem ().toString();
            //StockType = SType.getSelectedItem ().toString ();
            SimpleDateFormat DFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
            CDate = DFormat.format ( Date.getDate ());
                        
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }    
    }
    
    public void getvalues2 () {
    
        try {
            
            ItemCode1 = Code.getSelectedItem ().toString();
        
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void getcurrentdate () {
    
        try {
        
            SimpleDateFormat DFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
            Date date = new Date ();
            Dat = DFormat.format ( date );
            
        }
        
        catch ( Exception e ) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ICode = new javax.swing.JComboBox<>();
        Remove = new javax.swing.JButton();
        Expiry = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Status = new javax.swing.JTable();
        Clear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Stock = new javax.swing.JTable();
        Date = new com.toedter.calendar.JDateChooser();
        Delete = new javax.swing.JButton();
        Expired = new javax.swing.JButton();
        Code = new javax.swing.JComboBox<>();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1090, 640));

        jPanel3.setBackground(new java.awt.Color(215, 215, 230));
        jPanel3.setMaximumSize(new java.awt.Dimension(1260, 620));
        jPanel3.setPreferredSize(new java.awt.Dimension(1260, 620));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Expiry");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Date");
        jLabel8.setPreferredSize(new java.awt.Dimension(88, 22));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Item Code");

        ICode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ICode.setMaximumRowCount(6);
        ICode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Code" }));

        Remove.setBackground(new java.awt.Color(85, 55, 118));
        Remove.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Remove.setForeground(new java.awt.Color(255, 255, 255));
        Remove.setText("Remove Stock");
        Remove.setAutoscrolls(true);
        Remove.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Remove.setBorderPainted(false);
        Remove.setFocusable(false);
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        Expiry.setBackground(new java.awt.Color(85, 55, 118));
        Expiry.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry.setForeground(new java.awt.Color(255, 255, 255));
        Expiry.setText("Check Expiry");
        Expiry.setAutoscrolls(true);
        Expiry.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry.setBorderPainted(false);
        Expiry.setFocusable(false);
        Expiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpiryActionPerformed(evt);
            }
        });

        Status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Status.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Code", "Expiry Date", "Status"
            }
        ));
        Status.setGridColor(new java.awt.Color(255, 255, 255));
        Status.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StatusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Status);

        Clear.setBackground(new java.awt.Color(85, 55, 118));
        Clear.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Clear.setForeground(new java.awt.Color(255, 255, 255));
        Clear.setText("Clear");
        Clear.setAutoscrolls(true);
        Clear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Clear.setBorderPainted(false);
        Clear.setFocusable(false);
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Expiry Status");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Expired Stock");

        Stock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Stock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item Code", "Expiry Date", "Quntity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Stock.setGridColor(new java.awt.Color(255, 255, 255));
        Stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StockMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Stock);

        Date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        Delete.setBackground(new java.awt.Color(85, 55, 118));
        Delete.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Delete.setForeground(new java.awt.Color(255, 255, 255));
        Delete.setText("Clear Expired Stock");
        Delete.setAutoscrolls(true);
        Delete.setBorderPainted(false);
        Delete.setFocusable(false);
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        Expired.setBackground(new java.awt.Color(85, 55, 118));
        Expired.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expired.setForeground(new java.awt.Color(255, 255, 255));
        Expired.setText("Expired Item List");
        Expired.setAutoscrolls(true);
        Expired.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expired.setBorderPainted(false);
        Expired.setFocusable(false);
        Expired.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpiredActionPerformed(evt);
            }
        });

        Code.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Code.setMaximumRowCount(6);
        Code.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Code" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Expired, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ICode, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 88, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ICode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(Expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Clear)
                        .addGap(18, 18, 18)
                        .addComponent(Expired, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed

        try {
            
            x = JOptionPane.showConfirmDialog ( null, "Do you really want to remove?" );

            if ( x == 0 ) {

                getvalues1 ();

                if ( "Select Item Code".equals ( ItemCode )) {

                    JOptionPane.showMessageDialog ( null, "Select Item Code." );

                }
                
                else {

                    sql = "SELECT * FROM sales_stock";
                    pst = con.prepareStatement ( sql );
                    rs = pst.executeQuery ();

                    while ( rs.next ()) {
                        
                        String IC = rs.getString ( "Item_Code" ).toString ();
                        //String ST = rs.getString ( "Stock_Type" ).toString ();
                        ExDate = rs.getString ( "Expiry_Date" );
                        Price = Float.parseFloat ( rs.getString ( "Price" ));
                        Quan = Integer.parseInt ( rs.getString ( "Quantity" ));
                        System.out.println("gvhggvhb");
                        if ( ItemCode.equals ( IC )) {
   System.out.println(ItemCode);                     
                            sql = "DELETE FROM sales_stock WHERE Item_Code = '"+ ItemCode +"' and Expiry_Date<=  CURDATE() ";
                            pst = con.prepareStatement ( sql );
                            pst.execute ();
System.out.println("gvhggvhb");
                            sql1 = "INSERT INTO expired_stock ( Item_Code, Expiry_Date, Quantity, Price ) VALUES ( '"+ ItemCode +"', '"+ ExDate +"', '"+ Quan +"', '"+ Price +"' )";
                            pst1 = con.prepareStatement ( sql1 );
                            pst1.executeUpdate ();

                            JOptionPane.showMessageDialog ( null, "Succesful" );

                            P = "False";
                            
                            tableload2 ();
                            
                        }
                        
                        else {
                        
                            P = "True";
                            
                        }
                    }
                        
                        if ( P == "True" ) {
                            
                            JOptionPane.showMessageDialog ( null, "Not Available Item." );
                            
                        }
                }
            }
        }
        
        catch ( Exception e ) {
        
            JOptionPane.showMessageDialog ( null, "Invalid Records.\n Cannot Remove." );
            
        }
    }//GEN-LAST:event_RemoveActionPerformed

    private void ExpiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpiryActionPerformed
    
        try {

            getvalues1 ();

            if ( "Select Item Code".equals ( ItemCode )) {

                JOptionPane.showMessageDialog ( null, "Invalid Search." );

            }
            
            else if ( CDate == null ) {
            
                JOptionPane.showMessageDialog ( null, "Invalid Search." );
                
            }
                
            else {

                sql = "SELECT Item_Code, Expiry_Date FROM sales_stock WHERE Item_Code = '"+ ItemCode +"' AND Expiry_Date <= '"+ CDate +"'";
                pst = con.prepareStatement ( sql );
                rs = pst.executeQuery ();
                
                while ( rs.next ()) {

                    ItemC = rs.getString ( "Item_Code" );
                    //StockType = rs.getString ( "Stock_Type" );
                    ExDate = rs.getString ( "Expiry_Date" );  
                    
                    if ( ItemCode.equals ( ItemC )) {
                
                    EState = "Expired";
                    
                }
                    
                    Status.setValueAt ( ItemCode, r, 0 );
                //Status.setValueAt ( StockType, r, 1 );
                Status.setValueAt ( ExDate, r, 1 );
                Status.setValueAt ( EState, r, 2 );
                                         
                }
                    
                sql = "SELECT Item_Code, Expiry_Date FROM sales_stock WHERE Item_Code = '"+ ItemCode +"' AND Expiry_Date > '"+ CDate +"'";
                pst = con.prepareStatement ( sql );
                rs = pst.executeQuery ();

                while ( rs.next ()) {

                    IC = rs.getString ( "Item_Code" );
                    
                    ExDate = rs.getString ( "Expiry_Date" );   
                    
                    if ( ItemCode.equals ( IC )) {
                
                    EState = "Not Expired";
                    
                }
                    Status.setValueAt ( ItemCode, r, 0 );
                //Status.setValueAt ( StockType, r, 1 );
                Status.setValueAt ( ExDate, r, 1 );
                Status.setValueAt ( EState, r, 2 );
                    
                   
                }
                
                
                
                
                
                
                    
            }
        }
                
        catch ( Exception e ) {
        
            JOptionPane.showMessageDialog ( null, "Invalid Records.\n" );
            
        }
    }//GEN-LAST:event_ExpiryActionPerformed

    private void StatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StatusMouseClicked

        r = Status.getSelectedRow ();

        ItemCode = Status.getValueAt ( r, 0 ).toString ();
        
        
        ICode.setSelectedItem ( ItemCode );
        

    }//GEN-LAST:event_StatusMouseClicked

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed

        ICode.setSelectedItem ( "Select Item Code" );
        
        Date.setDate ( null );
        Code.setSelectedItem ( "Select Item Code" );

    }//GEN-LAST:event_ClearActionPerformed

    private void StockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockMouseClicked

        r = Stock.getSelectedRow ();

        ItemCode = Stock.getValueAt ( r, 0 ).toString ();

        Code.setSelectedItem ( ItemCode );

    }//GEN-LAST:event_StockMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
    
        try {
            
            x = JOptionPane.showConfirmDialog ( null, "Do you really want to remove?" );

            if ( x == 0 ) {

                getvalues2();
                
                if ( "Select Item Code".equals ( ItemCode1 )) {

                    JOptionPane.showMessageDialog ( null, "Select Item Code." );

                }
                
                else {

                    sql = "SELECT * FROM expired_stock";
                    pst = con.prepareStatement ( sql );
                    rs = pst.executeQuery ();

                    while ( rs.next ()) {
                        
                        String IC = rs.getString ( "Item_Code" ).toString ();

                        if ( ItemCode1.equals ( IC )) {
                        
                            sql = "DELETE FROM expired_stock WHERE Item_Code = '"+ ItemCode1 +"' ";
                            pst = con.prepareStatement ( sql );
                            pst.execute ();
                            
                            JOptionPane.showMessageDialog ( null, "Succesful" );

                            P = "False";

                            tableload2 ();
                            
                        }
                        
                        else {
                        
                            P = "True";
                            
                        }
                    }
                        
                        if ( P == "True" ) {
                            
                            JOptionPane.showMessageDialog ( null, "Not Available Item." );
                            
                        }
                }
            }
        }
        
        catch ( Exception e ) {
        
            JOptionPane.showMessageDialog ( null, "Invalid Records.\n Cannot Remove." );
            
        }
        
        
        
        
        /*x = JOptionPane.showConfirmDialog ( null, "Do you really want to remove?" );

        if ( x==0 ) {

            getvalues ();

            try {

                if ( "Select Item Code".equals ( ItemCode )) {

                    JOptionPane.showMessageDialog ( null, "Select Item Code." );

                }

                else {
                    
                    sql = "DELETE FROM expired_stock WHERE Item_Code = '"+ ItemCode +"' ";
                    pst = con.prepareStatement ( sql );
                    pst.execute ();

                    JOptionPane.showMessageDialog ( null, "Remove Succesful" );

                    tableload2 ();
                    
                }
            }

            catch ( Exception e ) {

                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot remove." );

                System.out.println ( e );

            }
        }*/
    }//GEN-LAST:event_DeleteActionPerformed

    private void ExpiredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpiredActionPerformed

        Expiry_List EL = new Expiry_List();
        EL.setVisible ( true );

    }//GEN-LAST:event_ExpiredActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JComboBox<String> Code;
    private com.toedter.calendar.JDateChooser Date;
    private javax.swing.JButton Delete;
    private javax.swing.JButton Expired;
    private javax.swing.JButton Expiry;
    private javax.swing.JComboBox<String> ICode;
    private javax.swing.JButton Remove;
    private javax.swing.JTable Status;
    private javax.swing.JTable Stock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
