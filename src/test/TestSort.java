package test;

import main.com.zsl.algorithm.sort.Bubble;
import org.junit.Test;
public class TestSort {

    @Test
    public  void testBubbleSort(){
       Integer[] arr=new Integer[]{6,3,7,9,0,1};
       new Bubble().sort(arr);
    }
}
