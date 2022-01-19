package pro42840;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[] result = new int[3];

        int[][] map = new int[3][];
        map[0] = new int[] {1, 2, 3, 4, 5};
        map[1] = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        map[2] = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < 3; i++) {
            int[] curMath = map[i];
            int length = curMath.length;
            int startIdx = 0;

            while (startIdx < answers.length) {
                for (int j = startIdx, k = 0; j < startIdx + length; j++, k++) {
                    if (j >= answers.length) {
                        break;
                    }
                    if (answers[j] == curMath[k]) {
                        result[i]++;
                    }
                }
                startIdx += length;
            }
        }
        List<Integer> list = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (result[i] < maxValue) {
                continue;
            }
            if (result[i] > maxValue) {
                maxValue = result[i];
                list = new ArrayList<>();
            }
            list.add(i + 1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(new int[] {4});
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
