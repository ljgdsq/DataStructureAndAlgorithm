package test;

import main.com.zsl.algorithm.compoment.RBTree;

public class RBTreeTest  {
    public static void main(String[] args) {
        RBTree rbTree=new RBTree();


        rbTree.put("a","aa");
        rbTree.put("b","bb");
        rbTree.put("c","cc");
        rbTree.put("e","ee");
        rbTree.put("d","dd");


        System.out.println(rbTree.get("a"));
        System.out.println(rbTree.get("b"));
        System.out.println(rbTree.get("c"));
        System.out.println(rbTree.get("d"));
        System.out.println(rbTree.get("e"));
    }
}
