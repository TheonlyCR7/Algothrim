package Sort;

import java.util.ArrayList;
import java.util.Random;

import static Sort.SortExample.*;

// 冒泡排序
// 这里作升序排序
public class BubbleSort {
    public static void sort(Comparable[] b){

        Comparable[] a = new Comparable[b.length];
        // 拷贝传入的数组  在新数组上进行排序操作
        System.arraycopy(b, 0, a, 0, b.length);

        int N = a.length;

        for(int i = 0; i < a.length-1; i ++){
            for(int j = 0; j <a.length-i-1; j ++){
                if(less(a[j], a[j+1]))
                    exch(a, j, j+1);
            }
        }

        // 检查是否排序成功
        if(!isSorted(a))
            System.out.println("冒泡排序失败");
    }

    public static void main(String[] args) {
        String[] array = new String[10];
        Random random = new Random();
        for(int i = 0; i < array.length; i ++)
            array[i] = random.

        System.out.println(array.toString());

        BubbleSort.sort(array);
    }
}
