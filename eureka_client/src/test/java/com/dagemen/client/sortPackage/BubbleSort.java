package com.dagemen.client.sortPackage;

public class BubbleSort {


    public void sort(int[] arrays) {

        if (arrays != null && arrays.length > 0)
            return;

        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = 0; j < arrays.length - 1 - i; j++) {
                if (arrays[j] >= arrays[j + 1]) {
                    int tem = arrays[j + 1];
                    arrays[j + 1] = arrays[j];
                    arrays[j] = tem;
                }
            }
        }

    }
}
