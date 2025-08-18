public class PGRS_공원_산책 {

    public int[] solution(String[] park, String[] routes) {

        int R = park.length;
        int C = park[0].length();
        int[] dr = {0, 1, 0, -1}; // 동, 남, 서, 북
        int[] dc = {1, 0, -1, 0}; // 동, 남, 서, 북
        int cr = 0, cc = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (park[r].charAt(c) == 'S') {
                    cr = r;
                    cc = c;
                    break;
                }
            }
        }

        for (String route : routes) {
            String[] segments = route.split(" ");
            String direction = segments[0];
            int steps = Integer.parseInt(segments[1]);

            int dirIdx = switch (direction) {
                case "E" -> 0; // 동
                case "S" -> 1; // 남
                case "W" -> 2; // 서
                case "N" -> 3; // 북
                default -> -1;
            };

            int nr = cr;
            int nc = cc;

            boolean canMove = true;
            for (int i = 0; i < steps; i++) {
                nr += dr[dirIdx];
                nc += dc[dirIdx];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    canMove = false;
                    break;
                }

                if (park[nr].charAt(nc) == 'X') {
                    canMove = false;
                    break;
                }
            }

            if (canMove) {
                cr = nr;
                cc = nc;
            }
        }

        return new int[]{cr, cc};
    }
}
