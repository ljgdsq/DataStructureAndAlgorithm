package test;

import junit.framework.TestCase;
import main.com.zsl.algorithm.sort.*;
import org.junit.Test;

//import static junit.framework.TestCase.assertEquals;


public class TestSort extends TestCase {

    private Integer[] arr = new Integer[]{6, 3, 7, 9, 0, 1};

    @Test
    public void testBubbleSort() {
        new Bubble().sort(arr);
    }

    @Test
    public void testSelectSort() {
        new Select().sort(arr);
    }

    @Test
    public void testInsertionSort(){new Insertion().sort(arr);

    }

    @Test
    public void testSellSort(){new Shell().sort(arr);

    }


    @Test
    public void testMergeSort(){new Merge().sort(arr);

    }

    @Test
    public void testQuickSort(){new Quick().sort(arr);

    }
}
