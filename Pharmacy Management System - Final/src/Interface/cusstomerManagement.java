
package Interface;

import My_Code.DBconnect;
import My_Code.PaymentCode;
import Validation.Pay_validations;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import static rr.Ireport.bill;



public class cusstomerManagement extends javax.swing.JInternalFrame 
{

    Connection con =null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    
    /*customer related variables*/
    private String name;
    private String phone;
    private String nic;
    private String email;
    
    String sql;
    String result;
    float totalamount;
    String h;
    String nic1;
    String name1;
    String phone1;
     public static String stm;
    public static String etm;
    public static String p;
    public static String o;
    public static String i;
    public static String u;
    double discountamt;
    
    
    public cusstomerManagement() 
    {
        initComponents();
        
        con = DBconnect.connect ();
        addbutton.setEnabled(false);
        tableload ();
  
        
    }
    
    public cusstomerManagement(String nicpass,float total)
    {
    
        initComponents();
         
        this.totalamount = total;
        
        con = DBconnect.connect ();
        addbutton.setEnabled(false);
        
    }
    
    public cusstomerManagement(String nicpass,String name,String phn,String tot)
    {
    
        initComponents();
        con = DBconnect.connect ();
        addbutton.setEnabled(false);
        nictextreg.setText(nicpass);
        nametext.setText(name);
        phonetext.setText(phn);
        h = tot;
        
        stm=tot;
        etm="0.0";  
        p = "0.0";
        o = "0.0";
        i = "0.0";
        u = String.valueOf(PaymentCode.getSalesId());
        
        //emailtext.setText(emailpass);
        
        if(nametext.getText().equals(""))
        {
            addbutton.setEnabled(false);
            
                
            nic1 = nicpass;
            name1 = nametext.getText();
            phone1 = phonetext.getText();
            

            
        }
        else
            addbutton.setEnabled(true);
        
       
        //con = DBconnect.connect ();
        //add();
        tableload();
    
    }

    
    
    cusstomerManagement(String niccheck) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
    
      
      
    public void tableload () /*Populate debttable with existing details from db*/
    {
        
    try 
    {
        
        String nicdebt = nictextreg.getText();
            
        String sql = "SELECT debt_id AS Debt,debt_amount as Amount,debt_date as Date,debt_status as Status FROM debt WHERE cust_id_fk = '"+ nicdebt +"'";
        pst = con.prepareStatement ( sql );
        rs = pst.executeQuery ();
        
        debttable.setModel ( DbUtils.resultSetToTableModel ( rs ));
        
        }
        
        catch ( SQLException e ) 
        {
        
        JOptionPane.showMessageDialog ( null, e );
        
        }    
    
    
    }
    
    public void add(){
            if((!name1.equals(""))&&(!phone1.equals(""))) {   
                
            addbutton.setEnabled(true);

            try{

            if(addbutton.isEnabled()){
            String sql = "INSERT INTO customer (cus_id,cus_name,cus_phone) VALUES ( '"+ nic1 +"', '"+ name1 +"', '"+ phone1 +"')";
            pst = con.prepareStatement ( sql );
            pst.execute ();
            
            JOptionPane.showMessageDialog ( null, "Save Succesful" );
            }}
//            else{
//                  JOptionPane.showMessageDialog ( null, "Some field(s) are empty" );  
//                    }
            catch(Exception e){
                
            }
}
            
    }
    
    public void checkCustomerAvalibility() /*Checks whether customer details are already in db, if not insert details to db */
    {
    
    
        nic = nictextreg.getText();
        name = nametext.getText();
        phone = phonetext.getText();
        
        
        try 
        {
      
            result ="SELECT cus_id FROM customer WHERE cus_id = '"+ nic +"'";
            pst = con.prepareStatement ( result );
            rs =  pst.executeQuery();
        
            if(rs.next())
            {
            
            try 
            {
                
                String update = "UPDATE customer SET cus_name = '"+name+"', cus_phone = '"+phone+"' WHERE cus_id='"+nic+"' ";
                pst = con.prepareStatement ( update );
                pst.execute();
            
            } 
            
            catch (Exception e) 
            {
                
                JOptionPane.showMessageDialog ( null, e );
                
            }
            
            
            }
            
            else
            {
             

            sql = "INSERT INTO customer (cus_id,cus_name,cus_phone) VALUES ( '"+ nic +"', '"+ name +"', '"+ phone +"')";
            pst = con.prepareStatement ( sql );
            pst.execute ();
            
            //JOptionPane.showMessageDialog ( null, "Save Succesful" );
        
            }
        
        }

        catch ( Exception e ) 
        {
            
        JOptionPane.showMessageDialog ( null, e );
           
        }
        
    
    }
    
   
    
