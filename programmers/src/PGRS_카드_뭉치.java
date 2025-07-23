public class PGRS_카드_뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int cards1Idx = 0;
        int cards2Idx = 0;
        for (String target : goal) {
            boolean found = false;

            if (cards1Idx >= cards1.length && cards2Idx >= cards2.length) {
                answer = "No";
                break;
            }

            if (cards1Idx < cards1.length && cards1[cards1Idx].equals(target)) {
                found = true;
                cards1Idx++;
            } else if (cards2Idx < cards2.length && cards2[cards2Idx].equals(target)) {
                found = true;
                cards2Idx++;
            }

            if (!found) {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}
