public class PGRS_문자열_다루기_기본 {

    public boolean solution(String s) {

        char[] charArr = s.toCharArray();

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (char cur : charArr) {
            if (!Character.isDigit(cur)) {
                return false;
            }
        }

        return true;
    }
}
