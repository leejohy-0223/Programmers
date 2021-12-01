package pro12909;

import java.util.Stack;

public class Solution {

	boolean solution(String s) {

		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				Character pop = stack.pop();
				if (pop != '(') {
					return false;
				}
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {

	}
}
