package main.com.zsl.algorithm.sort;

import main.com.zsl.algorithm.util.ArrayUtil;

public class Bubble implements ISortable {
    @Override
    public void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i-1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    ArrayUtil.swap(arr,j,j+1);
                }
            }
        }
    }
}
