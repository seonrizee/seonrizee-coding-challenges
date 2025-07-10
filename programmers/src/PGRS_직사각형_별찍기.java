import java.util.Scanner;
import java.util.stream.IntStream;

public class PGRS_직사각형_별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt();
        int R = sc.nextInt();

        String row = "*".repeat(C);
        IntStream.range(0, R).forEach(i -> System.out.println(row));
    }
}
