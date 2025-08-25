import java.util.HashMap;
import java.util.Map;

public class PGRS_추억_점수 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        int[] result = new int[photo.length];

        Map<String, Integer> nameToYearning = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            nameToYearning.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String photoName : photo[i]) {
                score += nameToYearning.getOrDefault(photoName, 0);
            }
            result[i] = score;
        }

        return result;
    }
}
