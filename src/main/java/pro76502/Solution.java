package pro76502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        Queue<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            queue.offer(aChar);
        }

        Stack<Character> stack;
        int count = 0;
        int innerCount;
        while (count < s.length()) {
            stack = new Stack<>();
            innerCount = 0;
            for (Character cur : queue) {
                if (cur == '(' || cur == '{' || cur == '[') {
                    stack.push(cur);
                    innerCount++;
                    continue;
                }
                if (stack.isEmpty() && (cur == ')' || cur == '}' || cur == ']')) {
                    break;
                }
                if (cur == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                        innerCount++;
                        continue;
                    } else {
                        break;
                    }
                }
                if (cur == '}') {
                    if (stack.peek() == '{') {
                        stack.pop();
                        innerCount++;
                        continue;
                    } else {
                        break;
                    }
                }
                if (cur == ']') {
                    if (stack.peek() == '[') {
                        stack.pop();
                        innerCount++;
                    } else
                        break;
                }
            }
            if (stack.isEmpty() && innerCount == s.length()) {
                answer++;
            }

            queue.offer(queue.poll());

            count++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "}}}";

        System.out.println(s.solution(s1));
    }
}
