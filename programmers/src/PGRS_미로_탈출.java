import java.util.ArrayDeque;
import java.util.Queue;

public class PGRS_미로_탈출 {

  public int solution(String[] maps) {

    int R = maps.length;
    int C = maps[0].length();
    int startR = 0, startC = 0, leverR = 0, leverC = 0, endR = 0, endC = 0;

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        char c = maps[i].charAt(j);
        switch (c) {
          case 'S':
            startR = i;
            startC = j;
            break;
          case 'E':
            endR = i;
            endC = j;
            break;
          case 'L':
            leverR = i;
            leverC = j;
            break;
        }
      }
    }

    int toLaver = bfs(maps, startR, startC, leverR, leverC);
    if (toLaver == -1) {
      return -1; // 레버를 당기지 못한 경우
    }
    int toEnd = bfs(maps, leverR, leverC, endR, endC);
    if (toEnd == -1) {
      return -1; // 레버를 당기지 못한 경우
    }
    return toLaver + toEnd;
  }

  private int bfs(String[] maps, int sr, int sc, int tr, int tc) {

    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};

    int R = maps.length;
    int C = maps[0].length();
    boolean[][] isVisited = new boolean[R][C];

    Queue<Point> q = new ArrayDeque<>();
    q.offer(new Point(sr, sc, 0));
    isVisited[sr][sc] = true;

    while (!q.isEmpty()) {
      Point cur = q.poll();

      if (cur.r == tr && cur.c == tc) {
        return cur.step;
      }

      for (int d = 0; d < 4; d++) {
        int nr = cur.r + dr[d];
        int nc = cur.c + dc[d];

        if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
          continue; // 범위를 벗어나는 경우
        }

        if (isVisited[nr][nc] || maps[nr].charAt(nc) == 'X') {
          continue; // 이미 방문했거나 X인 경우
        }

        isVisited[nr][nc] = true;
        q.offer(new Point(nr, nc, cur.step + 1));
      }
    }

    return -1;
  }

  public static class Point {
    int r, c;
    int step;

    Point(int r, int c, int step) {
      this.r = r;
      this.c = c;
      this.step = step;
    }
  }
}
