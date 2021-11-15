package pro86971;

public class SolutionSimple {
    int N, min;
    int[][] map;
    int[] vst;
    
    public int solution(int n, int[][] wires) {
        N = n;
        min = n;
        map = new int[n+1][n+1];
        vst = new int[n+1];
        for(int[] wire : wires) {
            int a = wire[0], b = wire[1];
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        return min;
    }

    private int dfs(int n) {
        vst[n] = 1;
        int child = 1;
        for (int i = 1; i <= N; i++) {
            if (vst[i] == 0 && map[n][i] == 1) {
                vst[i] = 1;
                child += dfs(i);
            }
        }
        System.out.println("n = " + n);
        System.out.println("child = " + child);
        System.out.println();
        min = Math.min(min, Math.abs(child - (N - child)));
        return child;
    }

    public static void main(String[] args) {
        SolutionSimple s = new SolutionSimple();
        int solution = s.solution(9, getBoard("[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]", 8, 2));
        System.out.println(solution);
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