package pro87946;

public class Solution {

    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0);
        return answer;
    }

    private void dfs(int tired, int[][] dungeons, int cnt) {
        // [0] : 최소 필요 피로도, [1] : 소모 피로도
        // 피로도 소모하기
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > tired) continue;
            visited[i] = true;
            dfs(tired - dungeons[i][1], dungeons, cnt + 1);
            visited[i] = false;
        }

        answer = Math.max(answer, cnt);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(80, getBoard("[[80,20],[50,40],[30,10]]", 3, 2)));
    }

    private static int[][] getBoard(String tmp, int isize, int jsize) {
        tmp = tmp.substring(2, tmp.length() - 2);
        int[][] board = new int[isize][jsize];
        String[] split = tmp.split("],\\[");

        for (int i = 0; i < isize; i++) {
            String[] split1 = split[i].split(",");
            for (int j = 0; j < jsize; j++) {
                board[i][j] = Integer.parseInt(split1[j]);
            }
        }
        return board;
    }
}
