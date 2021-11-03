package pro17680;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static Queue<String> queue = new LinkedList<>();
    static int answer = 0;

    public int solution(int cacheSize, String[] cities) {

        for (String city : cities) {
            // 사이즈가 충분할 경우
            String s = city.toLowerCase();

            if (cacheSize == 0) {
                answer += 5;
                continue;
            }

            if (queue.size() < cacheSize) {
                // 큐에 포함되어있지 않다면, miss
                if (!queue.contains(s)) {
                    queue.offer(s);
                    answer += 5;
                } else { // 포함되어 있다면, hit & 최신 처리 필요
                    hitProcess(s);
                }
                continue;
            }

            // 사이즈가 꽉 찼을 경우
            // cache hit
            if (queue.contains(s)) {
                hitProcess(s);
                continue;
            }

            // cache miss
            queue.poll();
            queue.offer(s);
            answer += 5;

        }
        return answer;
    }

    private void hitProcess(String s) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String poll = queue.poll();
            if (!poll.equals(s)) {
                queue.offer(poll);
            }
        }
        queue.offer(s);
        answer += 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(0, new String[]{"LA", "LA"}));

    }
}
