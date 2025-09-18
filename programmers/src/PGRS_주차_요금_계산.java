import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PGRS_주차_요금_계산 {

    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> parkingMap = new HashMap<>();
        Map<String, Integer> totalTimeMap = new TreeMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String time = split[0];
            String carNum = split[1];
            String inOut = split[2];

            String[] timeSplit = time.split(":");
            int hour = Integer.parseInt(timeSplit[0]);
            int minute = Integer.parseInt(timeSplit[1]);
            int totalMinute = hour * 60 + minute;

            if (inOut.equals("IN")) {
                parkingMap.put(carNum, totalMinute);
            } else {
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + (totalMinute - parkingMap.get(carNum)));
                parkingMap.remove(carNum);
            }
        }

        for (String carNum : parkingMap.keySet()) {
            int inTime = parkingMap.get(carNum);
            int totalMinute = (23 * 60 + 59) - inTime;
            totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + totalMinute);
        }

        int[] answer = new int[totalTimeMap.size()];
        int i = 0;
        for (Integer time : totalTimeMap.values()) {
            answer[i++] = calculateFee(time, fees);
        }

        return answer;
    }

    private int calculateFee(int totalTime, int[] fees) {

        int baseMinute = fees[0];
        int baseFee = fees[1];
        int unitMinute = fees[2];
        int unitFee = fees[3];

        if (totalTime <= baseMinute) {
            return baseFee;
        }

        int overTime = totalTime - baseMinute;
        int overTimeFee = baseFee + overTime / unitMinute * unitFee;
        if (overTime % unitMinute != 0) {
            overTimeFee += unitFee;
        }

        return overTimeFee;
    }
}
