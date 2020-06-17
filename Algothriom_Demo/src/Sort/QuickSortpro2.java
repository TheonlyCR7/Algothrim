package Sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Random;

import static Sort.SortExample.*;
import static Sort.SortExample.exch;
import static edu.princeton.cs.algs4.StdRandom.uniform;

// 改进方法二
// 在进行小数组排序时, 使用小数组的中位数为切分元素
public class QuickSortpro2 {

    // 主函数
    public static void sort(Comparable[] b){

        Comparable[] a = new Comparable[b.length];
        System.arraycopy(b, 0, a, 0, b.length);

        StdRandom.shuffle(a);   // 调用了algs4.jar 中的源代码
        sort(a, 0, a.length-1);   // 默认切分元素为第一个元素


        if(!isSorted(a))
            System.out.println("快速排序2失败");
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

        if(hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    // 将数组分为 a[lo...,j-1] a[j] a[j+1..hi]
    // a[j] 左右两边完成排序
    private static int partition(Comparable[] a, int lo, int hi){

        int i = lo, j = hi+1;    // 定义左右扫描指针
        // 定义切分元素
        Comparable v;
        if(hi-lo <= 3)
            v = a[lo+(hi-lo+1)/2];
        else
            v = a[lo];
//        System.out.println("切分元素为" + v);
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
//            System.out.println("要交换的元素是" + a[i] + ", " + a[j]);
//            System.out.println(Arrays.toString(a));
            exch(a, i, j);   // 当左右标记满足条件停止移动时，交换标记所在的元素
        }
        exch(a, lo, j);    // 将 v= a[j] 放入正确的位置
//        System.out.println(j);
        return j;          // 返回切分元素索引，此时a[j] 左右两侧完成排序
    }

    public static void main(String[] args) {
        Comparable[] test2 = new Comparable[10];
        Random random = new Random();
        for(int i = 0; i < 10; i ++)
            test2[i] = random.nextInt(100);
        System.out.println(Arrays.toString(test2));
        sort(test2);
    }

}
