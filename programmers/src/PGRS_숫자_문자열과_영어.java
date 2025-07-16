import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PGRS_숫자_문자열과_영어 {

    // length 14, start 9
    public int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        Map<String, Character> map = new HashMap<>();
        IntStream.range(0, 10)
                .forEach(i -> map.put(words[i], Character.forDigit(i, 10)));

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int length = s.length();
        while (idx < length) {
            char cur = s.charAt(idx);
            if (Character.isDigit(cur)) {
                sb.append(cur);
                idx++;
                continue;
            }

            if (idx + 3 <= length) {
                String curStrThree = s.substring(idx, idx + 3);
                if (map.containsKey(curStrThree)) {
                    sb.append(map.get(curStrThree));
                    idx += 3;
                    continue;
                }
            }
            if (idx + 4 <= length) {
                String curStrFour = s.substring(idx, idx + 4);
                if (map.containsKey(curStrFour)) {
                    sb.append(map.get(curStrFour));
                    idx += 4;
                    continue;
                }
            }
            if (idx + 5 <= length) {
                String curStrFive = s.substring(idx, idx + 5);
                if (map.containsKey(curStrFive)) {
                    sb.append(map.get(curStrFive));
                    idx += 5;
                }
            }
        }

        return Integer.parseInt(sb.toString());
    }

}
