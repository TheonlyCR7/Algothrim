package Sort;


import static Sort.SortExample.less;

// 通过有序数组实现优先队列
public class OrderedArrayTopM<Key extends Comparable<Key>> {
    private Key[] pq;          // elements
    private int n;             // number of elements

    // set inititial size of heap to hold size elements
    public OrderedArrayTopM(int capacity) {
        pq = (Key[]) (new Comparable[capacity]);
        n = 0;
    }

    public boolean isEmpty() { return n == 0;  }
    public int size()        { return n;       }
    public Key delMax()      { return pq[--n]; }

    public void insert(Key key) {
        int i = n-1;
        // 从后往前遍历 直到有元素不小于插入元素key
        while (i >= 0 && less(key, pq[i])) {
            pq[i+1] = pq[i];  // 向后移
            i--;
        }
        pq[i+1] = key;  // 插入
        n++;   // 元素个数加一
    }

}
