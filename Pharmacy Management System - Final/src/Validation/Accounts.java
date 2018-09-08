/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Devin
 */
public class Accounts {
    
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
    
    public static boolean  isDoubleTellBill(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Tell Bill Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    public static boolean  isDoubleRent(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Rent Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    
    public static boolean  isOtherAmount(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Rent Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    public static boolean  isDoubleTax(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Tax Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    public static boolean  isDoubleElecBill(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Electricity Bill Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
         public static boolean  isDoubleCharge(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Charge is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
       
    
    public static boolean  isDoubleDepositAmt(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Deposit Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    

    public static boolean  isDoublePrice(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Other Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    public static boolean Namevalidation(String name)
    {
        
            boolean b=true ;
             for(int i=0;i<name.length();i++)
             {
                 if( !Character.isAlphabetic(name.charAt(i)) || name.length()>30  )
                  {
           
              
                       //JOptionPane.showMessageDialog(null, "Bank Name format invalid it's should be Letters only ");
                       b=false;
                       return b;
                  }
        }
            return b;
       
          
    }
    
   
          
    
    public static boolean AccNumvalidation(String c)
    {
        
        /*if(c.isEmpty())
       {
                  JOptionPane.showMessageDialog(null, "Account Number is Empty");
                  return false;
       }*/
        boolean b=true ;
        for(int i=0;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))  )
            {
           
              
               //JOptionPane.showMessageDialog(null, "Account Number format invalid it's should be Digits only ");
               b=false;
               return b;
             }
        }
        return b;
    } 
    
    public boolean BankNameValidation(String a) {
        
            if(a.equals("Select Bank")){
                //JOptionPane.showMessageDialog(null, "Select Bank", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    
   
    public boolean StockTypeValidation(String a) {
        
            if(a.equals("Select Stock Type")){
                //JOptionPane.showMessageDialog(null, "Select Stock Type", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    
    public boolean AccTypeValidation(String a) {
        
            if(a.equals("Select Type")){
                JOptionPane.showMessageDialog(null, "Select Account Type", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    public boolean bnameValidation(String a) {
        
            if(a.equals("")){
                JOptionPane.showMessageDialog(null, "Enter Bank Name", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    
     public boolean AccnumValidation(String a) {
        
            if(a.equals("Select Account Number")){
                //JOptionPane.showMessageDialog(null, "Select Account Number", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    
    
    public boolean MonthValidation(String a) {
        
            if(a.equals("Select Month")){
                //JOptionPane.showMessageDialog(null, "Select Month", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    
    
    
    
    
    
    
    
    
    public boolean ItemCodeValidation(String a) {
        
            if(a.equals("Select Item Code")){
                //JOptionPane.showMessageDialog(null, "Select Item Code", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }
    
    

       
            //JOptionPane.showMessageDialog(null, "Quantity is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

     public boolean ChqPayValidation(String a) {
        
            if(a==" "){
                JOptionPane.showMessageDialog(null, "Fill Cheque Payments", "Error", JOptionPane.INFORMATION_MESSAGE);
                //JOptionPane.showMessageDialog(null, "Select Item Code", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }      
     
     
     public boolean CashPayValidation(String a) {
        
            if(a==" "){
                //JOptionPane.showMessageDialog(null, "Select Item Code", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }      
}



    
    