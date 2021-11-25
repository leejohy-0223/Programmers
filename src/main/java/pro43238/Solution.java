package pro43238;

import java.util.Arrays;

public class Solution {

    public long solution(int n, int[] times) {

        int maxValue = Arrays.stream(times) // 3배 정도 빠르다.
                .max()
                .getAsInt();

        long lo = 0;
        long hi = (long) n * maxValue; // 가장 오래 걸리는 시간

        while (lo < hi) {

            long half = (lo + hi) / 2;
            long sum = 0; // 총 심사된 인원

            for (int time : times) {
                sum += half / time; // 주어진 시간에 처리할 수 있는 인원을 sum으로 더하기
            }

            if (sum < n) { // 해야할 인원보다 심사를 못함 -> lo를 올려 half를 높혀 sum이 더 크게 되도록 함.
                lo = half + 1;
            } else {
                hi = half; // 해야할 인원보다 많이 처리함 -> hi를 올려 half를 내려 sum이 작도록 함 -> 같을 경우에는 하한으로 밀어 붙임(최솟값), 즉 만족하는 경우의 하한선 찾기
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long solution = s.solution(20, new int[]{2, 3, 8, 12});
        System.out.println(solution);
    }
}
