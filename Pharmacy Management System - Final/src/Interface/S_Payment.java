/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import My_Code.DBconnect;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MAXMO
 */
public class S_Payment extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pas=null;
    ResultSet rs= null;
    
    String r;
    
    /**
     * Creates new form S_Payment
     */
    public S_Payment() {
        initComponents();
                //DB Connection & Table Load
        con = DBconnect.connect();
        fields();
        tableLoad();
        SupfillCombo();
        //fillCombo1();
        PayfillCombo2();
        tableLoadCHQ();
        PayIdCombo();
        payDate.getDateEditor().setEnabled(false);
        jDateChooser1.getDateEditor().setEnabled(false);
        jPanel2.setVisible(true);
        payId.setEditable(false);
        selectCombo();
        System.out.println("table loaded");
    }
    
        public void tableLoadCHQ()
    {
        try{
        String querry10="SELECT ch_id, acc_num, cheque_no, cheque_date, pay_id FROM cheque_pay";
        pas= con.prepareStatement(querry10);
        rs = pas.executeQuery();
      jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
           System.out.println(e); 
        }
    }
    
    public void tableLoad()
    {
        try{
        String querry2="SELECT pay_id, supplierId, invoiceNo, payDate, type,amount FROM supplier_payment";
        pas= con.prepareStatement(querry2);
        rs = pas.executeQuery();
      jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
           System.out.println(e); 
        }
    }
    private void PayfillCombo()
    {
        try{
            String querry3="SELECT * from supplier_payment";
            pas= con.prepareStatement(querry3);
            rs = pas.executeQuery();
            
            while (rs.next())
            {
                String S_Id = rs.getString("pay_id");
                paySupId.addItem(S_Id);
            }
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
 
 private void PayfillCombo2()
    {
        try{
            String d = paySupId.getSelectedItem().toString();
            
            String querry3="SELECT * from place_order where S_Id='"+d+"'";
            pas= con.prepareStatement(querry3);
            rs = pas.executeQuery();
            
            while (rs.next())
            {
                String S_Id = rs.getString("InvoiceNo");
                jComboBox2.addItem(S_Id);
            }
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
    private void SupfillCombo()
    {
        try{
            String querry3="SELECT * from pharma_supplier";
            pas= con.prepareStatement(querry3);
            rs = pas.executeQuery();
            
            while (rs.next())
            {
                String S_Id = rs.getString("S_Id");
                paySupId.addItem(S_Id);
            }
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }
        private void PayIdCombo()
        {
        try{
            String querry3="SELECT * from supplier_payment";
            pas= con.prepareStatement(querry3);
            rs = pas.executeQuery();
            
            while (rs.next())
            {
                String S_Id = rs.getString("pay_id");
                jComboBox1.addItem(S_Id);
            }
        }
        catch(Exception e)
                {
                    System.out.println(e);
                }
    }

//private void fillCombo1()
//    {
//        try{
//            String querry3="SELECT * from  supplier_payment";
//            pas= con.prepareStatement(querry3);
//            rs = pas.executeQuery();
//            
//            while (rs.next())
//            {
//                String Inv = rs.getString("InvoiceNo");
//                jComboBox1.addItem(Inv);
//            }
//        }
//        catch(Exception e)
//                {
//                    System.out.println(e);
//                }
//    }
    private void selectCombo()
    {
        try
        {
            int i = payType.getSelectedIndex();
            if(i==2){
              jPanel2.setVisible(true);
            } 
            else {
               //JOptionPane.showMessageDialog(null,"You Selected Cash payment"); 
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void fields()
    {
                jTextField1.setEditable(false);
                jTextField2.setEditable(false);
                jTextField3.setEditable(false);
                jDateChooser1.setEnabled(false);
                jComboBox1.setEnabled(false);
                jButton1.setEnabled(false);
                jButton6.setEnabled(false);
                jButton7.setEnabled(false);
                jButton8.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        payId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        paySupId = new javax.swing.JComboBox<>();
        payDate = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        payAmount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        payType = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 640));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Supplier Payment");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Payment Id");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Invoice Number");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Supplier Id");

        payId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payIdActionPerformed(evt);
            }
        });
        payId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                payIdKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Pay Date");

        paySupId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supplier Id" }));
        paySupId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paySupIdActionPerformed(evt);
            }
        });

        payDate.setDateFormatString("yyyy-MM-dd");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Amount");

        payAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payAmountActionPerformed(evt);
            }
        });
        payAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                payAmountKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Payment Type");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton3.setText("Pay");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment Id", "Invoice No", "Supplier Id", "Pay Date", "Amount", "Payment", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
        }

        payType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Pay Type", "Cheque", "Cash" }));
        payType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payTypeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Cheuqe Id");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Account No");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Cheque No");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Cheque Date");

        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Payment Id");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setText("Add Cheque Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Pay ID" }));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton6.setText("Update Details");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton7.setText("Delete Details");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton8.setText("Clear All");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cheque id", "Account no", "Cheque No", "cheqye Date", "Payment Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
            jTable2.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel13.setText("Search");

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Invoice No" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(payId)
                                    .addComponent(paySupId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(payDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(payType, 0, 137, Short.MAX_VALUE)
                                    .addComponent(payAmount)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5))
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(jLabel13)
                                .addGap(38, 38, 38)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(188, 188, 188)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paySupId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(payDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(payType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(payAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(payId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1092, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payAmountActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String SupplierId = paySupId.getSelectedItem().toString();
        String Invoice = jComboBox2.getSelectedItem().toString();
        String PayDate=((JTextField)payDate.getDateEditor().getUiComponent()).getText();
        String PayType = payType.getSelectedItem().toString();
        String Amount = payAmount.getText();
        //String status = jComboBox3.getSelectedItem().toString();
        
        String querry1 = "INSERT INTO supplier_payment( supplierId, invoiceNo, payDate, type,amount) values('"+SupplierId+"','"+Invoice+"','"+PayDate+"','"+PayType+"','"+Amount+"')";
    
       try{
           
        pas= con.prepareStatement(querry1);
        pas.executeUpdate();
        tableLoad();
        JOptionPane.showMessageDialog(null,"Successfully Added");
                 System.out.println("qry executed");
        String o ="Paid";
        String r = "Update place_order set Status='"+o+"' where InvoiceNo='"+Invoice+"'";
        pas= con.prepareStatement(r);
        pas.execute();
       }
        catch(Exception e)
        {System.out.println(e);}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void payTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payTypeActionPerformed
        Object selected = payType.getSelectedItem();

            if(selected.toString().equals("Cheque"))
            {
                jTextField1.setEditable(false);
                jTextField2.setEditable(true);
                jTextField3.setEditable(true);
                jDateChooser1.setEnabled(true);
                jComboBox1.setEnabled(true);
                jButton1.setEnabled(true);
                jButton6.setEnabled(true);
                jButton7.setEnabled(true);
                jButton8.setEnabled(true);
            }
            else
            {
                fields();
            }
    }//GEN-LAST:event_payTypeActionPerformed

    private void payIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payIdKeyTyped

    }//GEN-LAST:event_payIdKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        String AccNo = jTextField2.getText();
        String chNo = jTextField3.getText();
        String chDate=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        String PayId = jComboBox1.getSelectedItem().toString();
         
        
        
        String querry2 = "INSERT INTO  cheque_pay( acc_num, cheque_no, cheque_date, pay_id) values('"+AccNo+"','"+chNo+"','"+chDate+"','"+PayId+"')";
    
       try{
           PayfillCombo();
        pas= con.prepareStatement(querry2);
        pas.executeUpdate();
        tableLoadCHQ();
        JOptionPane.showMessageDialog(null,"Successfully Added");
                 System.out.println("qry executed");
        
        
       }
        catch(Exception e)
        {System.out.println(e);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
                char vachar = evt.getKeyChar();
        if(!(Character.isDigit(vachar))
                ||(vachar == KeyEvent.VK_BACK_SPACE)
                ||(vachar == KeyEvent.VK_DELETE)){evt.consume();}
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
               char vachar = evt.getKeyChar();
        if(!(Character.isDigit(vachar))
                ||(vachar == KeyEvent.VK_BACK_SPACE)
                ||(vachar == KeyEvent.VK_DELETE)){evt.consume();}
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             int a =  JOptionPane.showConfirmDialog(null, "Do you want to update info!");
       if(a==0)
       {
        String PayId = payId.getText();
        String SupplierId = paySupId.getSelectedItem().toString();
        String Invoice = jComboBox2.getSelectedItem().toString();
        String PayDate=((JTextField)payDate.getDateEditor().getUiComponent()).getText();
        String PayType = payType.getSelectedItem().toString();
        String Amount = payAmount.getText();
        //String status = jComboBox1.getSelectedItem().toString(); 
        try
        {
        String query3 = "UPDATE supplier_payment set supplierId ='"+SupplierId+"', invoiceNo = '"+Invoice+"', payDate = '"+PayDate+"', type= '"+PayType+"', amount = '"+Amount+"' WHERE pay_id ='"+PayId+"'";
        pas = con.prepareStatement(query3);
        pas.execute();
        tableLoad();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                       int x= JOptionPane.showConfirmDialog(null, "Do you want to delete this info");
        if(x==0)
        {
            String Id = payId.getText();
            String Invoice = jComboBox2.getSelectedItem().toString();
            String query4 = "DELETE from supplier_payment WHERE pay_id = '"+Id+"'";
            try{
                 pas= con.prepareStatement(query4);
                 pas.execute();
                 tableLoad();
                 
                 String o ="Not Paid";
            String r = "Update place_order set Status='"+o+"' where InvoiceNo='"+Invoice+"'";
            pas= con.prepareStatement(r);
            pas.execute();
            }
            catch(Exception e)
                    {
                        System.out.println(e);
                    }
            
        }
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        payId.setText(" ");
        paySupId.setSelectedItem("Select Supplier Id");
        jComboBox2.setSelectedItem("Select Invoice No");
        ((JTextField)payDate.getDateEditor().getUiComponent()).setText(" ") ;
       payType.setSelectedItem("Select Pay Type");
       payAmount.setText(" ");
              
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
                               int x= JOptionPane.showConfirmDialog(null, "Do you want to delete this info");
        if(x==0)
        {
            String Id = jTextField1.getText();
            String query4 = "DELETE from cheque_pay WHERE ch_id = '"+Id+"'";
            try{
                 pas= con.prepareStatement(query4);
                 pas.execute();
                 tableLoadCHQ();
            }
            catch(Exception e)
                    {
                        System.out.println(e);
                    }
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                    int a =  JOptionPane.showConfirmDialog(null, "Do you want to update info!");
       if(a==0)
       {
        String chId = jTextField1.getText();
        String AccNo = jTextField2.getText();
        String chNo = jTextField3.getText();
        String chDate=((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        String PayId = jComboBox1.getSelectedItem().toString();
        try
        {
        String query3 = "UPDATE cheque_pay set acc_num ='"+AccNo+"', cheque_no = '"+chNo+"', cheque_date = '"+chDate+"', pay_id= '"+PayId+"' WHERE ch_id ='"+chId+"'";
        pas = con.prepareStatement(query3);
        pas.execute();
        tableLoadCHQ();
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
       }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       jTextField1.setText(" ");
       jTextField2.setText(" ");
       jTextField3.setText(" ");
       ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText(" ") ;
       jComboBox1.setSelectedItem("Select Pay ID");
    }//GEN-LAST:event_jButton8ActionPerformed

    @SuppressWarnings("empty-statement")
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
payId.setEnabled(false); 
        
        int r = jTable1.getSelectedRow();
        String pay_id = jTable1.getValueAt(r,0).toString();
        String SupplierId = jTable1.getValueAt(r,1).toString();
        String InvoiceNo = jTable1.getValueAt(r,2).toString();
        String payDate1 = jTable1.getValueAt(r,3).toString();
        String type = jTable1.getValueAt(r,4).toString();
        String Amount = jTable1.getValueAt(r, 5).toString();
        
        payId.setText(pay_id);
        paySupId.setSelectedItem(SupplierId);
        jComboBox2.setSelectedItem(InvoiceNo);
        ((JTextField)payDate.getDateEditor().getUiComponent()).setText (payDate1);
        payType.setSelectedItem(type);
        payAmount.setText(Amount);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
                    int r = jTable2.getSelectedRow();
        String ch_id = jTable2.getValueAt(r,0).toString();
        String acc_num = jTable2.getValueAt(r,1).toString();
        String cheque_no = jTable2.getValueAt(r,2).toString();
        String cheque_date = jTable2.getValueAt(r,3).toString();
        String pay_id = jTable2.getValueAt(r,4).toString();
        
        
        jTextField1.setText(ch_id);
        jTextField2.setText(acc_num);
        jTextField3.setText(cheque_no);
       ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).setText(cheque_date);;
        jComboBox1.setSelectedItem(pay_id);
        
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void payIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payIdActionPerformed

    }//GEN-LAST:event_payIdActionPerformed

    private void payAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payAmountKeyTyped
char vachar = evt.getKeyChar();
        if(!(Character.isDigit(vachar))
                ||(vachar == KeyEvent.VK_BACK_SPACE)
                ||(vachar == KeyEvent.VK_DELETE)){evt.consume();}
    }//GEN-LAST:event_payAmountKeyTyped

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
               DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
       String Search = jTextField4.getText();
       TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
       jTable1.setRowSorter(tr);
       tr.setRowFilter(RowFilter.regexFilter(Search));
    }//GEN-LAST:event_jTextField4KeyReleased

    private void paySupIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paySupIdActionPerformed
        // TODO add your handling code here:
        PayfillCombo2();
    }//GEN-LAST:event_paySupIdActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        try{
            String q = paySupId.getSelectedItem().toString();
            String h = jComboBox2.getSelectedItem().toString();
            String sql = "Select Amount from place_order where S_Id = '"+ q +"' and InvoiceNo = '"+ h +"'";
            pas= con.prepareStatement(sql);
            rs = pas.executeQuery();
            
            while(rs.next()){
                r = rs.getString(1);
            }
            
            payAmount.setText(r);
            
        }
        
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField payAmount;
    private com.toedter.calendar.JDateChooser payDate;
    private javax.swing.JTextField payId;
    private javax.swing.JComboBox<String> paySupId;
    private javax.swing.JComboBox<String> payType;
    // End of variables declaration//GEN-END:variables
}
