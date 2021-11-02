package pro42842;

public class Solution {

    public int[] solution(int brown, int yellow) {

        int halfB = brown / 2;
        for (int i = 1; i <= halfB / 2; i++) {
            int garo = halfB - i;

            if (garo * (i + 2) - brown == yellow) {
                return new int[]{garo, i + 2};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(10, 2);
        s.solution(8, 1);
        s.solution(24, 24);
    }
}
