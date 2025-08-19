import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PGRS_신고_결과_받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));
        Map<String, Set<String>> toReportMap = new HashMap<>();
        Map<String, Integer> reportCounts = new HashMap<>();
        Set<String> vanUsers = new HashSet<>();

        for (String s : id_list) {
            toReportMap.put(s, new HashSet<>());
            reportCounts.put(s, 0);
        }

        for (String s : uniqueReports) {
            String[] segments = s.split(" ");
            String reporter = segments[0];
            String reported = segments[1];

            toReportMap.get(reporter).add(reported);
            reportCounts.put(reported, reportCounts.get(reported) + 1);
        }

        for (String s : id_list) {
            if (reportCounts.get(s) >= k) {
                vanUsers.add(s);
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            String curReporter = id_list[i];
            Set<String> reportedSet = toReportMap.get(curReporter);
            int cnt = 0;

            for (String reportedUser : reportedSet) {
                if (vanUsers.contains(reportedUser)) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        return answer;
    }
}
