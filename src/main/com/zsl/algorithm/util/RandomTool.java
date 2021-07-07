package main.com.zsl.algorithm.util;

import java.util.Random;

public class RandomTool {
    public static int [] RandomArray(int count,int bound)
    {
        Random random=new Random();
        int arr[]=new int[count];

        for (int i=0;i<count;i++)
        {
            arr[i]=random.nextInt(bound);
        }

        return arr;
    }
}
