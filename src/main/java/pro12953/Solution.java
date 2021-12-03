package pro12953;

public class Solution {

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int gcd = getGCD(answer, arr[i]);
            answer = ((answer * arr[i]) / gcd);
        }

        return answer;
    }

    public static int getGCD(int a, int b) {
        while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution(new int[] {2, 7, 8, 14});
        System.out.println("solution = " + solution);
    }
}
