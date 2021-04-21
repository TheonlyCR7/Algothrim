package Sort;


import edu.princeton.cs.algs4.In;

import java.io.*;


public class Main {
    static String[] testArray;

    public static void main(String[] args) {

        // 这里使用相对路径时，要注意，根目录(起始目录)为 Algothrim_Demo(项目文件夹)，并非java文件本身
        String filePath =
                "src\\algo4-data\\8kints.txt";
        // 通过文件路径获取文件
        File file = new File(filePath);

        if (file.exists()) {
            try {
                // 创建文件读取对象
                FileReader fileReader = new FileReader(file);
                // 创建一个使用默认大小的输入缓冲区的缓冲字符输入流
                BufferedReader br = new BufferedReader(fileReader);
                String lineContent = null;
                // algs4-data\\1Kints.txt 有1000行数据
                testArray = new String[10];
                int i = 0;
                while ((lineContent = br.readLine()) != null && i < 10) {
                    testArray[i] = lineContent;
                    i ++;
                }

                Bubble();
                Insert();
                bintaryInsert();
                Select();
                Shell();
                Merge();
//                MergeBU();
                Quick();
                Quick1();
                Quick2();
                Quick3();
                unorderedArray();
                orderedArray();
                MaxPQAddDel();

                br.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("no this file");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("io exception");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 调用冒泡排序
    private static void Bubble(){
        long startTime = System.nanoTime();
        BubbleSort.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "冒泡排序, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 调用插入排序
    private static void Insert(){
        long startTime = System.nanoTime();
        insertSort.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "顺序插入排序, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 调用折半插入排序
    private static void bintaryInsert(){
        long startTime = System.nanoTime();
        binaryInsertSort.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "折半插入排序, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 调用选择排序
    private static void Select(){
        long startTime = System.nanoTime();
        SelectSort.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "选择排序, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 调用希尔排序
    private static void Shell(){
        long startTime = System.nanoTime();
        ShellSort.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "希尔排序, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 调用自顶向下归并排序
    private static void Merge(){
        long startTime = System.nanoTime();
        MergeSort.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "自顶向下排序, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 调用自顶向上归并排序
    private static void MergeBU(){
        long startTime = System.nanoTime();
        MergeSortBU.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "自顶向下排序, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    //调用快速排序
    private static void Quick(){
        long startTime = System.nanoTime();
        QuickSort.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "快速排序, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 快速排序1
    private static void Quick1(){
        long startTime = System.nanoTime();
        QuickSortpro1.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "快速排序改进1, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 快速排序1
    private static void Quick2(){
        long startTime = System.nanoTime();
        QuickSortpro2.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "快速排序改进2, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 快速排序3
    private static void Quick3(){
        long startTime = System.nanoTime();
        QuickSortpro3.sort(testArray);
        long endTime = System.nanoTime();
        System.out.println(
                "快速排序改进1, " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");
    }

    // 无序数组实现的优先队列  添加元素  删除最大元素
    private static void unorderedArray(){
        UnorderedArrayTopM unorderedArrayTopM = new UnorderedArrayTopM(testArray.length);
        long startTime = System.nanoTime();
        for(Comparable element:testArray)
            unorderedArrayTopM.insert(element);
        long endTime = System.nanoTime();
        System.out.println(
                "无序数组实现的优先队列, 添加 " + testArray.length + "个数据，执行时间为：" +
                        (endTime - startTime) / 1000000000.0 + " s");

        long startTime1 = System.nanoTime();
        unorderedArrayTopM.delMax();
        long endTime1 = System.nanoTime();

        System.out.println(
                "无序数组实现的优先队列, 删除最大元素，执行时间为：" +
                        (endTime1 - startTime1) / 1000000000.0 + " s");
    }

    // 有序数组实现的优先队列
    private static void orderedArray(){
        OrderedArrayTopM orderedArrayTopM = new OrderedArrayTopM(testArray.length);
        long startTime1 = System.nanoTime();
        for(Comparable element:testArray)
            orderedArrayTopM.insert(element);
        long endTime1 = System.nanoTime();
        long startTime2 = System.nanoTime();
        orderedArrayTopM.delMax();
        long endTime2 = System.nanoTime();
        System.out.println(
                "有序数组实现的优先队列, 添加" + testArray.length + "个数据，执行时间为：" +
                        (endTime1 - startTime1) / 1000000000.0 + " s");
        System.out.println(
                "有序数组实现的优先队列, 删除最大元素，执行时间为：" +
                        (endTime2 - startTime2) / 1000000000.0 + " s");
    }

    // 基于堆实现的优先队列
    private  static void MaxPQAddDel(){
        MaxPQ maxPQ = new MaxPQ(testArray.length);
        long startTime1 = System.nanoTime();
        for(Comparable element:testArray)
            maxPQ.insert(element);
        long endTime1 = System.nanoTime();
        long startTime2 = System.nanoTime();
        maxPQ.delMax();
        long endTime2 = System.nanoTime();
        System.out.println(
                "基于堆实现的优先队列, 添加" + testArray.length + "个数据，执行时间为：" +
                        (endTime1 - startTime1) / 1000000000.0 + " s");
        System.out.println(
                "基于堆实现的优先队列, 删除最大元素，执行时间为：" +
                        (endTime2 - startTime2) / 1000000000.0 + " s");
    }





}
