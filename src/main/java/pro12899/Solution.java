package pro12899;

import java.util.Stack;

class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int num = n;
        int[] item = {4, 1, 2};

        while(true) {
            if(num == 1 || num == 2) {
                stack.push(num);
                break;
            }
            if(num == 3) {
                stack.push(0);
                break;
            }

            if(num % 3 == 0) {
                stack.push(0);
                num = (num / 3) - 1;
                continue;
            }
            stack.push(num % 3);
            num = num / 3;
        }
        while(!stack.isEmpty()) {
            sb.append(item[stack.pop()]);
        }
        answer = sb.toString();

        return answer;
    }
}