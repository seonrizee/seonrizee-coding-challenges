import java.util.Arrays;

class PGRS_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(command -> {
                    int[] sliced = Arrays.copyOfRange(array, command[0] - 1, command[1]);
                    Arrays.sort(sliced);
                    return sliced[command[2] - 1];
                })
                .toArray();
    }
}