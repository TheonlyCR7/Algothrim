package Sort;


import static Sort.SortExample.*;

// 插入排序
// 这里是从左到右进行升序排序
// 索引从左到右
// 检查索引左侧元素是否大于索引元素
// 如果大于 则交换
// 如果不大于 则索引++
// 即保持索引左侧的有序性
public class insertSort {
    public static void sort(Comparable[] b){

        Comparable[] a = new Comparable[b.length];
        // 拷贝传入的数组  在新数组上进行排序操作
        System.arraycopy(b, 0, a, 0, b.length);

        int N = a.length;
        // 索引i 向右移动
        for(int i = 0; i < N; i ++){
            // 索引j向左移动
            // 循环时要保证当前索引数据小于左边的数据  否则终止循环
            for(int j = i; j > 0 && less(a[j], a[j-1]); j --)
                exch(a, j, j-1);  // 交换数组a中 索引为j 和 j-1 的元素

//            printer(a, i);
        }

        // 检查是否排序成功
        if(!isSorted(a))
            System.out.println("插入排序失败");
    }

    public static void printer(Comparable[] a , int j){
        System.out.print("array" + j + ": ");
        for(int i = 0; i < a.length; i ++)
            System.out.print(a[i] + ", ");
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

        insertSort.sort(array);
    }
}
