import java.util.stream.IntStream;

public class PGRS_크기가_작은_부분문자열 {

    public int solution(String t, String p) {

        int tLength = t.length();
        int pLength = p.length();

        long pValue = Long.parseLong(p);
        return (int) IntStream.rangeClosed(0, tLength - pLength)
                .mapToLong(idx -> Long.parseLong(t.substring(idx, idx + pLength)))
                .filter(tValue -> tValue <= pValue)
                .count();
    }

}
