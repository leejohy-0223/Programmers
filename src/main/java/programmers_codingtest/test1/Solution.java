package programmers_codingtest.test1;

public class Solution {
    public int solution(String[] drum) {
        int answer = 0;

        int L = drum.length;
        char[][] board = new char[L][L];

        for (int i = 0; i < L; i++) {
            char[] chars = drum[i].toCharArray();
            System.arraycopy(chars, 0, board[i], 0, L);
        }

        for (int i = 0; i < L; i++) {
            int startX = 0;
            int startY = i;

            boolean chk = false;
            char now;
            while (true) {
                now = board[startX][startY];
                if (now == '#') {
                    startX++;
                    if (startX == L) {
                        answer++;
                        break;
                    }
                }
                if (now == '*') {
                    if (chk) break;
                    chk =true;
                    startX++;
                    if (startX == L) {
                        answer++;
                        break;
                    }
                }
                if (now == '>') {
                    startY++;
                }
                if (now == '<') {
                    startY--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution(new String[] {"######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"});
        System.out.println("solution = " + solution);
    }

}
