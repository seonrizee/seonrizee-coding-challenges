import java.util.HashMap;
import java.util.Map;

public class PGRS_대충_만든_자판 {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> minPressMap = new HashMap<>();
        for (String key : keymap) {

            for (int idx = 0; idx < key.length(); idx++) {
                Character c = key.charAt(idx);
                minPressMap.merge(c, idx + 1, Math::min);
            }
        }

        for (int i = 0; i < targets.length; i++) {

            int totalPress = 0;
            String target = targets[i];

            for (int idx = 0; idx < target.length(); idx++) {
                Character c = target.charAt(idx);
                if (!minPressMap.containsKey(c)) {
                    totalPress = -1;
                    break;
                } else {
                    totalPress += minPressMap.get(c);
                }
            }
            answer[i] = totalPress;
        }

        return answer;
    }
}


