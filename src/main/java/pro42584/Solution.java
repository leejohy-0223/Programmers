package pro42584;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int[] solution(int[] prices) {
        int L = prices.length;
        int[] answer = new int[L];

        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.offer(price);
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();
            int count = 0;
            for (Integer integer : queue) {
                if (integer >= now) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer[idx++] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(new int[]{1, 2, 3, 2, 3, 1}); // 5, 4, 1, 2, 1, 0
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
