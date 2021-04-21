package Sort;

import static Sort.SortExample.isSorted;
import static Sort.SortExample.less;

// 折半冒泡排序
// 时间复杂度为 O((logn)n^2)
public class binaryInsertSort {
    public static void sort(Comparable[] b) {
        Comparable[] arr = new Comparable[b.length];
        // 拷贝传入的数组  在新数组上进行排序操作
        System.arraycopy(b, 0, arr, 0, b.length);

        // 将数组第0位作为有序序列，从第1位开始逐一进行插入
        for (int i = 1; i < arr.length; i++) {
            Comparable temp = arr[i];
            int low = 0;
            int high = i - 1;
            int mid = 0;
            // 使用折半查找法查找要插入的位置
            while (low <= high) {
                mid = (low + high) / 2;
                if (less(temp, arr[mid])) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // 向后移位
            for (int j = i - 1; j >= mid; j--) {
                arr[j+1] = arr[j];
            }
            arr[mid] = temp;        // 插入元素
            printer(arr, i);
        }

        // 检查是否排序成功
        if(!isSorted(arr))
            System.out.println("折半冒泡排序失败");
    }

    public static void printer(Comparable[] arr, int i){
        System.out.print("array" + i + ": ");
        for(int j = 0; j < arr.length; j ++) {
            System.out.print(arr[j]);
            if(j != arr.length-1)
                System.out.print(", ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        String[] array = new String[10];
        for(int i = 0; i < array.length; i ++)
            array[i] = (char)(74 - i) + "";

        System.out.print("array:");
        for(int j = 0;j < array.length; j ++)
            System.out.print(array[j] + ", ");
        System.out.println();

        binaryInsertSort.sort(array);
    }
}
