package com.company;

/**
 * Created by pratap on 4/16/17.
 */
public class KthLargest {

    public static void main(String[] args) {
        KthLargest kth = new KthLargest();
        int[] nums = {2, 1};
        int k = 1;
        System.out.println(kth.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        else if (nums.length == 1 && k == 1)
            return nums[0];

        int start = 0, end = nums.length - 1, p;
        int index = nums.length - k;

        while (start < end) {
            p = partition(nums, start, end);

            if (p < index) {
                start = p + 1;
            } else if (p > index) {
                end = p - 1;
            } else
                return nums[p];
        }
        return nums[start];
    }

    private int partition(int[] nums, int low, int high) {
        if (low == high)
            return nums[low];
        int i = low - 1, pivot = nums[high], temp;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] <= pivot) {
                i++;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        temp = nums[high];
        nums[high] = nums[i + 1];
        nums[i + 1] = temp;
        return i + 1;
    }
}
