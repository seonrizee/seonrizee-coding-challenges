import java.util.HashMap;
import java.util.Map;

public class PGRS_달리기_경주 {

    public String[] solution(String[] players, String[] callings) {

        Map<Integer, String> rankToPlayer = new HashMap<>();
        Map<String, Integer> playerToRank = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            rankToPlayer.put(i + 1, players[i]);
            playerToRank.put(players[i], i + 1);
        }

        for (int i = 0; i < callings.length; i++) {
            String targetName = callings[i];
            int targetRank = playerToRank.get(targetName);
            String frontTargetName = rankToPlayer.get(targetRank - 1);
            int frontTargetRank = targetRank - 1;

            rankToPlayer.put(targetRank, frontTargetName);
            rankToPlayer.put(frontTargetRank, targetName);
            playerToRank.put(frontTargetName, targetRank);
            playerToRank.put(targetName, frontTargetRank);
        }

        String[] answer = new String[players.length];
        for (int i = 0; i < rankToPlayer.size(); i++) {
            answer[i] = rankToPlayer.get(i + 1);
        }

        return answer;
    }
}
