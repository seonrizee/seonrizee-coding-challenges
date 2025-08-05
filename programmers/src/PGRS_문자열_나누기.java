class PGRS_문자열_나누기 {
    public int solution(String s) {

        int answer = 0;
        char startChar = ' ';
        int startCnt = 0;
        int otherCnt = 0;
        for (char cur : s.toCharArray()) {
            if (startCnt == 0) {
                startChar = cur;
                answer++;
            }

            if (startChar == cur) {
                startCnt++;
            } else {
                otherCnt++;
            }

            if (startCnt == otherCnt) {
                startCnt = 0;
                otherCnt = 0;
            }

        }

        return answer;
    }
}