    public void addDebt(String debt)  /*Add new debt detais to database*/
    {
        
        if(phonetext.getText().equals(""))
            
        JOptionPane.showMessageDialog ( null, "Add Customer details to proceed" );
        
        else
        {  
            
        String cusid = nictextreg.getText();
        
        /*get system date*/
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String idate = sd.format(d);
            
        try
        {
            /*insert new debt record to database*/
            String debtInsert = "INSERT INTO debt(debt_amount, debt_date, debt_status, cust_id_fk) VALUES ('"+debt+"','"+idate+"','N','"+cusid+"')";
            pst = con.prepareStatement ( debtInsert );
            pst.execute();
        }
            
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog ( null, e );
            
        }
            
            
       
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

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        nictextreg = new javax.swing.JTextField();
        nametext = new javax.swing.JTextField();
        phonetext = new javax.swing.JTextField();
        clearbutton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        debttable = new javax.swing.JTable();
        customermanback = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        searchbutton = new javax.swing.JButton();
        addbutton = new javax.swing.JButton();
        payall = new javax.swing.JButton();
        paydebt = new javax.swing.JButton();
        debt = new javax.swing.JLabel();
        editbutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 3), new java.awt.Dimension(0, 3), new java.awt.Dimension(32767, 3));
        jSeparator1 = new javax.swing.JSeparator();
        viewdebts = new javax.swing.JButton();
        viewcustomer = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setPreferredSize(new java.awt.Dimension(1080, 640));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        nictextreg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nictextreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nictextregActionPerformed(evt);
            }
        });
        nictextreg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nictextregKeyTyped(evt);
            }
        });

        nametext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nametext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametextActionPerformed(evt);
            }
        });
        nametext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nametextKeyTyped(evt);
            }
        });

        phonetext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phonetext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonetextActionPerformed(evt);
            }
        });
        phonetext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phonetextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phonetextKeyTyped(evt);
            }
        });

        clearbutton.setBackground(new java.awt.Color(85, 55, 118));
        clearbutton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        clearbutton.setForeground(new java.awt.Color(255, 255, 255));
        clearbutton.setText("Clear");
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("NIC :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Phone :");

        debttable.setAutoCreateRowSorter(true);
        debttable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        debttable.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Debt", "Amount", "Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        debttable.setColumnSelectionAllowed(true);
        debttable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        debttable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(debttable);
        debttable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        customermanback.setBackground(new java.awt.Color(85, 55, 118));
        customermanback.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        customermanback.setForeground(new java.awt.Color(255, 255, 255));
        customermanback.setText("Back");
        customermanback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customermanbackActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(85, 55, 118));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Done");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        searchbutton.setBackground(new java.awt.Color(85, 55, 118));
        searchbutton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(255, 255, 255));
        searchbutton.setText("Search");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        addbutton.setBackground(new java.awt.Color(85, 55, 118));
        addbutton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        addbutton.setForeground(new java.awt.Color(255, 255, 255));
        addbutton.setText("Add debt");
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });

        payall.setBackground(new java.awt.Color(85, 55, 118));
        payall.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        payall.setForeground(new java.awt.Color(255, 255, 255));
        payall.setText("Pay All");
        payall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payallActionPerformed(evt);
            }
        });

        paydebt.setBackground(new java.awt.Color(85, 55, 118));
        paydebt.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        paydebt.setForeground(new java.awt.Color(255, 255, 255));
        paydebt.setText("Pay debt");
        paydebt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paydebtActionPerformed(evt);
            }
        });

        editbutton.setBackground(new java.awt.Color(85, 55, 118));
        editbutton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        editbutton.setForeground(new java.awt.Color(255, 255, 255));
        editbutton.setText("Edit");
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Customer Details");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Debt Details ");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        viewdebts.setBackground(new java.awt.Color(85, 55, 118));
        viewdebts.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        viewdebts.setForeground(new java.awt.Color(255, 255, 255));
        viewdebts.setText("View debts");
        viewdebts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewdebtsActionPerformed(evt);
            }
        });

        viewcustomer.setBackground(new java.awt.Color(85, 55, 118));
        viewcustomer.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        viewcustomer.setForeground(new java.awt.Color(255, 255, 255));
        viewcustomer.setText("View Customer");
        viewcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(customermanback, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(debt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(345, 345, 345))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(67, 67, 67)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(45, 45, 45)
                                            .addComponent(nictextreg, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(26, 26, 26)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(phonetext, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel2)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(editbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(clearbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(23, 23, 23)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(viewcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(payall, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewdebts))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paydebt, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addbutton, payall, searchbutton, viewdebts});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton5, paydebt});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(debt))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(customermanback))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4)
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(nictextreg, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nametext, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(phonetext, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6)
                                .addGap(59, 59, 59)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(payall, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(paydebt))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(viewdebts)
                                    .addComponent(jButton5))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchbutton)
                                    .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(clearbutton)
                                    .addComponent(editbutton))
                                .addGap(18, 18, 18)
                                .addComponent(viewcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addbutton, clearbutton, editbutton, searchbutton});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton5, payall, paydebt, viewdebts});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        
        nictextreg.setText(" ");
        nametext.setText(" ");
        phonetext.setText(" ");
       
       
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void customermanbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customermanbackActionPerformed

        Customer_Home1 ch = new Customer_Home1();
        ch.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_customermanbackActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        
        
        this.dispose();
        
        
        
        Customer_Home1 ch = new Customer_Home1();
        ch.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
 
        /*perform search action*/
  
        if (Pay_validations.nicvalidation(nictextreg.getText())==false) 
        {  
            
            JOptionPane.showMessageDialog ( null, "Please Enter a Valid Customer NIC (Format =123456789V)" );
            
        }
        else
        {
            
            try
            {
            
                nic = nictextreg.getText();
                name = nametext.getText();  
              
                sql = "SELECT debt_id,debt_amount,debt_date,debt_status FROM customer c,debt d WHERE c.cus_id = d.cust_id_fk AND c.cus_id = '"+ nic +"'";
                pst = con.prepareStatement ( sql );
                rs =  pst.executeQuery();
            
                if(rs.next())
                {
                    String sql2 = "SELECT * FROM customer WHERE cus_id = '"+nic+"'";
                    pst = con.prepareStatement ( sql2 );
                    rs =  pst.executeQuery();
                    
                    if(rs.next())
                    {
                    
                        nictextreg.setText(nic);
                        nametext.setText(rs.getString("cus_name"));
                        phonetext.setText(String.valueOf(rs.getInt("cus_phone")));
                        
                    
                    }
                    
                    debttable.setModel ( DbUtils.resultSetToTableModel ( rs ));
                    tableload();
                    
                    
                    
                }
            
                else
                {
                    
                JOptionPane.showMessageDialog ( null, "No debts for given NIC number!" );
                
                }

            }

            catch ( Exception e ) 
            {

            JOptionPane.showMessageDialog ( null, e );       
            
 
            }
            
        }
       
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void nictextregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nictextregActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nictextregActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed

        
        /*Adds new debt record*/
        
        nic = nictextreg.getText();
        name = nametext.getText();
        phone = phonetext.getText();
        
        
        if(Pay_validations.namevalidation(name)==true && Pay_validations.phonevalidation(phone)==true )
        {
            
            
                
               checkCustomerAvalibility();   
               addDebt(h);
               tableload();
           
            
                cbill b;
                try {
                    b = new cbill(stm,etm,p,o,i,u);
                    b.setVisible(true);
                } catch (PrinterException ex) {
                    
                }
            
            
                    
        this.dispose();
        
            
        }
      
        
    }//GEN-LAST:event_addbuttonActionPerformed

    private void payallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payallActionPerformed

        /*pay all debts at once*/
        
        int rowcount = debttable.getRowCount();
        
        for(int i = 0;i<rowcount ;i++)
        {
        
            try
            {
            
                String debtall = "UPDATE debt SET debt_status ='Y' WHERE debt_id = '"+ debttable.getValueAt(i, 0)+"'";
                pst = con.prepareStatement ( debtall );
                pst.execute();
            
            }
            
            catch(Exception e)
            {
                
                JOptionPane.showMessageDialog ( null, e );
            
            }
        
        tableload();
        
            
        }
    JOptionPane.showMessageDialog ( null, "Transaction Successful" );
        
    }//GEN-LAST:event_payallActionPerformed

    private void paydebtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paydebtActionPerformed

        /*pay only a one selected debt*/
        
        int rownum = debttable.getSelectedRow();
        
        if(rownum<0)
        {
            
            JOptionPane.showMessageDialog ( null, "Please Select a debt to pay" );
            
        }
        else
        {
        
            try
            {
            
                String debtone = "UPDATE debt SET debt_status ='Y' WHERE debt_id = '"+ debttable.getValueAt(rownum, 0)+"'";
                pst = con.prepareStatement ( debtone );
                pst.execute();
            }
            
            catch(Exception e)
            {
            
                JOptionPane.showMessageDialog ( null, e );
            
            }
            
            tableload();
            JOptionPane.showMessageDialog ( null, "Transaction Successful" );
        }
        
        
        
    }//GEN-LAST:event_paydebtActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed

        if(nametext.getText().equals("") || phonetext.getText().equals("") )
        {
        
            JOptionPane.showMessageDialog ( null, "Please select a field to be edited" );
        }
        else
        {
            
            nic = nictextreg.getText();
            name = nametext.getText();
            phone = phonetext.getText();
          
        
            try
            {
            
                String edit = "UPDATE customer SET cus_name ='"+name+"',cus_phone ='"+phone+"' WHERE cus_id = '"+nic+"'";
                pst = con.prepareStatement ( edit );
                pst.execute();
                
                String sql2 = "SELECT * FROM customer WHERE cus_id = '"+nic+"'";
                pst = con.prepareStatement ( sql2 );
                rs =  pst.executeQuery();
                    
                    if(rs.next())
                    {
                    
                        nictextreg.setText(nic);
                        nametext.setText(rs.getString("cus_name"));
                        phonetext.setText(String.valueOf(rs.getInt("cus_phone")));
                        
                    
                    }
                    
                     JOptionPane.showMessageDialog ( null, "Update successful" );
            }
            catch(Exception e)
            {
                
                JOptionPane.showMessageDialog ( null, e );
            
            }
            
        }
        
        
    
    }//GEN-LAST:event_editbuttonActionPerformed

    private void nictextregKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nictextregKeyTyped

          if(nictextreg.getText().length()>9)
        {
            nictextreg.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Maximum NIC length is 10.");
            evt.consume();
          
        }
           
        nictextreg.setBorder(BorderFactory.createLineBorder(Color.GRAY));
    
    }//GEN-LAST:event_nictextregKeyTyped

    private void nametextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nametextKeyTyped

        /*cheks for invalid characters when typing */
        
        Pay_validations p2 = new Pay_validations();
        
        char c = evt.getKeyChar();
        String x = Character.toString(c);
        if(!(p2.lettersOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            nametext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Name cannot include numeric values.");
            evt.consume();
        
        }
        
        nametext.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
    }//GEN-LAST:event_nametextKeyTyped

    private void phonetextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phonetextKeyTyped

        /*cheks for invalid characters when typing */
        
        
        
        Pay_validations p1 = new Pay_validations();
        
        char c = evt.getKeyChar();
        String x = Character.toString(c);
        String type1 = nametext.getText();
        if(type1.equals("")){
             getToolkit().beep();
             phonetext.setText("");
             //qty.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Enter Customer Name", "Error", JOptionPane.INFORMATION_MESSAGE);
             phonetext.setText("");
             evt.consume();
         }
        
        else if(phonetext.getText().length()>9)
        {
            phonetext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Length should be 10.");
            evt.consume();
            phonetext.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
          
        }
        else if(!(p1.digitsOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            phonetext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Phone number cannot include letters.");
            evt.consume();
        
            phonetext.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        }
        
        if((phonetext.getText().length()==9)){
            addbutton.setEnabled(true);
        }
        
    }//GEN-LAST:event_phonetextKeyTyped

    private void nametextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametextActionPerformed

    private void phonetextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonetextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonetextActionPerformed

    private void viewdebtsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewdebtsActionPerformed

        /*View ireport*/

        HashMap param = new HashMap();

        String report = "C:\\ireportsNew\\debt.jasper";

        try
        {

            bill(report,null);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog (null,e);
        }
     
       
    }//GEN-LAST:event_viewdebtsActionPerformed

    private void viewcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcustomerActionPerformed

        /*View ireport*/

        HashMap param = new HashMap();

        String report = "C:\\ireportsNew\\debtcustomer.jasper";

        try
        {

            bill(report,null);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog (null,e);
        }
     
        
    }//GEN-LAST:event_viewcustomerActionPerformed

    private void phonetextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phonetextKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_phonetextKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JButton clearbutton;
    private javax.swing.JButton customermanback;
    private javax.swing.JLabel debt;
    private javax.swing.JTable debttable;
    private javax.swing.JButton editbutton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton5;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nametext;
    private javax.swing.JTextField nictextreg;
    private javax.swing.JButton payall;
    private javax.swing.JButton paydebt;
    private javax.swing.JTextField phonetext;
    private javax.swing.JButton searchbutton;
    private javax.swing.JButton viewcustomer;
    private javax.swing.JButton viewdebts;
    // End of variables declaration//GEN-END:variables
}
