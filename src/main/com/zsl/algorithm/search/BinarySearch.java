package main.com.zsl.algorithm.search;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,8,9,10};
        int index= search(arr,7);

        System.out.println(index==-1?"not found!":index);
    }


    private static int search(int arr[], int num)
    {
        int start=0;
        int end=arr.length-1;

        while (start<=end)
        {
            int mid=(start+end)/2;
            if (arr[mid]<num)
            {
                start=mid+1;
            }else if(arr[mid]>num)
            {
                end=mid-1;
            }else
            {
                return mid;
            }
        }

        return -1;
    }
}
