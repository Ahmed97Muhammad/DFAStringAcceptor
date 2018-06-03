/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfastringacceptor;

import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author M AHMED
 */
public class DfaStringAcceptor {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        DFA obj=new DFA();
        Scanner in=new Scanner(System.in);
        String a;
        
        while(true)
        {
            
            
          String choice = JOptionPane.showInputDialog("\n                 TOA PROJECT"+"\n\n REGULAR EXPRESSION:    1* + { 1* 0 (01)* }"+"\n ALPHABETS:    0 , 1\n"+"\nEnter your choice: "+"\na) Entering the string"+"\nb)For showing the transition table"+"\nc)For showing Tuple Set\nd)For showing Image reprensentation of DFA\ne)Exit");
          
        switch(choice)
        {
            case "a":
            {
                a=JOptionPane.showInputDialog("\nEnter the string: ");
                obj.check(a);
                System.out.println();
                break;
            }
            case "b":
            {
                obj.show();
                break;
            }
            case "c":
            {
                obj.tupleSet();
                break;
            }
            case "d":
            {
                EventQueue.invokeLater(() -> {
                DisplayImage ex = new DisplayImage();
                ex.setVisible(true);
                });
                break;
            }
            case "e":
            {
                JOptionPane.showMessageDialog(null,"\nMADE BY:MUHAMMAD AHMED","Program Terminated",1);
                System.exit(0);
            }
            default:
            {
                JOptionPane.showMessageDialog(null,"Wrong choice enter!!!!","ERROR",2);
            }
        }
        
        }
        
    }
    
}
