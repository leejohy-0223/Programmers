package pro12981;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        int idx = 1;
        String word1 = words[0];
        char finWord = word1.charAt(0);
        for (String word : words) {
            // 포함된 단어이거나, 끝말잇기가 안되는 단어라면, 끝내기
            if (set.contains(word) || (finWord != word.charAt(0))) {
                if (idx % n == 0) {
                    answer[0] = n;
                    answer[1] = idx / n;
                } else {
                    answer[0] = idx % n;
                    answer[1] = (idx / n) + 1;
                }
                break;
            }
            set.add(word);
            finWord = word.charAt(word.length() - 1);
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"});
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
