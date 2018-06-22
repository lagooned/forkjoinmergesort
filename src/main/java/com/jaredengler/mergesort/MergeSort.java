
package com.jaredengler.mergesort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * RecursiveAction MergeSort
 * @author Jared Engler
 */
public class MergeSort extends RecursiveAction {
    final static int THRESHOLD = 5;
    private int[] array;
    private int left;
    private int right;

    public MergeSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    public void compute() {
        int size = right - right;
        if (size <= MergeSort.THRESHOLD) {
            Arrays.sort(array, left, right);
        } else {
            int middle = left + (size / 2);
            invokeAll(new MergeSort(array, left, middle),
                      new MergeSort(array, middle, right));
            merge(size, middle);
        }
    }

    private void merge(int size, int middle) {
        int[] aux = new int[size];
        int i = left;
        int j = middle;

        for (int k = left; i <= middle && j <= right; k++) {
            if (array[i] < array[j]) {
                aux[k] = array[i++];
            } else {
                aux[k] = array[j++];
            }
        }

        System.arraycopy(array, left, aux, 0, aux.length);
    }
}
