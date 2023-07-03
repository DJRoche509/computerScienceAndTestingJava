package main.java;

/*
* Write a function that takes in a string and returns true or false depending on whether that string has balanced parentheses.
* A string has balanced parentheses if every opening parenthesis “(“ has a matching closing parentheses “)” that closes the
* corresponding opening parentheses.

* For the purposes of this problem, you only need to worry about parentheses “(“and “)”, not other opening-and-closing marks,
* like curly brackets, square brackets, or angle brackets.
*
*/

import java.util.HashMap;
import java.util.Stack;

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


    /*
    * Write a function that takes in a string and returns true or false based on whether the string’s opening-and-closing marks
    * (that is, brackets) are balanced. Account for the following bracket types:
    * TYPE Opener Closer  ----> PARENTHESES: (  );  CURLY BRACES: {  };  SQUARE BRACKETS: [ ];  ANGLE BRACKETS: < >
    * The string doesn’t need to have all four types of brackets, but if an open bracket appears, the pair should also be closed
    * correctly. Assume you can use any libraries in Java needed.
    *
    */

    public static boolean balancedBrackets(String s) {

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        for (int i = 0; i < s.length(); i += 1) {

            // If character is opening bracket
            if (bracketPairs.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            // Else, if character is closing bracket
            else if (bracketPairs.containsKey(s.charAt(i))) {
                // Closing bracket without matching opening bracket
                if (stack.isEmpty()) {
                    System.out.print("This one is empty ---> " );
                    return false;
                }
                // Check that most recent bracket on stack matches
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String twoOpenParens = "((1";
        String emptyString = "";
        String closedOpenParens = ")(";

        System.out.println(balancedParentheses(twoOpenParens));
        System.out.println(balancedParentheses(closedOpenParens));
        System.out.println(balancedParentheses(emptyString));

        System.out.println(balancedBrackets(twoOpenParens));
        System.out.println(balancedBrackets(closedOpenParens));
        System.out.println(balancedBrackets(emptyString));
    }
}
