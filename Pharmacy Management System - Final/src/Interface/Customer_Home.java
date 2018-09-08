package Interface;


import Validation.Pay_validations;
import My_Code.DBconnect;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static My_Code.PaymentCode.addDiscount;
import rr.Ireport;
import java.awt.Color;
import javax.swing.BorderFactory;

public class Customer_Home extends javax.swing.JInternalFrame 
{
 
    Connection con =null;
    PreparedStatement pst =null;
    ResultSet rs = null;
   
    
    private String name;
    private String phone;
    private String nic;
    private String email;
    String sql,sqlauto,sqlitem,sqltotable,sql1;
    String itemname;
    String cardnum;
    String bank;
    String type;
    double unprice;
    double unprice1;
    int amount;
    String itemno;
    int rowmain= 0; 
    public static String niccheck;
    public static String a;
    String quantity;
    public static int id;
    String namech;
    String phnch;
    String tot;
    double totalprice1;
    
    ArrayList arr1 =new ArrayList();
    
    
    
    public Customer_Home ()
    {
        initComponents ();
        
        con = DBconnect.connect ();
       
        fillcomboName();
        fillcomboCode();
        fillitemname();
        clear();
        nictext.setEnabled(false);
        
    }
    
    
    
       public void paymentMethodValidation () /*Validates Payment details*/
    {
        if(cashRadio.isSelected()==false && debtbox.isSelected()==false && cardRadio.isSelected()==false)
        {
            JOptionPane.showMessageDialog ( null,"Please Select a Payment Method");
        }
       
        else if(cashRadio.isSelected()==true)
        {   
            String customerinsert;
            String cus= nictext.getText();
            niccheck = nictext.getText();
            
            try
            {     
                if(customerCheck()==true)
                {
                    customerinsert = "INSERT INTO customer(cus_id) VALUES ('"+ cus +"')";
                    pst = con.prepareStatement ( customerinsert );
                    pst.execute();     
                }
            }
            
            catch(SQLException e)
            {    
                JOptionPane.showMessageDialog ( null,e);
            }

            cashPayment cp = new cashPayment ();
            cp.setVisible ( true );
          
            String msg = totalamttext.getText();
            String nictosend = nictext.getText();
            
            new cashPayment(msg,nictosend).setVisible(true);
        }
    }
     
    public void fillcomboName () /*populate item name combobox from db*/
    {
        String itemnamen;
 
        try 
        {   
            sql = "SELECT DISTINCT brandName FROM pharma_items p,sales_stock s where p.I_id = s.Item_Code";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) 
            {    
                itemnamen = rs.getString ( "brandName" );
                itemnamebox.addItem ( itemnamen );
            }
        }
        
