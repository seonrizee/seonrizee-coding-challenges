import java.util.ArrayDeque;
import java.util.Queue;

public class PGRS_게임_맵_최단거리 {

  public int solution(int[][] maps) {
    int answer = -1;

    int sr = 0, sc = 0;
    int er = maps.length;
    int ec = maps[0].length;

    boolean[][] isVisited = new boolean[er][ec];
    Queue<Point> q = new ArrayDeque<>();
    q.offer(new Point(sr, sc, 1));
    isVisited[sr][sc] = true;

    int[] dr = new int[] {0, 0, 1, -1};
    int[] dc = new int[] {1, -1, 0, 0};

    while (!q.isEmpty()) {
      Point cur = q.poll();

      if (cur.r == er - 1 && cur.c == ec - 1) {
        answer = cur.step;
      }

      for (int d = 0; d < 4; d++) {
        int nr = cur.r + dr[d];
        int nc = cur.c + dc[d];

        if (nr < 0 || nc < 0 || nr >= er || nc >= ec) {
          continue;
        }

        if (isVisited[nr][nc] || maps[nr][nc] == 0) {
          continue;
        }

        q.offer(new Point(nr, nc, cur.step + 1));
        isVisited[nr][nc] = true;
      }
    }

    return answer;
  }

  public static class Point {
    int r, c, step;

    public Point(int r, int c, int step) {
      this.r = r;
      this.c = c;
      this.step = step;
    }
  }
}
