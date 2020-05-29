package Sort;


import java.io.*;

import static Sort.SortExample.isSorted;

public class Main {
    public static void main(String[] args) {

        // 这里使用相对路径时，要注意，根目录(起始目录)为 Algothrim_Demo(项目文件夹)，并非java文件本身
        String filePath =
                "src\\algo4-data\\1kints.txt";
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
                String[] testArray = new String[1000];
                int i = 0;
                while ((lineContent = br.readLine()) != null) {
                    testArray[i] = lineContent;
                    i ++;
                }

                // System.out.println(Arrays.toString(testArray));

                // 计时器
                long startTime1 = System.nanoTime();
                SelectSort.sort(testArray);
                long endTime1 = System.nanoTime();
                System.out.println(
                        "选择排序，1000个数据，执行时间为：" +
                                (endTime1 - startTime1) / 1000000000.0 + " s");

                long startTime2 = System.nanoTime();
                insertSort.sort(testArray);
                long endTime2 = System.nanoTime();
                System.out.println(
                        "插入排序，1000个数据，执行时间为：" +
                                (endTime2 - startTime2) / 1000000000.0 + " s");

                long startTime3 = System.nanoTime();
                ShellSort.sort(testArray);
                long endTime3 = System.nanoTime();
                System.out.println(
                        "希尔排序，1000个数据，执行时间为：" +
                                (endTime3 - startTime3) / 1000000000.0 + " s");

                long startTime4 = System.nanoTime();
                MergeSort.sort(testArray);
                long endTime4 = System.nanoTime();
                System.out.println(
                        "自顶向下归并排序，1000个数据，执行时间为：" +
                                (endTime4 - startTime4) / 1000000000.0 + " s");

                long startTime5 = System.nanoTime();
                MergeSort.sort(testArray);
                long endTime5 = System.nanoTime();
                System.out.println(
                        "自底向上归并排序，1000个数据，执行时间为：" +
                                (endTime5 - startTime5) / 1000000000.0 + " s");

                long startTime6 = System.nanoTime();
                QuickSort.sort(testArray);
                long endTime6 = System.nanoTime();
                System.out.println(
                        "快速排序，1000个数据，执行时间为：" +
                                (endTime6 - startTime6) / 1000000000.0 + " s");


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
}
