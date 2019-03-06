/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.problemsolving.math;

/**
 *
 * @author Rahul
 */
public class NumericStringIncrement {

    /**
     * This method adds one to the given numeric String and returns the result
     * in new string.
     *
     * @param number
     *
     * @return
     */
    public String incrementByOne(String number) {
        char[] digits = number.toCharArray();
        int res = Character.getNumericValue(digits[digits.length - 1]) + 1;
        if (res < 10) {
            digits[digits.length - 1] = Character.forDigit(res, 10);
            return new String(digits);
        }

        int carry = res / 10;
        res = res % 10;
        digits[digits.length - 1] = Character.forDigit(res, 10);

        for (int i = digits.length - 2; i >= 0; i--) {
            res = Character.getNumericValue(digits[i]) + 1;
            if (res < 10) {
                digits[i] = Character.forDigit(res, 10);
                break;
            }

            carry = res / 10;
            res = res % 10;
            digits[i] = Character.forDigit(res, 10);
        }
        
        if (carry == 0) {
            return new String(digits);
        } else {
            return new StringBuilder().append(carry).append(digits).toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumericStringIncrement().incrementByOne("999"));
        System.out.println(new NumericStringIncrement().incrementByOne("0"));
        System.out.println(new NumericStringIncrement().incrementByOne("1234"));
    }
}
