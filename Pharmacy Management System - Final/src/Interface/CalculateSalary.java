/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import static Interface.CreatePaysheet.date;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import My_Code.DBconnect;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import Validation.Employee;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import net.sf.jasperreports.engine.JRException;
import static rr.Ireport.MyReport;

/**
 *
 * @author MAXMO
 */
public class CalculateSalary extends javax.swing.JInternalFrame {

    /**
     * Creates new form CalculateSalary
     */
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String id;
    String sql;
    String month;
    String em;
    String p;
    String epf;
    String etf;
    String other;
    String allowances;
    Double epf1;
    Double etf1;
    Double allowances1;
    Double other1;
    String basicSalary;
    String ot;
    String otHours;
    int otHours1;
    String otRate;
    Double otRate1;
    Double basicSalary1;
    Double ot1;
    String totsal1;
    String date;
    int r;
    int x;
    String date1;
    public static String sid;
    public double totsal;
    double m;
    double m1;
    String h;
    String f;
    
    
    
    
    public CalculateSalary() {
        initComponents();
        
        con = DBconnect.connect();
        
        fillcombo ();
        //fillcombo1 ();
        tableload ();
        Date.getDateEditor().setEnabled(false);
        Etf.setEditable(false);
        Epf.setEditable(false);
    }
    
    public void clear(){
        Id.setSelectedItem( "Select Id" );
        Month.setSelectedItem ( "Select Month" );
        BasicSalary.setText( "" );
        Ot.setText( "" );
        Allowances.setText( "" );
        Epf.setText("");
        Etf.setText( "" );
        Other.setText( "" );
        Salary.setText( "" );
        Date.setDate( null );
        }

