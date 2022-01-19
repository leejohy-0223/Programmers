package pro42748;

import java.util.Arrays;

public class SolutionRef {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] copy = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            sort(copy, 0, commands[i][1] - commands[i][0]);
            answer[i] = copy[commands[i][2] - 1];
        }
        return answer;
    }

    public void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start + 1;
        int right = end;

        while (left <= right) {
            // pivot == start 보다 큰 데이터를 찾을 때까지 반복
            while (left <= end && a[left] <= a[start]) {
                left++;
            }
            // pivot 보다 작은 데이터를 찾을 때까지 반복
            while (right > start && a[right] >= a[start]) {
                right--;
            }
            int tmp = a[right];
            if (left > right) { // 엇갈렸다면, right(작은 데이터)와 피봇(a[start])을 교체
                a[right] = a[start];
                a[start] = tmp;
            } else {            // 안 엇갈렸다면, left, right 교체
                a[right] = a[left];
                a[left] = tmp;
            }
        }
        // right는 정렬 완료! 따라서 right의 좌우를 기준으로 다시 sorting을 수행한다.
        sort(a, start, right - 1);
        sort(a, right + 1, end);
    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
        int[] solution = s.solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
