package main.com.zsl.algorithm.compoment;


public class RBTree<Key extends Comparable,Value> {
    private static final int RED = 0;
    private static final int BLACK = 1;
    private int count;
    private Node root;

    public RBTree() {
        this.count = 0;

    }

    public int size()
    {
        return count;
    }

    private  boolean isRed(Node node)
    {
        if (node==null)return false;
        return node.color==RED;
    }

    private void flipColor(Node node)
    {
        node.color=RED;
        node.left.color=BLACK;
        node.right.color=BLACK;
    }

    private Node rotateLeft(Node node)
    {

        Node S=node.right;
        node.right=S.left;
        S.left= node;
        S.color= node.color;
        node.color=RED;


        return S;
    }

    private Node rotateRight(Node node)
    {
        Node S=node.left;
        node.left=S.right;
        S.right=node;
        S.color=node.color;
        node.color=RED;

        return S;
    }


    public void put(Key key,Value value)
    {
        root=put(root,key,value);
        root.color=BLACK;
    }

    private Node put(Node node, Key key,Value value)
    {
        if (node==null) {
            count++;
            return new Node(key, value, RED, null, null);
        }

        int cmp=key.compareTo(node.key);
        if (cmp>0)
        {
            node.right=put(node.right,key,value);
        }else if(cmp<0)
        {
            node.left=put(node.left,key,value);

        }else
        {
            node.value=value;
        }

        if (!isRed(node.left) &&isRed(node.right))
        {
            node=rotateLeft(node);
        }

        if (isRed(node.left) &&isRed(node.left.left))
        {
            node=rotateRight(node);
        }


        if (isRed(node.left)&&isRed(node.right))
        {
            flipColor(node);
        }


        return node;


    }


    public Value get( Key key)
    {
        return get(root,key);
    }


    private Value get(Node node,Key key)
    {
        if (node==null)return null;
        int cmp=key.compareTo(node.key);
        if (cmp>0)
        {
            return get(node.right,key);
        }else if(cmp<0)
        {
            return get(node.left,key);

        }else
        {
            return  node.value;
        }
    }


    private class Node {
        private Key key;
        private Value value;
        private int color;
        private Node left;
        private Node right;

        public Node(Key key, Value value,int color, Node left, Node right) {
            this.key = key;
            this.value=value;
            this.color = color;
            this.left = left;
            this.right = right;
        }
    }

}
