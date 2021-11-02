package pro17679;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};
    static boolean finChk = true;
    static char[][] arr;
    static int answer;
    static boolean[][] chk;
    static int mSize, nSize;

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int m, int n, String[] board) {
        answer = 0;
        mSize = m;
        nSize = n;
        arr = new char[m][n];

        for (int i = 0; i < m; i++) {
            String s = board[i];
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        while (finChk) {
            finChk = false;
            chk = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if(arr[i][j] != '0') {
                        blockErase(i, j);
                    }
                }
            }
            // blockErase 과정에서 아무 블록도 사라지지 않았다면 break
            if(!finChk) break;

            // chk 대상으로 블록 지우기
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (chk[i][j]) {
                        answer++;
                        arr[i][j] = '0';
                    }
                }
            }
            // 재 정렬 진행
            reArr();
//            for (int i = 0; i < m; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }

        return answer;
    }

    private void reArr() {

        StringBuilder sb;
        for (int j = 0; j < nSize; j++) {
            sb = new StringBuilder();
            for (int i = mSize - 1; i >= 0 ; i--) {
                if (arr[i][j] != '0') {
                    sb.append(arr[i][j]);
                }
            }
            int idx = 0;
            String s = sb.toString();
            while (idx != s.length()) {
                arr[mSize - idx - 1][j] = s.charAt(idx);
                idx++;
            }
            for (int i = mSize - idx - 1; i >= 0; i--) {
                arr[i][j] = '0';
            }
        }

    }

    private void blockErase(int i, int j) {

        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(i, j));
        char ref = arr[i][j];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int count = 0;
                Position poll = queue.poll();
                for (int l = 0; l < 3; l++) {
                    int nx = poll.x + dx[l];
                    int ny = poll.y + dy[l];

                    if (nx >= 0 && ny >= 0 && nx < mSize && ny < nSize && arr[nx][ny] == ref) {
                        count++;
                    }
                }

                if (count != 3) continue;

                chk[poll.x][poll.y] = true;
                finChk = true;

                for (int l = 0; l < 3; l++) {
                    int nx = poll.x + dx[l];
                    int ny = poll.y + dy[l];
                    if(!chk[nx][ny]) {
                        chk[nx][ny] = true;
                        queue.offer(new Position(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] bd = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] bd1 = {"ABCD", "BACE", "BCDD", "BCDD"};
        String[] bd2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        String[] bd3 = {"HGNHU", "CRSHV", "UKHVL", "MJHQB", "GSHOT", "MQMJJ", "AGJKK", "QULKK"};
//        String[] bd2 = {"AA", "CA"};

//        System.out.println(s.solution(4, 5, bd));
        System.out.println(s.solution(6, 6, bd2));
//        System.out.println(s.solution(2, 2, bd2));
//        System.out.println(s.solution(4, 4, bd1));
//        System.out.println(s.solution(8, 5, bd3));


    }
}
