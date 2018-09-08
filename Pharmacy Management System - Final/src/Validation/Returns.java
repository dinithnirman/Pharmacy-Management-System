/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import javax.swing.JOptionPane;

/**
 *
 * @author AAA
 */

public class Returns {
    
   /* public static boolean  isDoubleCrg(String c) {
        
        boolean b=false;
        for(int i=0;i<c.length();i++)
        {
        if( !(Character.isAlphabetic(c.charAt(i))) )
            {
                
              
               //JOptionPane.showMessageDialog(null, "Quantity invalid it's should be Digits only ");
               b=true;
               return b;
             }
        }
        return false;
    } */
    
    public static boolean  isDoubleCharge(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Charge is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    
    public boolean BrandNameValidation(String a) {
        
            if(a.equals("Select Brand Name")){
                //JOptionPane.showMessageDialog(null, "Select Brand Name", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    
   
    public boolean SupplierNameValidation(String a) {
        
            if(a.equals("Select Supplier Name")){
                //JOptionPane.showMessageDialog(null, "Select Supplier Name", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    
     public static boolean  isIntQty(String c) {
          boolean b=true ;
        for(int i=0;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))  )
        {
               //JOptionPane.showMessageDialog(null, "Quantity invalid it's should be Digits only ");
               b=false;
               return b;
             }
        }
        return b;
    } 
    public static boolean Quantityvalidation(String c)
    {
        
        boolean b=true ;
        for(int i=0;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))  )
            {
               //JOptionPane.showMessageDialog(null, "Quantity invalid it's should be Digits only ");
               b=false;
               return b;
             }
        }
        return b;
    } 
    
}
