package Array.Easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray o = new MergeSortedArray();

        o.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        // [1, 2, 2, 3, 5, 6]
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j])
                result[k] = nums1[i++];
            else
                result[k] = nums2[j++];
            k++;
        }

        while (i < m)
            result[k++] = nums1[i++];

        while (j < n)
            result[k++] = nums2[j++];

        for (i = 0; i < m + n; i++)
            nums1[i] = result[i];

        display(nums1); // remove this function during leetcode submission
    }

    private void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}

// https://leetcode.com/problems/merge-sorted-array/
