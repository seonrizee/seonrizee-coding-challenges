public class PGRS_크기가_작은_부분문자열 {

    public int solution(String t, String p) {

        int answer = 0;
        int tLength = t.length();
        int pLength = p.length();

        long pValue = Long.parseLong(p);
        for (int idx = 0; idx <= tLength - pLength; idx++) {
            long tCurValue = Long.parseLong(t.substring(idx, idx + pLength));
            if (pValue >= tCurValue) {
                answer++;
            }
        }

        return answer;
    }

}
