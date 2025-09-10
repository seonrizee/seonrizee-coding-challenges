import java.util.Map;

public class PGRS_의상 {

    public int solution(String[][] clothes) {

        Map<String, Integer> categoryCountMap = new java.util.HashMap<>();
        for (String[] cloth : clothes) {
            String category = cloth[1];
            categoryCountMap.put(category, categoryCountMap.getOrDefault(category, 0) + 1);
        }

        return categoryCountMap.values()
                .stream()
                .map(cnt -> cnt + 1)
                .reduce(1, (a, b) -> a * b) - 1;
    }
}
