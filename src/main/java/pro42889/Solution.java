package pro42889;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static class Rate implements Comparable<Rate> {
        int value;
        double failRate;

        public Rate(int value, double failRate) {
            this.value = value;
            this.failRate = failRate;
        }

        @Override
        public int compareTo(Rate o) {
            if (this.failRate == o.failRate) {
                return this.value - o.value;
            }
            if (this.failRate < o.failRate) {
                return 1;
            }
            return -1;

        }
    }

    public int[] solution(int N, int[] stages) {
        List<Rate> list = new ArrayList<>();
        int[] numberCount = new int[N + 2]; // 1부터 N+1까지 계산하기

        for (int stage : stages) {
            numberCount[stage]++;
        }

        int bunmo = stages.length;
        int start = 1;
        double rate;
        while (start < N + 1) {
            rate = (double) numberCount[start] / bunmo;
            if (Double.isNaN(rate)) {
                list.add(new Rate(start, 0));
            } else {
                list.add(new Rate(start, rate));
            }
            bunmo -= numberCount[start];
            start++;
        }

        Collections.sort(list);

        return list.stream().mapToInt(s -> s.value).toArray();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] solution = s.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        int[] solution = s.solution(3, new int[]{1, 2, 2});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
