package com.jaredengler.mergesort;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for ForkJoinMergeSort
 */
public class ForkJoinMergeSortTest {

    int size = 10_000_000;
    Random r = new Random();
    int[] array = new int[size];
    int[] array2 = new int[size];

    @Before
    public void setup() {
        for (int i = 0; i < size; i++)
            array[i] = r.nextInt(size);
        array2 = Arrays.copyOf(array, size);
    }

    @Test
    public void testSorted() {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new MergeSort(array, 0, array.length));
        Arrays.sort(array2);
        assertTrue(Arrays.equals(array, array2));
    }
}
