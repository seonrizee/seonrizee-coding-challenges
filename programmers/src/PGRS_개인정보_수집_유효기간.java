import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PGRS_개인정보_수집_유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] sep = term.split(" ");
            termsMap.put(sep[0], Integer.parseInt(sep[1]));
        }

        int todayDays = getTotalDays(today);
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] sep = privacies[i].split(" ");
            String date = sep[0];
            String type = sep[1];

            int termMonths = termsMap.get(type);
            int termDays = getTotalDays(date);

            int totalDays = termDays + (termMonths * 28);

            if (todayDays >= totalDays) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int getTotalDays(String dateStr) {
        String[] dateParts = dateStr.split("\\.");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);

        return (year * 12 * 28) + ((month - 1) * 28) + day;
    }
}
