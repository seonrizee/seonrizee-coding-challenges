import java.util.ArrayDeque;
import java.util.Deque;

public class PGRS_괄호_회전하기 {

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {

            if (isValid(s)) {
                answer++;
            }
            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    private boolean isValid(String s) {

        Deque<Character> stk = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (stk.isEmpty()) {
                stk.push(c);
                continue;
            }

            char top = stk.peek();
            if ((top == '[' && c == ']') || (top == '{' && c == '}') || (top == '(' && c == ')')) {
                stk.pop();
            } else {
                stk.push(c);
            }
        }

        return stk.isEmpty();
    }
}
