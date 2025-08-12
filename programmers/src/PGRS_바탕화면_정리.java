public class PGRS_바탕화면_정리 {

    public int[] solution(String[] wallpaper) {

        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int bottom = Integer.MIN_VALUE;

        for (int r = 0; r < wallpaper.length; r++) {
            for (int c = 0; c < wallpaper[0].length(); c++) {

                if (wallpaper[r].charAt(c) == '#') {
                    top = Math.min(top, r);
                    left = Math.min(left, c);
                    right = Math.max(right, c);
                    bottom = Math.max(bottom, r);
                }
            }
        }

        return new int[]{top, left, bottom + 1, right + 1};
    }
}
