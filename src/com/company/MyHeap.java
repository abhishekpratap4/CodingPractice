package com.company;

/**
 * Created by pratap on 10/12/16.
 */
public class MyHeap {
    public static void createSimpleHeap() {
        int input[] = Utilities.getArray();
        Utilities.printArray(input);
        int heap[] = new int[input.length];
        heap[0] = input[0];
        for (int i = 0; i < input.length / 2; i++) {
            heap[2 * i + 1] = input[2 * i + 1];
            heap[2 * i + 2] = input[2 * i + 2];
        }
        Utilities.printArray(heap);
    }

    public static void createMinMaxHeap() {
        int input[] = Utilities.getArray();
        Utilities.printArray(input);

        for (int i = input.length / 2 - 1; i >= 0; i--)
            minHeapify(input, i);

        Utilities.printArray(input);

        for (int i = input.length / 2 - 1; i >= 0; i--)
            maxHeapify(input, i);

        Utilities.printArray(input);
    }

    private static void maxHeapify(int arr[], int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < arr.length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            maxHeapify(arr, largest);
        }
    }

    private static void minHeapify(int arr[], int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < arr.length && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < arr.length && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(arr, smallest);
        }
    }
}
