import java.util.Arrays;

public class PGRS_안전지대 {

    public int solution(int[][] board) {
        int answer = 0;
        int boardSize = board.length;

        boolean[][] safeArea = new boolean[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(safeArea[i], true);
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == 1) {
                    safeArea[i][j] = false;
                    markDangerZone(safeArea, i, j, boardSize);
                }
            }
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (safeArea[i][j]) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void markDangerZone(boolean[][] safeArea, int R, int C, int N) {

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int d = 0; d < 8; d++) {
            int nr = R + dr[d];
            int nc = C + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }

            safeArea[nr][nc] = false;
        }

    }
}
