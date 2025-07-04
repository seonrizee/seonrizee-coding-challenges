import java.util.*;

public class PGRS_연속된_수의_합 {

  public int[] solution(int num, int total) {
    List<Integer> answer = new ArrayList<Integer>();

    for (int startNumber = -1000; startNumber <= 1000; startNumber++) {
      int sum = 0;
      int tempNumber = startNumber;
      for (int i = 0; i < num; i++) {
        sum += tempNumber;
        tempNumber++;
      }
      if (sum == total) {
        for (int i = 0; i < num; i++) {
          answer.add(startNumber);
          startNumber++;
        }
        break;
      }
    }
    return answer.stream().mapToInt(Integer::intValue).toArray();
  }

  class SolutionTwo {
    public int[] solution(int num, int total) {
      int[] answer = new int[num];

      // 등차수열 합 공식을 이용해 시작 숫자(startNumber)를 계산
      // total = num * startNumber + (num * (num - 1) / 2)
      int startNumber = (total / num) - (num - 1) / 2;

      // 계산된 시작 숫자부터 num개의 정수를 배열에 채워넣기
      for (int i = 0; i < num; i++) {
        answer[i] = startNumber + i;
      }

      return answer;
    }
  }
}
