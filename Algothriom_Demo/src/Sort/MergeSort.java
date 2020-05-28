package Sort;

import java.util.Arrays;
import java.util.Random;

import static Sort.SortExample.isSorted;
import static Sort.SortExample.less;

public class MergeSort {

    public static Comparable[] aux;

    // 主函数，供外界调用
    public static void sort(Comparable[] b){

        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);

        aux = new Comparable[a.length];   // 1000
        sort(a, 0, a.length-1);          // 1000

        if(!isSorted(a))
            System.out.println("自顶向下归并排序失败");
    }

    // 通过递归将大数组不断划分，直到每个小数组只有两个元素
    public static void sort(Comparable[] a, int lo, int hi){
        // 将数组a[lo..hi] 排序
        if(hi <= lo)
            return;
        int mid = lo + (hi-lo)/2;  // 4
        sort(a, lo, mid);    // 左半边排序
        sort(a, mid+1, hi);  // 右半边排序
        merge(a, lo, mid, hi);   // 归并结果
    }

    // 抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        // 将大数组a分成两个小数组，a[lo, mid], a[mid, hi] 分别进行排序
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

    public static void main(String[] args) {
        Comparable[] test2 = new Comparable[4];
        Random random = new Random();
        for(int i = 0; i < 4; i ++)
            test2[i] = random.nextInt(20);
        System.out.println(Arrays.toString(test2));
        sort(test2);
    }
}
