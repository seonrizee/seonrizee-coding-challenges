import java.util.LinkedHashSet;
import java.util.Set;

public class PGRS_둘만의_암호 {

    public String solution(String s, String skip, int index) {
        Set<Character> pwCharsSet = new LinkedHashSet<>();

        for (char c = 'a'; c <= 'z'; c++) {
            pwCharsSet.add(c);
        }

        for (char c : skip.toCharArray()) {
            pwCharsSet.remove(c);
        }

        char[] pwChars = new char[pwCharsSet.size()];
        int idx = 0;
        for (Character c : pwCharsSet) {
            pwChars[idx++] = c;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int newIndex = c - 'a' + pwChars.length;
            for (int cnt = 0; cnt < index; cnt++) {
                newIndex++;
                if (newIndex >= pwChars.length) {
                    newIndex = 0;
                }
            }
            sb.append(pwChars[newIndex]);
        }

        return sb.toString();
    }
}