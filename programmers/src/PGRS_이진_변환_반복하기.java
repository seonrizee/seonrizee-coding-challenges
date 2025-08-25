public class PGRS_이진_변환_반복하기 {

    public int[] solution(String s) {
        int transformCount = 0;
        int removedZeroCount = 0;

        String currentS = s;

        while (!"1".equals(currentS)) {
            int oneCount = 0;
            for (char c : currentS.toCharArray()) {
                if (c == '0') {
                    removedZeroCount++;
                } else {
                    oneCount++;
                }
            }

            currentS = Integer.toBinaryString(oneCount);
            transformCount++;
        }

        return new int[]{transformCount, removedZeroCount};
    }
}
