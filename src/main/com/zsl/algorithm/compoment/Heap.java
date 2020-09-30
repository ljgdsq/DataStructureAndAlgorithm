package main.com.zsl.algorithm.compoment;

import main.com.zsl.algorithm.util.ArrayUtil;
import main.com.zsl.algorithm.util.CompareUtil;


//大根堆
public class Heap<T extends Comparable> {
    private int count;
    private T[] items;

    public Heap(int capacity) {
        this.count = 0;
        this.items = (T[]) new Comparable[capacity+1];
    }

    public void insert(T data) {
        // 0索引不使用
        items[++count] = data;
        swim(count);
    }

    private void swim(int index) {
        while (index > 1) {
            if (CompareUtil.less(items[index / 2], items[index])) {
                ArrayUtil.swap(items, index, index / 2);
            }
            index = index / 2;
        }

    }

    public T delMax() {
        T max = items[1];
        ArrayUtil.swap(items, 1, count);
        items[count] = null;
        count--;
        sink(1);
        return max;
    }

    private void sink(int index) {
        int max;
        while (2 * index <= count) {
            if (2 * index + 1 <= count) {
                if (CompareUtil.less(items[2 * index], items[2 * index + 1])) {
                    max = 2 * index + 1;
                } else {
                    max = 2 * index;
                }
            } else {
                max = 2 * index;
            }

            if (CompareUtil.less(items[max], items[index])) {
                break;
            }
            ArrayUtil.swap(items, index, max);
            index=max;
        }
    }

}
