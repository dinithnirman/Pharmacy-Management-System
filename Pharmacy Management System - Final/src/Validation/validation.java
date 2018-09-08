package Validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Kasun
 */
public class validation {
  
      public static boolean vvalidation(String c)
    {
//    final String doub ="[0-9]+(\\.){0,1}[0-9]{2}";
//        boolean b=true ;
//         
//
//        if(!Pattern.matches(doub,c))
//        {
//               JOptionPane.showMessageDialog(null, "Invalid input\n Please enter price");
//               b=false;
//               return b;
//             }
//        
//        return b;
//    }
  
        boolean a= false;
        //int k=0;
         if(Character.isDigit(c.charAt(0))){
              a=true;
              //break;
            }
//        else if((c==".")){
//            a=true;
//         }
         else
            a=false;
//            //System.out.println(c.charAt(0));
//        
//    switch(c){
//        case("."):a=true;
//                 break;
//        case("0"):a=true;
//                 break;
//        case("1"):a=true;
//                 break;
//        case("2"):a=true;
//                 break;
//        case("3"):a=true;
//                 break;
//        case("4"):a=true;
//                 break;
//        case("5"):a=true;
//                 break;
//        case("6"):a=true;
//                 break;
//        case("7"):a=true;
//                 break;
//        case("8"):a=true;
//                 break;
//        case("9"):a=true;
//                 break;
//        default:a=false;
//                break;
//                
//        
//                    
//    
//    }
        return a;
}
}
