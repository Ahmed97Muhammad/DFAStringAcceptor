/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nfastringacceptor;

import javax.swing.JOptionPane;

/**
 *
 * @author M AHMED
 */
public class DFA {
    
    char []states;
    String msgprint;
    
    public DFA()
    {
        msgprint=new String();
        states=new char[10];
        states[0]='A';
        states[1]='B';
        states[2]='C';
        states[3]='R';
    }
   
    public void show()
    {
        JOptionPane.showMessageDialog(null,"=================================================="+"\n STATES         ALPHABETS "+"\n                             0           1 "+"\n==================================================\n"+"*->A                     B          A"+"\n  *B                      C            R"+"\n    C                      R            B","\nTRANSITION TABLE: \n",1);
    }
    
    public void tupleSet()
    {
        JOptionPane.showMessageDialog(null,"\nStates   {A , B , C , R}\nALphabets:   0 ,1 \nInitial State   A \nFinal State   {A , B} \nTransition Function   6 = Q * E => Q","TUPLE SET",1);
    }
    
    void check(String in)
    {
        msgprint="";
        boolean a=checkbool(in);
        if(a)
        {
            JOptionPane.showMessageDialog(null,"The string "+in+" is accepted by the regular expression 1* + {1* 0 (01}* }","ACCEPTED",1);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"The string "+in+" is not accepted by the regular expression 1* + {1* 0 (01}* }","REJECTED",2);
        }
             JOptionPane.showMessageDialog(null,msgprint,"TRANSITONS",1);
    }
    
    private  boolean checkbool(String in)
    {
        int count=0;
        char currentstate;
        
        if(in.length()==0)
        {
            msgprint="Empty String provided";
            return true;
        }
        
        for(int i=0;i<in.length();i++)
        {
            if(in.charAt(i)!='1')
            {
                if(in.charAt(i)!='0')
                {
                    msgprint="Wrong alphabets entered in to the string alphabets are only 1 and 0\n";
                    return false;
                }
            }    
        }
        
        for(int i=0;i<in.length();i++)
        {
            if(in.charAt(i)=='1')
                count++;
            else
                count=0;
        }
        
        if(count==in.length())
        {
            for(int i=0;i<in.length();i++)
            {
                msgprint+="{A,1}=>A\n";
            }
            return true;
        }
        
        count=0;
        for(int i=0;i<in.length();i++)
        {
            
            if(in.charAt(i)=='0')
            {
                    
                msgprint+="{A,0}=>B\n";
                        
                count=i+1;
                
                if(in.charAt(i)=='0' && (i+1)==in.length())
                { 
                    return true;
                }
                
                if(in.charAt(i)=='0' && in.charAt(i+1)=='1')
                {   
                      msgprint+="{B,1}=>R\n";
                    return false;
                }
                i=in.length()+8;
            }
            
           if(i<in.length())
            if(in.charAt(i)=='1')
            {
                msgprint+="{A,1}=>A\n";
            }
        }
        
        while(in.length()>count)
        {
            msgprint+="{B,0}=>C\n";
                    
            if(count+1==in.length())
            {
                msgprint+="String ended at state C\n";
                //msgprint+="{C,0}=>R\n";
                return false;
            }
            
            if(in.charAt(count)=='0' && in.charAt(count+1)!='1')
            {
                msgprint+="{C,0}=>R\n";
                return false;
            }
            
            count+=2;
                
            msgprint+="{C,1}=>B\n";
        }
        
        return true;
    }
    
}
