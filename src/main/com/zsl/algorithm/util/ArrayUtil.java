package main.com.zsl.algorithm.util;

public class ArrayUtil {
    public  static <T>  void swap(T[] arr,int i,int j){
        T temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public  static void swap(int[] arr,int i,int j){

        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }



    public  static <T>  void print(T[] arr){
        for(T e : arr){
            System.out.print(e +" ");
        }
        System.out.println();
    }

    public  static  void print(int[] arr){
        for(int e : arr){
            System.out.print(e +" ");
        }
        System.out.println();
    }



}
