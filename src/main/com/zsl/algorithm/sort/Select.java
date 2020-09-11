package main.com.zsl.algorithm.sort;

import main.com.zsl.algorithm.util.ArrayUtil;

public class Select implements ISortable {
    @Override
    public void sort(Comparable[] arr) {


        for (int i=0;i<arr.length-1;i++)
        {
            int min=i;
            for (int j=i+1;j<arr.length;j++)
            {
                if (arr[j].compareTo(arr[min])<0)
                {
                    min=j;
                }
            }
            if (min!=i)
            {
                ArrayUtil.swap(arr,min,i);
            }
        }
    }
}
