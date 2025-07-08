import java.util.Comparator;
import java.util.stream.Collectors;

class PGRS_문자열_내림차순으로_배치하기 {
    public String solution(String s) {
        return s.chars() // 1. 문자열을 IntStream으로 변환 (각 문자의 아스키코드 값)
                .boxed() // 2. IntStream을 Stream<Integer>로 변환 (Comparator를 사용하기 위함)
                .sorted(Comparator.reverseOrder()) // 3. 역순(내림차순)으로 정렬
                .map(i -> String.valueOf((char) i.intValue())) // 4. 각 Integer를 다시 문자로 변환
                .collect(Collectors.joining()); // 5. 모든 문자를 하나의 문자열로 합침
    }
}