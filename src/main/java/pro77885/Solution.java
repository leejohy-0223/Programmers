package pro77885;

public class Solution {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int i = 0;
        for (long number : numbers) {
            // 다음 넘버와 계속 비교
            // 짝수라면 바로 그 다음 숫자를 가리킴
            if (number % 2 == 0) {
                answer[i] = number + 1;
                i++;
                continue;
            }

            // 홀수일 경우,
            StringBuilder sb = new StringBuilder("0" + Long.toBinaryString(number));
            for (int j = sb.length() - 1; j >= 0; j--) {
                if (sb.charAt(j) == '0') {
                    sb.setCharAt(j, '1');
                    sb.setCharAt(j + 1, '0');
                    break;
                }
            }
            answer[i] = Long.parseLong(sb.toString(), 2);
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long[] numbers = {3, 7};
        long[] solution = s.solution(numbers);
        for (long l : solution) {
            System.out.println(l);
        }

    }
}
