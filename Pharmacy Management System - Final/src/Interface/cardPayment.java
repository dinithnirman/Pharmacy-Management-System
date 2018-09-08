
package Interface;

import My_Code.DBconnect;
import rr.Ireport;
import static Interface.Customer_Home1.a;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.awt.HeadlessException;
import My_Code.PaymentCode;
import Validation.Pay_validations;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.BorderFactory;

import static rr.Ireport.bill;

public final class cardPayment extends javax.swing.JFrame{

    Connection con =null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    
    /*Variables related to cards*/
    private String bank1;
    private String cardnum1;
    private String type;
    
    /*variables related to customer*/
    private String name;
    private String phone;
    private String nic;
    private String email;
    
    String result;
    String cardnumtable;
    String banktable;
    String typetable;
    double dis;
    String sql;
    public static String stm;
    public static String etm;
    public static String p;
    public static String o;
    public static String i;
    public static String u;
    double discountamt;
    
    
    public cardPayment() 
    {
        
        initComponents();
     
        con = DBconnect.connect ();
        
        calculateDiscount();
        //tableload ();
        setSalesId();
        
        
        
    }

    
    
    
    
     public cardPayment(double discount)
     {
    
        initComponents();
        this.dis = discount;
        
         
        con = DBconnect.connect ();
        calculateDiscount();
        //tableload();
        setSalesId();
    
    }
    
     public cardPayment(String totalpass,String nic)
    {
        System.out.println(totalpass);
        initComponents();
        //nictextcard.setText(nicpass);
        //nametextcard.setText(name);
        //phonetextcard1.setText(phn);
        //emailtextcard.setText(emailpass);
        grossamt.setText(totalpass);
        
        
        con = DBconnect.connect ();
        calculateDiscount();
        //tableload();
        setSalesId();
    
    }
     
     
//    public void tableload () /*Populate cardTable with existing details or prompt to add new details*/
//    {
//        
//        try 
//        {
//            
//            if(nametextcard.equals(" "))
//            {
//            
//                JOptionPane.showMessageDialog ( null, "Please add customer details to proceed" );
//                
//            }
//            
//            
//            else
//            {
//            
//                String nictosql = nictextcard.getText();
//                
//                String getcarddetails = "SELECT cc.card_num,cc.card_bank,cc.card_type,cp.payment_date,cp.payment_amount  FROM cust_card cc ,cust_payments cp WHERE cc.cus_pay_fk = cp.payment_id AND cp.cus_if_fk = '"+ nictosql +"'";
//                pst = con.prepareStatement ( getcarddetails );
//                rs = pst.executeQuery ();
//                cardtable.setModel ( DbUtils.resultSetToTableModel ( rs ));
//            
//            }
//                
//                
//                    
//       
//        }
//       
//        catch ( Exception e ) 
//        {
//            JOptionPane.showMessageDialog ( null, e );
//            
//        }    
//    
//    
//    }
    
 
    
    public boolean cardNumvalidation(String cardnum) /* Validate Credit card number */
    {
       
        if(cardnum.equals(" "))
        {
           
            return false;
        }
        
        else
        {
            
            char[] cardnumarr = cardnum.toCharArray();
            
            for(int i = 0; i<cardnumarr.length; i++)
            {
            
                try
                {
                    
                    Integer.parseInt(String.valueOf(cardnumarr[i]));
                    
                }
                
                catch(NumberFormatException e)
                {
                    JOptionPane.showMessageDialog ( null, "Card number can only contain digits" );
                    
                    break;
                    
                }
                
            }
            
        }
        
        return true;

    }
    
    
    
