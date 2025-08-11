import java.util.HashMap;
import java.util.Map;

public class PGRS_성격_유형_검사하기 {

    public String solution(String[] survey, int[] choices) {

        Map<Character, Integer> scoreMap = new HashMap<>();
        String types = "RTCFJMAN";
        for (char type : types.toCharArray()) {
            scoreMap.put(type, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            Character firstChar = survey[i].charAt(0);
            Character secondChar = survey[i].charAt(1);
            int choice = choices[i];
            if (choice < 4) {
                scoreMap.put(firstChar, scoreMap.get(firstChar) + (4 - choice));
            } else if (choice > 4) {
                scoreMap.put(secondChar, scoreMap.get(secondChar) + (choice - 4));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        sb.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        sb.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        sb.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');

        return sb.toString();
    }
}
