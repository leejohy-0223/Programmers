package pro43163;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] chk = new boolean[words.length];

        List<String> strings = Arrays.asList(words);
        if (!strings.contains(target)) {
            return answer;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);

        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < words.length; j++) {
                    if (!chk[j]) {
                        int result = compare(poll, words[j]);

                        // 하나만 다를 경우에만 큐에 넣기
                        if (result == begin.length() - 1) {
                            if (words[j].equals(target)) {
                                return answer;
                            }
                            queue.offer(words[j]);
                            chk[j] = true;
                        }
                    }
                }
            }
        }
        answer = 0;
        return answer;
    }

    private int compare(String cur, String target) {
        int count = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == target.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
