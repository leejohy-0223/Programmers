package pro12911;

public class SolutionRef {
	public int solution(int n) {

		int target = Integer.bitCount(n);
		int nextValue = n + 1;
		System.out.println("target = " + target);
		System.out.println("Integer.numberOfLeadingZeros() = " + Integer.numberOfLeadingZeros(n));
		System.out.println("Integer.numberOfTrailingZeros(n) = " + Integer.numberOfTrailingZeros(n));

		while (true) {
			int tmp = Integer.bitCount(nextValue);
			if (tmp == target) {
				break;
			}
			nextValue++;
		}
		return nextValue;
	}
}
