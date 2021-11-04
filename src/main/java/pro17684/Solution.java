package pro17684;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    static Map<String, Integer> map = new HashMap<>();

    public int[] solution(String msg) {

        char first = 'A';
        for (int i = 1; i <= 26; i++) {
            map.put(first + "", i);
            first++;
        }

        ArrayList<Integer> arr = new ArrayList<>();

        int left = 0, right = 0;
        int value = 27;

        while (left < msg.length()) {

            // left가 맨 끝을 가리키면 이거 시행
            if (left == msg.length() - 1) {
                arr.add(map.get(msg.charAt(left) + ""));
                break;
            }

            // right 변경하며 체크해보기
            right++;
            while (right < msg.length()) {
                String sub = msg.substring(left, right + 1);

                if (map.containsKey(sub)) {
                    // sub를 가지는데, right가 맨 마지막이라면,
                    if (right == msg.length() - 1) {
                        arr.add(map.get(sub));
                        left = right + 1;
                        break;
                    }
                    // sub를 가지는데, right가 마지막이 아니라면
                    right++;
                } else { // sub를 안가진다면,
                    // 만약 left, right가 한자리였다면,
                    if (left + 1 == right) {
                        arr.add(map.get(msg.charAt(left) + ""));
                    } else {
                        String newSub = msg.substring(left, right);
                        arr.add(map.get(newSub));
                    }
                    map.put(sub, value++);
                    left = right;
                }
            }
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("ABABABABABABABAB");
    }
}
