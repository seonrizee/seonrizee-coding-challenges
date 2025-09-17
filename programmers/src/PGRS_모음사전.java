import java.util.HashMap;
import java.util.Map;

public class PGRS_모음사전 {

    public int solution(String word) {
        String[] targets = {"A", "E", "I", "O", "U"};

        Map<String, Integer> wordToOrder = new HashMap<>();

        dfs("", 0, targets, wordToOrder);
        return wordToOrder.get(word);
    }

    private void dfs(String s, int i, String[] targets, Map<String, Integer> wordToOrder) {

        if (i == 5) {
            return;
        }

        for (String m : targets) {
            String newWord = s + m;
            wordToOrder.put(newWord, wordToOrder.size() + 1);
            dfs(newWord, i + 1, targets, wordToOrder);
        }
    }
}
