/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication24;

/**
 *
 * @author Lab-214-21
 */
public class JavaApplication24 {
    public static boolean parImpar (int a, int b, int c)
    {
       return !todospares (a,b,c) && !todosimpares (a,b,c);
        
    }
    
    public static boolean par (int n)
    {
        return n % 2 == 0;
    }
    public static boolean impar (int n)
    {
      return n % 2 != 0;  
    }
    
    public static boolean todospares (int a, int b, int c)
    {
     return par(a) && par (b) && par(c);
     
    }
    
    public static boolean todosimpares (int a, int b, int c)
    {
       return impar (a) && impar (b) && impar (c);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("a,b,c ¿es un par impar? = "+todosimpares(23,24,5,21));
        //ffffffffffffffffffffffffffffffffffffffffffffff
        //hola como estas
    }
    
    public static boolean todosimpares (int a, int b, int c,int d)
    {
       return impar (a) && impar (b) && impar (c) && impar(d);
    }
}
