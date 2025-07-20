public class PGRS_2016년 {

    public String solution(int a, int b) {
        int[] daysInMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] weekDays = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int diffDays = 0;
        diffDays += b - 1;
        for (int m = 1; m < a; m++) {
            diffDays += daysInMonth[m];

        }

        return weekDays[diffDays % 7];
    }
}
