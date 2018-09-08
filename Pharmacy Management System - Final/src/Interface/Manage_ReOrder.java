package Interface;

import My_Code.DBconnect;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import static rr.Ireport.MyReport;

public class Manage_ReOrder extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    String ItemCode;
    String ItemC;
    String Quant;
    String State;
    String CDate;
    String ItemCode1;
    String P;
    String IC;
    String IC1;
    int Quan;
    int Re;
    int x;
    int r;
    
    public Manage_ReOrder () {
        
        initComponents ();
        
        con = DBconnect.connect ();
        
        //tableload1 ();
        tableload2 ();
        fillcombo1 ();
       // fillcombo2 ();
        fillcombo12();
        //clear();
    }

    public void tableload1 () {
        
        try {
            
            sql = "SELECT S.Item_Code FROM sales_stock S, pharma_items P WHERE P.I_id = S.Item_Code AND S.Quantity <= P.reOrder_level ";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
            
                String IC = rs.getString ( "Item_Code" );
                
                sql = "SELECT Item_Code, Quantity FROM sales_stock";
                pst = con.prepareStatement ( sql );
                rs = pst.executeQuery ();
                
                r = 0;
                
                while ( rs.next ()) {
                
                    ItemCode = rs.getString ( "Item_Code" );
                    Quan = Integer.parseInt ( rs.getString ( "Quantity" ));
                    
                    if ( ItemCode.equals ( IC )) {
                    
                        State = "Re-Order";
                    
                    }
                    
                    else {
                        
                        State = "Available";
                            
                    }
                    
                    RStatus.setValueAt ( ItemCode, r, 0 );
                    RStatus.setValueAt ( Quan, r, 1 );
                    RStatus.setValueAt ( State, r, 2 );

                    r++;
                    
                }
            }
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void tableload2 () {
        
        try {
            
            sql = "SELECT Item_Code, Quantity, Date FROM re_order_notification where type='m'";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            Notification.setModel ( DbUtils.resultSetToTableModel ( rs ));
        
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void fillcombo1 () {
        
        try {
            
            sql = "SELECT * FROM pharma_items";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                ItemC = rs.getString ( "I_id" );
                ICode.addItem ( ItemC );
                
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void fillcombo12() {
        
        try {
            
            String sql = "SELECT * FROM re_order_notification";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                String ps = rs.getString ( "Item_Code" );
                Boolean exists = false;
                for (int index = 0; index < Code.getItemCount() && !exists; index++) {
                    if (ps.equals(Code.getItemAt(index))) {
                        exists = true;
                    }
                }
                    if (!exists) {
                        Code.addItem ( ps );
                    }
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
            
        }
    }
    
    public void fillcombo2 () {
        
        try {
            
            sql = "SELECT DISTINCT Item_Code FROM re_order_notification";
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
            Quan = Integer.parseInt ( Qty.getText ());
                                    
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
    
        SimpleDateFormat DFormat1 = new SimpleDateFormat ( "yyyy-MM-dd" );
        Date date = new Date ();
        CDate = DFormat1.format ( date );
            
    }
    
    
    public void clear(){
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Qty = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ICode = new javax.swing.JComboBox<>();
        Notifi = new javax.swing.JButton();
        Check = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        RStatus = new javax.swing.JTable();
        Clear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Notification = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CNotifi = new javax.swing.JButton();
        List = new javax.swing.JButton();
        Code = new javax.swing.JComboBox<>();
        remove1 = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1090, 640));

        jPanel3.setBackground(new java.awt.Color(215, 215, 230));
        jPanel3.setMaximumSize(new java.awt.Dimension(1260, 620));
        jPanel3.setPreferredSize(new java.awt.Dimension(1260, 620));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Re-order");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Quantity");

        Qty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QtyKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Item Code");

        ICode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ICode.setMaximumRowCount(6);
        ICode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Code" }));

        Notifi.setBackground(new java.awt.Color(85, 55, 118));
        Notifi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Notifi.setForeground(new java.awt.Color(255, 255, 255));
        Notifi.setText("Send Re-order Notification");
        Notifi.setAutoscrolls(true);
        Notifi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Notifi.setBorderPainted(false);
        Notifi.setFocusable(false);
        Notifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotifiActionPerformed(evt);
            }
        });

        Check.setBackground(new java.awt.Color(85, 55, 118));
        Check.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Check.setForeground(new java.awt.Color(255, 255, 255));
        Check.setText("Check Re-order");
        Check.setAutoscrolls(true);
        Check.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Check.setBorderPainted(false);
        Check.setFocusable(false);
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });

        RStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RStatus.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null}
            },
            new String [] {
                "Item Code", "Quantity", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RStatus.setGridColor(new java.awt.Color(255, 255, 255));
        RStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RStatusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(RStatus);

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

        Notification.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Notification.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Code", "Date", "Quntity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Notification.setGridColor(new java.awt.Color(255, 255, 255));
        Notification.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NotificationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Notification);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Re-order Status");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Re-order Notification");

        CNotifi.setBackground(new java.awt.Color(85, 55, 118));
        CNotifi.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        CNotifi.setForeground(new java.awt.Color(255, 255, 255));
        CNotifi.setText("Clear Notification");
        CNotifi.setAutoscrolls(true);
        CNotifi.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CNotifi.setBorderPainted(false);
        CNotifi.setFocusable(false);
        CNotifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CNotifiActionPerformed(evt);
            }
        });

        List.setBackground(new java.awt.Color(85, 55, 118));
        List.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        List.setForeground(new java.awt.Color(255, 255, 255));
        List.setText("Re-order List");
        List.setAutoscrolls(true);
        List.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        List.setBorderPainted(false);
        List.setFocusable(false);
        List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListActionPerformed(evt);
            }
        });

        Code.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Code.setMaximumRowCount(6);
        Code.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Code" }));

        remove1.setBackground(new java.awt.Color(85, 55, 118));
        remove1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        remove1.setForeground(new java.awt.Color(255, 255, 255));
        remove1.setText("View Report");
        remove1.setFocusable(false);
        remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Notifi, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(List, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Check, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(ICode, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CNotifi, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(108, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ICode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Check, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Notifi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(List, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CNotifi, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Code, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remove1))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NotifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotifiActionPerformed

        try {

            getvalues1 ();
            getcurrentdate ();

            if ( "Select Item Code".equals ( ItemCode )) {

                JOptionPane.showMessageDialog ( null, "Select Item Code." );

            }

            else if ( Quan < 0 ) {

                JOptionPane.showMessageDialog ( null, "Invalid Quntity." );

            }

            else {
                int h=0;
                String j ="m";
                sql = "INSERT INTO re_order_notification ( Item_Code, Date, Quantity ,type) VALUES ( '"+ ItemCode +"', '"+ CDate +"', '"+ Quan +"','"+j+"' )";
                pst = con.prepareStatement ( sql );
                pst.executeUpdate ();

                JOptionPane.showMessageDialog ( null, "Add Succesful" );

                tableload2 ();
                fillcombo12();
((DefaultTableModel)RStatus.getModel()).removeRow(0);


                //ReOrder_List r = new ReOrder_List(ItemCode,Quan);

            }
            
        }

        catch ( Exception e ) {

            System.out.print ( e );

            JOptionPane.showMessageDialog ( null, "You have already re-ordered this item." );

        }
    }//GEN-LAST:event_NotifiActionPerformed

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed

        try {

            getvalues1();
            
            if ( "Select Item Code".equals ( ItemCode )) {

                JOptionPane.showMessageDialog ( null, "Select Item Code." );

            }
                
            else {
                
                sql = "SELECT S.Item_Code, sum(S.Quantity) FROM sales_stock S, pharma_items P WHERE P.I_id = S.Item_Code AND S.Quantity <= P.reOrder_level and s.Item_Code='"+ItemCode+"' group by s.Item_Code";
                pst = con.prepareStatement ( sql );
                rs = pst.executeQuery ();

                while ( rs.next ()) {

                    IC = rs.getString ( "Item_Code" );
                    Quan = Integer.parseInt ( rs.getString ( "sum(S.Quantity)" ));

                }
                
                sql = "SELECT S.Item_Code, sum(S.Quantity) FROM sales_stock S, pharma_items P WHERE P.I_id = S.Item_Code AND S.Quantity > P.reOrder_level and s.Item_Code='"+ItemCode+"' group by s.Item_Code";
                pst = con.prepareStatement ( sql );
                rs = pst.executeQuery ();

                System.out.println("hh");
                while ( rs.next ()) {

                    IC1 = rs.getString ( "Item_Code" );
                    Quan = Integer.parseInt ( rs.getString ( "sum(S.Quantity)" ));

                }
                System.out.println("jj");
                if ( ItemCode.equals ( IC )) {
                   
                    State = "Re-Order";
                    RStatus.setValueAt ( ItemCode, r, 0 );
                    RStatus.setValueAt ( Quan, r, 1 );
                    RStatus.setValueAt ( State, r, 2 );

                }

                else if (ItemCode.equals ( IC1 )){
                    System.out.println("jj");
                    State = "Available";
                    RStatus.setValueAt ( ItemCode, r, 0 );
                    RStatus.setValueAt ( Quan, r, 1 );
                    RStatus.setValueAt ( State, r, 2 );

                }
                        
                else {
                
                    JOptionPane.showMessageDialog ( null, "Not Available Item." );
                    
                }        
                
            }
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Invalid Search." );
            
        }
    }//GEN-LAST:event_CheckActionPerformed

    private void RStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RStatusMouseClicked

        r = RStatus.getSelectedRow ();

        ItemCode = RStatus.getValueAt ( r, 0 ).toString ();

        ICode.setSelectedItem ( ItemCode );

    }//GEN-LAST:event_RStatusMouseClicked

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed

        ICode.setSelectedItem ( "Select Item Code" );
        Qty.setText ( "0" );
        Code.setSelectedItem ( "Select Item Code" );

    }//GEN-LAST:event_ClearActionPerformed

    private void NotificationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NotificationMouseClicked

        r = Notification.getSelectedRow ();

        ItemCode1 = Notification.getValueAt ( r, 0 ).toString ();
      
        Code.setSelectedItem ( ItemCode1 );
        
    }//GEN-LAST:event_NotificationMouseClicked

    private void CNotifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CNotifiActionPerformed
    
        x = JOptionPane.showConfirmDialog ( null, "Do you really want to remove?" );

        if ( x==0 ) {

            getvalues1 ();

            try {

                if ( "Select Item Code".equals ( ItemCode1 )) {

                    JOptionPane.showMessageDialog ( null, "Select Item Code." );

                }

                else {
                    
                    sql = "DELETE FROM re_order_notification WHERE Item_Code = '"+ ItemCode1 +"' ";
                    pst = con.prepareStatement ( sql );
                    pst.execute ();

                    Code.removeItem(ItemCode1);
                    JOptionPane.showMessageDialog ( null, "Remove Succesful" );

                    tableload2 ();
                    
                //fillcombo12();
                }
            }

            catch ( Exception e ) {

                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot remove." );

                System.out.println ( e );

            }
        }
    }//GEN-LAST:event_CNotifiActionPerformed

    private void ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListActionPerformed

        ReOrder_List RL = new ReOrder_List ();
        RL.setVisible ( true );

    }//GEN-LAST:event_ListActionPerformed

    private void QtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyKeyTyped
        
        try {
        
            if ( Qty.getText ().length () >= 10 ) {
            
                getToolkit ().beep ();
                evt.consume ();
            
            }
        
            char c = evt.getKeyChar ();
            
            if ( !( Character.isDigit (c) || ( c == KeyEvent.VK_BACKSPACE )||( c == KeyEvent.VK_DELETE ))) {
                
                getToolkit().beep();
                Qty.setBorder ( BorderFactory.createLineBorder ( Color.RED ));
                JOptionPane.showMessageDialog ( null, "Cannot enter character." );
                evt.consume();
                
            }
                
            else {
                
                Qty.setBorder ( BorderFactory.createLineBorder ( Color.WHITE ));
            
            }
        }
        
        catch ( Exception e ) {
        
        }
    }//GEN-LAST:event_QtyKeyTyped

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed

        String report1 = "C:\\ireportsNew\\re_order_notification.jasper" ;

        try {
            
            MyReport ( report1, null );
            
        }
        catch ( SQLException | JRException ex ) {
            
        }
    }//GEN-LAST:event_remove1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CNotifi;
    private javax.swing.JButton Check;
    private javax.swing.JButton Clear;
    private javax.swing.JComboBox<String> Code;
    private javax.swing.JComboBox<String> ICode;
    private javax.swing.JButton List;
    private javax.swing.JButton Notifi;
    private javax.swing.JTable Notification;
    private javax.swing.JTextField Qty;
    private javax.swing.JTable RStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton remove1;
    // End of variables declaration//GEN-END:variables
}
