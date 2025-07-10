import java.util.ArrayDeque;
import java.util.Queue;

public class PGRS_네트워크 {

    public int solution(int n, int[][] computers) {

        int networkCnt = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                networkCnt++;
                bfs(i, n, computers, visited);
            }
        }

        return networkCnt;
    }

    private void bfs(int st, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(st);
        visited[st] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nc = 0; nc < n; nc++) {
                if (visited[nc]) {
                    continue;
                }
                if (computers[cur][nc] == 1) {
                    visited[nc] = true;
                    q.offer(nc);
                }
            }
        }
    }
}
