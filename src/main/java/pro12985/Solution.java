package pro12985;

public class Solution {
    public int solution(int n, int a, int b) {
        int start = 1;
        int end = n;
        int divide;
        int pow = getPow(n); // 승수 계산

        while (pow != 1) {
            divide = (start + end) / 2;
            // 두 수가 divide보다 크다면 start 올리기
            if (divide < a && divide < b) {
                start = divide + 1;
                pow--;
                continue;
                // 두 수가 divide보다 작다면 end 내리기
            } else if (divide >= a && divide >= b) {
                end = divide;
                pow--;
                continue;
            }

            // 두 수가 다른 쪽에 있다면,
            return pow;

        }
        // while에서 빠져나왔다면 바로 옆에 있으므로 return 1
        return 1;
    }

    private int getPow(int n) {
        int pow = 0;
        while (n != 1) {
            pow++;
            n /= 2;
        }
        return pow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(8, 1, 4));
    }
}
