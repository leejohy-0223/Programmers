package pro17687;

public class Solution {

    static StringBuilder sb = new StringBuilder();
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        int pow = 1;
        int count, sum = 1;
        int target = t * m; // 최소 여기번째까지는 확인해야 한다.

        while (true) {
            count = (int) (Math.pow(n, pow) - Math.pow(n, pow - 1));
            sum += (pow * count);

            if (sum >= target) {
                break;
            }
            pow++;
        }

        // Math.pow(n, pow)까지 String을 만든다.
        int max = (int) Math.pow(n, pow);
        sb.append(0).append(1);

        for (int i = 2; i <= max; i++) {
            changeToN(i, n);
        }

        String s = sb.toString();
        for (int i = p-1; i <= target; i+=m) {
            answer.append(s.charAt(i));
        }
        return answer.substring(0, t);
    }

    private void changeToN(int n, int b) {

        StringBuilder tmp = new StringBuilder();

        while (n > b - 1) {
            int i = n % b;
            tmp.append(Integer.toHexString(i).toUpperCase());
            n /= b;
        }
        tmp.append(Integer.toHexString(n).toUpperCase());
        sb.append(tmp.reverse());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution(2, 4, 2, 1));
//        System.out.println(s.solution(16, 16, 2, 1));
        System.out.println(s.solution(16, 16, 2, 2));
    }
}
