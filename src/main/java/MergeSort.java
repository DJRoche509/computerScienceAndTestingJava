package main.java;

import java.util.Arrays;


/**
 * Insertion sort:  Efficient for small inputs or when input is already partially sorted. Not recommended for large or unsorted inputs
 * Best case: O(n), when the input is already sorted.
 * Worst case: O(n^2), when the input is sorted in reverse order.
 * Average case: O(n^2), for random inputs.
 *
 *
 * Merge sort:  Stable and efficient sorting algorithm that works well for large inputs. Time complexity is always O(n log n) regardless of the distribution of the input data
 * Best case: O(n log n), for all inputs.
 * Worst case: O(n log n), for all inputs.
 * Average case: O(n log n), for all inputs.
 *
 *
 * Quicksort:  Fast and efficient sorting algorithm that works well for large inputs and is commonly used in practice.
 *             However, worst-case time complexity is quadratic,
 * Best case: O(n log n), when the partitioning is balanced.
 * Worst case: O(n^2), when the partitioning is unbalanced (e.g., when the pivot is the minimum or maximum element).
 * Average case: O(n log n), for random inputs.
 */

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 13, 9, 11, 6, 5, 8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
