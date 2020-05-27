package Sort;

import static Sort.SortExample.isSorted;
import static Sort.SortExample.less;

public class MergeSort {

    public static Comparable[] aux;

    // 主函数，供外界调用
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        // 将数组a[lo..hi] 排序
        if(hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid);    // 左半边排序
        sort(a, mid+1, hi);  // 右半边排序
        hi = a.length;
        merge(a, lo, mid, hi);   // 归并结果
    }

    // 抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        System.out.println("a.length: "+ a.length + " lo: " + lo + " mid: " + mid + " hi: " + hi);
        // 将大数组a分成两个小数组，a[lo, mid], a[mid, hi] 分别进行排序
        int j = mid+1;
        int i = lo;
        Comparable[] aux = new Comparable[hi-lo];
        // 数组复制
        for(int k =lo; k <= hi-1; k++)
            aux[k] = a[k];

        for(int k = lo; k <= hi; k++)
            if(i > mid)
                a[k] = aux[j+1];
            else if(j > mid)
                a[k] = aux[i++];
            else if(less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
    }
}
