package pro67256;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Map<Character, Position> map = new HashMap<>();

        map.put('1', new Position(0, 0));
        map.put('2', new Position(0, 1));
        map.put('3', new Position(0, 2));
        map.put('4', new Position(1, 0));
        map.put('5', new Position(1, 1));
        map.put('6', new Position(1, 2));
        map.put('7', new Position(2, 0));
        map.put('8', new Position(2, 1));
        map.put('9', new Position(2, 2));
        map.put('*', new Position(3, 0));
        map.put('0', new Position(3, 1));
        map.put('#', new Position(3, 2));


        // 엄지 위치 초기화
        int lx = 3, ly = 0;
        int rx = 3, ry = 2;

        for (int number : numbers) {
            // 왼쪽에 가까운 경우
            if (number == 1 || number == 4 || number == 7) {
                answer.append('L');
                lx = map.get(Character.forDigit(number, 10)).x;
                ly = map.get(Character.forDigit(number, 10)).y;
                continue;
            }

            // 오른쪽에 가까운 경우
            if (number == 3 || number == 6 || number == 9) {
                answer.append('R');
                rx = map.get(Character.forDigit(number, 10)).x;
                ry = map.get(Character.forDigit(number, 10)).y;
                continue;
            }

            // 가운데에 있을 경우
            int nx = map.get(Character.forDigit(number, 10)).x;
            int ny = map.get(Character.forDigit(number, 10)).y;

            int ld = Math.abs(nx - lx) + Math.abs(ny - ly);
            int rd = Math.abs(nx - rx) + Math.abs(ny - ry);

            if (ld > rd) {
                answer.append('R');
                rx = nx;
                ry = ny;
            } else if (ld < rd) {
                answer.append('L');
                lx = nx;
                ly = ny;
            } else {
                if (hand.equals("left")) {
                    answer.append('L');
                    lx = nx;
                    ly = ny;
                } else {
                    answer.append('R');
                    rx = nx;
                    ry = ny;
                }
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
    }
}
