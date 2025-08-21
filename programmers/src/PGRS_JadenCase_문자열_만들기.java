public class PGRS_JadenCase_문자열_만들기 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String lowerS = s.toLowerCase();
        boolean isFirst = true;
        for (char c : lowerS.toCharArray()) {

            if (isFirst) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(c);
            }

            isFirst = (c == ' ');
        }
        return sb.toString();
    }
}
