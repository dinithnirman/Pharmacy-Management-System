package Validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dam
 */
public class report_Code {
    
     public static boolean digitsOnly(String qty) 
    {
        
        for(int i=0;i<qty.length();i++)
        {
            if( !Character.isDigit(qty.charAt(i))) 
            {
                boolean x = false;
                return x;
            }
                
        }
         
     
         return true;
         
    }


 public static boolean lettersOnly(String namep) 
    {
        
        for(int i=0;i<namep.length();i++)
        {
            if( Character.isDigit(namep.charAt(i)))
            {
                boolean x = false;
                return x;
            }
                
        }
         
     
        return true;
         
    }

    
    
}
