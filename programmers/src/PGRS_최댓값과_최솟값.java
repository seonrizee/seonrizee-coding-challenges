import java.util.Arrays;

public class PGRS_최댓값과_최솟값 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int[] numbers = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        sb.append(Arrays.stream(numbers).min().getAsInt())
                .append(" ")
                .append(Arrays.stream(numbers).max().getAsInt());
        return sb.toString();
    }
}
