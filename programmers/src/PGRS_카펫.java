public class PGRS_카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        int totalGrid = brown + yellow;
        // c >= r
        for (int width = 1; width <= totalGrid; width++) {
            if (totalGrid % width != 0) {
                continue;
            }
            int height = totalGrid / width;
            if (width >= height && (height - 2) * (width - 2) == yellow) {
                answer = new int[]{width, height};
                break;
            }
        }
        return answer;
    }
}
