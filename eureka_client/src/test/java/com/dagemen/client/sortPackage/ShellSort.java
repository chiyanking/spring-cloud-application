package com.dagemen.client.sortPackage;

public class ShellSort {

    public void sort(int[] arrays) {
        int i = (arrays.length - 1) / 2;
        for (int j = 0; j < i; j++) {
            if (arrays[j] > arrays[j + i]) {
                swap(arrays, j, j + i);
            }
        }
    }

    public void swap(int[] arrays, int replace, int j) {
        int tem = arrays[replace];
        arrays[replace] = arrays[j];
        arrays[j] = tem;
    }
}
