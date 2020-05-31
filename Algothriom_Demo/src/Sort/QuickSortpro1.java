package Sort;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import static Sort.SortExample.*;
import static Sort.SortExample.exch;
import static edu.princeton.cs.algs4.StdRandom.uniform;

// 改进方法一
// 进行小数组排序时，切换到插入排序
public class QuickSortpro1 {

    // 主函数
    public static void sort(Comparable[] b){

        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);

        StdRandom.shuffle(a);   // 调用了algs4.jar 中的源代码
        sort(a, 0, a.length-1);   // 默认切分元素为第一个元素

        if(!isSorted(a))
            System.out.println("快速排序1失败");
    }

    // 为algs4.jar 中的源代码
    // 将数组再次打乱  减少了对输入的依赖
    public static void shuffle(Object[] a) {
        validateNotNull(a);   // 判断数组是否为空
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n-i);     // between i and n-1
            // 交换位置操作
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    // 为 algs4.jar 中的源代码
    private static void validateNotNull(Object x) {
        if (x == null) {
            throw new IllegalArgumentException("argument is null");
        }
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo){
            Insertion.sort(a, lo, hi);
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    // 将数组分为 a[lo...,i-1] a[i] a[i+1..hi]
    private static int partition(Comparable[] a, int lo, int hi){

        int i = lo, j = hi+1;    // 定义左右扫描指针
        Comparable v = a[lo];    // 定义切分元素

        // 扫描左右，检查扫描是否结束并交换元素
        while (true){
            while (less(a[++i], v))   // 左标记不断向右移动，直到有元素>=切分元素
                if(i == hi)        // 当左标记到达最右端，跳出循环
                    break;
            while (less(v, a[--j]))   // 右标记不断向左移动，直到有元素<=切分元素
                if(j == lo)        // 当右标记到达最左端，跳出循环
                    break;
            if(i >= j)       // 当左标记与右标记重合，跳出大循环
                break;
            exch(a, i, j);   // 当左右标记满足条件停止移动时，交换标记所在的元素
        }
        exch(a, lo, j);    // 将 v= a[j] 放入正确的位置
        return j;          // 返回切分元素索引，此时a[j] 左右两侧完成排序
    }

}
