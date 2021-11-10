package pro64061;

import java.util.Stack;

public class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int L = board.length;

        for (int now : moves) {
            for (int i = 0; i < L; i++) {
                int value = board[i][now - 1];
                if (value != 0) {
                    if (!stack.isEmpty() && stack.peek() == value) {
                        answer += 2;
                        stack.pop();
                        board[i][now - 1] = 0;
                        break;
                    } else {
                        stack.push(value);
                        board[i][now - 1] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String tmp = "[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]";

        // ------------이차원 int 배열 만들기------------------
        int isize = 5, jsize = 5;
        int[][] board = getBoard(tmp, isize, jsize);
        // ------------------------------------------------

        int[] move = {1,5,3,5,1,2,1,4};

        System.out.println(s.solution(board, move));
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
