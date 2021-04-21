package Sort;

import static Sort.SortExample.exch;
import static Sort.SortExample.isSorted;

// 三向切分，当含有大量重复元素时适用
public class QuickSortpro3 {

    public static void sort(Comparable[] b){
        Comparable[] a = sort(b, 0, b.length-1);

        if(!isSorted(a))
            System.out.println("快速排序3失败");
    }

    public static Comparable[] sort(Comparable[] b, int lo, int hi){

        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);

        if(hi <= lo)
            return null;
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

        return a;
    }

}
