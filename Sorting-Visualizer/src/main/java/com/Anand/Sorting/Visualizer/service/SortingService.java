package com.Anand.Sorting.Visualizer.service;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SortingService {

    public List<int[]> bubbleSort(int[] array) {
        List<int[]> operations = new ArrayList<>();
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    // Save the current state of the array
                    operations.add(array.clone());
                }
            }
        }
        return operations;
    }

    public List<int[]> quickSort(int[] array) {
        List<int[]> states = new ArrayList<>();
        quickSort(array, 0, array.length - 1, states);
        return states;
    }

    // Recursive Quick Sort method
    private void quickSort(int[] array, int low, int high, List<int[]> states) {
        if (low < high) {
            int pi = partition(array, low, high, states);
            quickSort(array, low, pi - 1, states);
            quickSort(array, pi + 1, high, states);
        }
    }

    // Method to partition the array and track its state
    private int partition(int[] array, int low, int high, List<int[]> states) {
        int pivot = array[high];
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Add the current state of the array to the list
        states.add(array.clone());

        return i + 1;
    }

    //insertion sort
    public List<int[]> insertionSort(int[] array) {
        List<int[]> states = new ArrayList<>();
        int[] arr = array.clone();
        states.add(arr.clone());

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                states.add(arr.clone());
            }
            arr[j + 1] = key;
            states.add(arr.clone());
        }

        return states;
    }

    public List<int[]> selectionSort(int[] array) {
        List<int[]> states = new ArrayList<>();
        int[] arr = array.clone();
        states.add(arr.clone());

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            states.add(arr.clone());
        }

        return states;
    }

    public List<int[]> mergeSort(int[] array) {
        List<int[]> states = new ArrayList<>();
        mergeSortHelper(array, 0, array.length - 1, states);
        return states;
    }

    private void mergeSortHelper(int[] array, int left, int right, List<int[]> states) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortHelper(array, left, mid, states);
            mergeSortHelper(array, mid + 1, right, states);

            merge(array, left, mid, right, states);
        }
    }

    private void merge(int[] array, int left, int mid, int right, List<int[]> states) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        System.arraycopy(array, left, leftArray, 0, leftArray.length);
        System.arraycopy(array, mid + 1, rightArray, 0, rightArray.length);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }

        states.add(array.clone());
    }
}
