package test;


import junit.framework.TestCase;
import main.com.zsl.algorithm.compoment.LinkedList;

public class TestLinkedList extends TestCase {


    public void testInsert() {
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);

        linkedList.reverse();


        linkedList.forEach(System.out::println);
    }


    public void testFastSlowIndicator(){

    }
}
