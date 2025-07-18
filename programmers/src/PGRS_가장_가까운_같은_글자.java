public class PGRS_가장_가까운_같은_글자 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] lastIdx = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int alphabetIdx = c - 'a';

            if (lastIdx[alphabetIdx] == 0) {
                answer[i] = -1;
            } else {
                answer[i] = i - lastIdx[alphabetIdx] + 1;
            }

            lastIdx[alphabetIdx] = i + 1;
        }

        return answer;
    }
}
