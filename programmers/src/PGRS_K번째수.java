import java.util.Arrays;

public class PGRS_K번째수 {

    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            int stIdx = command[0] - 1;
            int edIdx = command[1];
            int K = command[2];

            int[] subArray = Arrays.copyOfRange(array, stIdx, edIdx);
            Arrays.sort(subArray);

            answer[idx++] = subArray[K - 1];
        }

        return answer;
    }
}
