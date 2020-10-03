package home_4.queue;

import java.util.Optional;

public class TestsPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < 6; i++) {
            System.out.println("PUT " + 30 + i);
            priorityQueue.enqueue(2, 300 + i);
        }

        for (int i = 0; i < 6; i++) {
            System.out.println("PUT " + 20 + i);
            priorityQueue.enqueue(1, 200 + i);
        }

        for (int i = 0; i < 6; i++) {
            System.out.println("PUT " + 10 + i);
            priorityQueue.enqueue(0, 100 + i);
        }

        System.out.println(priorityQueue.size());

        for (int i = 0; i < 100; i++) {
            Optional<Integer> test = priorityQueue.dequeue();
            System.out.println("Result " + test.get());
        }

    }
}
