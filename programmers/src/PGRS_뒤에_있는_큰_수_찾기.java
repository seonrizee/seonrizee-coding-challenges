import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class PGRS_뒤에_있는_큰_수_찾기 {

    public int[] solution(int[] numbers) {

        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            while (!stk.isEmpty() && numbers[stk.peek()] < numbers[i]) {
                int target = stk.pop();
                answer[target] = numbers[i];
            }
            stk.push(i);
        }

        return answer;
    }
}