    public boolean cardTypeValidation() /*validates credit card type*/
    {
    
        if(typecombo.getSelectedIndex()==0)
        {
           
            return false;
        }
        
        else
            return true;
    }
    
    
    
    
   /* public void addcustomer() /*Add new customer details to database
    {
        
        String nic = nictextcard.getText();
//        String namenew = nametextcard.getText();
//        String phonenew = phonetextcard1.getText();
//        String emailnew = emailtextcard.getText();
        
        
       
        try 
        {

            String cuschek = "SELECT * FROM customer WHERE cus_id='"+nic+"' AND cus_name IS NULL"; /*checks whether customer details are already in database*/
            //pst = con.prepareStatement ( cuschek );
            //rs =  pst.executeQuery();
            
                    
            //if(rs.next()) /*If customer details exist in database update details
//            {
//                        
//                String update = "UPDATE customer SET cus_name = '"+namenew+"', cus_phone = '"+phonenew+"', cus_email='"+emailnew+"' WHERE cus_id='"+nic+"' ";
//                pst = con.prepareStatement ( update );
//                pst.execute();
//            }
//                    
//            else  /*if not add new record
//            {     
//                        
//                String customercard = "INSERT INTO customer(cus_id, cus_name, cus_phone, cus_email) VALUES ('"+nic+"','"+namenew+"','"+phonenew+"','"+ emailnew+"') ";
//                pst = con.prepareStatement ( customercard );
//                pst.execute();
//            
//                        
//            }
//                    
//                
//        
//        }
//        
//        catch (Exception e) 
//        {
//            
//            JOptionPane.showMessageDialog ( null, e );
//            
//        }
//    
//        
//        
//    
//    }
//    
//    */
    
    public void addpayment(double total,String cusid) /*Add new transaction details*/
    {
    
        
        double amount = total;
        
        Date d = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String idate = sd.format(d);

        try  /*Add new payment record to database */
        {
            
            String cardpay = "INSERT INTO cust_payments (payment_amount,payment_date ) VALUES  ('"+amount+"','"+idate+"') ";
            pst = con.prepareStatement ( cardpay );
            pst.execute();
            
            cardnum1 = cardnumtext.getText();
        bank1 = banktext.getText();
        String cardtype = typecombo.getSelectedItem().toString().trim();
        
        
        if((cardnumtext.getText().equals(" ") || banktext.getText().equals(" ") || typecombo.getSelectedIndex() == 0)) /*checks whether card details are incomplete*/
        {
            
             JOptionPane.showMessageDialog ( null, "Card details cannot be empty, Please recheck" );
            
        }
        
        else
        {
            try /*insert card details to database*/
            {
                  
                    String customercard = "INSERT INTO cust_card(card_num, card_bank, card_type, cus_pay_fk) VALUES ('"+cardnum1+"','"+bank1+"','"+cardtype+"',last_insert_id()) ";
                    pst = con.prepareStatement ( customercard );
                    pst.execute();
                    
                   
            }
            
            
            catch (SQLException e) 
            {
            
                JOptionPane.showMessageDialog ( null, e );
            
            }
    
           
            
        }
            
        } 
        
        catch (SQLException e) 
        {
            
            JOptionPane.showMessageDialog ( null, e );
            
        }
    
    
    }
    
    
    
    
    public void addcard(String cusid)  /*Add new credit/debit card details*/
    {
        
        cardnum1 = cardnumtext.getText();
        bank1 = banktext.getText();
        String cardtype = typecombo.getSelectedItem().toString().trim();
        
        
        if((cardnumtext.getText().equals(" ") || banktext.getText().equals(" ") || typecombo.getSelectedIndex() == 0)) /*checks whether card details are incomplete*/
        {
            
             JOptionPane.showMessageDialog ( null, "Card details cannot be empty, Please recheck" );
            
        }
        
        else
        {
            try /*insert card details to database*/
            {
                  
                    String customercard = "INSERT INTO cust_card(card_num, card_bank, card_type, cus_pay_fk) VALUES ('"+cardnum1+"','"+bank1+"','"+cardtype+"',last_insert_id()) ";
                    pst = con.prepareStatement ( customercard );
                    pst.execute();
                    
            }
            
            
            catch (SQLException e) 
            {
            
                JOptionPane.showMessageDialog ( null, e );
            
            }
    
           
            
        }
    
    }
   
    
    
