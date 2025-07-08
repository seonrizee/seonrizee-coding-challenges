public class PGRS_부족한_금액_계산하기 {

    public long solution(int price, int money, int count) {

        long totalCost = 0;
        for (int i = 1; i <= count; i++) {
            totalCost += (long) i * price;
        }

        return totalCost > money ? totalCost - money : 0;
    }
}
