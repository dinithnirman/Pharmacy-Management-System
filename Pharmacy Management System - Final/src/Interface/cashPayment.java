


package Interface;

import My_Code.DBconnect;
import static rr.Ireport.bill;
import Validation.Pay_validations;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import My_Code.PaymentCode;
import static My_Code.PaymentCode.updateDiscount;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.BorderFactory;



public class cashPayment extends javax.swing.JFrame 
{

    Connection con =null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    
    String customerinsert;
    String cashsend;
    String amt;
    String cus;
    double dis;
    public static String stm;
    public static String etm;
    public static String p;
    public static String o;
    public static String i;
    public static String u;
    double discountamt;
    
    public cashPayment() 
    {
        
        initComponents();
        con = DBconnect.connect ();
        calculateDiscount();
        setSalesId();
    }

    
    public cashPayment(double discount)
    {
    
        initComponents();
        
        this.dis = discount;
        con = DBconnect.connect ();
        
        calculateDiscount();
        setSalesId();
       
    }
    
    public cashPayment(String total,String nic)
    {
    
        initComponents();
        
        grossamttext.setText(total);
        //niclabel.setText(nic);
        
        con = DBconnect.connect ();
        
        calculateDiscount();
        setSalesId();
         
        
    }
    
    
    public boolean cashValidaton () /*Validate details in cash field*/
    {
    
        if(cashtxt.getText().matches("^[0-9]*$"))
        {
    
            return true;
        
        }
        
        else 
        {
            
            JOptionPane.showMessageDialog ( null, "Cash cannot be a non-numeric value" );
            cashtxt.setText(" ");
            return false;
        }
        
    }
  
    
    
    public void calculateDiscount() /*Calculate discount for a given rate*/
    {

        if(discountbox.getSelectedIndex()==0)
        {
            amttobepaid.setText(grossamttext.getText());
        
        }
        
        else
        {
            int x = Integer.parseInt((String)discountbox.getSelectedItem());
            double gamt = Double.parseDouble(grossamttext.getText());
            double discountamt = (gamt*(x/100.00));  
            gamt = gamt - discountamt;
                
            amttobepaid.setText(new DecimalFormat("##.##").format(gamt));
            
           
        }
    
    }
    
