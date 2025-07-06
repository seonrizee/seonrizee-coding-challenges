import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class PGRS_무인도_여행 {

  static int[] dr = {0, 0, 1, -1};
  static int[] dc = {1, -1, 0, 0};

  public int[] solution(String[] maps) {

    int R = maps.length;
    int C = maps[0].length();
    int[][] map = new int[R][C];
    boolean[][] isVisited = new boolean[R][C];
    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (maps[i].charAt(j) == 'X') {
          map[i][j] = -1; // X는 -1로 표시
        } else {
          map[i][j] = maps[i].charAt(j) - '0'; // 숫자로 변환
        }
      }
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] != -1 && !isVisited[i][j]) {
          answer.add(bfs(i, j, map, isVisited, R, C));
        }
      }
    }

    if (answer.isEmpty()) {
      answer.add(-1); // 무인도에 도달할 수 없는 경우 -1 추가
    }

    return answer.stream().sorted().mapToInt(Integer::intValue).toArray(); // 결과를 정렬하여 반환
  }

  private int bfs(int r, int c, int[][] map, boolean[][] isVisited, int R, int C) {
    Queue<Point> q = new ArrayDeque<>();
    q.offer(new Point(r, c));
    isVisited[r][c] = true;
    int sum = map[r][c];

    while (!q.isEmpty()) {
      Point cur = q.poll();
      int cr = cur.r;
      int cc = cur.c;

      for (int d = 0; d < 4; d++) {
        int nr = cr + dr[d];
        int nc = cc + dc[d];

        if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
          continue; // 범위를 벗어나거나 이미  방문했거나 X인 경우
        }

        if (isVisited[nr][nc] || map[nr][nc] == -1) {
          continue; // X이거나 이미 방문한 곳은 건너뜀
        }

        isVisited[nr][nc] = true; // 방문 표시
        sum += map[nr][nc]; // 합산
        q.offer(new Point(nr, nc)); // 큐에 추가
      }
    }

    return sum;
  }

  private static class Point {

    int r, c;

    public Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
