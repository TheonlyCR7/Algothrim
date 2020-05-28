package Sort;

import static Sort.Merge.merge;
import static Sort.SortExample.isSorted;

public class MergeSortBU {

    public static void sort(Comparable[] b){

        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);

        // 进行 lgN 次两两归并
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for(int sz = 1; sz < N; sz *= 2){   // 以2个元素为一个最小数组
            for(int lo = 0; lo < N-sz; lo += sz+sz)     // 以相邻的两个小数组为一组进行归并
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));   // 将相邻的两个小数组归并

        if(!isSorted(a))
            System.out.println("自底向上归并排序失败");
        }
    }
}
