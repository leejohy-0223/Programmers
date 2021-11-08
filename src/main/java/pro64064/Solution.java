package pro64064;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Solution {
    static ArrayList<String> pm;
    static boolean[] chk;
    static Set<ArrayList<String>> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", "."); // *은 정규 표현식에서 앞문자가 없을 수도, 무한정일수도를 의미하므로 .으로 변경(임의의 한 문자)
        }
        pm = new ArrayList<>();
        chk = new boolean[user_id.length];

        permu(0, user_id, banned_id);
        System.out.println(set.size());
        return set.size();
    }

    private static void permu(int L, String[] user_id, String[] banned_id) {
        if (L == banned_id.length) {
            //Array 만들기
            for (ArrayList<String> strings : set) {
                if (strings.containsAll(pm)) {
                    return;
                }
            }
            ArrayList<String> tmp = (ArrayList<String>) pm.clone(); // pm에서 복사해서 set에 전달해야 한다. 아니면 값이 바뀐게 set에 계속 반영된다.
            set.add(tmp);
            return;
        }

        Pattern idPattern = Pattern.compile(banned_id[L]);
        for (int i = 0; i < user_id.length; i++) {
            if (!chk[i] && idPattern.matcher(user_id[i]).matches()) {
                pm.add(user_id[i]);
                chk[i] = true;
                permu(L + 1, user_id, banned_id);
                chk[i] = false;
                pm.remove(L);
            }
        }
    }

//    private static boolean checkPossible(String userId, String bannedId) {
//
//        if(userId.length() != bannedId.length()) return false;
//
//        char[] chars = bannedId.toCharArray();
//        int count = 0;
//        int notVoid;
//        int notVoidCount = 0;
//        for (char aChar : chars) {
//            if (aChar == '*') {
//                count++;
//            }
//        }
//        notVoid = bannedId.length() - count;
//        for (int k = 0; k < bannedId.length(); k++) {
//            if (bannedId.charAt(k) == userId.charAt(k)) {
//                notVoidCount++;
//            }
//        }
//        return notVoid == notVoidCount;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] uid = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] bid = {"fr*d*", "abc1**"};
        s.solution(uid, bid);
    }


//    public void idontKnow() {
//        if (!idChk[j] && (ban.length() == user_id[j].length())) {
//            // ban과 일치 여부 검사
//            String tmp = user_id[j]; // 검사 대상
//            char[] chars = ban.toCharArray();
//            int count = 0;
//            int notVoid = 0;
//            int notVoidCount = 0;
//            for (char aChar : chars) {
//                if (aChar == '*') {
//                    count++;
//                }
//            }
//            notVoid = ban.length() - count;
//            for (int k = 0; k < ban.length(); k++) {
//                if (ban.charAt(k) == tmp.charAt(k)) {
//                    notVoidCount++;
//                }
//            }
//            if (notVoid == notVoidCount) {
//                // 일치하는 아이디이다.
//                idChk[j] = true;
//
//            }
//
//        }
//    }
}
