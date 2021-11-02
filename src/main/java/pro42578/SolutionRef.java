package pro42578;

import java.util.Arrays;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class SolutionRef {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] i1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(s.solution(i1));

    }
}
