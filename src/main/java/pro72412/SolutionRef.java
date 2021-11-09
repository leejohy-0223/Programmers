package pro72412;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SolutionRef {

    static Map<String, ArrayList<Integer>> allinfo;
    static ArrayList<Integer> in;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        allinfo = new HashMap<>();

        // 1. key에 info로 가능한 String 형태, value로는 key에 해당하는 점수를 모두 붙인다.
        for (String s : info) {
            dfs("", 0, s.split(" "));
        }

        // 2. 이분 탐색을 위한 정렬을 진행한다.
        ArrayList<String> list = new ArrayList<>(allinfo.keySet());
        for (String s : list) {
            ArrayList<Integer> arrayList = allinfo.get(s);
            Collections.sort(arrayList);
        }

        // 3. 이분 탐색을 통해 만족하는 점수를 counting 한다.
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            q = q.replaceAll(" and ", "");
            String[] s = q.split(" ");
            answer[i] = binary(s[0], Integer.parseInt(s[1]));
        }
        return answer;
    }

    private int binary(String findKey, int score) {
        if(!allinfo.containsKey(findKey)) return 0;

        ArrayList<Integer> scoreList = allinfo.get(findKey);

        // score와 같거나 큰 개수를 구한다.
        int start = 0, end = scoreList.size();

        while (start < end) {
            int mid = (start + end) / 2;

            if (scoreList.get(mid) >= score) {
                end = mid;
            } else
                start = mid + 1;
        }

        return scoreList.size() - start;

    }

    private void dfs(String cur, int depth, String[] info) {
        if (depth == 4) {
            // allinfo에 넣는 처리 진행
            if (!allinfo.containsKey(cur)) {
                in = new ArrayList<>();
                in.add(Integer.parseInt(info[4]));
                allinfo.put(cur, in);
            } else {
                allinfo.get(cur).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(cur + "-", depth + 1, info);
        dfs(cur + info[depth], depth + 1, info);
    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
        allinfo = new HashMap<>();

        String tmp = "java backend junior pizza 150";
        s.dfs("", 0, tmp.split(" "));
    }
}
