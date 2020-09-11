package main.com.zsl.algorithm.sort;

public class Merge implements ISortable{

    private Comparable[]temp;
    @Override
    public void sort(Comparable[] arr) {
        temp=new Comparable[arr.length];
        int low=0;
        int high=arr.length-1;
        sort(arr,low,high);
    }


    private void sort(Comparable[]arr,int low,int high)
    {
        if (high<=low)
            return;

        int mid=low+(high-low)/2;

        sort(arr,low,mid);
        sort(arr,mid+1,high);
        merge(arr,low,mid,high);

    }

    private void merge(Comparable[]arr,int low,int mid,int high)
    {
        int i=low;
        int p1=low;
        int p2=mid+1;

        while (p1<=mid&&p2<=high)
        {
            if (arr[p1].compareTo(arr[p2])<0)
            {
                temp[i++]=arr[p1++];
            }else {
                temp[i++]=arr[p2++];
            }
        }

        while (p1<=mid)
        {
            temp[i++]=arr[p1++];
        }

        while (p2<=high)
        {
            temp[i++]=arr[p2++];
        }


        for (int j=low;j<=high;j++)
        {
            arr[j]=temp[j];
        }


    }

}
