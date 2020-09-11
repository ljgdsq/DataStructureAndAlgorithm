package main.com.zsl.algorithm.util;

public class ArrayUtil {
    public  static <T>  void swap(T[] arr,int i,int j){
        T temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public  static <T>  void print(T[] arr){
        for(T e : arr){
            System.out.print(e);
        }
        System.out.println();
    }

}
