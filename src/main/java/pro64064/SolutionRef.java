package pro64064;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SolutionRef {

    static boolean[] visit;
    static ArrayList<String> list = new ArrayList<>();
    static HashSet<String> set;
    static ArrayList<HashSet<String>> result = new ArrayList<>();

    public int solution(String[] user_id, String[] banned_id) {
        Arrays.sort(banned_id);
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", "."); // *은 정규 표현식에서 앞문자가 없을 수도, 무한정일수도를 의미하므로 .으로 변경(임의의 한 문자)
        }
        visit = new boolean[user_id.length];
        dfs(banned_id, user_id, 0);

        return result.size();
    }

    private void dfs(String[] banned_id, String[] user_id, int idx) {
        if (idx == banned_id.length) {
            set = new HashSet<>();
            set.addAll(list);


            System.out.println();
            boolean flag = true;
            // 같은 아이디로 이루어진 조합이 있는지 체크
            for (HashSet<String> str : result) {
                if(str.containsAll(list)) flag = false;
            }


            if (flag) {
                result.add(set);
            }
            return;
        }

        Pattern idPattern = Pattern.compile(banned_id[idx]);
        for (int i = 0; i < user_id.length; i++) {
            Matcher matcher = idPattern.matcher(user_id[i]);

            // 정규식 표현에 맞는 문자
            if (matcher.matches() && !visit[i]) {
                list.add(user_id[i]);
                visit[i] = true;
                dfs(banned_id, user_id, idx + 1);
                visit[i] = false;
                list.remove(idx);
            }
        }

    }

    public static void main(String[] args) {
        SolutionRef s = new SolutionRef();
        String[] uid = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bid = {"fr*d*", "abc1**"};
        s.solution(uid, bid);
    }
}