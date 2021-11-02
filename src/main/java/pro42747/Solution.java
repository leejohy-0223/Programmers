package pro42747;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int i : citations) {
            list.add(i);
        }
        list.sort(Collections.reverseOrder());

        int L = citations.length;

        while (L > 0) {
            int cnt = 0;

            for (int c : citations) {
                if(c >= L) {
                    cnt++;
                }
            }

            if (L <= cnt) {
                answer = L;
                break;
            }
            L--;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{3, 0, 6, 1, 5}));
//        System.out.println(s.solution(new int[]{3, 3, 2}));
    }
}
