package pro64061;

import java.util.Stack;

public class Solution_W3 {
    public int solution(int[][] board, int[] moves) {
        int depth = board.length;
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int position = move - 1;
            for (int i = 0; i < depth; i++) {
                int value = board[i][position];
                if (value == 0) {
                    continue;
                }
                board[i][position] = 0;
                if (!stack.isEmpty() && stack.peek() == value) {
                    stack.pop();
                    result += 2;
                    break;
                }
                stack.push(value);
                break;
            }
        }
        return result;
    }
}
