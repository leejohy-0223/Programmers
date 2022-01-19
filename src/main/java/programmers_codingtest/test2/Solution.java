package programmers_codingtest.test2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int n, String[] recipes, String[] orders) {
        int answer = 0;

        Map<String, Integer> recipe = new HashMap<>();

        int[] fire = new int[n];

        for (String s : recipes) {
            String[] split = s.split(" ");
            recipe.put(split[0], Integer.parseInt(split[1]));
        }

        for (String order : orders) {
            String[] s = order.split(" ");
            String orderMenu = s[0];
            int orderTime = Integer.parseInt(s[1]);

            boolean nextChk = false;

            for (int i = 0; i < n; i++) {
                if (fire[i] <= orderTime) {
                    fire[i] = orderTime + recipe.get(orderMenu);
                    answer = fire[i];
                    nextChk = true;
                    break;
                }
            }
            if (nextChk) {
                continue;
            }

            // 화로가 비지 않았을 경우, 가장 빨리 끝나는 화로 찾기
            int minFire = Arrays.stream(fire).min().getAsInt();
            int minIdx = 0;

            for (int i = 0; i < n; i++) {
                if (fire[i] == minFire) {
                    minIdx = i;
                    break;
                }
            }

            // 해당 화로로 갱신하기
            fire[minIdx] += recipe.get(orderMenu);
            answer = fire[minIdx];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // 2, ["A 3", "B 2"], ["A 1", "A 2", "B 3", "B 4"]
        int solution = s.solution(2, new String[] {"A 3", "B 2"}, new String[] {"A 1", "A 2", "B 3", "B 4"});
        System.out.println("solution = " + solution);
    }
}
