
package My_Code;

import static Interface.CreatePaysheet.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;




public class PaymentCode
{
    
    
    static Connection con =null;
    static PreparedStatement pst =null;
    static ResultSet rs = null;
    
  
    
    
    public static void addDiscount(double dis) /*add discount details to database*/
    {
      
        con = DBconnect.connect ();
        
        try
        {
           Date d = new Date ();
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           String date1 = sdf.format(d);  
            
            String sql = "INSERT INTO discounts(disc_amount,date)VALUES('"+dis+"','"+date1+"')";
            pst = con.prepareStatement ( sql );
            pst.execute();
        
        }
        
        catch(Exception e)
        {
        
            JOptionPane.showMessageDialog ( null, e );
        
        }
        
    }
    
        
    public static void updateDiscount()
    {
    
        try
        {
        
            int id= 0;
   
            String getid = "SELECT MAX(payment_id) AS pid FROM cust_payments";
            pst = con.prepareStatement ( getid );
            rs =  pst.executeQuery();
            
            if(rs.next())
            {
                id=rs.getInt("pid");
                
                String update = "UPDATE discounts SET payment_id_fk = '"+id+"' WHERE payment_id_fk is null";
                pst = con.prepareStatement(update);
                pst.executeUpdate();
                }
            
        }
        catch(Exception e)
        {
    
            JOptionPane.showMessageDialog ( null, e );
    
        }
    
    }
    
    
    public static int getSalesId() /*get current sales id*/
    {
        
        
        try
        {
            con = DBconnect.connect();
            
            String id = "SELECT MAX(sales_id) AS ssid FROM sales";
            pst = con.prepareStatement ( id );
            rs =  pst.executeQuery();
            
            if(rs.next())
            {
                int sid = rs.getInt("ssid");
                return sid;
            }
        
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog ( null, e );
           
        }
    
        return 0;
    
    }
    
    
   
}

