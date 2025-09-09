import java.util.HashMap;
import java.util.Map;

public class PGRS_할인_행사 {

    public int solution(String[] want, int[] number, String[] discount) {

        final int MEMBERSHIP_DAYS = 10;
        int answer = 0;
        Map<String, Integer> nameToIdx = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            nameToIdx.put(want[i], i);
        }

        int cnt = 0;
        for (int i = 0; i < MEMBERSHIP_DAYS; i++) {
            String item = discount[i];
            if (nameToIdx.containsKey(item)) {
                int idx = nameToIdx.get(item);
                number[idx]--;
                if (number[idx] == 0) {
                    cnt++;
                }
            }
        }
        if (cnt == want.length) {
            answer++;
        }

        for (int i = 1; i <= discount.length - MEMBERSHIP_DAYS; i++) {

            // 제거
            String deleteItem = discount[i - 1];
            int deleteItemIdx = nameToIdx.getOrDefault(deleteItem, -1);
            if (deleteItemIdx != -1) {
                if (number[deleteItemIdx] == 0) {
                    cnt--;
                }
                number[deleteItemIdx]++;
            }

            // 추가
            String addItem = discount[i + 9];
            int addItemIdx = nameToIdx.getOrDefault(addItem, -1);
            if (addItemIdx == -1) {
                continue;
            }
            number[addItemIdx]--;
            if (number[addItemIdx] == 0) {
                cnt++;
            }

            // 검증
            if (cnt == want.length) {
                answer++;
            }
        }

        return answer;
    }
}
