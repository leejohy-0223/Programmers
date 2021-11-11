package pro68645;

import java.util.ArrayList;

public class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[][] triangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                triangle[i][j] = 0;
            }
        }

        int size = n;
        int i = 0, j = 0;
        int value = 1;
        while (size >= 1) {
            // 1. 아래방향 쓰기
            for (int k = i; k < i + size; k++) {
                triangle[k][j] = value++;
            }

            // 2. 오른쪽 방향 쓰기(->)
            for (int k = j + 1; k < j + size; k++) {
                triangle[i + size - 1][k] = value++;
            }

            // 3. 왼쪽 위방향 대각선 쓰기(i, j의 이동방향은 처음 i, j값에 의존하게 됨)
            for (int k = i + size - 2, l = j + size - 2; k > i && l > j; k--, l--) {
                triangle[k][l] = value++;
            }
            size -= 3;
            i += 2;
            j += 1;
        }
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                if(triangle[k][l] != 0) {
                    answer.add(triangle[k][l]);
                }
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(6);
    }
}
