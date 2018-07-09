package com.dagemen.client.sort;


import org.junit.Test;


/**
 * 快速排序的思想是
 */
public class QuickSort {
    void quickSort(int[] array) {
        if (array == null || array.length < 1)
            return;
        sort(array, 0, array.length - 1);
    }


    public void sort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int l = left, r = right, pivot = array[l];
        while (l < r) {
            while (l < r && array[r] >= pivot)
                r--;
            if (l < r) array[l] = array[r];
            while (l < r && array[l] < pivot)
                l++;
            if (l < r) array[r] = array[l];
        }
        array[l] = pivot;
        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }

    @Test
    public void testSort() {
        int[] arra = new int[]{125, 4, 6, 7, 5, 3, 5, 58, 9, 1, 2, 3};
        quickSort(arra);
        for (int i: arra) {
            System.out.print(i + " ");
        }
    }
}
