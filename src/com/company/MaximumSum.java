package com.company;

/**
 * Created by pratap on 4/15/17.
 */
class MaximumSum {
    /*Function to return max sum such that no two elements
    are adjacent */
    int FindMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = arr[1];
        int excl_new, incl_new;
        int ans = Math.max(excl, incl);
        int i;

        for (i = 2; i < n; i++) {
            /* current max excluding i */
            excl_new = Math.max(incl, excl);
            /* current max including i */
            incl_new = Math.max(arr[i], excl + arr[i]);
            ans = Math.max(ans, Math.max(excl_new, incl_new));

            incl = incl_new;
            excl = excl_new;
        }
        return ans;
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        MaximumSum sum = new MaximumSum();
        int arr[] = new int[]{5, 5, 10, -100, 10, 5};
        System.out.println(sum.FindMaxSum(arr, arr.length));
    }
}
