package main.com.zsl.algorithm.sort;

import main.com.zsl.algorithm.util.ArrayUtil;

/**
 * 同种算法的不同实现
 */
public class Insertion implements ISortable {

//    @Override
//    public void sort(Comparable[] arr) {
//        for (int i=1;i<arr.length;i++)
//        {
//            var tmp=arr[i];
//            int j=i;
//            while (j>0&&tmp.compareTo(arr[j-1])<0)
//            {
//                arr[j]=arr[j-1];
//                j--;
//            }
//
//            if (j!=i)
//            {
//                arr[j]=tmp;
//            }
//        }
//    }


    @Override
    public void sort(Comparable[] arr) {
        ArrayUtil.print(arr);
        for (int i = 1; i < arr.length; i++) {
            for (int j=i;j>0;j--)
            {
                if (arr[j].compareTo(arr[j-1])<0)
                {
                    ArrayUtil.swap(arr,j,j-1);
                }else
                {
                    break;
                }
            }
        }

        ArrayUtil.print(arr);

    }


}
