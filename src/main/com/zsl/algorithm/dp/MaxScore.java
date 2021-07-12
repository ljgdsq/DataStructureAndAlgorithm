package main.com.zsl.algorithm.dp;

import java.util.Arrays;

public class MaxScore {
    public static void main(String[] args) {

        int arr[]=new int[]{5,200,2,3,4};
        int score=maxScroe(arr,0,arr.length-1);

        int sum = Arrays.stream(arr).sum();


        System.out.println(score>(sum-score));


    }



    private static int maxScroe(int arr[],int l,int r)
    {
        if (l==r) return arr[l];
        if (r-l==1) return Math.max(arr[l],arr[r]);

        int sLeft=0;
        int sRight=0;

        sLeft=arr[l]+Math.min(maxScroe(arr,l+1,r-1),maxScroe(arr,l+2,r));
        sRight=arr[r]+Math.min(maxScroe(arr,l,r-2),maxScroe(arr,l+1,r-1));
        return Math.max(sLeft,sRight);

    }


    private static int maxScore1(int arr[],int l,int r)
    {
        if (l==r) return arr[l];

        int sLeft=arr[l]-maxScore1(arr,l+1,r);
        int sRight=arr[r]-maxScore1(arr,l,r-1);
        return Math.max(sLeft,sRight);

    }
}
