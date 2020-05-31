package Sort;

import static Sort.SortExample.exch;
import static Sort.SortExample.isSorted;

// 三向切分，当含有大量重复元素时适用
public class QuickSortpro3 {
    public static void sort(Comparable[] b, int lo, int hi){

        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);

        if(hi <= lo)
            return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if(cmp > 0)
                exch(a, i , gt--);
            else
                i ++;
        }
        sort(a, lo, lt-1);
        sort(a, gt+1, hi);

        if(!isSorted(a))
            System.out.println("快速排序3失败");
    }

}
