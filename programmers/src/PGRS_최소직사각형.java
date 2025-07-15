public class PGRS_최소직사각형 {

    public int solution(int[][] sizes) {

        int widthMax = Integer.MIN_VALUE;
        int heightMin = Integer.MIN_VALUE;

        for (int i = 0; i < sizes.length; i++) {

            int maxSide = Math.max(sizes[i][0], sizes[i][1]);
            int minSide = Math.min(sizes[i][0], sizes[i][1]);

            widthMax = Math.max(widthMax, maxSide);
            heightMin = Math.max(heightMin, minSide);

        }

        return heightMin * widthMax;
    }
}