    public boolean dateValidation(){
        if(((JTextField)Date.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Enter Date");
            return false;
        } else {
            return true;
        }
    }
    
    public void fillcombo () {
        
        try {
            
            sql = "SELECT * FROM employee";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                em = rs.getString ( "Id" );
                Id.addItem ( em );
                
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
            
        }
        
    }
    
    /*public void fillcombo1 () {
        
        try {
            
            sql = "SELECT distinct Month FROM paysheet";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                p = rs.getString ( 1 );
                Month.addItem(p);
            }
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
            
        }
        
        
    }*/
    
    public void labelload () {
        
        try {
            id = Id.getSelectedItem().toString();
            
            sql = "SELECT sd.Basic_Salary FROM employee e, salary_details sd WHERE e.Designation = sd.Designation AND e.Id = '"+ id +"' ";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                BasicSalary.setText ( rs.getString ( 1 ) );
                f = rs.getString(1);
            }
            double l = (Double.parseDouble(f))*20/100;
            double k = (Double.parseDouble(f))*4/100;
            
            Epf.setText(Double.toString(l));
            Etf.setText(Double.toString(k));
        }
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void labelload1 () {
        
        try {
            
            id = Id.getSelectedItem().toString();
            month = Month.getSelectedItem().toString();
            
            String sql1 = "Select sd.OT_Rate from salary_details sd, employee e Where e.Id = '"+ id +"'  AND e.Designation = sd.Designation";
            pst = con.prepareStatement ( sql1 );
            rs = pst.executeQuery ();
            while ( rs.next ()) {
            
                otRate = rs.getString(1);
            } 
            //System.out.println(otRate);
            //System.out.println(id);
            //System.out.println(month);
            sql = "SELECT sum(a.OT_Hours) FROM attendance a, employee e WHERE a.Employee_Id=e.Id AND a.Employee_Id = '"+ id +"' AND a.Month= '"+ month +"' group by a.Month";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while ( rs.next ()) {
                
                otHours =rs.getString ( 1 );
                System.out.println(otHours);
                if(rs.getString("sum(a.OT_Hours)")==null){
                Ot.setText(0.0+"");
                    
            }
            
           else{ 
         System.out.print(otHours);
            otHours1 = Integer.parseInt(otHours);
            
            
            otRate1 = Double.parseDouble(otRate);
            ot1 = otHours1 * otRate1;
            ot = Double.toString(ot1);
               
            Ot.setText(ot);
            }
        }}
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }

    
    public void tableload () {
        
        try {
            
            sql = "SELECT Employee_Id, Month, Total_Salary FROM salary";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            salary.setModel ( DbUtils.resultSetToTableModel ( rs ));
          
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

        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Other = new javax.swing.JTextField();
        Etf = new javax.swing.JTextField();
        Epf = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Salary = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Ot = new javax.swing.JLabel();
        BasicSalary = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Month = new javax.swing.JComboBox<>();
        Id = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Other_ = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Date = new com.toedter.calendar.JDateChooser();
        Allowances = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        salary = new javax.swing.JTable();
        BasicSalary1 = new javax.swing.JLabel();
        OT = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        Expiry12 = new javax.swing.JButton();
        remove1 = new javax.swing.JButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 640));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        jButton6.setBackground(new java.awt.Color(85, 55, 118));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("View Salary List");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(85, 55, 118));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(85, 55, 118));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Calculate Salary ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Other.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Other.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OtherActionPerformed(evt);
            }
        });
        Other.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                OtherKeyTyped(evt);
            }
        });

        Etf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Etf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtfActionPerformed(evt);
            }
        });
        Etf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EtfKeyTyped(evt);
            }
        });

        Epf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Epf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EpfActionPerformed(evt);
            }
        });
        Epf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EpfKeyTyped(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Deductions");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Total Salary");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Allowances");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("OT charges");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Basic Salary");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Month");

        Month.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Month", "January", "Februrary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        Month.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MonthMouseClicked(evt);
            }
        });
        Month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonthActionPerformed(evt);
            }
        });

        Id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Id" }));
        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel68.setText("Employee ID");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Calculate Salary");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("EPF");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("ETF");

        Other_.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Other_.setText("Other");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("Date");

        Date.setDateFormatString("yyyy-MM-dd");
        Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateMouseClicked(evt);
            }
        });

        Allowances.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Allowances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllowancesActionPerformed(evt);
            }
        });
        Allowances.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AllowancesKeyTyped(evt);
            }
        });

        salary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Employ_Id", "Month", "Salary"
            }
        ));
        salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salaryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(salary);

        jButton7.setBackground(new java.awt.Color(85, 55, 118));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(85, 55, 118));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(85, 55, 118));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("View Attendance");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        Expiry12.setBackground(new java.awt.Color(85, 55, 118));
        Expiry12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry12.setForeground(new java.awt.Color(255, 255, 255));
        Expiry12.setText("Update");
        Expiry12.setAutoscrolls(true);
        Expiry12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry12.setBorderPainted(false);
        Expiry12.setFocusable(false);
        Expiry12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry12ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Month, 0, 203, Short.MAX_VALUE)
                                            .addComponent(Id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Ot, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Allowances, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Other_, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Etf)
                                        .addComponent(Other, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(Epf, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9))
                                    .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(OT, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(remove1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Expiry12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BasicSalary1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(480, 480, 480))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(BasicSalary1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel68)
                                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel24)
                                    .addComponent(Month, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21)))
                            .addComponent(OT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(BasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Ot, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(Allowances, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(Epf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(Etf, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Other_)
                            .addComponent(Other, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jButton9)
                            .addComponent(Expiry12)
                            .addComponent(jButton7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25)
                                    .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(remove1))
                        .addGap(68, 68, 68))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ViewSalary VS = new ViewSalary ();
        VS.setVisible ( true );
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        clear();
        
         
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         
        Employee E = new Employee();
        try{
            
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            date = dformat.format(Date.getDate());
            
            String [] dateParts = date.split("-");
        String month1 = dateParts[1];
                String month12 = null;
        int num = Integer.parseInt(month1);
        switch (num)
        {
        case 1:
            month12 = "January";
            break;
        case 2:
            month12 = "February";
            break;
        case 3:
            month12 = "March";
            break;
        case 4:
            month12 = "April";
            break;
        case 5:
            month12 = "May";
            break;
        case 6:
            month12 = "June";
            break;
        case 7:
            month12 = "July";
            break;
        case 8:
            month12 = "August";
            break;
        case 9:
            month12 = "September";
            break;
        case 10:
            month12 = "October";
            break;
        case 11:
            month12 = "November";
            break;
        case 12:
            month12 = "December";
            break;
        //default:
        //    System.out.println ("You have entered an invalid number");
        }
            
        String sql7 = "Select Total_Salary from salary where Employee_Id = '"+ id +"' and Month = '"+ month12 +"'";
        pst = con.prepareStatement ( sql7 );
        rs = pst.executeQuery ();
        
        while(rs.next()){
            h= rs.getString(1);
        }
        
        System.out.println(h);
        if(h==null){
        try {
            id = Id.getSelectedItem().toString();
      
            sql = "SELECT sd.Basic_Salary, s.OT_Charge FROM employee e, salary_details sd, salary s WHERE e.Designation = sd.Designation AND e.Id = '"+ id +"' AND s.Employee_Id = '"+ id +"' ";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            basicSalary = BasicSalary.getText();
            ot = Ot.getText();
      
        
            id = Id.getSelectedItem().toString();
            month = Month.getSelectedItem().toString();
            //SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            date = dformat.format(Date.getDate());
            allowances = Allowances.getText();
            epf = Epf.getText();
            etf = Etf.getText();
            other = Other.getText();
        
        
        allowances1 = Double.parseDouble(allowances);
        epf1 = Double.parseDouble(epf);
        etf1 = Double.parseDouble(etf);
        other1 = Double.parseDouble(other);
        basicSalary1 = Double.parseDouble(basicSalary);
        ot1 = Double.parseDouble(ot);
        
        totsal = basicSalary1 + ot1 + allowances1 - (epf1 + etf1 + other1);
        totsal1 = Double.toString(totsal);
        
        
            
            
            
            date1 = date;
            
            Calendar now = Calendar.getInstance();
            int year1 = now.get(Calendar.YEAR);
            String year = String.valueOf(year1);
            System.out.println(year);
                     
            sql = "INSERT INTO salary ( Employee_Id, Month,Year, Allowances, Total_Salary, OT_Charge, Date, Epf, Etf, Other ) VALUES ( '"+ id +"', '"+ month +"', '"+ year +"' ,'"+ allowances +"', '"+ totsal +"', '"+ ot +"', '"+ date +"', '"+ epf +"', '"+ etf +"', '"+ other +"' )";
            pst = con.prepareStatement ( sql );
            pst.execute ();
            
            JOptionPane.showMessageDialog ( null, "Calculate Succesful" );
            
        }
    
        catch ( Exception e ) {
        
            System.out.print ( e );
            
            JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
        
        }        }

        else{
            JOptionPane.showMessageDialog ( null, "You have already created the salary for this employee. \nConnot add this records." );
        }
        
        Salary.setText(totsal1);
        
        tableload ();
        
        }
        catch ( Exception e ) {
        
            System.out.print ( e );
            
            //JOptionPane.showMessageDialog ( null, "Records are incomplete. \nConnot add this records." );
        
        }  
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OtherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OtherActionPerformed

    private void EtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EtfActionPerformed

    private void EpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EpfActionPerformed

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
        labelload ();
    }//GEN-LAST:event_IdActionPerformed

    private void MonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonthActionPerformed
        // TODO add your handling code here:
        labelload1 ();
    }//GEN-LAST:event_MonthActionPerformed

    private void AllowancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllowancesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AllowancesActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        x = JOptionPane.showConfirmDialog ( null, "Do you really want to delete?" );

        if ( x==0 ) {
            
            id = Id.getSelectedItem().toString();
            allowances = Allowances.getText();
            epf = Epf.getText();
            epf = Etf.getText();
            other = Other.getText();
           
           try {
                id = Id.getSelectedItem().toString();

                sql = "DELETE FROM salary WHERE Employee_Id = '"+ id +"' ";
                pst = con.prepareStatement ( sql );
                pst.execute ();

                JOptionPane.showMessageDialog ( null, "Delete Succesful" );
            }

            catch ( Exception e ) {

                JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot delete." );

                System.out.println ( e );

            } 

            tableload ();
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        id = Id.getSelectedItem().toString();
        
        try {

            sql = "SELECT Salary_Id,Employee_Id, Month, Allowances, Total_Salary, OT_Charge, Date, Epf,Etf, Other FROM salary WHERE Employee_Id LIKE '%"+ id +"%' ";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();

            salary.setModel ( DbUtils.resultSetToTableModel ( rs ));

        }

        catch ( Exception e ) {

            JOptionPane.showMessageDialog ( null, "Invalid Id." );

            System.out.println ( e );

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void salaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salaryMouseClicked
        // TODO add your handling code here:
        r = salary.getSelectedRow ();
        sid = salary.getValueAt(r, 0).toString();
        id = salary.getValueAt ( r, 1 ).toString ();
        month = salary.getValueAt ( r, 2 ).toString ();
        allowances = salary.getValueAt ( r, 3 ).toString ();
        ot = salary.getValueAt ( r, 5 ).toString ();
        epf = salary.getValueAt ( r, 7 ).toString ();
        etf = salary.getValueAt ( r, 8 ).toString ();
        other = salary.getValueAt ( r, 9 ).toString ();
        totsal1 = salary.getValueAt ( r, 4 ).toString ();
        date = salary.getValueAt(r, 6).toString();
        

        Allowances.setText ( allowances );
        Ot.setText ( ot );
        Epf.setText ( epf );
        Etf.setText ( etf );
        Other.setText ( other );
        ((JTextField)Date.getDateEditor().getUiComponent()).setText (date);
        //Date.setText (date1);
        Id.setSelectedItem ( id );
        Month.setSelectedItem ( month );
        Salary.setText ( totsal1 );
    }//GEN-LAST:event_salaryMouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        ViewAttendance a = new ViewAttendance ();
        a.setVisible ( true );
    }//GEN-LAST:event_jButton9ActionPerformed

    private void Expiry12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry12ActionPerformed
        // TODO add your handling code here:
        Employee E = new Employee();
        int x = JOptionPane.showConfirmDialog ( null, "Do you really want to update?" );

        if ( x==0 ) {
try {
            id = Id.getSelectedItem().toString();
            month = Month.getSelectedItem().toString();
            SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
            date = dformat.format(Date.getDate());
            allowances = Allowances.getText();
            epf = Epf.getText();
            etf = Etf.getText();
            other = Other.getText();
            basicSalary = BasicSalary.getText();
        
        allowances1 = Double.parseDouble(allowances);
        epf1 = Double.parseDouble(epf);
        etf1 = Double.parseDouble(etf);
        ot1 = Double.parseDouble(ot);
         System.out.println("jkjhj");
        other1 = Double.parseDouble(other);
        
       
        basicSalary1 = Double.parseDouble(basicSalary);
        System.out.println(other1);
        System.out.println(allowances1);
        if(other.equals(0)){
            m= 0.0;
        }
        else{
            m=other1;
        }
        if(allowances.equals(0)){
            m1= 0.0;
        }
        else{
            m1=allowances1;
        }
        /*System.out.println(Double.toString(m));
        System.out.println(Double.toString(m1));*/
        totsal = basicSalary1 + ot1 + allowances1 - (epf1 + etf1 + other1);
        totsal1 = Double.toString(totsal);
        
        
            
            System.out.println(totsal1);
            System.out.println("cffcg");
            date1 = date;
            
            Calendar now = Calendar.getInstance();
            int year1 = now.get(Calendar.YEAR);
            String year = String.valueOf(year1);
            //System.out.println(year);
       
                                String eid = Id.getSelectedItem().toString();
                                

                                    String sql = "UPDATE salary SET Employee_Id = '"+ id +"', Month = '"+ month +"', Year = '"+ year +"', Allowances = '"+ allowances +"', Total_Salary = '"+ totsal1 +"', Ot_Charge = '"+ ot +"', Date = '"+ date +"', Epf = '"+ epf +"', Etf = '"+ etf +"', Other = '"+ other +"' WHERE Salary_Id = '"+ sid +"' ";
                                    pst = con.prepareStatement ( sql );
                                    pst.execute ();

                                    Salary.setText(totsal1);
                                    JOptionPane.showMessageDialog ( null, "Update Succesful" );
                                    
                                    tableload ();

                                }

                                catch ( Exception e ) {

                                    System.out.println ( e );

                                    JOptionPane.showMessageDialog ( null, "Invalid Records. \nConnot update." );

                                }
                            }
    }//GEN-LAST:event_Expiry12ActionPerformed

    private void MonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MonthMouseClicked
        // TODO add your handling code here: 
        Employee e = new Employee();
        String id1 = Id.getSelectedItem().toString();

        if(!((e.empIdValidation(id1)))){
            getToolkit().beep();
            Month.setSelectedItem("Select Month");

            JOptionPane.showMessageDialog(null, "Select Id", "Error", JOptionPane.INFORMATION_MESSAGE);

        }
    }//GEN-LAST:event_MonthMouseClicked

    private void DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateMouseClicked
        // TODO add your handling code here:
        Employee e = new Employee();
        
    }//GEN-LAST:event_DateMouseClicked

    private void AllowancesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AllowancesKeyTyped
        // TODO add your handling code here:
        Employee e = new Employee();
        
        String id1 = Month.getSelectedItem().toString();

        if(!((e.MonthValidation(id1)))){
            getToolkit().beep();
            Allowances.setText("");

            JOptionPane.showMessageDialog(null, "Select Month", "Error", JOptionPane.INFORMATION_MESSAGE);
             Allowances.setText("");
             evt.consume();

        }
               
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(e.isDoubleAllowances(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             Allowances.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Allowances Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);
             evt.consume();
         }
         Allowances.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
         
    }//GEN-LAST:event_AllowancesKeyTyped

    private void EpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EpfKeyTyped
        // TODO add your handling code here:
        Employee e2= new Employee();
                String type1 = Allowances.getText();
         if(type1.equals("")){
             getToolkit().beep();
             Epf.setText("");
             //BasicSalary.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Enter Allowances Amount", "Error", JOptionPane.INFORMATION_MESSAGE);
             Epf.setText("");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(e2.isDoubleAllowances(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             Epf.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "EPF should be digits only", "Error", JOptionPane.INFORMATION_MESSAGE);
             evt.consume();
         }
         Epf.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
    }//GEN-LAST:event_EpfKeyTyped

    private void EtfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EtfKeyTyped
        // TODO add your handling code here:
        Employee e2= new Employee();
                String type1 = Epf.getText();
         if(type1.equals("")){
             getToolkit().beep();
             Etf.setText("");
             //BasicSalary.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Enter EPF Amount", "Error", JOptionPane.INFORMATION_MESSAGE);
             Etf.setText("");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(e2.isDoubleAllowances(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             Etf.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "ETF Amount should be digits only", "Error", JOptionPane.INFORMATION_MESSAGE);
             evt.consume();
         }
         Etf.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
    }//GEN-LAST:event_EtfKeyTyped

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed
        // TODO add your handling code here:
        String report1="C:\\ireportsNew\\salary_details.jasper" ;

        try {
            MyReport(report1,null);
        }
        catch (SQLException | JRException ex) {
        }
    }//GEN-LAST:event_remove1ActionPerformed

    private void OtherKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_OtherKeyTyped
        // TODO add your handling code here:
        
       Employee e2= new Employee();
                String type1 = Allowances.getText();
         if(type1.equals("")){
             getToolkit().beep();
             Other.setText("");
             //BasicSalary.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Enter Allowances Amount", "Error", JOptionPane.INFORMATION_MESSAGE);
             Other.setText("");
             evt.consume();
         }
         else{
               
         char c = evt.getKeyChar();
         String x = Character.toString(c);
         if(!(e2.isDoubleOther(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
             getToolkit().beep();
             Other.setBorder(BorderFactory.createLineBorder(Color.red));
             JOptionPane.showMessageDialog(null, "Other Amount should be digits only", "Error", JOptionPane.INFORMATION_MESSAGE);
             evt.consume();
         }
         Other.setBorder(BorderFactory.createLineBorder(Color.GRAY));
         }
    }//GEN-LAST:event_OtherKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Allowances;
    private javax.swing.JLabel BasicSalary;
    private javax.swing.JLabel BasicSalary1;
    private com.toedter.calendar.JDateChooser Date;
    private javax.swing.JTextField Epf;
    private javax.swing.JTextField Etf;
    private javax.swing.JButton Expiry12;
    private javax.swing.JComboBox<String> Id;
    private javax.swing.JComboBox<String> Month;
    private javax.swing.JLabel OT;
    private javax.swing.JLabel Ot;
    private javax.swing.JTextField Other;
    private javax.swing.JLabel Other_;
    private javax.swing.JLabel Salary;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton remove1;
    private javax.swing.JTable salary;
    // End of variables declaration//GEN-END:variables
}
