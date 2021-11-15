package pro86971;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionBfs {
    // 1. 각 간선 끊기
    // 2. bfs 돌면서 몇개인지 체크
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        ArrayList<Node>[] arr = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            arr[wires[i][0]].add(new Node(wires[i][1], i));
            arr[wires[i][1]].add(new Node(wires[i][0], i));
        }

        for (int i = 0; i < n - 1; i++) {
            //i번 간선 끊기

            boolean[] visited = new boolean[n + 1];

            Queue<Integer> q = new LinkedList<>();
            q.add(1);
            visited[1] = true;
            int cnt = 1;
            while (!q.isEmpty()) {
                int nowIndex = q.poll();

                for (Node nextNode : arr[nowIndex]) {
                    if (nextNode.num == i || visited[nextNode.index]) {
                        continue;
                    }

                    q.add(nextNode.index);
                    visited[nextNode.index] = true;
                    cnt++;
                }
            }
            System.out.println("cnt = " + cnt);
            answer = Integer.min(answer, Math.abs(n - cnt - cnt));
        }
        return answer;
    }

    public class Node {
        int index;
        int num;

        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        SolutionBfs s = new SolutionBfs();
        int solution = s.solution(9, getBoard("[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]", 8, 2));
        System.out.println(solution);
    }

    private static int[][] getBoard(String tmp, int isize, int jsize) {
        tmp = tmp.substring(2, tmp.length() - 2);
        int[][] board = new int[isize][jsize];
        String[] split = tmp.split("],\\[");

        for (int i = 0; i < isize; i++) {
            String[] split1 = split[i].split(",");
            for (int j = 0; j < jsize; j++) {
                board[i][j] = Integer.parseInt(split1[j]);
            }
        }
        return board;
    }
}
