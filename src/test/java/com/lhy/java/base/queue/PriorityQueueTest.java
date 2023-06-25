package com.lhy.java.base.queue;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    @Test
    void poll(){
        // 如果没有比较器，则默认的是自然排序。
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer(4);
        priorityQueue.offer(2);
        priorityQueue.offer(6);
        priorityQueue.offer(1);

        while (!priorityQueue.isEmpty()) {
            // 和poll有关的api，只有poll，没有pollLast和PollFirst
            System.out.println(priorityQueue.poll());
        }
        /*
        输出：
        1
        2
        4
        6
         */
    }
}
