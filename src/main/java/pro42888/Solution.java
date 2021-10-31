///programmers(가장 큰 수) https://programmers.co.kr/learn/courses/30/lessons/42746

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    class UserInfo {
        String info;
        String id;

        public UserInfo(String info, String id) {
            this.info = info;
            this.id = id;
        }
    }

    public String[] solution(String[] record) {
        ArrayList<UserInfo> arrayList = new ArrayList<>();
        String[] answer;
        HashMap<String, String> hm = new HashMap<>();

        for (String x : record) {
            String[] split = x.split(" ");

            if (split[0].equals("Enter")) {
                hm.put(split[1], split[2]);
                arrayList.add(new UserInfo("님이 들어왔습니다.", split[1]));
                continue;
            }

            if (split[0].equals("Leave")) {
                String tmp = hm.get(split[1]);
                arrayList.add(new UserInfo("님이 나갔습니다.", split[1]));
                continue;
            }
            if (split[0].equals("Change")) {
                //이전 기록 id의 value를 갱신
                hm.put(split[1], split[2]);
            }
        }

        answer = new String[arrayList.size()];
        int i = 0;
        for(UserInfo usr : arrayList) {
            answer[i] = hm.get(usr.id) + usr.info;
            i++;
        }
        return answer;
    }
}
