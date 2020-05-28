package Sort;

import static Sort.SortExample.less;

// 将两个小数组，a[lo, mid], a[mid, hi] 进行合并排序(归并)
public class Merge {

    public static Comparable[] aux;
    // 抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi){

        int j = mid+1;
        int i = lo;
        //Comparable[] aux = new Comparable[hi-lo];
        // 数组复制
        for(int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for(int k = lo; k <= hi; k++) {
            if (i > mid)             // 当左侧小数组为空时
                a[k] = aux[j++];
            else if (j > hi)        // 当右侧小数组为空时
                a[k] = aux[i++];
                // 比较左右两个数组首位，如果aux[j]小于aux[i]
            else if (aux[j]!=null && aux[i]!=null && less(aux[j], aux[i])) {
                a[k] = aux[j++];            // 将 aux[j] 放入原数组  并索引下移
            }
            else                            // 否则将 aux[i] 放入原数组  并索引下移
                a[k] = aux[i++];
        }
    }
}
