package Sort;

import static Sort.SortExample.less;

public class binaryInsertSort {
    public static void sort(Comparable[] arr) {
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
        }
    }
}