        catch ( SQLException e ) 
        { 
            JOptionPane.showMessageDialog ( null, e );
        }
    }
    
    public void fillcomboCode ()  /*populate item code combobox from db*/
    {     
        String itemcoden;
        
        try 
        {       
            sql = "SELECT DISTINCT Item_Code FROM sales_stock";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) 
            {
                itemcoden = rs.getString ( "Item_Code" );    
                itemcodebox.addItem ( itemcoden );
            }
        }
        
        catch ( SQLException e ) 
        {
            JOptionPane.showMessageDialog ( null, e );  
        }
    }
     
    public void fillitemname () /* Assign item name according to selected item code value*/
    {
        String itemcode  = itemcodebox.getSelectedItem().toString();
        
        try
        {
            String getitemname  = "SELECT brandName FROM pharma_items WHERE I_id = '"+ itemcode +"' ";
            pst = con.prepareStatement ( getitemname );
            rs =  pst.executeQuery();
            
            while(rs.next())
            {   
                itemnamebox.setSelectedItem(rs.getString("brandName"));
            }
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    public void fillexp () /* Assign item name according to selected item code value*/
    {
        String itemcode  = itemcodebox.getSelectedItem().toString();
        //String w = itemnamebox.getSelectedItem().toString();
        
        try
        {
            String getitemname  = "SELECT Expiry_Date FROM sales_stock WHERE Item_Code = '"+ itemcode +"' ";
            pst = con.prepareStatement ( getitemname );
            rs =  pst.executeQuery();
            
            while(rs.next())
            {   
                String acc1 = rs.getString ( 1 );
                typebox.addItem(acc1);
                //typebox.setSelectedItem(rs.getString(1));
                System.out.println("d");
            }
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    public void fillitemcode() /*Assign item code according to selected item name value*/
    {
        String itemnameat = itemnamebox.getSelectedItem().toString();
        
        try 
        {
            String getitemcode  = "SELECT p.I_id FROM pharma_items p, sales_stock s WHERE s.Item_Code = p.I_id and brandName = '"+ itemnameat +"' ";
            pst = con.prepareStatement ( getitemcode );
            rs =  pst.executeQuery();
            
            while(rs.next())
            {       
                itemcodebox.setSelectedItem(rs.getString("I_id")); 
            }
        } 
        
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,e);   
        }
    }
    
    public int checkquantity() /*Checks available quantity for selected item*/
    {
        quantity = quantitytext.getText();
        
        if(quantitytext.getText().equals(""))
        {
            JOptionPane.showMessageDialog ( null, "Please select a quantity for selected item" );
            return 0;      
        }
        
        else
        {
            String itcode =itemcodebox.getSelectedItem().toString();
            String sttype = typebox.getSelectedItem().toString();
            String qty = quantitytext.getText();
            int qtyint = Integer.parseInt(qty);
            int dbqty;
                
            try
            { 
                String checkqty = "SELECT * FROM sales_stock WHERE Item_code = '"+ itcode +"' and Expiry_Date='"+ sttype +"'" ;
                pst = con.prepareStatement ( checkqty );
                rs =  pst.executeQuery();

                while(rs.next())
                {
                    dbqty = rs.getInt("Quantity");

                    if(dbqty >= qtyint)
                    {
                        return 1;           
                    }   

                    else if(dbqty == 0)
                    {   
                        return 2;
                    }
                
                    else if(dbqty<qtyint)
                    {
                        JOptionPane.showMessageDialog(null,"Only "+ dbqty +" Avialable From "+ itcode +".");
                        break;   
                    }
                }      
            }
        
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,e);
            }        
        }
        return 0;
    }
    
    public void getUpdateStock(String item,String type ,int qty) /* Updates stock details after a transaction*/
    {
        int Qtyzz=0 ;
        System.out.println("gh");
        String sqlselect = "SELECT * FROM sales_stock WHERE Expiry_Date =? AND Item_Code=?";
        String sqlupdate = "UPDATE sales_stock SET Quantity = ? WHERE Item_Code=? AND Expiry_Date =? ";
           
        try
        {     
            PreparedStatement pst6 = con.prepareStatement ( sqlselect ) ; 
            pst6.setString(1, type);
            pst6.setString(2, item);
            ResultSet up = pst6.executeQuery();
            
            while(up.next())
            {
                Qtyzz=up.getInt(3);      
            }
            
            PreparedStatement pst5 = con.prepareStatement ( sqlupdate);
            
            Qtyzz-=qty;
            
            pst5.setInt(1, Qtyzz);
            pst5.setString(2, item);
            pst5.setString(3, type);
            pst5.executeUpdate();
            
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void clear(){
        quantitytext.setText("");
        nictext.setText("");
        totalamttext.setText("");
        itemcodebox.setSelectedItem("Select Item Code");
        itemnamebox.setSelectedItem("Select Item Name");
        typebox.setSelectedItem("Old");        
    }
    
    public void updatesalesstock() /*Get details from maintable to passed to getupdatestock()*/
    {
        int rowcount = maintable.getRowCount();
    
        for(int row =0;row<rowcount;row++)
        {           
            if(maintable.getValueAt(row, 0)==null)
            {
                break;   
            }
                 
            else
            {
                String itemcode =(String)maintable.getValueAt(row, 0);
                String stocktype = (String)maintable.getValueAt(row, 2);
                double stocktypeqq = (double)maintable.getValueAt(row, 3);
                int prdamount =(Integer) maintable.getValueAt(row, 4);
                getUpdateStock(itemcode,stocktype,prdamount) ;   
            }
        }
    }
    
    public  void addtosales() /*Add details to sales table*/
    {
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String idate = sd.format(d);
        
        try
        {
            id = 0;
          
            String getid = "SELECT MAX(sales_id) AS mid FROM sales";
            pst = con.prepareStatement ( getid );
            rs =  pst.executeQuery();
            
            if(rs.next())
            {
                id=rs.getInt("mid");
                id = id + 1;
                int rowcount = maintable.getRowCount();
        
                for(int row = 0; row<rowcount; row++)
                {
                    if(maintable.getValueAt(row, 0)==null)
                    {    
                        break;
                    }
                
                    else
                    {
                        String itemcode= String.valueOf(maintable.getValueAt(row, 0));
                        String sttype = String.valueOf(maintable.getValueAt(row, 2));
                        String h = String.valueOf(maintable.getValueAt(row, 4));

                        String a = "INSERT INTO `sales`(`sales_id`, `Item_code`, `sales_qty`, `sales_date`, Expiry_Date) VALUES ('"+ id +"', '"+itemcode+"' , '"+h+"', '"+ idate +"','"+ sttype +"')";
                        pst = con.prepareStatement ( a );
                        pst.execute();
                        
                    }
                }
            }
        }
        
        catch(SQLException e)
        {  
           JOptionPane.showMessageDialog(null,e);
        }        
    }
   
    public boolean  additionvalidation() /*Validates the item code and item name fields*/
    {
        if(itemcodebox.getSelectedIndex()==0 || itemnamebox.getSelectedIndex()==0)
        {
            JOptionPane.showMessageDialog ( null, "Please select an Item" );
            return false;
        }
        
        else if(quantitytext.getText().equals(""))
        {
            getToolkit().beep();
            quantitytext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog ( null, "Please select a quantity for selected item" );
            quantitytext.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            
            return false;  
        }
       
        else
        {    
            return true;
        }
    }
// System.out.println
    public boolean customerCheck() /* Checks whether customer is already registered */
    {
        try
        {
            niccheck = nictext.getText();
            
            String sql2 = "SELECT * FROM customer WHERE cus_id = '"+ niccheck +"'";
            pst = con.prepareStatement ( sql2 );
            rs =  pst.executeQuery();
      
            if(!rs.next())
            {            
                return true;
            }
                    
            else 
            {    
                return false;
            }        
        }
        
        catch(Exception e)
        { 
            JOptionPane.showMessageDialog ( null,e);
        }
    
        return false; 
    }
   
    public void addNic()  /*Assign nic number to customer*/
    {
       
        String cus= nictext.getText();
    
        try
        {
             String customerinsert = "INSERT INTO customer(cus_id) VALUES ('"+ cus +"')";
             pst = con.prepareStatement ( customerinsert );
             pst.execute();

        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog ( null,e);
        }   
    }
    
    
   public void nextbutton() /*peform next buttton activities*/
    {
        a = totalamttext.getText();
       
        if(itemcodebox.getSelectedIndex()==0 || itemnamebox.getSelectedIndex()==0 || quantitytext.getText().equals(" "))
        {
            JOptionPane.showMessageDialog ( null,"Incomplete Item details! \n Please recheck");
        }
        
        else if(cashRadio.isSelected()==false && debtbox.isSelected()==false && cardRadio.isSelected()==false)
        {
            JOptionPane.showMessageDialog ( null,"Please Select a Payment Method");
        }
        
        else if(cashRadio.isSelected()==true)
        {    
            addtosales();
            updatesalesstock();
                    
            String msg = totalamttext.getText();
            String nictosend = nictext.getText();
                        
            new cashPayment(msg,nictosend).setVisible(true);
        }
        
        else if(cardRadio.isSelected()==true)
        {
            addtosales();
            updatesalesstock();
//            cardPayment cardp = new cardPayment (a);
//            cardp.setVisible ( true );
            
            String msg = totalamttext.getText();
            String nictosend = nictext.getText();
                        
            new cardPayment(msg,nictosend).setVisible(true);
            
        }        
        
        else if(debtbox.isSelected()==true)
        {
            nictext.setEnabled(true);
            if(nictext.getText().equals(" ") || Pay_validations.nicvalidation(nictext.getText())==false)
            {
                JOptionPane.showMessageDialog ( null,"Please Enter a Valid Customer NIC (Format =123456789V)");
            }
      
            else
            { 
                try
                {
                    niccheck = nictext.getText();
                    tot = totalamttext.getText();
                    
                    String sql8 = "select * from customer where cus_id='"+ niccheck +"'";
                    pst = con.prepareStatement(sql8);
                    rs = pst.executeQuery();
                                    
                    while(rs.next())
                    {
                        namech =rs.getString(2);
                        phnch =rs.getString(3);
                    }
                    
                    addtosales();
                    updatesalesstock();
                    cusstomerManagement CM = new cusstomerManagement (niccheck,namech,phnch,tot);
                    IHome.add ( CM ).setVisible ( true );
                }
                
                catch(Exception e)
                {
                    
                }
            } 
        }
      
                 
    }
        
    
    
    
    public void calTotal() /* Calculate total bill */
    {
        double totalrmv = 0.0; 
        int rowscount = maintable.getRowCount();
                
        for(int i=0;i<rowscount ;i++)
        {
            if(maintable.getValueAt(i, 0)==null)
            {
                break;
            }
            
            else
            {
                totalrmv = (totalrmv + Double.parseDouble(maintable.getValueAt(i,5).toString()));
                totalamttext.setText(String.valueOf(totalrmv));
            }
        } 
    }  
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        javax.swing.ButtonGroup paymentgroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Payment = new javax.swing.JButton();
        debtManage = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        IHome = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        itemcodebox = new javax.swing.JComboBox<>();
        itemnamebox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        quantitytext = new javax.swing.JTextField();
        typebox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        mainadd = new javax.swing.JButton();
        removebtn = new javax.swing.JButton();
        updatebutton = new javax.swing.JButton();
        removebtn1 = new javax.swing.JButton();
        removebtn2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        totalamttext = new javax.swing.JTextField();
        nictext = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        maintable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cashRadio = new javax.swing.JRadioButton();
        cardRadio = new javax.swing.JRadioButton();
        debtbox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        nextbutton = new javax.swing.JButton();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1080, 630));
        setPreferredSize(new java.awt.Dimension(1080, 725));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(85, 55, 118));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Payment.setBackground(new java.awt.Color(85, 55, 118));
        Payment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Payment.setForeground(new java.awt.Color(255, 255, 255));
        Payment.setText("Manage Payment");
        Payment.setAutoscrolls(true);
        Payment.setBorder(null);
        Payment.setBorderPainted(false);
        Payment.setFocusable(false);
        Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentActionPerformed(evt);
            }
        });
        jPanel3.add(Payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 40));

        debtManage.setBackground(new java.awt.Color(85, 55, 118));
        debtManage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        debtManage.setForeground(new java.awt.Color(255, 255, 255));
        debtManage.setText("Manage Customer & Debt");
        debtManage.setAutoscrolls(true);
        debtManage.setBorder(null);
        debtManage.setBorderPainted(false);
        debtManage.setFocusable(false);
        debtManage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debtManageActionPerformed(evt);
            }
        });
        jPanel3.add(debtManage, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 240, 40));

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

        IHome.setPreferredSize(new java.awt.Dimension(1080, 645));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 600));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Item Code");

        itemcodebox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemcodebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Code" }));
        itemcodebox.setBorder(null);
        itemcodebox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        itemcodebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemcodeboxActionPerformed(evt);
            }
        });

        itemnamebox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemnamebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item Name" }));
        itemnamebox.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                itemnameboxComponentAdded(evt);
            }
        });
        itemnamebox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemnameboxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                itemnameboxMouseEntered(evt);
            }
        });
        itemnamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemnameboxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Item Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        typebox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Expiry Date" }));
        typebox.setPreferredSize(new java.awt.Dimension(140, 43));
        typebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeboxActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Expiry Date");

        mainadd.setBackground(new java.awt.Color(85, 55, 118));
        mainadd.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        mainadd.setForeground(new java.awt.Color(255, 255, 255));
        mainadd.setText("Add");
        mainadd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainaddMouseClicked(evt);
            }
        });
        mainadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainaddActionPerformed(evt);
            }
        });
        mainadd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mainaddKeyPressed(evt);
            }
        });

        removebtn.setBackground(new java.awt.Color(85, 55, 118));
        removebtn.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        removebtn.setForeground(new java.awt.Color(255, 255, 255));
        removebtn.setText("Remove");
        removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtnActionPerformed(evt);
            }
        });

        updatebutton.setBackground(new java.awt.Color(85, 55, 118));
        updatebutton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        updatebutton.setForeground(new java.awt.Color(255, 255, 255));
        updatebutton.setText("Update");
        updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebuttonActionPerformed(evt);
            }
        });

        removebtn1.setBackground(new java.awt.Color(85, 55, 118));
        removebtn1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        removebtn1.setForeground(new java.awt.Color(255, 255, 255));
        removebtn1.setText("Void All");
        removebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtn1ActionPerformed(evt);
            }
        });

        removebtn2.setBackground(new java.awt.Color(85, 55, 118));
        removebtn2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        removebtn2.setForeground(new java.awt.Color(255, 255, 255));
        removebtn2.setText("Clear All");
        removebtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtn2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Total Amount");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Rs.");

        totalamttext.setEditable(false);
        totalamttext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalamttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalamttextActionPerformed(evt);
            }
        });

        nictext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nictext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nictextActionPerformed(evt);
            }
        });
        nictext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nictextKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Customer NIC");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Add Items ");

        maintable.setAutoCreateRowSorter(true);
        maintable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        maintable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Name", "Expiry Date", "Unit Price", "Amount", "Total "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        maintable.getTableHeader().setReorderingAllowed(false);
        maintable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maintableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(maintable);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Payment Method :");

        cashRadio.setBackground(new java.awt.Color(215, 215, 230));
        cashRadio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cashRadio.setText("Cash");
        cashRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashRadioActionPerformed(evt);
            }
        });

        cardRadio.setBackground(new java.awt.Color(215, 215, 230));
        cardRadio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cardRadio.setText("Card");
        cardRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardRadioActionPerformed(evt);
            }
        });

        debtbox.setBackground(new java.awt.Color(215, 215, 230));
        debtbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debtboxActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Add as a debt :");

        nextbutton.setBackground(new java.awt.Color(85, 55, 118));
        nextbutton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nextbutton.setForeground(new java.awt.Color(255, 255, 255));
        nextbutton.setText("Next");
        nextbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel4)
                                    .addComponent(mainadd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(removebtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(updatebutton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removebtn1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removebtn2)
                                        .addGap(577, 577, 577))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(itemcodebox, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(quantitytext, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(itemnamebox, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(typebox, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(131, 131, 131)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel15))
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(totalamttext, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nictext, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(120, 120, 120))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(1002, 1002, 1002))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(47, 47, 47)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(debtbox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(785, 785, 785))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(cashRadio)
                                            .addGap(29, 29, 29)
                                            .addComponent(cardRadio))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(itemcodebox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(itemnamebox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalamttext, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel15))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nictext, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(quantitytext, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mainadd)
                            .addComponent(removebtn)
                            .addComponent(updatebutton)
                            .addComponent(removebtn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(removebtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cashRadio)
                            .addComponent(cardRadio)
                            .addComponent(nextbutton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(debtbox)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel12))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        IHome.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout IHomeLayout = new javax.swing.GroupLayout(IHome);
        IHome.setLayout(IHomeLayout);
        IHomeLayout.setHorizontalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1159, Short.MAX_VALUE)
        );
        IHomeLayout.setVerticalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, IHomeLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void PaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PaymentActionPerformed

        
        IHome.removeAll ();
        paymentsMain PM = new paymentsMain ();
        IHome.add ( PM ).setVisible ( true );
        

             
    }//GEN-LAST:event_PaymentActionPerformed

    private void debtManageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debtManageActionPerformed

        cusstomerManagement CM = new cusstomerManagement ();
        IHome.add ( CM ).setVisible ( true );
        
    }//GEN-LAST:event_debtManageActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Do you really want to logout?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
        
            Home_Page1 HP1 = new Home_Page1 ();
            HP1.setVisible ( true );
            this.dispose ();
        
        }
        else{}
        
    }//GEN-LAST:event_LogoutActionPerformed

    private void itemcodeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemcodeboxActionPerformed

        fillitemname();
        fillexp();
    }//GEN-LAST:event_itemcodeboxActionPerformed

    private void itemnameboxComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_itemnameboxComponentAdded

    }//GEN-LAST:event_itemnameboxComponentAdded

    private void itemnameboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemnameboxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_itemnameboxMouseClicked

    private void itemnameboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemnameboxMouseEntered

    }//GEN-LAST:event_itemnameboxMouseEntered

    private void itemnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemnameboxActionPerformed

        fillitemcode();
    }//GEN-LAST:event_itemnameboxActionPerformed

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

    private void typeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeboxActionPerformed

    private void mainaddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainaddMouseClicked

    }//GEN-LAST:event_mainaddMouseClicked

    private void mainaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainaddActionPerformed

        DefaultTableModel model = (DefaultTableModel) maintable.getModel();

        boolean x =  additionvalidation();

        if(x!=false)
        {
            String itemcode;
            String stocktype;
            int y=checkquantity();

            if(y==1)
            {
                try
                {
                    itemname = itemnamebox.getSelectedItem().toString();
                    itemcode = itemcodebox.getSelectedItem().toString();
                    stocktype = typebox.getSelectedItem().toString();

                    sqlitem = "SELECT s.Sales_Price from sales_stock s WHERE s.Item_Code='"+ itemcode +"' and s.Expiry_Date='"+stocktype+"' ";
                    pst = con.prepareStatement ( sqlitem );
                    rs =  pst.executeQuery();

                    while(rs.next())
                    {
                        unprice1 =rs.getDouble(1);
                        amount = Integer.parseInt(quantitytext.getText());
                        totalprice1 =unprice1*amount;
                        System.out.println(unprice1);

                    }

                    model.addRow(new Object[]{itemcode,itemname,stocktype,unprice1,amount,totalprice1});
                    calTotal();
                }

                catch(NumberFormatException | SQLException e)
                {
                    JOptionPane.showMessageDialog ( null,e);
                }
            }

            else if(y==2)
            {
                JOptionPane.showMessageDialog ( null,"Product out of stock");
            }
        }
        typebox.removeAllItems();
    }//GEN-LAST:event_mainaddActionPerformed


    
    private void mainaddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainaddKeyPressed

    }//GEN-LAST:event_mainaddKeyPressed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed

        DefaultTableModel model = (DefaultTableModel) maintable.getModel();

        try
        {
            int  selectedRowIndex = maintable.getSelectedRow();

            if(selectedRowIndex<0)
            {
                JOptionPane.showMessageDialog(null,"Please select the item to be removed");
            }

            else
            {
                model.removeRow(selectedRowIndex);
                calTotal();
                JOptionPane.showMessageDialog(null," Item Removed ");
            }
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_removebtnActionPerformed

    private void updatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebuttonActionPerformed

        int i = maintable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)maintable.getModel();

        if(i>=0)
        {
            model.setValueAt(itemcodebox.getSelectedItem(), i, 0);
            model.setValueAt(itemnamebox.getSelectedItem(), i, 1);
            model.setValueAt(typebox.getSelectedItem(), i, 2);
            model.setValueAt(quantitytext.getText(), i, 4);

            double unitprice = Double.parseDouble(maintable.getValueAt(i, 3).toString());
            double newtotal = unitprice * Double.parseDouble(quantitytext.getText());

            model.setValueAt(newtotal, i, 5);
        }

        else
        {
            JOptionPane.showMessageDialog(null," Please select an item to be updated ");
        }

        calTotal();
    }//GEN-LAST:event_updatebuttonActionPerformed

    private void removebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtn1ActionPerformed
        // TODO add your handling code here:
        try
        {
            id = 0;

            String getid = "SELECT MAX(sales_id) AS mid FROM sales";
            pst = con.prepareStatement ( getid );
            rs =  pst.executeQuery();

            if(rs.next())
            {
                id=rs.getInt("mid");
            }

            String sql77 = "DELETE FROM sales WHERE sales_id = '"+ id +"' ";
            pst = con.prepareStatement ( sql77 );
            pst.execute ();

            JOptionPane.showMessageDialog(null, "Bill Void ");
        }
        catch(Exception e){

        }
    }//GEN-LAST:event_removebtn1ActionPerformed

    private void removebtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtn2ActionPerformed
        // TODO add your handling code here:
        clear();

        DefaultTableModel dm = (DefaultTableModel)maintable.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
    }//GEN-LAST:event_removebtn2ActionPerformed

    private void totalamttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalamttextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalamttextActionPerformed

    private void nictextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nictextActionPerformed

    }//GEN-LAST:event_nictextActionPerformed

    private void nictextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nictextKeyTyped

        /*checks for maximum length of nic nummber*/

        if(nictext.getText().length()>9)
        {
            nictext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Maximum length is 10.");
            evt.consume();
        }

        nictext.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    }//GEN-LAST:event_nictextKeyTyped

    private void maintableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maintableMouseClicked

        int rownum = maintable.getSelectedRow();

        String itcode = maintable.getValueAt(rownum, 0).toString();
        String itname = maintable.getValueAt(rownum, 1).toString();
        String sttype = maintable.getValueAt(rownum, 2).toString();
        String qty = maintable.getValueAt(rownum, 4).toString();

        itemcodebox.setSelectedItem(itcode);
        itemnamebox.setSelectedItem(itname);
        typebox.setSelectedItem(sttype);
        quantitytext.setText(qty);
    }//GEN-LAST:event_maintableMouseClicked

    private void cashRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashRadioActionPerformed

        nictext.setEnabled(false);
    }//GEN-LAST:event_cashRadioActionPerformed

    private void cardRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardRadioActionPerformed

        nictext.setEnabled(false);
    }//GEN-LAST:event_cardRadioActionPerformed

    private void debtboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debtboxActionPerformed
        // TODO add your handling code here:
        nictext.setEnabled(true);
    }//GEN-LAST:event_debtboxActionPerformed

    private void nextbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextbuttonActionPerformed

        nextbutton();
        a=totalamttext.getText();
    }//GEN-LAST:event_nextbuttonActionPerformed
      
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane IHome;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Payment;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JRadioButton cardRadio;
    private javax.swing.JRadioButton cashRadio;
    private javax.swing.JButton debtManage;
    private javax.swing.JCheckBox debtbox;
    private javax.swing.JComboBox<String> itemcodebox;
    private javax.swing.JComboBox<String> itemnamebox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton mainadd;
    private javax.swing.JTable maintable;
    private javax.swing.JButton nextbutton;
    private javax.swing.JTextField nictext;
    private javax.swing.JTextField quantitytext;
    private javax.swing.JButton removebtn;
    private javax.swing.JButton removebtn1;
    private javax.swing.JButton removebtn2;
    private javax.swing.JTextField totalamttext;
    private javax.swing.JComboBox<String> typebox;
    private javax.swing.JButton updatebutton;
    // End of variables declaration//GEN-END:variables

  
    }







