///programmers(빛의 경로 사이클) https://programmers.co.kr/learn/courses/30/lessons/86052
// 참고 : https://jisunshine.tistory.com/175
package pro86052;

import java.util.ArrayList;

public class Solution {
    static boolean[][][] isVisited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] grids;
    static int n, m;

    public int[] solution(String[] grid) {

        ArrayList<Integer> result = new ArrayList<>();

        n = grid.length;
        m = grid[0].length();

        grids = new char[n][m];
        isVisited = new boolean[n][m][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grids[i][j] = grid[i].charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!isVisited[i][j][k]) {
                        result.add(lightRoute(i, j, k));
                    }
                }
            }
        }
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        return result.stream().mapToInt(Integer::intValue).toArray();

    }

    private int lightRoute(int i, int j, int d) {
        int count = 0;

        while (!isVisited[i][j][d]) {

            isVisited[i][j][d] = true;
            count++;

            // 다음 방향 구하기
            if (grids[i][j] == 'L') {
                d = d == 0 ? 3 : d - 1;
            } else if (grids[i][j] == 'R') {
                d = d == 3 ? 0 : d + 1;
            }
            i = (i + dx[d] + n) % n;
            j = (j + dy[d] + m) % m;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String[] g1 = {"SL", "LR"};
        s.solution(g1);

    }
}
