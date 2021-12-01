package pro12951;

public class Solution {

	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		boolean firstChar = true;

		for (char c : s.toCharArray()) {

			if (c == ' ') {
				firstChar = true;
				sb.append(c);
				continue;
			}

			if (firstChar) {
				if (Character.isAlphabetic(c)) {
					sb.append(Character.toUpperCase(c));
				} else {
					sb.append(c);
				}
				firstChar = false;
				continue;
			}

			if (Character.isAlphabetic(c)) {
				sb.append(Character.toLowerCase(c));
			} else
				sb.append(c);
		}

		return sb.toString();
	}

	public static void main(String[] args) {

	}
}
