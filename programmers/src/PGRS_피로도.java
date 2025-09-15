public class PGRS_피로도 {
    public int solution(int k, int[][] dungeons) {

        int[] answer = {0};
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, visited, 0, answer);

        return answer[0];
    }

    private void dfs(int currentK, int[][] dungeons, boolean[] visited, int count, int[] answer) {

        answer[0] = Math.max(answer[0], count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && currentK >= dungeons[i][0]) {

                visited[i] = true;
                dfs(currentK - dungeons[i][1], dungeons, visited, count + 1, answer);
                visited[i] = false;
            }
        }
    }
}

