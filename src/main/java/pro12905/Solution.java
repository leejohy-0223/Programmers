package pro12905;

public class Solution {

    public int solution(int[][] board) {

        if (isAllZero(board)) {
            return 0;
        }

        int answer = 1;

        int N = board.length;
        int M = board[0].length;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (board[i][j] == 0) continue;

                // 1일 경우, 여기부터 크기 늘려가며 최대값 찾기
                int size = Math.min(N - i - 1, M - j - 1);
                int tempArea = 1;
                boolean chk = true;
                for (int k = 1; k <= size; k++) {

                    // i를 i+k로 고정
                    for (int l = j; l <= j + k; l++) {
                        if (board[i + k][l] != 1) {
                            chk = false;
                            break;
                        }
                    }

                    // j를 j+k로 고정
                    if (chk) {
                        for (int l = i; l <= i + k; l++) {
                            if (board[l][j + k] != 1) {
                                chk = false;
                                break;
                            }
                        }
                    }

                    if(!chk) {
                        tempArea = (int) Math.pow(k, 2);
                        break;
                    } else {
                        tempArea = (int) Math.pow(k + 1, 2);
                    }
                }
                answer = Math.max(answer, tempArea);
            }
        }

        return answer;
    }

    private static boolean isAllZero(int[][] board) {
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (ints[j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(getBoard("[[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,0]]", 4, 4)));
//        System.out.println(s.solution(getBoard("[[1,1,1,0,0,0,0],[1,1,1,0,1,1,1],[1,1,1,0,1,1,1],[0,0,0,0,1,1,1]]", 4, 7)));

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
