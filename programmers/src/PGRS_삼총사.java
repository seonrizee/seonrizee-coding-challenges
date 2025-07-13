public class PGRS_삼총사 {

    public int solution(int[] number) {

        int[] answer = new int[]{0};

        combination(number, new int[3], 0, 0, answer);
        return answer[0];
    }

    private void combination(int[] number, int[] selectedNumber, int startIdx, int selectedCnt, int[] answer) {
        if (selectedCnt == 3) {
            if (selectedNumber[0] + selectedNumber[1] + selectedNumber[2] == 0) {
                answer[0]++;
            }
            return;
        }
        for (int i = startIdx; i < number.length; i++) {
            selectedNumber[selectedCnt] = number[i];
            combination(number, selectedNumber, i + 1, selectedCnt + 1, answer);
        }
    }
}
