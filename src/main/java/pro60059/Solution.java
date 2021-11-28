package pro60059;

public class Solution {

	public boolean solution(int[][] key, int[][] lock) {

		int point = key.length - 1; // lock의 실제 위치를 담는다. 이를 기반으로 이후에 실제 lock의 범위만 탐색한다.
		int[][] nLock;
		int nLockSize = (lock.length + 2 * (key.length - 1));

		for (int i = 0; i < point + lock.length; i++) {
			for (int j = 0; j < point + lock.length; j++) {
				// key를 회전한다.
				for (int k = 0; k < 4; k++) {
					// 1. lock을 확장한다.(초기화)
					nLock = new int[nLockSize][nLockSize];

					// 2. 본래 lock 값으로 초기화 한다.
					for (int l = 0; l < lock.length; l++) {
						for (int m = 0; m < lock[0].length; m++) {
							nLock[l + point][m + point] = lock[l][m];
						}
					}

					// 3. key와 join한다.
					joinWithKey(nLock, key, i, j, k);

					// 4. 원래 Lock 부분만 검사한다.
					if (checkOriginLock(nLock, point, lock.length)) {
						return true;
					}

				}
			}
		}
		return false;
	}

	private boolean checkOriginLock(int[][] nLock, int point, int length) {

		for (int i = point; i < point + length; i++) {
			for (int j = point; j < point + length; j++) {

				/**
				 * lock의 모든 부분이 1로 변경되어 한다.
				 * nLock[i][j] == 0인 조건으로 잡으면, 모두 홈인 부분은 0으로, 이 부분에서 검증되긴 하지만
				 * 모두 돌기인 부분은 2로 되어 있어 이 부분에서 검증되지 않는다.
				 * 즉, 모든 부분이 1이 되는게 오픈 조건임을 기억하자.
				 */
				if (nLock[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	private void joinWithKey(int[][] nLock, int[][] key, int x, int y, int rotate) {
		int len = key.length;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (rotate == 0) { // 원래 방향
					nLock[i + x][j + y] += key[i][j];
				} else if(rotate == 1) { // 90도 회전
					nLock[i + x][j + y] += key[j][len - i - 1];
				} else if(rotate == 2) { //180도 회전
					nLock[i + x][j + y] += key[len - i - 1][len - j - 1];
				} else { // 270도 회전
					nLock[i + x][j + y] += key[len - j - 1][i];
				}
			}
		}
	}

	public static void main(String[] args) {

	}
}
