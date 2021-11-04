package pro43164;

import java.util.*;

public class Solution {

    static boolean[] visited;
    static ArrayList<String> arr;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        arr = new ArrayList<>();
        DFS("ICN", "ICN", 0, tickets);

        Collections.sort(arr);

        for (String s : arr) {
            System.out.println(s);
        }
        return new String[2];
//        return arr.get(0).split(" ");
    }

    private void DFS(String now, String accum, int count, String[][] tickets) {
        if (count == tickets.length) {
            arr.add(accum);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 방문 안했으며, 현 위치와 티켓의 시작점이 같다면
            if (!visited[i] && tickets[i][0].equals(now)) {
                visited[i] = true;
                DFS(tickets[i][1], accum + " " + tickets[i][1], count + 1, tickets);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {

        Solution s = new Solution();
        String[][] t1 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
//        String[][] t2 = {{"ICN", "SFO"}, {"ICN", "SFO"}, {"ICN", "SFO"}, {"SFO", "ABC"}};
        String[][] t2 = {{"ICN", "SFO"}, {"ICN", "SFO"}, {"ICN", "SFO"}, {"ICN", "SFO"}, {"SFO", "ICN"}};
//        String[][] t2 = {{"ICN", "SFO"}, {"ICN", "SFO"}, {"SFO", "ICN"}};

//        s.solution(t1);
        s.solution(t2);
    }
}
