import java.util.ArrayList;

public class PGRS_햄버거_만들기 {

    public int solution(int[] ingredient) {
        int answer = 0;
        ArrayList<Integer> stack = new ArrayList<>();

        for (int item : ingredient) {
            stack.add(item);

            if (stack.size() >= 4) {
                int curSize = stack.size();
                if (stack.get(curSize - 4) == 1 &&
                        stack.get(curSize - 3) == 2 &&
                        stack.get(curSize - 2) == 3 &&
                        stack.get(curSize - 1) == 1) {

                    answer++;

                    stack.remove(curSize - 1);
                    stack.remove(curSize - 2);
                    stack.remove(curSize - 3);
                    stack.remove(curSize - 4);
                }
            }
        }
        return answer;
    }
}
