/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import My_Code.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nemin
 */

public class Pay_validations {
    
  
    
    public static boolean phonevalidation(String c)  /*Validates phone number*/
    {
        
        
        if(c.length()==10) 
        {
            
            if(c.charAt(0) !='0' ) 
            {   
            
                JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XX1234567 ");
        
                return false;
            
            }
        
        boolean b=true ;
        
        for(int i=1;i<c.length();i++)
        {
            
            if( !Character.isDigit(c.charAt(i)))
            {
                b=false;
              
                JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XX1234567 ");
               
                return b;
            }
        
        }
        return b;
        
        }
    
        JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XX1234567 ");

        return false;
    
    }       
     
    
    
    public static boolean namevalidation(String name) /*validates customer name*/
    {
     
        if(!name.isEmpty())
        {
            
            boolean x=true ;
            
            for(int i=0;i<name.length();i++)
            {
                 
                if( Character.isDigit(name.charAt(i)) || name.length()>50)
                {
                    JOptionPane.showMessageDialog(null, "Name format invalid it's should be Letters only ");
                    x=false;
                    return x;
                }
            
            }
            
        return x;
        }
         
    JOptionPane.showMessageDialog(null, "Name is Empty");
          
    return false;
    
    }
    
    
    
    
    public static boolean emailvalidation(String email) /*validates email*/
    {
    
        boolean x;
    
        if(email.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Email is Empty");
            return false;
        }
    
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        x = m.matches();
          
        if(x)
        {
              
            return true;
              
        }
              
        JOptionPane.showMessageDialog(null, "Email format invalid  ");
        return false; 
    
    }
     
     
     
    public static boolean nicvalidation(String nic) /*validates nic number*/
    {
        
        if(nic.length()==10) 
        {
            
            if(nic.toUpperCase().charAt(9) !='V' ) 
            {   
 
            return false;
            
            }
        
            boolean b=true ;
        
            for(int i=0;i<nic.length()-1;i++)
            {
        
                if( !Character.isDigit(nic.charAt(i))) /*return false is a letter found*/
                {
                    b=false;
        
                    return b;
                }
            
            }
        
            return b;
        
        }
    
 
        return false;
    
    } 
    


    
    
    
    public static boolean lettersOnly(String namep) /*checks for letters only format*/
    {
        
        for(int i=0;i<namep.length();i++)
        {
            if( Character.isDigit(namep.charAt(i)))/*return false is a digit found*/
            {
                boolean x = false;
                return x;
            }
                
        }
         
     
        return true;
         
    }
     
        
    
    
    
    
   
     
    public static boolean digitsOnly(String qty) /*checks for digits only format*/
    {
        
        for(int i=0;i<qty.length();i++)
        {
            if( !Character.isDigit(qty.charAt(i))) /*return false is a letter found*/
            {
                boolean x = false;
                return x;
            }
                
        }
         
     
         return true;
         
    }
     
    
}



