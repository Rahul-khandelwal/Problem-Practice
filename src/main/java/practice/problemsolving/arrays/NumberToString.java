/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.arrays;

/**
 * Convert a given number to it's ASCII char representation
 * 
 * @author Rahul
 */
public class NumberToString {
   
    public String getString(int num) {
        if (num == 0)
        {
            return "0";
        }
        
        StringBuilder res = new StringBuilder();
        
        boolean isNegative = num < 0;
        if (isNegative)
        {
            num = num * -1;
        }
        
        while (num > 0) {
            res.append(num % 10);
            num = num / 10;
        }
        
        if (isNegative)
        {
            res.append('-');
        }
        
        res.reverse();
        return res.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new NumberToString().getString(0));
        System.out.println(new NumberToString().getString(1234));
        System.out.println(new NumberToString().getString(-1234));
    }
}
