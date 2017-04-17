package com.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by pratap on 12/11/16.
 */

//http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
//Both arrays are of same size

public class MedianSortedArrays {

    class MedianData {
        double median;
        int median_index;

        MedianData(double m, int n) {
            median = m;
            median_index = n;
        }
    }

    public static void main(String[] args) {

        int arr1[] = {1,2,5,16,19};
        int arr2[] = {4,13,14,15,16};

        MedianSortedArrays data = new MedianSortedArrays();
        double m = data.findMedianSortedArrays(arr1, arr2);
        System.out.println(m);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0))
            return 0.0;
        else if ((nums1 == null || nums1.length == 0) && (nums2 != null && nums2.length != 0))
            return getMedian(nums2, 0, nums2.length - 1).median;
        else if ((nums1 != null && nums1.length != 0) && (nums2 == null || nums2.length == 0))
            return getMedian(nums1, 0, nums1.length - 1).median;
        else {
            int nums1_effective_length = nums1.length;
            int nums2_effective_length = nums2.length;
            int n1_start = 0, n1_end = nums1.length - 1;
            int n2_start = 0, n2_end = nums2.length - 1;
            MedianData m1 = null, m2 = null;

            while (nums1_effective_length > 2 && nums2_effective_length > 2) {
                m1 = getMedian(nums1, n1_start, n1_end);
                m2 = getMedian(nums2, n2_start, n2_end);

                if (m1.median == m2.median) {
                    return m1.median;
                } else if (m2.median > m1.median) {
                    n2_end = m2.median_index;
                    n1_start = m1.median_index;
                    nums1_effective_length = n1_end - n1_start + 1;
                    nums2_effective_length = n2_end - n2_start + 1;
                } else {
                    n1_end = m1.median_index;
                    n2_start = m2.median_index;
                    nums1_effective_length = n1_end - n1_start + 1;
                    nums2_effective_length = n2_end - n2_start + 1;
                }
            }
            return (Math.max(nums1[n1_start], nums2[n2_start]) + Math.min(nums1[n1_end], nums2[n2_end])) / 2.0;
        }
    }

    private MedianData getMedian(int arr[], int start, int end) {
        double median;
        int index;
        if (start == end) {
            median = arr[start];
            index = start;
        } else if ((end - start) % 2 == 0) {
            index = (end + start) / 2;
            median = arr[index];
        } else {
            index = (end + start) / 2;
            median = (arr[index] + arr[index + 1]) / 2.0;
        }
        return new MedianData(median, index);
    }
}