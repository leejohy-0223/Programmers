package pro12905;

public class SolutionRef {

    public static int solution(int[][] board) {
        if (isAllZero(board)) {
            return 0;
        }
        int answer = 1;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 0) continue;

                // 현 위치 기준, 왼쪽, 위, 좌상 부분을 검사해서 최솟값의 +1만큼 더해주면 된다.
                board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
                answer = Math.max(answer, board[i][j]);
            }
        }
        return answer * answer;
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

}
