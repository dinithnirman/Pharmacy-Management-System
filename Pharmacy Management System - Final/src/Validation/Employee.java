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
public class Employee {
    public static boolean Namevalidation(String name)
    {
        
            boolean b=true ;
             for(int i=0;i<name.length();i++)
             {
                 if( !Character.isAlphabetic(name.charAt(i)) || name.length()>50  )
                  {
           
              
                     //  JOptionPane.showMessageDialog(null, "Name format invalid it's should be Letters only ");
                       b=false;
                       return b;
                       
                  }
        }return b;
            
    }
    
    public static boolean phnvalidation(String name)
    {
        
            boolean b=true ;
             for(int i=0;i<name.length();i++)
             {
                 if( !Character.isDigit(name.charAt(i)) || name.length()>50  )
                  {
           
              
                     //  JOptionPane.showMessageDialog(null, "Name format invalid it's should be Letters only ");
                       b=false;
                       return b;
                       
                  }
        }return b;
            
    }
    
    public static boolean  isDoublebSalary(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Charge is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    public static boolean  isDoublebot(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Charge is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    public boolean DesignationValidation(String a) {
        
            if(a.equals("Select Designation")){
                JOptionPane.showMessageDialog(null, "Select Designation", "Error", JOptionPane.INFORMATION_MESSAGE);
                return false; 
            }
            else{
                return true;
            }
        
    }


    public static boolean Addressvalidation(String add)
    {
        boolean b=true ;
       if( add.length()<100 && !add.isEmpty())
       {for(int i=0;i<add.length();i++)
        {
        if( !Character.isAlphabetic(add.charAt(i))&& !Character.isDigit(add.charAt(i))&& add.charAt(i)!='/' && add.charAt(i)!='-' && add.charAt(i)!='.' && add.charAt(i)!='#' && add.charAt(i)!=',' && add.charAt(i)!=' '  )
            {
           
              
               JOptionPane.showMessageDialog(null, "Address format is invalid");
               b=false;
               return b;
             }
        }


          return b;
       
       }
       else if(add.isEmpty())
       {
                  JOptionPane.showMessageDialog(null, "ADDRESS is Empty");
                  return false;
       }
       
       JOptionPane.showMessageDialog(null, "ADDRESS format invalid it's MAXIMUM SIZE should be 100 Characters only ");

       return false;
    }    
    
    public static boolean Phonevalidation(String c)
    {
    if(c.length()==10) 
    {
       if(c.charAt(0) !='0' ) 
        {   
            
            JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XXXXXXXXX ");

            return false;
        }
        
        boolean b=true ;
        for(int i=1;i<c.length();i++)
        {
        if( !Character.isDigit(c.charAt(i))   )
            {
               b=false;
              
              JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XXXXXXXXX ");
               
               return b;
             }
        }
        return b;
    }
    
    JOptionPane.showMessageDialog(null, "Phone Number format invalid it's should be 0XX1234567 ");

    return false;
}       
    
    
    public static boolean EmailValidation(String email) {
     boolean b;
    if(email.isEmpty())
       {
                  JOptionPane.showMessageDialog(null, "Email is Empty");
                  return false;
       }
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
          b= m.matches();
          if(b)
          {
               return true;
              
          }
              
           JOptionPane.showMessageDialog(null, "Email format invalid  ");
           return false; 
    }
    
    public static boolean NICvalidation(String c)
    {
       
        
        boolean b=true ;
             for(int i=0;i<c.length();i++)
             {
                 if( !Character.isDigit(c.charAt(i)) )
                  {
           
              
                     //  JOptionPane.showMessageDialog(null, "Name format invalid it's should be Letters only ");
                       b=false;
                       return b;
                       
                  } 
                 
        }return b;
    }
    
     public static boolean EmployeeIdvalidation(String c)
    {
         boolean b=true ;
             for(int i=0;i<c.length();i++)
             {
                 if( !Character.isDigit(c.charAt(i)) )
                  {
           
              
                     //  JOptionPane.showMessageDialog(null, "Name format invalid it's should be Letters only ");
                       b=false;
                       return b;
                       
                  } 
                 
        }return b;
              
       /* boolean b;
        String pattern = "^[E][0-9]{3}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = p.matcher(c);
        b = m.matches();
	if(b)
	{
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Invalid Employee Id ");
            return false;
	} */
    }
    
    
     public static boolean NIC1validation(String c)
    {
        switch (c){
            case "V":
                return true;
                //break;
            case "v" :
                return true;
                
    }
        
          
        return false;
    }
    
    public static boolean EmployeeId1validation(String c)
    {
        switch (c){
            case "E":
                return true;
                
                
    }
                  
        return false;
       /* boolean b;
        String pattern = "^[E][0-9]{3}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher m = p.matcher(c);
        b = m.matches();
	if(b)
	{
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"Invalid Employee Id ");
            return false;
	} */
    }
    
    
    public boolean empIdValidation(String a) {
        
            if(a.equals("Select Id")){
                //JOptionPane.showMessageDialog(null, "Select Id", "Error", JOptionPane.INFORMATION_MESSAGE);
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
    
    public static boolean  isDoubleAllowances(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Allowances Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    
    public static boolean  isDoubleEpf(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "EPF Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    
    public static boolean  isDoubleEtf(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Etf Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }
    
    
    public static boolean  isDoubleOther(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          //JOptionPane.showMessageDialog(null, "Other Amount is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
        
    }
    
    
    public static boolean NewDesignationvalidation(String name)
    {
        
            boolean b=true ;
             for(int i=0;i<name.length();i++)
             {
                 if( !Character.isAlphabetic(name.charAt(i)) || name.length()>50  )
                  {
           
              
                       //JOptionPane.showMessageDialog(null, "Designation should be Letters only ");
                       b=false;
                       return b;
                  }
        }
            return b;
       
    }
    
    
   
    
    
    public static boolean  isOtRate(String str) {
        try {
            Double.parseDouble(str);

            return true;
        } catch (NumberFormatException e) {
          JOptionPane.showMessageDialog(null, "Ot Rate is invalid", "Error", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
        
    }
    
}
    
