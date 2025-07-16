public class PGRS_시저_암호 {

    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!Character.isLetter(c)) {
                sb.append(c);
                continue;
            }

            char newChar;
            if (Character.isUpperCase(c)) {
                newChar = (char) (((c - 'A' + n) % 26) + 'A');
            } else {
                newChar = (char) (((c - 'a' + n) % 26) + 'a');
            }

            sb.append(newChar);
        }

        return sb.toString();
    }
}