    public void setSalesId() /*set current sales id*/
    {
        salesidtag.setText(String.valueOf(PaymentCode.getSalesId()));
    }
    
    
    public void printbill() /*generate ireport for the bill*/
    {
    
        HashMap param = new HashMap();
        Date d = new Date();
        
        String report = "‪C:\\ireportsNew\\bill.jasper";
        
        param.put("saleid",salesidtag);
       
        
        try
        {
            
            bill(report,param);
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog (null,e);
        }
        
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        grossamttext = new javax.swing.JTextField();
        cashtxt = new javax.swing.JTextField();
        changetxt = new javax.swing.JTextField();
        clesr = new javax.swing.JButton();
        cashdone = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        discountbox = new javax.swing.JComboBox<>();
        amttobepaid = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        salesidtag = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel14.setBackground(new java.awt.Color(206, 196, 217));
        jPanel14.setPreferredSize(new java.awt.Dimension(1080, 640));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Gross Amount :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Amount to be paid :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Change :");

        grossamttext.setEditable(false);
        grossamttext.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        grossamttext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grossamttextActionPerformed(evt);
            }
        });

        cashtxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cashtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashtxtKeyTyped(evt);
            }
        });

        changetxt.setEditable(false);
        changetxt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        changetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changetxtActionPerformed(evt);
            }
        });

        clesr.setBackground(new java.awt.Color(85, 55, 118));
        clesr.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        clesr.setForeground(new java.awt.Color(255, 255, 255));
        clesr.setText("Clear");
        clesr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clesrActionPerformed(evt);
            }
        });

        cashdone.setBackground(new java.awt.Color(85, 55, 118));
        cashdone.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cashdone.setForeground(new java.awt.Color(255, 255, 255));
        cashdone.setText("PAY");
        cashdone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashdoneMouseClicked(evt);
            }
        });
        cashdone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashdoneActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(85, 55, 118));

        Back.setBackground(new java.awt.Color(85, 55, 118));
        Back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setText("Back");
        Back.setAutoscrolls(true);
        Back.setBorder(null);
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Rs.");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Rs.");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Rs.");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Discount :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("%");

        discountbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
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

        amttobepaid.setEditable(false);
        amttobepaid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        amttobepaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amttobepaidActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Cash :");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Rs.");

        cancel.setBackground(new java.awt.Color(85, 55, 118));
        cancel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancel");
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
        });
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Sales ID :");

        salesidtag.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        salesidtag.setText("_______");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(amttobepaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(discountbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cashtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grossamttext, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cashdone, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(clesr, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(36, 36, 36)
                        .addComponent(salesidtag)))
                .addGap(64, 64, 64))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {amttobepaid, cashtxt, discountbox});

        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(salesidtag))
                .addGap(35, 35, 35)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(grossamttext, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(discountbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amttobepaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(clesr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changetxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cashdone)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(294, Short.MAX_VALUE))
        );

        jPanel14Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {amttobepaid, cashtxt, discountbox});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clesrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clesrActionPerformed

        
        cashtxt.setText(" ");

        
    }//GEN-LAST:event_clesrActionPerformed

    private void cashdoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashdoneActionPerformed

        if(cashValidaton()==true)
        {
         
            double grosstotal = Double.parseDouble(grossamttext.getText());
            double cash = Double.parseDouble(cashtxt.getText());
        
            if(discountbox.getSelectedIndex()!=0)
            {
            
                int discount = Integer.parseInt((String) discountbox.getSelectedItem());
                double ogtotal = grosstotal;
                discountamt = (grosstotal*(discount/100.00));  
                grosstotal = grosstotal - discountamt;
                
                amttobepaid.setText(new DecimalFormat("##.##").format(grosstotal));
                PaymentCode.addDiscount(discountamt);
        
        
            }   
        
            double amttobepaid = Double.parseDouble(this.amttobepaid.getText());
            double change = (Double)(cash - amttobepaid);
        
            changetxt.setText(new DecimalFormat("##.##").format(change));
        
        }
        
        
        calculateDiscount();
        
        
            amt = amttobepaid.getText();
            
            Date d = new Date();
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            String idate = sd.format(d);
        
        
            try
            {
        
       
                cashsend = "INSERT INTO cust_payments(payment_amount, payment_date) VALUES ('"+ amt +"','"+ idate +"')";
                pst = con.prepareStatement ( cashsend );
                pst.execute();
            
                //updateDiscount();

      
                
  
            }
            
            catch(Exception e)
            {
            
                JOptionPane.showMessageDialog ( null, e );
        
            }
            
            stm=cashtxt.getText();
            etm=changetxt.getText();  
            p = discountbox.getSelectedItem().toString();
            o = Double.toString(discountamt);
            i = amttobepaid.getText();
            u = salesidtag.getText();
              
            cbill b;
                try {
                    b = new cbill(stm,etm,p,o,i,u);
                    b.setVisible(true);
                } catch (PrinterException ex) {
                    
                }
            
            
                    
        this.dispose();
        
        
       
    }//GEN-LAST:event_cashdoneActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        this.dispose ();

    }//GEN-LAST:event_BackActionPerformed

    private void grossamttextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grossamttextActionPerformed

        
    }//GEN-LAST:event_grossamttextActionPerformed

    private void cashdoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashdoneMouseClicked
     
    }//GEN-LAST:event_cashdoneMouseClicked

    private void changetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changetxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changetxtActionPerformed

    private void discountboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_discountboxItemStateChanged


       
    }//GEN-LAST:event_discountboxItemStateChanged

    private void discountboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountboxActionPerformed

        calculateDiscount();
        
        
    }//GEN-LAST:event_discountboxActionPerformed

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
        {
            this.dispose();
        }
        
        
    }//GEN-LAST:event_cancelActionPerformed

    private void cashtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashtxtKeyTyped

        /*cheks for invalid characters when typing */
        
        Pay_validations p1 = new Pay_validations();
        
        char c = evt.getKeyChar();
        String x = Character.toString(c);
        
        if(!(p1.digitsOnly(x)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)))
        {
            getToolkit().beep();
            cashtxt.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Amount cannot include letters.");
            evt.consume();
        
        }
        
        cashtxt.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
       
        
    }//GEN-LAST:event_cashtxtKeyTyped

    private void amttobepaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amttobepaidActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_amttobepaidActionPerformed

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
            java.util.logging.Logger.getLogger(cashPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cashPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cashPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cashPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new cashPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField amttobepaid;
    private javax.swing.JButton cancel;
    private javax.swing.JButton cashdone;
    private javax.swing.JTextField cashtxt;
    private javax.swing.JTextField changetxt;
    private javax.swing.JButton clesr;
    private javax.swing.JComboBox<String> discountbox;
    private javax.swing.JTextField grossamttext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel salesidtag;
    // End of variables declaration//GEN-END:variables
}
