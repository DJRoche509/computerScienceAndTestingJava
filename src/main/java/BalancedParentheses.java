package main.java;

/*
* Write a function that takes in a string and returns true or false depending on whether that string has balanced parentheses.
* A string has balanced parentheses if every opening parenthesis “(“ has a matching closing parentheses “)” that closes the
* corresponding opening parentheses.

* For the purposes of this problem, you only need to worry about parentheses “(“and “)”, not other opening-and-closing marks,
* like curly brackets, square brackets, or angle brackets.
*
*/

public class BalancedParentheses {
    public static boolean balancedParentheses(String s) {
        int countOpenParentheses = 0;
        for (int c = 0; c < s.length(); c++) {
            if (s.charAt(c)== '(') {
                countOpenParentheses += 1;
            } else if (s.charAt(c) ==')' ) {
                countOpenParentheses -= 1;
            }
        }
        return true ? countOpenParentheses == 0 : false;
    }

    public static void main(String[] args) {
        System.out.println(balancedParentheses("((1"));
        System.out.println(balancedParentheses(")("));
        System.out.println(balancedParentheses(""));
    }
}
