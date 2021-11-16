package pro68936;

public class Solution {
    public static int[] answer = new int[2];

    public int[] solution(int[][] arr) {

        quadTree(0, 0, arr.length, arr);

        return answer;
    }

    private void quadTree(int i, int j, int size, int[][] arr) {

        // 만약 해당 범위에서 쿼드가 맞다면
        if (quadCheck(i, j, size, arr)) {
            answer[arr[i][j]]++;
        } else {
            // 사이즈 줄여서 재 탐색
            int nSize = size / 2;

            for (int k = i; k <= i + nSize; k += nSize) {
                for (int l = j; l <= j + nSize; l += nSize) {
                    quadTree(k, l, nSize, arr);
                }
            }
        }
    }

    private boolean quadCheck(int i, int j, int size, int[][] arr) {
        int ref = arr[i][j];
        for (int k = i; k < i + size; k++) {
            for (int l = j; l < j + size; l++) {
                if (arr[k][l] != ref) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "[[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]";

        Solution s1 = new Solution();
        int[] solution = s1.solution(getBoard(s, 4, 4));

        for (int i : solution) {
            System.out.println(i);
        }
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
