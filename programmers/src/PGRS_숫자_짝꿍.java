public class PGRS_숫자_짝꿍 {

    public String solution(String X, String Y) {

        int[] xCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] yCnt = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (char x : X.toCharArray()) {
            int num = x - '0';
            xCnt[num]++;
        }
        for (char y : Y.toCharArray()) {
            int num = y - '0';
            yCnt[num]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int number = 9; number >= 0; number--) {
            int minCnt = Math.min(xCnt[number], yCnt[number]);
            for (int i = 0; i < minCnt; i++) {
                sb.append(number);
            }
        }

        if (sb.length() == 0) {
            return "-1";
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
