import java.util.Optional;
import java.util.Set;

public class PGRS_옹알이_2 {

    public int solution(String[] babbling) {
        int answer = 0;
        String[] validWords = {"aya", "ye", "woo", "ma"};
        Set<String> validSet = Set.of(validWords);

        for (String target : babbling) {
            int curIdx = 0;
            String prevWord = "";

            while (true) {
                if (curIdx >= target.length()) {
                    answer++;
                    break;
                }

                Optional<String> validWord = isInSet(curIdx, target, validSet);

                if (validWord.isEmpty() || validWord.get().equals(prevWord)) {
                    break;
                }

                curIdx += validWord.get().length();
                prevWord = validWord.get();
            }

        }
        return answer;
    }

    private Optional<String> isInSet(int startIdx, String target, Set<String> validSet) {

        for (String validWord : validSet) {
            if (target.startsWith(validWord, startIdx)) {
                return Optional.of(validWord);
            }
        }

        return Optional.empty();
    }
}
