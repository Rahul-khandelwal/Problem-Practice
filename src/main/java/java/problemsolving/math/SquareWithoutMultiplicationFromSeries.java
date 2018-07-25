/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.problemsolving.math;

/**
 * Given two series : - 
 * First : square of 1 .. n numbers
 * Second ; Difference between those square values
 * 
 * Using such series devise a method to find square of any number without using multiplication.
 * 
 * Solution: 
 * If we look at such series:
 * 1, 4, 9, 16, 25, ....
 * 3, 5, 7, 9,..
 * Then square(5) = square(5 - 1) + (5 - 1) * 2 + 1
 * 
 * So, square(n) = square(n - 1) + (n - 1) * 2 + 1
 * 
 * NOTE: To multiply by 2, i.e. to double any number, we left shift it by 1.
 * 
 * @author Rahul
 */
public class SquareWithoutMultiplicationFromSeries {
    
    public int square(int _n) {
        if (_n == 1) {
            return 1;
        }
        
        return square(_n - 1) + ((_n - 1) << 1) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new SquareWithoutMultiplicationFromSeries().square(6));
    }
}
