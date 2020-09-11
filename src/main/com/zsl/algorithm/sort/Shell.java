package main.com.zsl.algorithm.sort;

import main.com.zsl.algorithm.util.ArrayUtil;

public class Shell implements ISortable {
    @Override
    public void sort(Comparable[] arr) {
        int h=1;
        while (h<arr.length/2)
        {
            h=h*2+1;
        }

        while (h>=1)
        {
            for (int i=h;i<arr.length;i++)
            {
                for (int j=i;j>=h;j-=h)
                {
                    if (arr[j-h].compareTo(arr[j])>0)
                    {
                        ArrayUtil.swap(arr,j-h,j);
                    }else
                    {
                        break;
                    }
                }
            }
            h=h/2;
        }
    }
}
