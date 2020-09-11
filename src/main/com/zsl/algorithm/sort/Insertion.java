package main.com.zsl.algorithm.sort;

public class Insertion implements ISortable {
    @Override
    public void sort(Comparable[] arr) {
        for (int i=1;i<arr.length;i++)
        {
            var tmp=arr[i];
            int j=i;
            while (j>0&&tmp.compareTo(arr[j-1])<0)
            {
                arr[j]=arr[j-1];
                j--;
            }

            if (j!=i)
            {
                arr[j]=tmp;
            }
        }
    }
}
