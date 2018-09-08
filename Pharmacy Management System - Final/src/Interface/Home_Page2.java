package Interface;
import static Interface.Login.idP;
import My_Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Home_Page2 extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String usr = idP;
    String type;
    String type1;
    public Home_Page2 () {
        
        initComponents ();
        con = DBconnect.connect();
        
    }
    
    public void login(){
        try{
            String sql = "Select Type from login where Username='"+ usr +"'";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while(rs.next()){
                type = rs.getString(1);
                
                System.out.println(type);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void login1(){
        try{
            String sql = "Select Type from login1 where Username='"+ usr +"'";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while(rs.next()){
                type = rs.getString(1);
                
                System.out.println(type);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Customer = new javax.swing.JButton();
        Request = new javax.swing.JButton();
        Item = new javax.swing.JButton();
        Inventory = new javax.swing.JButton();
        Returns = new javax.swing.JButton();
        Supplier = new javax.swing.JButton();
        Employee = new javax.swing.JButton();
        Account = new javax.swing.JButton();
        Report = new javax.swing.JButton();
        Licence = new javax.swing.JButton();
        Report1 = new javax.swing.JButton();
        Home = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        Logout = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1450, 725));
        setSize(new java.awt.Dimension(1450, 725));

        jPanel3.setBackground(new java.awt.Color(54, 33, 84));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 33, 84));

        Customer.setBackground(new java.awt.Color(85, 55, 118));
        Customer.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Customer.setForeground(new java.awt.Color(255, 255, 255));
        Customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/customer.png"))); // NOI18N
        Customer.setText("Customer           ");
        Customer.setActionCommand("Customer");
        Customer.setAutoscrolls(true);
        Customer.setBorder(null);
        Customer.setBorderPainted(false);
        Customer.setFocusable(false);
        Customer.setIconTextGap(15);
        Customer.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerActionPerformed(evt);
            }
        });

        Request.setBackground(new java.awt.Color(85, 55, 118));
        Request.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Request.setForeground(new java.awt.Color(255, 255, 255));
        Request.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Request.png"))); // NOI18N
        Request.setText("Requests           ");
        Request.setAutoscrolls(true);
        Request.setBorder(null);
        Request.setBorderPainted(false);
        Request.setFocusable(false);
        Request.setIconTextGap(15);
        Request.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestActionPerformed(evt);
            }
        });

        Item.setBackground(new java.awt.Color(85, 55, 118));
        Item.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Item.setForeground(new java.awt.Color(255, 255, 255));
        Item.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Request.png"))); // NOI18N
        Item.setText("Items               ");
        Item.setAutoscrolls(true);
        Item.setBorder(null);
        Item.setBorderPainted(false);
        Item.setFocusable(false);
        Item.setIconTextGap(15);
        Item.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemActionPerformed(evt);
            }
        });

        Inventory.setBackground(new java.awt.Color(85, 55, 118));
        Inventory.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Inventory.setForeground(new java.awt.Color(255, 255, 255));
        Inventory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Invantory.png"))); // NOI18N
        Inventory.setText("Inventory         ");
        Inventory.setAutoscrolls(true);
        Inventory.setBorder(null);
        Inventory.setBorderPainted(false);
        Inventory.setFocusable(false);
        Inventory.setIconTextGap(15);
        Inventory.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryActionPerformed(evt);
            }
        });

        Returns.setBackground(new java.awt.Color(85, 55, 118));
        Returns.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Returns.setForeground(new java.awt.Color(255, 255, 255));
        Returns.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Returns.png"))); // NOI18N
        Returns.setText("Returns            ");
        Returns.setAutoscrolls(true);
        Returns.setBorder(null);
        Returns.setBorderPainted(false);
        Returns.setFocusable(false);
        Returns.setIconTextGap(15);
        Returns.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Returns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnsActionPerformed(evt);
            }
        });

        Supplier.setBackground(new java.awt.Color(85, 55, 118));
        Supplier.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Supplier.setForeground(new java.awt.Color(255, 255, 255));
        Supplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Supplier.png"))); // NOI18N
        Supplier.setText("Supplier           ");
        Supplier.setAutoscrolls(true);
        Supplier.setBorder(null);
        Supplier.setBorderPainted(false);
        Supplier.setFocusable(false);
        Supplier.setIconTextGap(15);
        Supplier.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierActionPerformed(evt);
            }
        });

        Employee.setBackground(new java.awt.Color(85, 55, 118));
        Employee.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Employee.setForeground(new java.awt.Color(255, 255, 255));
        Employee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Employee.png"))); // NOI18N
        Employee.setText("Employee       ");
        Employee.setAutoscrolls(true);
        Employee.setBorder(null);
        Employee.setBorderPainted(false);
        Employee.setFocusable(false);
        Employee.setIconTextGap(10);
        Employee.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Employee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeActionPerformed(evt);
            }
        });

        Account.setBackground(new java.awt.Color(85, 55, 118));
        Account.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Account.setForeground(new java.awt.Color(255, 255, 255));
        Account.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Account.png"))); // NOI18N
        Account.setText("Accounts         ");
        Account.setAutoscrolls(true);
        Account.setBorder(null);
        Account.setBorderPainted(false);
        Account.setFocusable(false);
        Account.setIconTextGap(15);
        Account.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });

        Report.setBackground(new java.awt.Color(85, 55, 118));
        Report.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Report.setForeground(new java.awt.Color(255, 255, 255));
        Report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Reports.png"))); // NOI18N
        Report.setText("Ledger Sheets");
        Report.setAutoscrolls(true);
        Report.setBorder(null);
        Report.setBorderPainted(false);
        Report.setFocusable(false);
        Report.setIconTextGap(15);
        Report.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportActionPerformed(evt);
            }
        });

        Licence.setBackground(new java.awt.Color(85, 55, 118));
        Licence.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Licence.setForeground(new java.awt.Color(255, 255, 255));
        Licence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Supplier.png"))); // NOI18N
        Licence.setText("Licence Renew");
        Licence.setAutoscrolls(true);
        Licence.setBorder(null);
        Licence.setBorderPainted(false);
        Licence.setFocusable(false);
        Licence.setIconTextGap(15);
        Licence.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Licence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LicenceActionPerformed(evt);
            }
        });

        Report1.setBackground(new java.awt.Color(85, 55, 118));
        Report1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Report1.setForeground(new java.awt.Color(255, 255, 255));
        Report1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Reports.png"))); // NOI18N
        Report1.setText("Attendance      ");
        Report1.setAutoscrolls(true);
        Report1.setBorder(null);
        Report1.setBorderPainted(false);
        Report1.setFocusable(false);
        Report1.setIconTextGap(15);
        Report1.setMargin(new java.awt.Insets(2, 14, 2, 13));
        Report1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Report1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Customer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Request, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Item, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Inventory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Returns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Supplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Employee, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addComponent(Account, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Licence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Report1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Customer, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Request, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Item, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(Inventory, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Returns, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Employee, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Licence, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Report1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 0, 111, 35));

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Pharmacy");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 540, 250));

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 52)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 350, 200));

        jSeparator3.setBackground(new java.awt.Color(54, 33, 84));
        jSeparator3.setForeground(new java.awt.Color(54, 33, 84));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 660, 70));

        Home.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.add(Home, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 1080, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        
        Home_Page1 HP1 = new Home_Page1 ();
        HP1.setVisible ( true );
        this.dispose ();
        
    }//GEN-LAST:event_LogoutActionPerformed

    private void CustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerActionPerformed
        
        login();
        login1();
        if (type.equals("pharmacy_assistant")||type.equals("pharmacist")||type.equals("trainee")||type.equals("inventory_controller")||type.equals("cashier")||type.equals("owner")||type.equals("common")){
            Home.removeAll ();
            Customer_Home CH = new Customer_Home ();
            Home.add ( CH ).setVisible ( true );
        }
        
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }
        
    }//GEN-LAST:event_CustomerActionPerformed

    private void RequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestActionPerformed
        
        
        login();
        login1();
        if (type.equals("pharmacy_assistant")||type.equals("pharmacist")||type.equals("trainee")||type.equals("inventory_controller")||type.equals("cashier")||type.equals("owner")||type.equals("common")){
            Home.removeAll ();
            Request_Home RH = new Request_Home ();
            Home.add ( RH ).setVisible ( true );
        }
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }
        
    }//GEN-LAST:event_RequestActionPerformed

    private void ItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemActionPerformed
        
        
        login();
        login1();
        System.out.println(type);//
        if (type.equals("inventory_controller")||type.equals("owner")){
            Home.removeAll ();
            Item_Home IH = new Item_Home ();
            Home.add ( IH ).setVisible ( true );
        }
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }
        
    }//GEN-LAST:event_ItemActionPerformed

    private void InventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryActionPerformed
       
        
        login();
        login1();
        //if (type.equals("inventory_controller")||type.equals("owner")){
            Home.removeAll ();
            Inventory_Home1 InH = new Inventory_Home1 ();
            Home.add ( InH ).setVisible ( true );
