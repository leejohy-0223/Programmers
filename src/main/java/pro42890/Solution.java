package pro42890;

import java.util.*;

public class Solution {

    static int[] pm;
    static int row, column;
    static ArrayList<List<String>> candidateKeys = new ArrayList<>(); // 유일성(최소성 만족하는 최종 후보키 저장)

    public int solution(String[][] relation) {

        row = relation.length;
        column = relation[0].length;

        int size = 1;
        while (size <= column) {

            pm = new int[size];
            comb(0, 0, size, relation);
            size++;
        }

        return candidateKeys.size();
    }

    private static void comb(int L, int S, int size, String[][] relation) {
        if (L == size) {
            // column을 row 단위로 묶어서 문자열 만들기
            Set<String> set = new HashSet<>();
            StringBuilder sb;

            for (int i = 0; i < row; i++) {
                sb = new StringBuilder();
                for (int column : pm) {
                    sb.append(relation[i][column]);
                }
                set.add(sb.toString());
            }

            // 유일성 검사 통과한 컬럼 조합 대상으로 최소성 판별
            if (set.size() == row) {
                List<String> tmp = new ArrayList<>();
                for (int i : pm) {
                    tmp.add(i + "");
                }

                boolean chk = true;
                for (List<String> candidateKey : candidateKeys) {
                    if (tmp.containsAll(candidateKey)) {
                        chk = false;
                        break;
                    }
                }
                // 포함되어있지 않다면, 새로운 candidateKeys를 만들어 할당한다.
                if (chk) {
                    candidateKeys.add(tmp);
                }
            }
            return;
        }

        for (int i = S; i < column; i++) {
            pm[L] = i;
            comb(L + 1, i + 1, size, relation);
        }
    }

}
