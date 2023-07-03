package main.java;

import java.util.Arrays;
/*
*
*  Concepts: runtime  -  memory
*
* Imagine a list of numbers from 1 to max_num, inclusive - except that one of these numbers will be missing from the list.
*
* Write a function that takes this list of numbers, as well as the max_num, and it should return the missing number.
*
* For example, given a list of numbers, in random order, of 1…10, 8 was removed. If this list and the maxNum of 10 was passed
* into the function, it would return 8: missingNumber({2, 1, 4, 3, 6, 5, 7, 10, 9}, 10) ⇒ 8
*
* If there is no missing number, the function should return 0.
*
* */



public class MissingNumber {
    public static int missingNumber(int[] numList, int maxNum) {
        Arrays.sort(numList);
        for (int n = 1; n <= numList.length; n++) {
            if (n != numList[n - 1]) {
                return n;
            }
        }
        if (numList.length == maxNum && numList[maxNum - 1] == maxNum) {
            return 0;
        }

        System.out.print("ERROR!!! Check list again vs Maximum Number: ");
        return maxNum;
    }


    public static int missingNumberSum(int[] nums, int maxNum) {
        // Alternate solution: int sum = (nums.length + 1)*(nums.length) / 2
        int expectedSum = 0;
        for (int i = 1; i <= maxNum; i += 1) {
            expectedSum += i;
        }

        int actualSum = Arrays.stream(nums).sum();

        return expectedSum - actualSum;
    }


    public static void main(String[] args) {
        System.out.println(missingNumber( (new int[]{1, 2, 3, 4, 5}),5));
        System.out.println(missingNumber( (new int[]{1, 2, 3, 4, 5, 6,8}),8));
        System.out.println(missingNumber( (new int[]{1, 2, 4,3}),5));
        System.out.println(missingNumberSum( (new int[]{1, 2, 4,3,6}),6));
    }
}

