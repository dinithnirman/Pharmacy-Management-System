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
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import static rr.Ireport.MyReport;

public class Manage_Sales_Stock extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    String ItemCode;
    String StockType;
    String SupplierID;
    String ItemC;
    String Sup;
    String Quant;
    String Pric;
    String ExDate;
    String RDate;
    String St;
    String P;
    int Quan;
    int Profit;
    int x;
    int r;
    float Price;
    float SalesPrice;
    String qty; 
    private static int q1;
    private static String nm;
    String sqty149;
    String sqty14;
    String sqty;
    
    
    public Manage_Sales_Stock () {
        
        initComponents ();
    
        con = DBconnect.connect();
        
        tableload ();
        fillcombo1 ();
//        fillcombo2 ();
        
    }

    public void clear(){
        ICode.setSelectedItem ( "Select Item Code" );
        
        Qty.setText ( "0" );
        Pri.setText ( "0" );
//        
        EDate.setDate ( null );
        ICode.setEnabled(true);
        
        Qty.setEnabled(true);
        Pri.setEnabled(true);
//        
        EDate.getDateEditor().setEnabled(true);
    }
    
    public void tableload () {
        
        try {
            
            sql = "SELECT Item_Code, Quantity, Price, Sales_Price, Expiry_Date, Receive_Date FROM sales_stock";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            SalesTable.setModel ( DbUtils.resultSetToTableModel ( rs ));
        
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
    
//    public void fillcombo2 () {
//        
//        try {
//            
//            sql = "SELECT * FROM pharma_supplier";
//            pst = con.prepareStatement ( sql );
//            rs = pst.executeQuery ();
//            
//            while ( rs.next ()) {
//                
//                Sup = rs.getString ( "S_ID" );
//                //SupID.addItem ( Sup );
//                                
//            }
//        }
//        
//        catch ( Exception e ) {
//            
//            System.out.println ( e );
//            
//        }
//    }
    
    public void getvalues () {
        
        try {
            
            ItemCode = ICode.getSelectedItem ().toString();
            //StockType = SType.getSelectedItem ().toString ();
            Quan = Integer.parseInt ( Qty.getText ());
//            SupplierID = SupID.getSelectedItem ().toString ();
            Price = Float.parseFloat ( Pri.getText ());
            SimpleDateFormat DFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
            ExDate = DFormat.format ( EDate.getDate ());
            //RDate = DFormat.format ( Date.getDate ());
            Date d=new Date();
            RDate = DFormat.format (d );
            St = "False";
                            
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
                        
        }    
    }
    
    public void calSalesPrice () {
    
        getvalues ();
        
        try {
            
            sql = "SELECT profitMargin FROM pharma_items WHERE I_id = '"+ ItemCode +"'";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                Profit = Integer.parseInt ( rs.getString ( "profitMargin" ));
                SalesPrice = Price + ( Price * Profit / 100 );
                
            }
        }
       
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Manage_ReOrder = new javax.swing.JButton();
        Manage_Expiry = new javax.swing.JButton();
        Manage_Sales = new javax.swing.JButton();
        IHome = new javax.swing.JDesktopPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Qty = new javax.swing.JTextField();
        Pri = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ICode = new javax.swing.JComboBox<>();
        Add = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Remove = new javax.swing.JButton();
        Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        SalesTable = new javax.swing.JTable();
        Clear = new javax.swing.JButton();
        EDate = new com.toedter.calendar.JDateChooser();
        List = new javax.swing.JButton();
        AddQ = new javax.swing.JButton();
        remove1 = new javax.swing.JButton();

        setBorder(null);
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1090, 690));
        setVisible(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(85, 55, 118));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Manage_ReOrder.setBackground(new java.awt.Color(85, 55, 118));
        Manage_ReOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Manage_ReOrder.setForeground(new java.awt.Color(255, 255, 255));
        Manage_ReOrder.setText("Manage Re-Order");
        Manage_ReOrder.setAutoscrolls(true);
        Manage_ReOrder.setBorder(null);
        Manage_ReOrder.setBorderPainted(false);
        Manage_ReOrder.setFocusable(false);
        Manage_ReOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Manage_ReOrderActionPerformed(evt);
            }
        });
        jPanel2.add(Manage_ReOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 180, 40));

        Manage_Expiry.setBackground(new java.awt.Color(85, 55, 118));
        Manage_Expiry.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Manage_Expiry.setForeground(new java.awt.Color(255, 255, 255));
        Manage_Expiry.setText("Manage Expiry ");
        Manage_Expiry.setAutoscrolls(true);
        Manage_Expiry.setBorder(null);
        Manage_Expiry.setBorderPainted(false);
        Manage_Expiry.setFocusable(false);
        Manage_Expiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Manage_ExpiryActionPerformed(evt);
            }
        });
        jPanel2.add(Manage_Expiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 180, 40));

        Manage_Sales.setBackground(new java.awt.Color(85, 55, 118));
        Manage_Sales.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Manage_Sales.setForeground(new java.awt.Color(255, 255, 255));
        Manage_Sales.setText("Manage Sales Stock");
        Manage_Sales.setAutoscrolls(true);
        Manage_Sales.setBorder(null);
        Manage_Sales.setBorderPainted(false);
        Manage_Sales.setFocusable(false);
        Manage_Sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Manage_SalesActionPerformed(evt);
            }
        });
        jPanel2.add(Manage_Sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 196, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, -1));

        jPanel3.setBackground(new java.awt.Color(215, 215, 230));
        jPanel3.setMaximumSize(new java.awt.Dimension(1260, 620));
        jPanel3.setPreferredSize(new java.awt.Dimension(1260, 620));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Sales Stock");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Quantity");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Price");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Expiry Date");

        Qty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QtyKeyTyped(evt);
            }
        });

        Pri.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Pri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PriKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Item Code");

        ICode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ICode.setMaximumRowCount(6);
        ICode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Code" }));

        Add.setBackground(new java.awt.Color(85, 55, 118));
        Add.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("Add");
        Add.setAutoscrolls(true);
        Add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Add.setBorderPainted(false);
        Add.setFocusable(false);
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(85, 55, 118));
        Update.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Update.setForeground(new java.awt.Color(255, 255, 255));
        Update.setText("Update");
        Update.setAutoscrolls(true);
        Update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Update.setBorderPainted(false);
        Update.setFocusable(false);
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Remove.setBackground(new java.awt.Color(85, 55, 118));
        Remove.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Remove.setForeground(new java.awt.Color(255, 255, 255));
        Remove.setText("Remove");
        Remove.setAutoscrolls(true);
        Remove.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Remove.setBorderPainted(false);
        Remove.setFocusable(false);
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        Search.setBackground(new java.awt.Color(85, 55, 118));
        Search.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("Search");
        Search.setAutoscrolls(true);
        Search.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Search.setBorderPainted(false);
        Search.setFocusable(false);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        SalesTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SalesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Item Code", "Stock Type", "Quntity", "Supplier ID", "Price", "Sales Price", "Expiry Date", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SalesTable.setGridColor(new java.awt.Color(255, 255, 255));
        SalesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SalesTable);

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

        EDate.setDateFormatString("yyyy-MM-dd");
        EDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        List.setBackground(new java.awt.Color(85, 55, 118));
        List.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        List.setForeground(new java.awt.Color(255, 255, 255));
        List.setText("Available Item List");
        List.setAutoscrolls(true);
        List.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        List.setBorderPainted(false);
        List.setFocusable(false);
        List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListActionPerformed(evt);
            }
        });

        AddQ.setBackground(new java.awt.Color(85, 55, 118));
        AddQ.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        AddQ.setForeground(new java.awt.Color(255, 255, 255));
        AddQ.setText("Add Quantity");
        AddQ.setAutoscrolls(true);
        AddQ.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        AddQ.setBorderPainted(false);
        AddQ.setFocusable(false);
        AddQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddQActionPerformed(evt);
            }
        });

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(List, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(remove1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(817, 817, 817))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ICode, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(EDate, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(Pri, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(AddQ, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(34, 34, 34)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ICode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Search)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(AddQ)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pri, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(List, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remove1))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        IHome.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout IHomeLayout = new javax.swing.GroupLayout(IHome);
        IHome.setLayout(IHomeLayout);
        IHomeLayout.setHorizontalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1694, Short.MAX_VALUE)
        );
        IHomeLayout.setVerticalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        jPanel1.add(IHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1090, 640));

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

    private void Manage_ReOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Manage_ReOrderActionPerformed

        IHome.removeAll ();
        Manage_ReOrder MRO = new Manage_ReOrder ();
        IHome.add ( MRO ).setVisible ( true );
        
    }//GEN-LAST:event_Manage_ReOrderActionPerformed

    private void Manage_ExpiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Manage_ExpiryActionPerformed

        IHome.removeAll ();
        Manage_Expiry ME = new Manage_Expiry ();
        IHome.add ( ME ).setVisible ( true );
        
    }//GEN-LAST:event_Manage_ExpiryActionPerformed

    private void Manage_SalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Manage_SalesActionPerformed

        IHome.removeAll ();
        Manage_Sales_Stock MSS = new Manage_Sales_Stock ();
        IHome.add ( MSS ).setVisible ( true );
        
    }//GEN-LAST:event_Manage_SalesActionPerformed

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

    private void PriKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriKeyTyped

        try {

            if ( Pri.getText ().length () >= 10 ) {

                getToolkit ().beep ();
                evt.consume ();

            }

            char c = evt.getKeyChar ();

            if ( !( Character.isDigit (c) || ( c == KeyEvent.VK_BACKSPACE )||( c == KeyEvent.VK_DELETE ))) {

                getToolkit().beep();
                Pri.setBorder ( BorderFactory.createLineBorder ( Color.RED ));
                JOptionPane.showMessageDialog ( null, "Cannot enter character." );
                evt.consume();

            }

            else {

                Pri.setBorder ( BorderFactory.createLineBorder ( Color.WHITE ));

            }
        }

        catch ( Exception e ) {

        }
    }//GEN-LAST:event_PriKeyTyped

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed

        try {

            getvalues ();
            calSalesPrice ();

            if ( "Select Item Code".equals ( ItemCode )) {

                JOptionPane.showMessageDialog ( null, "Select Item Code." );

            }

            else if ( Quan <= 0 ) {

                JOptionPane.showMessageDialog ( null, "Invalid Quntity." );

            }

            else if ( Price <= 0 ) {

                JOptionPane.showMessageDialog ( null, "Invalid price." );

            }

            else if ( SalesPrice <= 0 ) {

                JOptionPane.showMessageDialog ( null, "Invalid price." );

            }

            else if ( "Select Supplier ID".equals ( SupplierID )) {

                JOptionPane.showMessageDialog ( null, "Select Supplier ID." );

            }

            else if ( ExDate == null ) {

                JOptionPane.showMessageDialog ( null, "Invalid Expiry Date." );

            }

            else if ( RDate == null ) {

                JOptionPane.showMessageDialog ( null, "Invalid Date." );

            }

            else {
                String sql1= "Select sum(Quantity) from sales_stock where Item_Code='"+ItemCode +"' and Price='"+ Price +"' and Expiry_Date='"+ ExDate +"'"; 
                pst = con.prepareStatement ( sql1 );
                rs = pst.executeQuery();
                while(rs.next()){
                    qty = rs.getString(1);
                
                if(rs.getString("sum(Quantity)")==null){
                sql = "INSERT INTO sales_stock ( Item_Code, Quantity, Price, Sales_Price, Expiry_Date, Receive_Date,Status) VALUES ( '"+ ItemCode +"', '"+ Quan +"', '"+ Price +"', '"+ SalesPrice +"', '"+ ExDate +"', '"+ RDate +"','"+St+"' )";
                pst = con.prepareStatement ( sql );
                pst.executeUpdate ();
                }
                else{
                    int nqty = Integer.parseInt(qty)+Quan;
                    
                    String sql12 = "UPDATE sales_stock SET Quantity = '"+ nqty +"' WHERE Item_Code = '"+ ItemCode +"' and Price='"+ Price +"' and Expiry_Date='"+ ExDate +"' ";
                    pst = con.prepareStatement ( sql12 );
                    pst.execute ();
                }
                }
                
                System.out.println("dfg");
                nm = Qty.getText();
                System.out.println(nm);
                JOptionPane.showMessageDialog ( null, "Add Succesful" );

                tableload ();
                clear();
            }
        }

        catch ( Exception e ) {

            System.out.print ( e );

            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );

        }
    }//GEN-LAST:event_AddActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed

        try {

            x = JOptionPane.showConfirmDialog ( null, "You can update only once.\nDo you really want to update?" );

            if ( x == 0 ) {

                getvalues();
                calSalesPrice ();
                
                try {
                        String sql3 = "Select Quantity from sales_stock where Item_Code='"+ItemCode+"' and Price='"+ Price +"' and Expiry_Date='"+ ExDate +"'";
                        pst = con.prepareStatement ( sql3 );
                        rs = pst.executeQuery ();
                        while(rs.next()){
                            sqty = rs.getString(1);
                            
                        }
                        System.out.println(nm);
                        int sqty12 = Integer.parseInt(sqty);
                       
                        int q3 = sqty12 - Integer.parseInt(nm);
                        String sq15 = Integer.toString(q3);
                        System.out.println(q1);
                        String sql41 = "Update sales_stock SET Quantity = '"+ sq15 +"' where Item_Code='"+ItemCode+"' and Price='"+ Price +"' and Expiry_Date='"+ ExDate +"'";
                        pst = con.prepareStatement ( sql41 );
                        pst.execute ();
//                    
                        String sql31 = "Select Quantity from sales_stock where Item_Code='"+ItemCode+"' and Price='"+ Price +"' and Expiry_Date='"+ ExDate +"'";
                        pst = con.prepareStatement ( sql31 );
                        rs = pst.executeQuery ();
                        while(rs.next()){
                            sqty14 = rs.getString(1);
                            
                        }
                        
                        int sqty121 = Integer.parseInt(sqty14);
//          
                        int sw=sqty121+Quan;

                        String s1 = "Update sales_stock SET Quantity='"+sw+"' where Item_Code='"+ItemCode+"' and Price='"+ Price +"' and Expiry_Date= '"+ ExDate +"'";
                        pst = con.prepareStatement ( s1 );
                        pst.execute ();
                        System.out.println("gygyg");
//                
                        JOptionPane.showMessageDialog ( null, "Update Succesful" );
                        tableload();
                        clear();
//                           
                    }

                    catch ( Exception e ) {

                        System.out.println ( e );

                        JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot update." );

                    }

//                if ( "Select Item Code".equals ( ItemCode )) {
//
//                    JOptionPane.showMessageDialog ( null, "Select Item Code." );
//
//                }
//
//                else {
//
//                    sql = "SELECT * FROM sales_stock";
//                    pst = con.prepareStatement ( sql );
//                    rs = pst.executeQuery ();
//
//                    while ( rs.next ()) {
//
//                        String IC = rs.getString ( "Item_Code" );
//
//                        if ( ItemCode.equals ( IC )) {
//
//                            sql = "SELECT * FROM sales_stock WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"'";
//                            pst = con.prepareStatement ( sql );
//                            rs = pst.executeQuery ();
//
//                            while ( rs.next ()) {
//
//                                int Q = Integer.parseInt(rs.getString ( "Quantity" ));
//                                int P = Integer.parseInt(rs.getString ( "Price" ));
//                                String SI = rs.getString ( "Supplier_ID" );
//                                String ED = rs.getString ( "Expiry_Date" );
//                                String RD = rs.getString ( "Receive_Date" );
//
//                                if ( Quan > 0 & Q != Quan ) {
//
//                                    sql = "UPDATE sales_stock SET Quantity = '"+ Quan +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                    pst = con.prepareStatement ( sql );
//                                    pst.execute ();
//
//                                    JOptionPane.showMessageDialog ( null, "Update Succesful" );
//
//                                    tableload ();
//
//                                    if ( Price > 0 & P != Price ) {
//
//                                        sql = "UPDATE sales_stock SET Price = '"+ Price +"', Sales_Price = '"+ SalesPrice +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                        pst = con.prepareStatement ( sql );
//                                        pst.execute ();
//
//                                        tableload ();
//
//                                        if ( "Select Supplier ID".equals ( SupplierID ) || SupplierID.equals ( SI )) {
//
//                                            if ( " ".equals ( ExDate ) || ExDate.equals ( ED )) {
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//
//                                            else {
//
//                                                sql = "UPDATE sales_stock SET Expiry_Date = '"+ ExDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                pst = con.prepareStatement ( sql );
//                                                pst.execute ();
//
//                                                tableload ();
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//                                        }
//
//                                        else {
//
//                                            sql = "UPDATE sales_stock SET Supplier_ID = '"+ SupplierID +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                            pst = con.prepareStatement ( sql );
//                                            pst.execute ();
//
//                                            tableload ();
//
//                                            if ( " ".equals ( ExDate ) || ExDate.equals ( ED )) {
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//
//                                            else {
//
//                                                sql = "UPDATE sales_stock SET Expiry_Date = '"+ ExDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                pst = con.prepareStatement ( sql );
//                                                pst.execute ();
//
//                                                tableload ();
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//                                        }
//                                    }
//
//                                    else {
//
//                                        if ( "Select Supplier ID".equals ( SupplierID ) || SupplierID.equals ( SI )) {
//
//                                            if ( " ".equals ( ExDate ) || ExDate.equals ( ED )) {
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//
//                                            else {
//
//                                                sql = "UPDATE sales_stock SET Expiry_Date = '"+ ExDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                pst = con.prepareStatement ( sql );
//                                                pst.execute ();
//
//                                                tableload ();
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//                                        }
//
//                                        else {
//
//                                            sql = "UPDATE sales_stock SET Supplier_ID = '"+ SupplierID +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                            pst = con.prepareStatement ( sql );
//                                            pst.execute ();
//
//                                            JOptionPane.showMessageDialog ( null, "Update Succesful" );
//
//                                            tableload ();
//
//                                            if ( " ".equals ( ExDate ) || ExDate.equals ( ED )) {
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//
//                                            else {
//
//                                                sql = "UPDATE sales_stock SET Expiry_Date = '"+ ExDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                pst = con.prepareStatement ( sql );
//                                                pst.execute ();
//
//                                                tableload ();
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//
//                                else {
//
//                                    if ( Price > 0 & P != Price ) {
//
//                                        sql = "UPDATE sales_stock SET Price = '"+ Price +"', Sales_Price = '"+ SalesPrice +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                        pst = con.prepareStatement ( sql );
//                                        pst.execute ();
//
//                                        JOptionPane.showMessageDialog ( null, "Update Succesful" );
//
//                                        tableload ();
//
//                                        if ( "Select Supplier ID".equals ( SupplierID ) || SupplierID.equals ( SI )) {
//
//                                            if ( " ".equals ( ExDate ) || ExDate.equals ( ED )) {
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//
//                                            else {
//
//                                                sql = "UPDATE sales_stock SET Expiry_Date = '"+ ExDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                pst = con.prepareStatement ( sql );
//                                                pst.execute ();
//
//                                                tableload ();
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//                                        }
//
//                                        else {
//
//                                            sql = "UPDATE sales_stock SET Supplier_ID = '"+ SupplierID +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                            pst = con.prepareStatement ( sql );
//                                            pst.execute ();
//
//                                            tableload ();
//
//                                            if ( " ".equals ( ExDate ) || ExDate.equals ( ED )) {
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//
//                                            else {
//
//                                                sql = "UPDATE sales_stock SET Expiry_Date = '"+ ExDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                pst = con.prepareStatement ( sql );
//                                                pst.execute ();
//
//                                                tableload ();
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//                                        }
//                                    }
//
//                                    else {
//
//                                        if ( "Select Supplier ID".equals ( SupplierID ) || SupplierID.equals ( SI )) {
//
//                                            if ( " ".equals ( ExDate ) || ExDate.equals ( ED )) {
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//
//                                                    JOptionPane.showMessageDialog ( null, "123Invalid Records.\n Cannot Update." );
//
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    JOptionPane.showMessageDialog ( null, "12Update Succesful" );
//
//                                                    tableload ();
//
//                                                }
//                                            }
//
//                                            else {
//
//                                                sql = "UPDATE sales_stock SET Expiry_Date = '"+ ExDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                pst = con.prepareStatement ( sql );
//                                                pst.execute ();
//
//                                                tableload ();
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//                                        }
//
//                                        else {
//
//                                            sql = "UPDATE sales_stock SET Supplier_ID = '"+ SupplierID +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                            pst = con.prepareStatement ( sql );
//                                            pst.execute ();
//
//                                            JOptionPane.showMessageDialog ( null, "Update Succesful" );
//
//                                            tableload ();
//
//                                            if ( " ".equals ( ExDate ) || ExDate.equals ( ED )) {
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//
//                                            else {
//
//                                                sql = "UPDATE sales_stock SET Expiry_Date = '"+ ExDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                pst = con.prepareStatement ( sql );
//                                                pst.execute ();
//
//                                                JOptionPane.showMessageDialog ( null, "Update Succesful" );
//
//                                                tableload ();
//
//                                                if ( " ".equals ( RDate ) || RDate.equals ( RD )) {
//
//                                                }
//
//                                                else {
//
//                                                    sql = "UPDATE sales_stock SET Receive_Date = '"+ RDate +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
//                                                    pst = con.prepareStatement ( sql );
//                                                    pst.execute ();
//
//                                                    tableload ();
//
//                                                }
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//
//                            P = "False";
//
//                        }
//
//                        else {
//
//                            P = "True";
//
//                        }
//                    }
//
//                    if ( P == "True" ) {
//
//                        JOptionPane.showMessageDialog ( null, "Not Available Item." );
//
//                    }
//                }
            }
        }

        catch ( Exception e ) {

            JOptionPane.showMessageDialog ( null, "Invalid Records.\n Cannot Update." );

        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed

        try {

            x = JOptionPane.showConfirmDialog ( null, "Do you really want to remove last record?" );

            if ( x == 0 ) {

                  getvalues();
                  calSalesPrice ();
                  
                  String sql3 = "Select Quantity from sales_stock where Item_Code='"+ItemCode+"' and Price='"+ Price +"' and Expiry_Date='"+ ExDate +"'";
                        pst = con.prepareStatement ( sql3 );
                        rs = pst.executeQuery ();
                        while(rs.next()){
                            sqty = rs.getString(1);
                            
                        }
                        System.out.println(nm);
                        int sqty12 = Integer.parseInt(sqty);
                       
                        int q3 = sqty12 - Integer.parseInt(nm);
                        String sq15 = Integer.toString(q3);
                        System.out.println(q1);
                        String sql41 = "Update sales_stock SET Quantity = '"+ sq15 +"' where Item_Code='"+ItemCode+"' and Price='"+ Price +"' and Expiry_Date='"+ ExDate +"'";
                        pst = con.prepareStatement ( sql41 );
                        pst.execute ();
               
                        JOptionPane.showMessageDialog ( null, "Delete Succesful" );
                        tableload();
                        clear();  
                    
//
//                if ( "Select Item Code".equals ( ItemCode )) {
//
//                    JOptionPane.showMessageDialog ( null, "Select Item Code." );
//
//                }
//
//                else {
//
//                    sql = "SELECT * FROM sales_stock";
//                    pst = con.prepareStatement ( sql );
//                    rs = pst.executeQuery ();
//
//                    while ( rs.next ()) {
//
//                        String IC = rs.getString ( "Item_Code" ).toString ();
//                        String ST = rs.getString ( "Stock_Type" ).toString ();
//
//                        if ( ItemCode.equals ( IC ) & StockType.equals ( ST )) {
//
//                            sql = "DELETE FROM sales_stock WHERE Stock_Type = '"+ StockType +"' AND Item_Code = '"+ ItemCode +"' ";
//                            pst = con.prepareStatement ( sql );
//                            pst.execute ();
//
//                            JOptionPane.showMessageDialog ( null, "Remove Succesful" );
//
//                            P = "False";
//
//                            tableload ();
//
//                        }
//
//                        else {
//
//                            P = "True";
//
//                        }
//                    }
//
//                    if ( P == "True" ) {
//
//                        JOptionPane.showMessageDialog ( null, "Not Available Item." );
//
//                    }
//                }
//            }
        }
        }
        catch ( Exception e ) {

            JOptionPane.showMessageDialog ( null, "Invalid Records.\n Cannot Remove." );

        }
    }//GEN-LAST:event_RemoveActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed

        try {

            getvalues();
            calSalesPrice ();

            if ( "Select Item Code".equals ( ItemCode )) {

                JOptionPane.showMessageDialog ( null, "Select Item Code." );

            }

            else {

                sql = "SELECT * FROM sales_stock";
                pst = con.prepareStatement ( sql );
                rs = pst.executeQuery ();

                while ( rs.next ()) {

                    String IC = rs.getString ( "Item_Code" ).toString ();

                    if ( ItemCode.equals ( IC )) {

                        sql = "SELECT Item_Code, Quantity, Supplier_ID, Price, Sales_Price, Expiry_Date, Receive_Date FROM sales_stock WHERE Item_Code = '"+ ItemCode +"'";
                        pst = con.prepareStatement ( sql );
                        rs = pst.executeQuery ();

                        SalesTable.setModel ( DbUtils.resultSetToTableModel ( rs ));

                        P = "False";

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

        catch ( Exception e ) {

            JOptionPane.showMessageDialog ( null, "Invalid Records.\n" );

        }
    }//GEN-LAST:event_SearchActionPerformed

    private void SalesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesTableMouseClicked

        r = SalesTable.getSelectedRow ();

        ItemCode = SalesTable.getValueAt ( r, 0 ).toString ();
        //StockType = SalesTable.getValueAt ( r, 1 ).toString ();
        Quant = SalesTable.getValueAt ( r, 1 ).toString ();
        SupplierID = SalesTable.getValueAt ( r, 3 ).toString ();
        Pric = SalesTable.getValueAt ( r, 2 ).toString ();
        ExDate = SalesTable.getValueAt ( r, 4 ).toString ();
        RDate = SalesTable.getValueAt ( r, 5 ).toString ();
        int q2 = Integer.parseInt(Quant);
        q1 = q2;
        
        ICode.setEnabled(false);
        Pri.setEnabled(false);
        EDate.getDateEditor().setEnabled(false);
        
        ICode.setSelectedItem ( ItemCode );
        //SType.setSelectedItem ( StockType );
        Qty.setText ( nm );
        Pri.setText ( Pric );
//        SupID.setSelectedItem ( SupplierID );
        ((JTextField)EDate.getDateEditor().getUiComponent()).setText ( ExDate );
        //((JTextField)Date.getDateEditor().getUiComponent()).setText ( RDate );
        Pri.setText ( Pric );
        
    }//GEN-LAST:event_SalesTableMouseClicked

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        clear();
        
       
    }//GEN-LAST:event_ClearActionPerformed

    private void ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListActionPerformed

        Available_Item_List AIL = new Available_Item_List ();
        AIL.setVisible ( true );
    }//GEN-LAST:event_ListActionPerformed

    private void AddQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddQActionPerformed

        try {

            x = JOptionPane.showConfirmDialog ( null, "Do you really want to add?" );

            if ( x == 0 ) {

                getvalues();
                calSalesPrice ();

                if ( "Select Item Code".equals ( ItemCode )) {

                    JOptionPane.showMessageDialog ( null, "Select Item Code." );

                }

                else {

                    sql = "SELECT * FROM sales_stock";
                    pst = con.prepareStatement ( sql );
                    rs = pst.executeQuery ();

                    while ( rs.next ()) {

                        String IC = rs.getString ( "Item_Code" ).toString ();
                        String ST = rs.getString ( "Stock_Type" ).toString ();
                        int Q = Integer.parseInt(rs.getString ( "Quantity" ));

                        int AQ = Q + Quan;

                        if ( ItemCode.equals ( IC ) & StockType.equals ( ST )) {

                            sql = "UPDATE sales_stock SET Quantity = '"+ AQ +"' WHERE Item_Code = '"+ ItemCode +"' AND Stock_Type = '"+ StockType +"' ";
                            pst = con.prepareStatement ( sql );
                            pst.execute ();

                            JOptionPane.showMessageDialog ( null, "Add Succesful" );

                            P = "False";

                            tableload ();

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

            JOptionPane.showMessageDialog ( null, "Invalid Records.\n Cannot Add." );

        }
    }//GEN-LAST:event_AddQActionPerformed

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed

        String report1 = "C:\\ireportsNew\\sales_stock.jasper" ;

        try {

            MyReport ( report1, null );

        }

        catch ( SQLException | JRException ex ) {

        }
    }//GEN-LAST:event_remove1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton AddQ;
    private javax.swing.JButton Clear;
    private com.toedter.calendar.JDateChooser EDate;
    private javax.swing.JComboBox<String> ICode;
    private javax.swing.JDesktopPane IHome;
    private javax.swing.JButton List;
    private javax.swing.JButton Manage_Expiry;
    private javax.swing.JButton Manage_ReOrder;
    private javax.swing.JButton Manage_Sales;
    private javax.swing.JTextField Pri;
    private javax.swing.JTextField Qty;
    private javax.swing.JButton Remove;
    private javax.swing.JTable SalesTable;
    private javax.swing.JButton Search;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove1;
    // End of variables declaration//GEN-END:variables
}
