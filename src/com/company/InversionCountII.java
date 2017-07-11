package com.company;

import java.util.Arrays;

/**
 * Created by pratap on 6/23/17.
 */
public class InversionCountII {
    /* This method sorts the input array and returns the
    number of inversions in the array */
    static int mergeSort(int arr[], int array_size) {

        return _mergeSort(arr, 0, array_size - 1);
    }

    /* An auxiliary recursive method that sorts the input array and
    returns the number of inversions in the array. */
    static int _mergeSort(int arr[], int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
		/* Divide the array into two parts and call _mergeSortAndCountInv()
		for each of the parts */
            mid = (right + left) / 2;

		/* Inversion count will be sum of inversions in left-part, right-part
		and number of inversions in merging */
            inv_count = _mergeSort(arr, left, mid);
            inv_count += _mergeSort(arr, mid + 1, right);

		/*Merge the two parts*/
            inv_count += merge(arr, left, mid, right);
        }
        return inv_count;
    }

    /* This method merges two sorted arrays and returns inversion count in
    the arrays.*/
    static int merge(int arr[], int left, int mid, int right) {
        int i, j, k;
        int inv_count = 0;
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];

        for (i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        i = 0; /* i is index for left subarray*/
        j = 0; /* j is index for right subarray*/
        k = left; /* k is index for resultant merged subarray*/
        while ((i < n1) && (j < n2)) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];

		/*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - left);
            }
        }

	/* Copy the remaining elements of left subarray
	(if there are any) to temp*/
        while (i < n1)
            arr[k++] = leftArr[i++];

	/* Copy the remaining elements of right subarray
	(if there are any) to temp*/
        while (j < n2)
            arr[k++] = rightArr[j++];

	/*Copy back the merged elements to original array*/
// 	for (i=left; i <= right; i++)
// 		arr[i] = temp[i];

        return inv_count;
    }

    // Driver method to test the above function
    public static void main(String[] args) {
        int arr[] = new int[]{2,4,1,3,5};
        System.out.println("Number of inversions are " + mergeSort(arr, 5));
        System.out.println(Arrays.toString(arr));
    }
}
