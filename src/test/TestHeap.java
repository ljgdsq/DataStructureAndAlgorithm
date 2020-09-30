package test;

import junit.framework.TestCase;
import main.com.zsl.algorithm.compoment.Heap;

public class TestHeap extends TestCase {

    public void testDel()
    {
        Heap<String> heap=new Heap<>(10);
        heap.insert("a");
        heap.insert("b");
        heap.insert("c");
        heap.insert("d");
        heap.insert("e");
        heap.insert("f");
        heap.insert("g");


        String res;
        while ((res=heap.delMax())!=null)
        {
            System.out.println(res);
        }
    }

}
