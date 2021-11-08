package pro17682;

import java.util.Stack;

public class SolutionRef {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < dartResult.length(); i++) {
            // 숫자일 때만 스택에 넣는다.
            if (dartResult.charAt(i) == '1') {
                if (dartResult.charAt(i + 1) == '0') {
                    stack.push(10);
                    i++;
                } else {
                    stack.push(1);
                }
                continue;
            }

            if (Character.isDigit(dartResult.charAt(i))) {
                stack.push(dartResult.charAt(i) - '0');
                continue;
            }

            Integer pop, pop2;
            switch (dartResult.charAt(i)) {
                case 'D':
                    pop = stack.pop();
                    stack.push((int) Math.pow(pop, 2));
                    break;
                case 'T':
                    pop = stack.pop();
                    stack.push((int) Math.pow(pop, 3));
                    break;
                case 'S':
                    break;
                case '*':
                    pop = stack.pop();
                    if (!stack.isEmpty()) {
                        pop2 = stack.pop();
                        stack.push(2 * pop2);
                    }
                    stack.push(2 * pop);
                    break;
                case '#':
                    pop = stack.pop();
                    stack.push(-1 * pop);
                    break;
            }
        }

        for (Integer integer : stack) {
            answer += integer;
        }
        return answer;
    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
//        System.out.println(s.solution("1S2D*3T"));
        System.out.println(s.solution("10S10T10S"));
    }
}