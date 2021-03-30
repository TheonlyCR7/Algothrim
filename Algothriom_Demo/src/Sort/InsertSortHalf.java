package Sort;

import static Sort.SortExample.isSorted;
import static Sort.SortExample.less;

public class InsertSortHalf {
    public static void sort(Comparable[] b){
        Comparable[] a = new Comparable[b.length];
        // 拷贝传入的数组  在新数组上进行排序操作
        System.arraycopy(b, 0, a, 0, b.length);

        int N = a.length;
        for(int i = 0; i < N; i ++){
            for(int j = i;j > 0 && less(a[j], a[j-1]); j--){
                a = HalfSeek(a, j);
//                printer(a, j);
            }
        }

        // 检查是否排序成功
        if(!isSorted(a))
            System.out.println("折半插入排序失败");
    }


    // 折半查找
    public static Comparable[] HalfSeek(Comparable[] a, int i){

        int mid = i/2;
        // 找到正确的插入点mid
        while(less(a[i], a[mid+1]) && mid != 0){
            if(mid == i || mid > i)
                break;
            if(less(a[i], a[mid-1]) || a[i].compareTo(a[mid-1]) == 0)
                mid = mid/2;
            else
                mid = (mid + i)/2;
        }

        // 交换位置
        Comparable n = a[i];
        for(int j = i; j > mid; j --)
            a[j] = a[j-1];
        a[mid] = n;
//        a[i] = a[mid];
//        a[mid] = n;

        return a;
    }

    // 小范围 解析折半插入排序使用
    public static void printer(Comparable[] a , int j){
        System.out.print("array" + j + ": ");
        for(int i = 0; i < a.length; i ++)
            System.out.print(a[i] + ", ");
        System.out.println();
    }

    // 小范围 解析折半插入排序使用
    public static void main(String[] args) {

        String[] array = new String[10];
        for(int i = 0; i < array.length; i ++)
            array[i] = (char)(74 - i) + "";

        System.out.print("array:");
        for(int j = 0;j < array.length; j ++)
            System.out.print(array[j] + ", ");
        System.out.println();

        InsertSortHalf.sort(array);
    }
}
