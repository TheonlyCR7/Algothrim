package Sort;

import static Sort.SortExample.exch;
import static Sort.SortExample.less;

// 通过无序数组实现优先队列
public class UnorderedArrayTopM<Key extends Comparable<Key>> {

    Key[] pq;      // elements
    int n;         // number of elements

    // set inititial size of heap to hold size elements
    // 设置堆的初始大小以容纳大小元素
    public UnorderedArrayTopM(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        n = 0;
    }

    public boolean isEmpty()   { return n == 0; }
    public int size()          { return n;      }
    public void insert(Key x)  { pq[n++] = x;   }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < n; i++)  // for循环找到最大元素
            if (less(max, i)) max = i;
        exch(pq, max, n-1);

        return pq[--n];
    }

}
