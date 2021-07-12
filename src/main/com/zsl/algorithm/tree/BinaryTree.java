package main.com.zsl.algorithm.tree;

import java.util.*;

public class BinaryTree<K extends Comparable, V> {
    private static class Node<K extends Comparable, V> {
        public K key;
        public V value;
        public Node<K, V> left;
        public Node<K, V> right;


        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    private Node<K, V> root;
    private int count;

    public int size() {
        return count;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    public V get(K key) {
        return get(root, key);
    }

    public void delete(K key) {
        delete(root, key);
    }


    private Node put(Node node, K key, V value) {
        if (node == null) {
            count++;
            return new Node(key, value, null, null);
        }


        int result = key.compareTo(node.key);
        if (result > 0) {
            node.right = put(node.right, key, value);
        } else if (result < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }



        return node;
    }

    private V get(Node<K, V> node, K key) {

        if (node == null)
            return null;

        int result = key.compareTo(node.key);
        if (result > 0) {
            return get(node.right, key);
        } else if (result < 0) {
            return get(node.left, key);
        } else {
            return node.value;
        }
    }

    public Node delete(Node node, K key) {

        if (node == null)
            return null;


        int result = key.compareTo(node.key);
        if (result > 0) {
            node.right = delete(node.right, key);
        } else if (result < 0) {
            node.left = delete(node.left, key);
        } else {

            if (node.right == null) {
                return node.left;
            }

            if (node.left == null) {
                return node.right;
            }

            Node min = node.right;
            Node parent = node;
            while (min.left != null) {
                parent = min;
                min = min.left;
                if (min.left == null) {
                    parent.left = null;
                }
            }


            min.left = node.left;
            min.right = node.right;

            node = min;
            count--;

        }

        return node;
    }

    public List<K> preTraversal() {
        List<K> keys = new ArrayList<>();
        preTraversal(root, keys);
        return keys;

    }

    private void preTraversal(Node<K, V> node, List<K> keys) {
        if (node == null)
            return;

        keys.add(node.key);

        preTraversal(node.left, keys);
        preTraversal(node.right, keys);
    }


    public List<K> layerTraversal() {
        List<K> keys = new ArrayList<>();
        Queue<Node<K,V>> queue = new LinkedList<>();
        queue.add(root);
        var e=queue.peek();
        while (e!=null){
            keys.add(e.key);

            if (e.left!=null) {
                queue.add(e.left);
            }

            if (e.right!=null)
            {
                queue.add(e.right);
            }

        }

        return keys;
    }



    public int maxDepth(){
        return maxDepth(root);
    }

    private int maxDepth(Node node){
        if (node==null)
            return 0;

        int maxL=maxDepth(node.left);
        int maxR=maxDepth(node.right);
        int max=maxL>maxR?maxL+1:maxR+1;
        return max;
    }


}
