package pro12911;

public class Solution {

	public int solution(int n) {

		String s = Integer.toBinaryString(n);
		int targetCount;
		int nextValue = n + 1;

		targetCount = getTargetCount(s);

		while (true) {

			String tmp = Integer.toBinaryString(nextValue);
			int tmpCount;
			tmpCount = getTargetCount(tmp);

			if (tmpCount == targetCount) {
				break;
			}
			nextValue++;
		}

		return nextValue;
	}

	private int getTargetCount(String s) {
		int targetCount = 0;
		for (char c : s.toCharArray()) {
			if (c == '1') {
				targetCount++;
			}
		}
		return targetCount;
	}

	public static void main(String[] args) {

	}
}
