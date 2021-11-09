package pro72412;

import java.util.*;

public class Solution {

    static class Mapping {
        int realIdx;
        String query;

        public Mapping(int realIdx, String query) {
            this.realIdx = realIdx;
            this.query = query;
        }
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        ArrayList<Mapping> arr = new ArrayList<>();
        int idx = 0;
        for (String s : query) {
            arr.add(new Mapping(idx, s));
            idx++;
        }

        Arrays.sort(info, (s1, s2) -> {
            String[] a1 = s1.split(" ");
            String[] a2 = s2.split(" ");

            int sc1 = Integer.parseInt(a1[a1.length - 1]);
            int sc2 = Integer.parseInt(a2[a2.length - 1]);

            return sc2 - sc1;
        });

        arr.sort((o1, o2) -> {
            String[] split1 = o1.query.split(" and ");
            String[] split2 = o2.query.split(" and ");

            int sc1 = Integer.parseInt(split1[split1.length - 1].split(" ")[1]);
            int sc2 = Integer.parseInt(split2[split2.length - 1].split(" ")[1]);

            return sc2 - sc1;
        });

        for (Mapping cur : arr) {
            String[] ands = cur.query.split(" and ");
            int score = Integer.parseInt(ands[3].split(" ")[1]);
            ands[3] = ands[3].split(" ")[0];

            // 0 : 언어, 1 : 백 / 프론트, 2 : 주니어 / 시니어, 3 : 음식
            int count = 0;
            for (String s1 : info) {
                String[] s2 = s1.split(" ");
                if (Integer.parseInt(s2[4]) < score) {
                    break;
                }

                boolean chk = true;
                for (int i = 0; i < 4; i++) {
                    if (ands[i].equals("-")) continue;
                    if (!ands[i].equals(s2[i])) {
                        chk = false;
                        break;
                    }
                }
                if (chk) {
                    count++;
                }
            }
            answer[cur.realIdx] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        s.solution(info, query);
    }
}
