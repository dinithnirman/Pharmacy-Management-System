package Interface;

import Validation.Pay_validations;
import My_Code.DBconnect;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class ReOrder_List extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    String sql;
    String ItemCode;
    String ItemC;
    String Quant;
    String SDate;
    String State;
    int Quan;
    int Re;
    int x;
    int r;
    int id;
    String cdate;
    String h;
//    public ReOrder_List (String item,int qty) {
//        initComponents ();
//        
//        con = DBconnect.connect ();
//        
//        DefaultTableModel model = (DefaultTableModel) RItem1.getModel();
//        model.addRow(new Object[]{item,qty});
//    }
    
    
    public ReOrder_List () {
        
        initComponents ();
        
        con = DBconnect.connect ();
        lableload ();
        aa();
        
        tableload ();
        
        tableload2();
        cc();
        
    }

    public void cc(){
        id = 0;
          try{
            String getid = "SELECT MAX(orderId) AS mid FROM order_details";
            pst = con.prepareStatement ( getid );
            rs =  pst.executeQuery();
            
            if(rs.next())
            {
                id=rs.getInt("mid");
                id = id + 1;
            }
          }
          catch (Exception e){
              
          }
    }
   
    public void tableload2 () {
        
        try {
            int h = 0;
            
            sql = "SELECT l.Item_Code,s.brandName ,l.Quantity as Needed_Quantity FROM re_order_notification l , pharma_items s where s.I_id=l.Item_Code and l.type = 'm' ";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            RItem1.setModel ( DbUtils.resultSetToTableModel ( rs ));
        
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void aa(){
        try {
            
            String sqla = "SELECT S.Item_Code,sum(S.Quantity) FROM sales_stock S WHERE rSt='0' group by S.Item_Code";
            pst = con.prepareStatement ( sqla );
            rs = pst.executeQuery ();
            while(rs.next()){
                System.out.println("fgflllllllllllll");
                String ItemCode1=rs.getString(1);
                String Quant1=rs.getString(2);
          
            sql = "SELECT reOrder_level FROM pharma_items WHERE I_id = '"+ItemCode1+"' ";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
            
            while(rs.next()){
                h= rs.getString(1);
            }
            int h1 =  Integer.parseInt(Quant1);
            int j1 = Integer.parseInt(h);
//            sql = "SELECT S.Item_Code,sum(S.Quantity),p.brandName FROM sales_stock S, pharma_items P WHERE S.Item_Code='"+ItemCode1+"' and P.I_id = S.Item_Code AND '"+Quant1+"' <= P.reOrder_level group by S.Item_Code,p.brandName";
//            pst = con.prepareStatement ( sql );
//            rs = pst.executeQuery ();
            System.out.println(ItemCode1);   
          System.out.println(Quant1);   
            if(h1<=j1){
                System.out.println(ItemCode1);   
          System.out.println(Quant1);   
                System.out.println("fgf");   
//                ItemCode=rs.getString(1);
//                Quant=rs.getString(2);
           System.out.println(ItemCode1);
           System.out.println(Quant1);
               Date d = new Date ();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String da = sdf.format(d);
               // String cdate1 = CDate.getText();
                System.out.println(da);
            String k = "a";
            String sql1 = "INSERT INTO re_order_notification ( Item_Code, Date, Quantity,type) VALUES ( '"+ ItemCode1 +"', '"+ cdate +"', '"+ Quant1 +"' ,'"+k+"')";
            pst = con.prepareStatement ( sql1 );
            pst.executeUpdate ();
            System.out.println("fgf");
            int y =1;
            String j = "UPDATE `sales_stock` SET rSt='"+ y +"' WHERE Item_Code='"+ ItemCode1 +"'";   
            pst = con.prepareStatement ( j );
            pst.executeUpdate ();
            System.out.println("fgf");
            }
            System.out.println("fgftyg");
            }
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void tableload () {
        
        try {
            int h=0;
            
            sql = "SELECT l.Item_Code,s.brandName ,l.Quantity as Remaining_Quantity FROM re_order_notification l , pharma_items s where s.I_id=l.Item_Code and l.type = 'a'";
            pst = con.prepareStatement ( sql );
            rs = pst.executeQuery ();
        
            
            
            RItem.setModel ( DbUtils.resultSetToTableModel ( rs ));
            
        } 
        
        catch ( Exception e ) {
            
            System.out.println ( e );
            
        }
    }
    
    public void lableload () {
    
        SimpleDateFormat DFormat = new SimpleDateFormat ( "yyyy-MM-dd" );
        Date date = new Date ();
        CDate.setText ( DFormat.format ( date ));
        cdate=CDate.getText();
        System.out.println(cdate);
        System.out.println(cdate);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        RItem = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        Back = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CDate = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        RItem1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 725));

        jPanel1.setBackground(new java.awt.Color(206, 196, 217));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(650, 725));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Re-order Item List");

        RItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item Code", "Quntity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RItem.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(RItem);

        jPanel3.setBackground(new java.awt.Color(85, 55, 118));

        Back.setBackground(new java.awt.Color(85, 55, 118));
        Back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Back.setForeground(new java.awt.Color(255, 255, 255));
        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Back.png"))); // NOI18N
        Back.setAutoscrolls(true);
        Back.setBorder(null);
        Back.setBorderPainted(false);
        Back.setFocusable(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Current Date:");

        CDate.setBackground(new java.awt.Color(255, 255, 255));
        CDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        RItem1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RItem1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item Code", "Quntity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RItem1.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(RItem1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Manually added list");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(CDate, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(97, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

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

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        this.dispose ();

    }//GEN-LAST:event_BackActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed

        Home_Page1 HP1 = new Home_Page1 ();
        HP1.setVisible ( true );
        this.dispose ();

    }//GEN-LAST:event_LogoutActionPerformed

    public static void main ( String args[] ) {
      
        java.awt.EventQueue.invokeLater (new Runnable () {
            
            public void run () {
                
                new ReOrder_List ().setVisible ( true );
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel CDate;
    private javax.swing.JButton Logout;
    private javax.swing.JTable RItem;
    private javax.swing.JTable RItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
