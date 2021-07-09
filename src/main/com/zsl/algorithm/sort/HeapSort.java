package main.com.zsl.algorithm.sort;

import main.com.zsl.algorithm.util.ArrayUtil;

public class HeapSort implements ISortable {
    @Override
    public void sort(Comparable[] arr) {


        Comparable[] heap = new Comparable[arr.length + 1];
        createHeap(arr,heap);

        int n=heap.length-1;

        while (n>1)
        {
            ArrayUtil.swap(heap,1,n);
            n--;
            sink(heap,1,n);
        }

        System.arraycopy(heap,1,arr,0,heap.length-1);
    }


    private void createHeap(Comparable[]source,Comparable[]heap)
    {
        System.arraycopy(source,0,heap,1,source.length);

        for (int i=(heap.length/2);i>0;i--)
        {
            sink(heap,i,heap.length-1);
        }
    }

    private void sink(Comparable[]heap,int index,int range)
    {
        int maxIndex;
        while (index*2<=range)
        {
            if ((index*2+1)<=range)
            {
                if (heap[index*2].compareTo(heap[index*2+1])>0)
                {
                    maxIndex=index*2;
                }else
                {
                    maxIndex=index*2+1;
                }
            }else
            {
                maxIndex=index*2;
            }
            if (heap[maxIndex].compareTo(heap[index])<0)
            {
                break;
            }

            ArrayUtil.swap(heap,index,maxIndex);
            index=maxIndex;
        }
    }

}
