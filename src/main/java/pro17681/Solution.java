package pro17681;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            int result = arr1[i] | arr2[i];
            StringBuilder s = new StringBuilder(Integer.toBinaryString(result));
            while (s.length() != n) {
                s.insert(0, "0");
            }
            s = new StringBuilder(s.toString().replaceAll("1", "#"));
            s = new StringBuilder(s.toString().replaceAll("0", " "));
            answer[i] = s.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        s.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        s.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
    }
}
