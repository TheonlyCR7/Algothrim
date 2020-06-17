package Sort;

import edu.princeton.cs.algs4.*;

// 优先队列的示例代码
public class TopM {

    // This class should not be instantiated.
    private TopM() { }


    public static void main(String[] args) {
        // 打印输出流中最大的M行
        int m = Integer.parseInt(args[0]);
        MinPQ<Transaction> pq = new MinPQ<Transaction>(m+1);

        while (StdIn.hasNextLine()) {
            // 为下一行输入创建一个元素并放入优先队列中
            String line = StdIn.readLine();
            Transaction transaction = new Transaction(line);
            pq.insert(transaction);

            // 如果优先队列种存在 m+1 个元素 删除最小元素
            if (pq.size() > m)
                pq.delMin();
        }   // 循环结束，最大的M个元素都在优先队列中

        // 以相反的顺序在PQ上打印条目
        Stack<Transaction> stack = new Stack<Transaction>();
        for (Transaction transaction : pq)
            stack.push(transaction);
        for (Transaction transaction : stack)
            StdOut.println(transaction);
    }
}
