import java.util.Arrays;


public class PGRS_문자열_내림차순으로_배치하기 {

    public String solution(String s) {
        
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb = new StringBuilder(String.valueOf(charArr));

        return sb.reverse().toString();
    }
}