//        }
//        else{
//            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
//                    
//        }
    }//GEN-LAST:event_InventoryActionPerformed

    private void ReturnsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnsActionPerformed
        
        
        login();
        login1();
        if (type.equals("inventory_controller")||type.equals("owner")){
            Home.removeAll ();
            Returns_Home ReH = new Returns_Home ();
            Home.add ( ReH ).setVisible ( true );
        }
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }
    }//GEN-LAST:event_ReturnsActionPerformed

    private void SupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierActionPerformed
        
        
        login();
        login1();
        //if (type.equals("inventory_controller")||type.equals("owner")){
            Home.removeAll ();
            Supplier_Home SH = new Supplier_Home ();
            Home.add ( SH ).setVisible ( true );
        /*}
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }*/
    }//GEN-LAST:event_SupplierActionPerformed

    private void EmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeActionPerformed
        
        
        login();
        login1();
        if (type.equals("owner")){
            Home.removeAll ();
            Employee_Home EH = new Employee_Home ();
            Home.add ( EH ).setVisible ( true );
        }
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }
    }//GEN-LAST:event_EmployeeActionPerformed

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
        
        
        login();
        login1();
        if (type.equals("pharmacy_assistant")||type.equals("pharmacist")||type.equals("inventory_controller")||type.equals("cashier")||type.equals("owner")){
            Home.removeAll ();
            Account_Home AH = new Account_Home ();
            Home.add ( AH ).setVisible ( true );
        }
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }
    }//GEN-LAST:event_AccountActionPerformed

    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportActionPerformed
 
        
        login();
        login1();
        if (type.equals("owner")){
            Home.removeAll ();
            Report_Home RepH = new Report_Home ();
            Home.add ( RepH ).setVisible ( true );
        }
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }
    }//GEN-LAST:event_ReportActionPerformed

    private void LicenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LicenceActionPerformed
        
        
        login();
        login1();
        if (type.equals("owner")){
            Home.removeAll ();
            Licence_Renew_Home LRH = new Licence_Renew_Home ();
            Home.add ( LRH ).setVisible ( true );
        }
        else{
            JOptionPane.showMessageDialog ( null, "You Cannot Access." );
                    
        }
    }//GEN-LAST:event_LicenceActionPerformed

    private void Report1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Report1ActionPerformed
        // TODO add your handling code here:
        Attendance AH = new Attendance ();
        AH .setVisible ( true );
    }//GEN-LAST:event_Report1ActionPerformed
//
    public static void main ( String args[] ) {

        java.awt.EventQueue.invokeLater (new Runnable () {
            
            public void run () {
                
                new Home_Page2 ().setVisible ( true );
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Account;
    private javax.swing.JButton Customer;
    private javax.swing.JButton Employee;
    private javax.swing.JDesktopPane Home;
    private javax.swing.JButton Inventory;
    private javax.swing.JButton Item;
    private javax.swing.JButton Licence;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Report;
    private javax.swing.JButton Report1;
    private javax.swing.JButton Request;
    private javax.swing.JButton Returns;
    private javax.swing.JButton Supplier;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
