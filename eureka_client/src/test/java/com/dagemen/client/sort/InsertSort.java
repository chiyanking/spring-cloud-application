package com.dagemen.client.sort;

import org.junit.Test;

/**
 * 想象一下手上理牌
 */
public class InsertSort {

    @Test
    public void testInsertSort() {
        int[] arra = new int[]{5, 4, 3, 4, 3, 2, 1, 50, 249, 2, 1};
        insertSort(arra);
        for (int i: arra) {
            System.out.print(i + " ");
        }
    }

    public void insertSort(int[] arrays) {
        int l = 1, r = arrays.length - 1;
        for (int i = 1; i <= r; i++) {
            int tem = arrays[i];
            for (int j = i; j > 0; j--) {
                if (tem < arrays[j-1]) {
                    int e = arrays[j - 1];
                    arrays[j - 1] = arrays[j];
                    arrays[j] = e;
                } else {
                    break;
                }
            }
        }
    }
}
