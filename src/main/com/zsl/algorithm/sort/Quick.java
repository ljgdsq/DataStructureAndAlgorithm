package main.com.zsl.algorithm.sort;

import main.com.zsl.algorithm.util.ArrayUtil;

public class Quick implements ISortable {
    @Override
    public void sort(Comparable[] arr) {
        sort(arr,0,arr.length-1);
    }


    private void sort(Comparable[] arr,int low,int high)
    {
        if (high<=low)
            return;

        int position=partition(arr,low,high);
        sort(arr,low,position-1);
        sort(arr,position+1,high);

    }

    private int partition(Comparable[] arr,int low,int high)
    {

        var e=arr[low];

        int left=low;
        int right=high+1;

        while (true)
        {
            while (e.compareTo(arr[--right])<0)
            {
                if (right==low)break;
            }

            while (e.compareTo(arr[++left])>0)
            {
                if (left==high)break;
            }


            if (left>=right){
                break;
            }else {
                ArrayUtil.swap(arr,left,right);
            }
        }


        ArrayUtil.swap(arr,low,right);

        return right;
    }
}
