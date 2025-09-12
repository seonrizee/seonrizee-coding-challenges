import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PGRS_프로세스 {

    public int solution(int[] priorities, int location) {

        Queue<Process> queue = new ArrayDeque<>();
        Queue<Integer> priorityPQ = new PriorityQueue<>(Collections.reverseOrder());

        int name = 0;
        for (int priority : priorities) {
            priorityPQ.offer(priority);
            queue.offer(new Process(name, priority));
            name++;
        }

        int order = 1;

        while (!queue.isEmpty()) {
            Process curProcess = queue.poll();
            if (curProcess.priority != priorityPQ.peek()) {
                queue.offer(curProcess);
                continue;
            }

            if (curProcess.name == location) {
                break;
            }
            priorityPQ.poll();
            order++;

        }
        return order;
    }

    private class Process {
        int name;
        int priority;

        public Process(int name, int priority) {
            this.name = name;
            this.priority = priority;
        }
    }
}
