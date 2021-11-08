package pro17682;

import java.util.Stack;

public class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        while (idx < dartResult.length()) {
            int end = idx + 1;

            if (dartResult.substring(idx, end + 1).equals("10")) {
                end++;
            }

            while (end < dartResult.length() && !Character.isDigit(dartResult.charAt(end))) {
                end++;
            }

            // 이 시점에는 end가 digit을 가리키게 된다.
            String subset = dartResult.substring(idx, end);

            // 옵션 없다면 그냥 스택에 넣는다.
            if(!subset.contains("#") && !subset.contains("*")){
                stack.push(calValue(subset));
                idx = end;
                continue;
            }

            // 옵션 있다면, 처리한다.
            // * 옵션이면, 스택 맨 위에서 값도 2배해서 넣어준다.
            if (subset.charAt(2) == '*') {
                if(!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    stack.push(pop * 2);
                }
                stack.push(2 * calValue(subset));
            }

            // # 옵션이면, 계산된 값에 -2배를 진행한다.
            if (subset.charAt(2) == '#') {
                stack.push(-1 * calValue(subset));
            }
            idx = end;
        }

        // stack에서 값을 빼며 더해준다.
        for (Integer integer : stack) {
            answer += integer;
        }

        return answer;
    }

    private int calValue(String subset) {
        int value = subset.charAt(0) - '0';
        if (subset.contains("10")) {
            value = 10;
        }
        if (subset.contains("D")) {
            value = (int) Math.pow(value, 2);
        } else if (subset.contains("T")) {
            value = (int) Math.pow(value, 3);
        }
        return value;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.solution("1S2D*3T"));
        System.out.println(s.solution("10S10T10S"));
    }

}
