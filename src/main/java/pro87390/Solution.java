package pro87390;

import java.util.ArrayList;
import java.util.List;

public class
Solution {
    public int[] solution(int n, long left, long right) {

        List<Integer> list = new ArrayList<>();
        int idx = 0;
        int sValue = (int) (left / n) + 1; // 시작 value
        long startCount = (left / n) * n; // 이전 row까지의 개수

        for (int i = sValue; i <= n; i++) {
            // 해당 수와 동일한 만큼 반복
            for (int j = 0; j < i; j++) {
                // 탈출조건 명시
                if (right == startCount) {
                    list.add(i);
                    return list.stream().mapToInt(Integer::intValue).toArray();
                }
                // left보다 같거나 클때만 갱신
                if (left <= startCount) {
                    list.add(i);
                }
                // 아니면 startCount만 올리기
                startCount++;
            }

            // 나머지 반복
            int nValue = i + 1;
            for (int j = 0; j < n - i; j++) {
                if (right == startCount) {
                    list.add(nValue);
                    return list.stream().mapToInt(Integer::intValue).toArray();
                }
                if (left <= startCount) {
                    list.add(nValue);
                }
                nValue++; // 여기는 이것도 올려줘야 함
                startCount++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(4, 7, 14);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
