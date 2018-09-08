package Interface;
import Validation.report_Code;
import My_Code.DBconnect;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class Request_Home extends javax.swing.JInternalFrame {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
public static String x;
    int r;
    int f;
    int g;
    public Request_Home () {
        
        initComponents ();
        con = DBconnect.connect();
        tableload();
    }

    public void clear(){
            reqname.setText("");
            req.setText("");
            reqphone.setText("");
            reqdate.setCalendar(null);
            rid.setText("");
    }
    
    public void tableload()
    {
        try
        {
            String log = "SELECT rid AS RID,phone AS Phone,name AS Name,date AS Date,request AS Request  FROM requests";
            pst = con.prepareStatement(log);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Payment = new javax.swing.JButton();
        Customer = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        Customer1 = new javax.swing.JButton();
        Customer2 = new javax.swing.JButton();
        IHome = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        reqname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        reqphone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        req = new javax.swing.JTextField();
        reqdate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        Expiry8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Expiry9 = new javax.swing.JButton();
        update1 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        rid = new javax.swing.JLabel();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1080, 725));
        setPreferredSize(new java.awt.Dimension(1080, 725));
        setRequestFocusEnabled(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(85, 55, 118));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Payment.setBackground(new java.awt.Color(85, 55, 118));
        Payment.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Payment.setForeground(new java.awt.Color(255, 255, 255));
        Payment.setText("Manage Complaint");
        Payment.setAutoscrolls(true);
        Payment.setBorder(null);
        Payment.setBorderPainted(false);
        Payment.setFocusable(false);
        Payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PaymentActionPerformed(evt);
            }
        });
        jPanel3.add(Payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 240, 40));

        Customer.setBackground(new java.awt.Color(85, 55, 118));
        Customer.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Customer.setForeground(new java.awt.Color(255, 255, 255));
        Customer.setText("Manage Request");
        Customer.setAutoscrolls(true);
        Customer.setBorder(null);
        Customer.setBorderPainted(false);
        Customer.setFocusable(false);
        Customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerActionPerformed(evt);
            }
        });
        jPanel3.add(Customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 40));

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

        Customer1.setBackground(new java.awt.Color(85, 55, 118));
        Customer1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Customer1.setForeground(new java.awt.Color(255, 255, 255));
        Customer1.setText("View Complaints");
        Customer1.setAutoscrolls(true);
        Customer1.setBorder(null);
        Customer1.setBorderPainted(false);
        Customer1.setFocusable(false);
        Customer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer1ActionPerformed(evt);
            }
        });
        jPanel3.add(Customer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 240, 40));

        Customer2.setBackground(new java.awt.Color(85, 55, 118));
        Customer2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Customer2.setForeground(new java.awt.Color(255, 255, 255));
        Customer2.setText("View Requests");
        Customer2.setAutoscrolls(true);
        Customer2.setBorder(null);
        Customer2.setBorderPainted(false);
        Customer2.setFocusable(false);
        Customer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer2ActionPerformed(evt);
            }
        });
        jPanel3.add(Customer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 250, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        jPanel1.setBackground(new java.awt.Color(215, 215, 230));

        reqname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reqname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqnameActionPerformed(evt);
            }
        });
        reqname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reqnameKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Date of Request");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Customer Phone");

        reqphone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        reqphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqphoneActionPerformed(evt);
            }
        });
        reqphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reqphoneKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Customer Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Request");

        req.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        req.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqActionPerformed(evt);
            }
        });

        reqdate.setDateFormatString("yyyy-MM-dd");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Customer Requests");

        Expiry8.setBackground(new java.awt.Color(85, 55, 118));
        Expiry8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry8.setForeground(new java.awt.Color(255, 255, 255));
        Expiry8.setText("Enter Request");
        Expiry8.setAutoscrolls(true);
        Expiry8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry8.setBorderPainted(false);
        Expiry8.setFocusable(false);
        Expiry8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry8ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Expiry9.setBackground(new java.awt.Color(85, 55, 118));
        Expiry9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        Expiry9.setForeground(new java.awt.Color(255, 255, 255));
        Expiry9.setText("Clear");
        Expiry9.setAutoscrolls(true);
        Expiry9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Expiry9.setBorderPainted(false);
        Expiry9.setFocusable(false);
        Expiry9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Expiry9ActionPerformed(evt);
            }
        });

        update1.setBackground(new java.awt.Color(85, 55, 118));
        update1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        update1.setForeground(new java.awt.Color(255, 255, 255));
        update1.setText("Update");
        update1.setAutoscrolls(true);
        update1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update1.setBorderPainted(false);
        update1.setFocusable(false);
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(85, 55, 118));
        delete.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("Delete");
        delete.setAutoscrolls(true);
        delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.setBorderPainted(false);
        delete.setFocusable(false);
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("RID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(Expiry8, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reqdate, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reqname, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reqphone, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(req, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rid, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(update1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGap(207, 207, 207))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(339, 339, 339)
                    .addComponent(Expiry9, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(597, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reqphone, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reqname, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reqdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update1)
                            .addComponent(delete))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(Expiry8)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(527, Short.MAX_VALUE)
                    .addComponent(Expiry9)
                    .addGap(63, 63, 63)))
        );

        IHome.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout IHomeLayout = new javax.swing.GroupLayout(IHome);
        IHome.setLayout(IHomeLayout);
        IHomeLayout.setHorizontalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        IHomeLayout.setVerticalGroup(
            IHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        complaint C = new complaint ();
        IHome.add ( C ).setVisible ( true );

    }//GEN-LAST:event_PaymentActionPerformed

    private void CustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerActionPerformed

        IHome.removeAll ();
        request R = new request ();
        IHome.add ( R ).setVisible ( true );

    }//GEN-LAST:event_CustomerActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed

        Home_Page1 HP1 = new Home_Page1 ();
        HP1.setVisible ( true );
        this.dispose ();

    }//GEN-LAST:event_LogoutActionPerformed

    private void Customer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer1ActionPerformed
        // TODO add your handling code here:
        IHome.removeAll ();
        complaintlog R = new complaintlog ();
        IHome.add ( R ).setVisible ( true );
    }//GEN-LAST:event_Customer1ActionPerformed

    private void Customer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer2ActionPerformed
        // TODO add your handling code here:
        IHome.removeAll ();
        requestlog R = new requestlog ();
        IHome.add ( R ).setVisible ( true );
    }//GEN-LAST:event_Customer2ActionPerformed

    private void reqnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reqnameActionPerformed

    private void reqnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reqnameKeyTyped

        report_Code rc = new report_Code();

        char c = evt.getKeyChar();
        String x = Character.toString(c);
        if(!(rc.lettersOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            reqname.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Name cannot include numeric values.");
            evt.consume();

        }

        reqname.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    }//GEN-LAST:event_reqnameKeyTyped

    private void reqphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqphoneActionPerformed
        try
        {
            String log = "SELECT cus_name FROM customer WHERE cus_phone="+ reqphone.getText();
            pst = con.prepareStatement(log);
            rs = pst.executeQuery();
            while(rs.next())
            {
                reqname.setText(rs.getString("cus_name"));
            }

        }
        catch (Exception e)
        {

        }
    }//GEN-LAST:event_reqphoneActionPerformed

    private void reqphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reqphoneKeyTyped

        report_Code rc = new report_Code();

        char c = evt.getKeyChar();
        String x = Character.toString(c);
        if (reqphone.getText().length()>9)
        {
            reqphone.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null, "Phone cannot include more than 10 digits");
            evt.consume();
        }
        else if(!(rc.digitsOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {

            getToolkit().beep();
            reqphone.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Phone cannot include alphabetic values.");
            evt.consume();

        }

        reqphone.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    }//GEN-LAST:event_reqphoneKeyTyped

    private void reqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reqActionPerformed

    private void Expiry8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry8ActionPerformed
        String phone = reqphone.getText();
        String name = reqname.getText();
        java.sql.Date date = new java.sql.Date(reqdate.getDate().getTime());
        String request = req.getText();

        if (phone.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Phone can't be empty");
        }
        else if (name.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Name can't be empty");
        }
        else if (request.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Request can't be empty");
        }

        else{
            try
            {
                String r = "INSERT INTO requests (name,phone,date,request) values ('"+ name +"', '"+ phone +"','"+ date +"', '"+ request +"')";
                pst = con.prepareStatement(r);
                pst.execute();

            }
            catch (Exception e)
            {

            }
            tableload();
            clear();
            JOptionPane.showMessageDialog(null, "Request Added Successfully");
    }//GEN-LAST:event_Expiry8ActionPerformed
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        r = jTable1.getSelectedRow ();

        reqphone.setText(jTable1.getValueAt(r, 1).toString());
        reqname.setText(jTable1.getValueAt ( r, 2).toString());
        String Date = jTable1.getValueAt ( r, 3).toString ();
        req.setText(jTable1.getValueAt ( r, 4).toString());
        rid.setText(jTable1.getValueAt(r, 0).toString());
        ((JTextField)reqdate.getDateEditor().getUiComponent()).setText ( Date );

    }//GEN-LAST:event_jTable1MouseClicked

    private void Expiry9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Expiry9ActionPerformed
        clear();

    }//GEN-LAST:event_Expiry9ActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
        if(jTable1.getSelectedRow()<0){

            JOptionPane.showMessageDialog(null,"Select detail to update");
        }
        else{

            java.sql.Date date = new java.sql.Date(reqdate.getDate().getTime());
            String phone  = reqphone.getText();
            String name = reqname.getText();

            try {
                int x = JOptionPane.showConfirmDialog(null, "Do you really want to update?");

                if( x==0){

                    g = Integer.parseInt(rid.getText());
                    String update = "UPDATE requests SET phone=? , name=? ,date=? ,request= ?" +" WHERE rid=? ";
                    pst = con.prepareStatement(update);
                    pst.setString(1, phone);
                    pst.setString(2, name);
                    pst.setDate(3, date);
                    pst.setString(4, req.getText());
                    pst.setString(5, rid.getText());
                    pst.executeUpdate();

                    tableload();
                    clear();

                    JOptionPane.showMessageDialog(null,"Update successful");
                }
                else { clear();}
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_update1ActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        if(jTable1.getSelectedRow()<0){

            JOptionPane.showMessageDialog(null,"Select detail to delete");
        }
        else{

            try {
                int x = JOptionPane.showConfirmDialog(null, "Do you really want to delete?");

                if( x==0){

                    f = Integer.parseInt(rid.getText());
                    String delete = "DELETE from requests where rid='"+ f +"'";
                    pst = con.prepareStatement(delete);
                    pst.executeUpdate();

                    tableload();
                    clear();

                    JOptionPane.showMessageDialog(null,"Delete successful");
                }
                else{clear();}
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }//GEN-LAST:event_deleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Customer;
    private javax.swing.JButton Customer1;
    private javax.swing.JButton Customer2;
    private javax.swing.JButton Expiry8;
    private javax.swing.JButton Expiry9;
    private javax.swing.JDesktopPane IHome;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Payment;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField req;
    private com.toedter.calendar.JDateChooser reqdate;
    private javax.swing.JTextField reqname;
    private javax.swing.JTextField reqphone;
    private javax.swing.JLabel rid;
    private javax.swing.JButton update1;
    // End of variables declaration//GEN-END:variables
}
