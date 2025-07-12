public class PGRS_이상한_문자_만들기 {

    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        int wordIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                wordIdx = 0;
            } else {
                if (wordIdx % 2 == 0) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }
                wordIdx++;
            }
        }
        return sb.toString();
    }
}
