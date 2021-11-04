package pro43162;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer++;
                queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        Integer poll = queue.poll();
                        for (int k = 0; k < n; k++) {
                            if (computers[poll][k] == 1 && !visited[k]) {
                                visited[k] = true;
                                queue.offer(k);
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