    public void calculateDiscount() /*Calculate discount to given rate*/
    {
        

        if(discountbox.getSelectedIndex()==0)
        {
            amttobepaid.setText(grossamt.getText());
           
        }
        
        else /*equations for discount calculation */
        {
            int x = Integer.parseInt((String)discountbox.getSelectedItem());
            double gamt = Double.parseDouble(grossamt.getText());
            double discountamt = (gamt*(x/100.00));  
            gamt = gamt - discountamt;
                
            amttobepaid.setText(new DecimalFormat("##.##").format(gamt));
        }
    
    }
    
    
     public void setSalesId() /*to get sales id for generating bill*/
    {
        salesidtag.setText(String.valueOf(PaymentCode.getSalesId()));
        //System.out.println(a);
        //grossamt.setText(a);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phonetextcard = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        donecard = new javax.swing.JButton();
        cardnumtext = new javax.swing.JTextField();
        typecombo = new javax.swing.JComboBox<>();
        banktext = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        cardpayment = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        grossamt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        discountbox = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        amttobepaid = new javax.swing.JTextField();
        salesidtag = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        viewcard = new javax.swing.JButton();

        phonetextcard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(206, 196, 217));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 640));

        donecard.setBackground(new java.awt.Color(85, 55, 118));
        donecard.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        donecard.setForeground(new java.awt.Color(255, 255, 255));
        donecard.setText("Cancel");
        donecard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donecardActionPerformed(evt);
            }
        });

        cardnumtext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cardnumtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardnumtextActionPerformed(evt);
            }
        });
        cardnumtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cardnumtextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cardnumtextKeyTyped(evt);
            }
        });

        typecombo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typecombo.setMaximumRowCount(10);
        typecombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Card Type", "Visa", "Debit", "Master Card", "American Express", "" }));
        typecombo.setToolTipText("");

        banktext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        banktext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                banktextActionPerformed(evt);
            }
        });
        banktext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                banktextKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("Card Details ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Card Number :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Card Type :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Bank :");

        jPanel2.setBackground(new java.awt.Color(85, 55, 118));

        Back.setBackground(new java.awt.Color(85, 55, 118));
        Back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.setAutoscrolls(true);
        Back.setBorderPainted(false);
        Back.setFocusable(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        cardpayment.setBackground(new java.awt.Color(85, 55, 118));
        cardpayment.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cardpayment.setForeground(new java.awt.Color(255, 255, 255));
        cardpayment.setText("PAY");
        cardpayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardpaymentActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Gross Amount  :");

        grossamt.setEditable(false);
        grossamt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        grossamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grossamtActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Rs.");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Discount :");

        discountbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        discountbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "3", "5" }));
        discountbox.setToolTipText("");
        discountbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                discountboxItemStateChanged(evt);
            }
        });
        discountbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountboxActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("%");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Amount to be paid :");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Rs.");

        amttobepaid.setEditable(false);
        amttobepaid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        salesidtag.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salesidtag.setText("_______");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Sales ID :");

        viewcard.setBackground(new java.awt.Color(85, 55, 118));
        viewcard.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        viewcard.setForeground(new java.awt.Color(255, 255, 255));
        viewcard.setText("View Cards");
        viewcard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(23, 23, 23)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(typecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cardnumtext, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(banktext, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(155, 155, 155))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(grossamt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(discountbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(salesidtag))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(amttobepaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cardpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewcard)
                .addGap(18, 18, 18)
                .addComponent(donecard, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {amttobepaid, banktext, cardnumtext, discountbox, grossamt, typecombo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cardnumtext, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typecombo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(banktext, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(salesidtag))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grossamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(discountbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(amttobepaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardpayment)
                    .addComponent(viewcard)
                    .addComponent(donecard))
                .addContainerGap(360, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {amttobepaid, banktext, cardnumtext, discountbox, grossamt, typecombo});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void donecardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donecardActionPerformed

         
        
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
        {
            this.dispose();
        }
        
             
    }//GEN-LAST:event_donecardActionPerformed

    private void cardnumtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardnumtextActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_cardnumtextActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
  
        
        this.dispose ();
    }//GEN-LAST:event_BackActionPerformed

    private void cardpaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardpaymentActionPerformed

        

        cardnum1 = cardnumtext.getText();
        bank1 = banktext.getText();
        type = typecombo.getSelectedItem().toString();
        

        
            calculateDiscount();
            
            if((cardNumvalidation(cardnum1)==false || cardTypeValidation()==false || cardnumtext.getText().equals(" ") || banktext.getText().equals(" ") || typecombo.getSelectedIndex() == 0))
            {
                  JOptionPane.showMessageDialog ( null, "Card details cannot be empty, Please recheck" );
            
            }
        
            else  
            {
                
                double amt = Double.parseDouble(amttobepaid.getText());
            
                try
                {
            
   
        
                    if(discountbox.getSelectedIndex()!=0)
                    {
                       
                        double grosstotal = amt;
                        int discount = Integer.parseInt((String) discountbox.getSelectedItem()); 
                        discountamt = (grosstotal*(discount/100.00));  
                        grosstotal = grosstotal - discountamt;
                        addpayment(grosstotal, nic); /*add payment detais if a discount is  given*/
                        PaymentCode.addDiscount(discount); /*add discount details to database*/
                        //PaymentCode.updateDiscount(); /*update discount details related to the payment*/
                    }
        
                    else
                    {
              
                        addpayment(amt, nic);/*add payment details if discount is not given*/
                
                    }
                
                 
              
                }   
        
                catch(Exception e)
                {
            
                    JOptionPane.showMessageDialog ( null, e );
        
                }
                
        
          
       
            
            
            stm=amttobepaid.getText();
            //String stm1 = (new DecimalFormat("##.##").format(stm));
            etm="0.0";  
            //String etm1 = (new DecimalFormat("##.##").format(etm));
            p = discountbox.getSelectedItem().toString();
            //String p1 = (new DecimalFormat("##.##").format(p));
            o = Double.toString(discountamt);
            //String o1 = (new DecimalFormat("##.##").format(o));
            i = amttobepaid.getText();
            //String i1 = (new DecimalFormat("##.##").format(i));
            u = salesidtag.getText();
              
            cbill b;
                try {
                    b = new cbill(stm,etm,p,o,i,u);
            
                    b.setVisible(true);
                } catch (PrinterException ex) {
                    //Logger.getLogger(SalesREP.class.getName()).log(Level.SEVERE, null, ex);
                }

       
        this.dispose();
            }
    }//GEN-LAST:event_cardpaymentActionPerformed

    private void cardnumtextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardnumtextKeyPressed

        //cardvalidation();
    }//GEN-LAST:event_cardnumtextKeyPressed

    private void banktextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_banktextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_banktextActionPerformed

    private void discountboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_discountboxItemStateChanged

        
    }//GEN-LAST:event_discountboxItemStateChanged

    private void discountboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountboxActionPerformed

        calculateDiscount();
    }//GEN-LAST:event_discountboxActionPerformed

    private void cardnumtextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cardnumtextKeyTyped

         /*cheks for invalid characters when typing */
         
        Pay_validations p3 = new Pay_validations();
        
        char c = evt.getKeyChar();
        String x = Character.toString(c);
        /*checks for maximum length of nic nummber*/
        
        if(cardnumtext.getText().length()>15)
        {
            
            cardnumtext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Maximum length is 16.");
            evt.consume();
          
        }
         
        else if(!(p3.digitsOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            cardnumtext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Card number cannot include letters.");
            evt.consume();
        
        }
        
        cardnumtext.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        
    }//GEN-LAST:event_cardnumtextKeyTyped

    private void banktextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_banktextKeyTyped

         /*cheks for invalid characters when typing */
         
        Pay_validations p4 = new Pay_validations();
        
        char c = evt.getKeyChar();
        String x = Character.toString(c);
        if(!(p4.lettersOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            banktext.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Bank name cannot include digits.");
            evt.consume();
        
        }
        
        banktext.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        
    }//GEN-LAST:event_banktextKeyTyped

    private void grossamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grossamtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grossamtActionPerformed

    private void viewcardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcardActionPerformed

        /*View ireport*/
        
        HashMap param = new HashMap();

        String report = "C:\\ireportsNew\\card.jasper";

        try
        {

            bill(report,null);

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog (null,e);
        }
        
    }//GEN-LAST:event_viewcardActionPerformed

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
            java.util.logging.Logger.getLogger(cardPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cardPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cardPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cardPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new cardPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField amttobepaid;
    private javax.swing.JTextField banktext;
    private javax.swing.JTextField cardnumtext;
    private javax.swing.JButton cardpayment;
    private javax.swing.JComboBox<String> discountbox;
    private javax.swing.JButton donecard;
    private javax.swing.JTextField grossamt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField phonetextcard;
    private javax.swing.JLabel salesidtag;
    private javax.swing.JComboBox<String> typecombo;
    private javax.swing.JButton viewcard;
    // End of variables declaration//GEN-END:variables
}
